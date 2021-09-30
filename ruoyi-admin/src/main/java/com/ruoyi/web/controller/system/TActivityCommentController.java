package com.ruoyi.web.controller.system;

import java.util.List;
import java.util.Arrays;

import lombok.RequiredArgsConstructor;
import javax.validation.constraints.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import com.ruoyi.common.annotation.RepeatSubmit;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.vo.TActivityCommentVo;
import com.ruoyi.system.bo.TActivityCommentQueryBo;
import com.ruoyi.system.bo.TActivityCommentAddBo;
import com.ruoyi.system.bo.TActivityCommentEditBo;
import com.ruoyi.system.service.ITActivityCommentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 活动评论Controller
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Validated
@Api(value = "活动评论控制器", tags = {"活动评论管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/system/comment")
public class TActivityCommentController extends BaseController {

    private final ITActivityCommentService iTActivityCommentService;

    /**
     * 查询活动评论列表
     */
    @ApiOperation("查询活动评论列表")
    @PreAuthorize("@ss.hasPermi('system:comment:list')")
    @GetMapping("/list")
    public TableDataInfo<TActivityCommentVo> list(@Validated TActivityCommentQueryBo bo) {
        return iTActivityCommentService.queryPageList(bo);
    }

    /**
     * 导出活动评论列表
     */
    @ApiOperation("导出活动评论列表")
    @PreAuthorize("@ss.hasPermi('system:comment:export')")
    @Log(title = "活动评论", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult<TActivityCommentVo> export(@Validated TActivityCommentQueryBo bo) {
        List<TActivityCommentVo> list = iTActivityCommentService.queryList(bo);
        ExcelUtil<TActivityCommentVo> util = new ExcelUtil<TActivityCommentVo>(TActivityCommentVo.class);
        return util.exportExcel(list, "活动评论");
    }

    /**
     * 获取活动评论详细信息
     */
    @ApiOperation("获取活动评论详细信息")
    @PreAuthorize("@ss.hasPermi('system:comment:query')")
    @GetMapping("/{id}")
    public AjaxResult<TActivityCommentVo> getInfo(@NotNull(message = "主键不能为空")
                                                  @PathVariable("id") Integer id) {
        return AjaxResult.success(iTActivityCommentService.queryById(id));
    }

    /**
     * 新增活动评论
     */
    @ApiOperation("新增活动评论")
    @PreAuthorize("@ss.hasPermi('system:comment:add')")
    @Log(title = "活动评论", businessType = BusinessType.INSERT)
    @RepeatSubmit
    @PostMapping()
    public AjaxResult<Void> add(@Validated @RequestBody TActivityCommentAddBo bo) {
        return toAjax(iTActivityCommentService.insertByAddBo(bo) ? 1 : 0);
    }

    /**
     * 修改活动评论
     */
    @ApiOperation("修改活动评论")
    @PreAuthorize("@ss.hasPermi('system:comment:edit')")
    @Log(title = "活动评论", businessType = BusinessType.UPDATE)
    @RepeatSubmit
    @PutMapping()
    public AjaxResult<Void> edit(@Validated @RequestBody TActivityCommentEditBo bo) {
        return toAjax(iTActivityCommentService.updateByEditBo(bo) ? 1 : 0);
    }

    /**
     * 删除活动评论
     */
    @ApiOperation("删除活动评论")
    @PreAuthorize("@ss.hasPermi('system:comment:remove')")
    @Log(title = "活动评论" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
                                       @PathVariable Integer[] ids) {
        return toAjax(iTActivityCommentService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
    }
}
