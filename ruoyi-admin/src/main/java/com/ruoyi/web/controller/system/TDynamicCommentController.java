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
import com.ruoyi.system.vo.TDynamicCommentVo;
import com.ruoyi.system.bo.TDynamicCommentQueryBo;
import com.ruoyi.system.bo.TDynamicCommentAddBo;
import com.ruoyi.system.bo.TDynamicCommentEditBo;
import com.ruoyi.system.service.ITDynamicCommentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 动态评论Controller
 *
 * @author ruoyi
 * @date 2021-09-12
 */
@Validated
@Api(value = "动态评论控制器", tags = {"动态评论管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/system/dynamicComment")
public class TDynamicCommentController extends BaseController {

    private final ITDynamicCommentService iTDynamicCommentService;

    /**
     * 查询动态评论列表
     */
    @ApiOperation("查询动态评论列表")
    @PreAuthorize("@ss.hasPermi('system:dynamicComment:list')")
    @GetMapping("/list")
    public TableDataInfo<TDynamicCommentVo> list(@Validated TDynamicCommentQueryBo bo) {
        return iTDynamicCommentService.queryPageList(bo);
    }

    /**
     * 导出动态评论列表
     */
    @ApiOperation("导出动态评论列表")
    @PreAuthorize("@ss.hasPermi('system:dynamicComment:export')")
    @Log(title = "动态评论", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult<TDynamicCommentVo> export(@Validated TDynamicCommentQueryBo bo) {
        List<TDynamicCommentVo> list = iTDynamicCommentService.queryList(bo);
        ExcelUtil<TDynamicCommentVo> util = new ExcelUtil<TDynamicCommentVo>(TDynamicCommentVo.class);
        return util.exportExcel(list, "动态评论");
    }

    /**
     * 获取动态评论详细信息
     */
    @ApiOperation("获取动态评论详细信息")
    @PreAuthorize("@ss.hasPermi('system:dynamicComment:query')")
    @GetMapping("/{id}")
    public AjaxResult<TDynamicCommentVo> getInfo(@NotNull(message = "主键不能为空")
                                                  @PathVariable("id") Integer id) {
        return AjaxResult.success(iTDynamicCommentService.queryById(id));
    }

    /**
     * 新增动态评论
     */
    @ApiOperation("新增动态评论")
    @PreAuthorize("@ss.hasPermi('system:dynamicComment:add')")
    @Log(title = "动态评论", businessType = BusinessType.INSERT)
    @RepeatSubmit
    @PostMapping()
    public AjaxResult<Void> add(@Validated @RequestBody TDynamicCommentAddBo bo) {
        return toAjax(iTDynamicCommentService.insertByAddBo(bo) ? 1 : 0);
    }

    /**
     * 修改动态评论
     */
    @ApiOperation("修改动态评论")
    @PreAuthorize("@ss.hasPermi('system:dynamicComment:edit')")
    @Log(title = "动态评论", businessType = BusinessType.UPDATE)
    @RepeatSubmit
    @PutMapping()
    public AjaxResult<Void> edit(@Validated @RequestBody TDynamicCommentEditBo bo) {
        return toAjax(iTDynamicCommentService.updateByEditBo(bo) ? 1 : 0);
    }

    /**
     * 删除动态评论
     */
    @ApiOperation("删除动态评论")
    @PreAuthorize("@ss.hasPermi('system:dynamicComment:remove')")
    @Log(title = "动态评论" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
                                       @PathVariable Integer[] ids) {
        return toAjax(iTDynamicCommentService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
    }
}