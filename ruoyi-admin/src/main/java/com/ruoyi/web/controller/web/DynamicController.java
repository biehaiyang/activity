package com.ruoyi.web.controller.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.mapper.TDynamicCommentMapper;
import com.ruoyi.system.mapper.TDynamicImgMapper;
import com.ruoyi.system.mapper.TDynamicMapper;
import com.ruoyi.system.mapper.TDynamicStarMapper;
import com.ruoyi.system.service.ITDynamicCommentService;
import com.ruoyi.system.service.ITDynamicImgService;
import com.ruoyi.system.service.ITDynamicService;
import com.ruoyi.web.controller.token.LoginUser;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;

/**
 * web用户端：动态服务
 *
 * @author RuoYi
 */
@RestController
@RequestMapping("/web/dynamic")
public class DynamicController {

    @Resource
    private ITDynamicService tDynamicService;

    @Resource
    private TDynamicMapper tDynamicMapper;

    @Resource
    private TDynamicImgMapper tDynamicImgMapper;

    @Resource
    private TDynamicStarMapper tDynamicStarMapper;

    @Resource
    private TDynamicCommentMapper tDynamicCommentMapper;

    @Resource
    private ITDynamicImgService dynamicImgService;

    @Resource
    private ITDynamicCommentService tDynamicCommentService;

    /**
     * 查询所有动态
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/queryList")
    public AjaxResult queryList(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {

        page = (page - 1) * 10;

        List<TDynamic> dynamicList = tDynamicMapper.selectDynamic(page, size);

        for (TDynamic tDynamic : dynamicList) {

            QueryWrapper<TDynamicImg> queryWrapper = new QueryWrapper<TDynamicImg>()
                    .eq("id", tDynamic.getId());

            List<TDynamicImg> list = dynamicImgService.list();

            tDynamic.setImgList(list);
        }

        return AjaxResult.success(dynamicList);
    }

    /**
     * 根据id获取动态详情
     *
     * @param id 活动id
     */
    @GetMapping("/query/{id:\\d+}")
    public AjaxResult queryById(
            @PathVariable(value = "id") Integer id) {
        Map<String, Object> ajax = new HashMap<>();
        ajax.put("dynamic", tDynamicMapper.selectById(id));
        ajax.put("dynamicImgList", dynamicImgService.list(new QueryWrapper<TDynamicImg>()
                .eq("id", id)));
        ajax.put("dynamicCommentList", tDynamicCommentService.list(new QueryWrapper<TDynamicComment>()
                .eq("dynamic_id", id)));
        return AjaxResult.success(ajax);
    }

    /**
     * 根据id获取动态详情
     *
     * @param tDynamic 活动内容
     */
    @PostMapping("/save")
    public AjaxResult save(
            TDynamic tDynamic,
            @RequestParam(value = "images") Collection<String> images,
            @LoginUser TWebUser webUser) {
        tDynamic.setUserId(webUser.getId());
        tDynamic.setUserName(webUser.getUserName());
        // 保存动态
        tDynamicService.save(tDynamic);
        // 清空原动态图片
        tDynamicImgMapper.delete(new QueryWrapper<TDynamicImg>().eq("id", tDynamic.getId()));
        // 插入动态图片
        tDynamicImgMapper.insertAll(images.stream().map(obj -> new TDynamicImg(tDynamic.getId(), obj)).collect(toList()));
        return AjaxResult.success("保存成功");
    }

    /**
     * 根据id删除动态
     *
     * @param id 活动id
     */
    @DeleteMapping("/save/{id:\\d+}")
    public AjaxResult delete(
            @PathVariable(value = "id") Long id, @LoginUser TWebUser webUser) {
        TDynamic tDynamic = tDynamicMapper.selectById(id);
        if (isNull(tDynamic) || !Objects.equals(webUser.getId(), tDynamic.getUserId())) {
            return AjaxResult.error("动态不存在或非作者删除");
        }
        tDynamicMapper.deleteById(id);
        // 清空原动态图片
        tDynamicImgMapper.delete(new QueryWrapper<TDynamicImg>().eq("id", id));
        // 删除评论
        tDynamicCommentMapper.delete(new QueryWrapper<TDynamicComment>().eq("dynamic_id", id));
        // 删除点赞
        tDynamicStarMapper.delete(new QueryWrapper<TDynamicStar>().eq("dynamic_id", id));
        return AjaxResult.success("删除动态成功");
    }

    /**
     * 根据id对活动进行点赞
     *
     * @param id 活动id
     */
    @PostMapping("/star/{id:\\d+}")
    public AjaxResult doStar(
            @PathVariable(value = "id") Integer id, @LoginUser TWebUser webUser) {
        TDynamic dynamic = tDynamicMapper.selectById(id);
        tDynamicStarMapper.insert(new TDynamicStar(null, dynamic.getId(), webUser.getId(), dynamic.getUserId(), new Date()));
        return AjaxResult.success("点赞成功");
    }

    /**
     * 根据id对活动撤销点赞
     *
     * @param id 活动id
     */
    @DeleteMapping("/star/{id:\\d+}")
    public AjaxResult cancelStar(
            @PathVariable(value = "id") Integer id, @LoginUser TWebUser webUser) {
        tDynamicStarMapper.delete(new QueryWrapper<TDynamicStar>().eq("dynamic_id", id).eq("user_id", webUser.getId()));
        return AjaxResult.success("撤销点赞成功");
    }

    /**
     * 根据id对活动进行评论
     *
     * @param tDynamicComment 评论内容
     */
    @PostMapping("/comment")
    public AjaxResult saveComment(
            @RequestParam TDynamicComment tDynamicComment, @LoginUser TWebUser webUser) {
        tDynamicComment.setCreateTime(new Date());
        tDynamicComment.setUserId(webUser.getId());
        tDynamicCommentService.save(tDynamicComment);
        return AjaxResult.success("评论成功");
    }

    /**
     * 根据活动评论id进行删除
     *
     * @param id 评论id
     */
    @DeleteMapping("/comment/{id:\\d+}")
    public AjaxResult deleteComment(
            @PathVariable(value = "id") Integer id, @LoginUser TWebUser webUser) {
        this.tDynamicCommentService.deleteWithValidByIds(Collections.singleton(id), true);
        return AjaxResult.success("删除评论成功");
    }
}
