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
import com.ruoyi.system.vo.TActivityImgVo;
import com.ruoyi.system.bo.TActivityImgQueryBo;
import com.ruoyi.system.bo.TActivityImgAddBo;
import com.ruoyi.system.bo.TActivityImgEditBo;
import com.ruoyi.system.service.ITActivityImgService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 活动图片Controller
 *
 * @author ruoyi
 * @date 2021-10-10
 */
@Validated
@Api(value = "活动图片控制器", tags = {"活动图片管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/system/activityImg")
public class TActivityImgController extends BaseController {

    private final ITActivityImgService iTActivityImgService;

    /**
     * 查询活动图片列表
     */
    @ApiOperation("查询活动图片列表")
    @PreAuthorize("@ss.hasPermi('system:activityImg:list')")
    @GetMapping("/list")
    public TableDataInfo<TActivityImgVo> list(@Validated TActivityImgQueryBo bo) {
        return iTActivityImgService.queryPageList(bo);
    }

    /**
     * 导出活动图片列表
     */
    @ApiOperation("导出活动图片列表")
    @PreAuthorize("@ss.hasPermi('system:activityImg:export')")
    @Log(title = "活动图片", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult<TActivityImgVo> export(@Validated TActivityImgQueryBo bo) {
        List<TActivityImgVo> list = iTActivityImgService.queryList(bo);
        ExcelUtil<TActivityImgVo> util = new ExcelUtil<TActivityImgVo>(TActivityImgVo.class);
        return util.exportExcel(list, "活动图片");
    }

    /**
     * 获取活动图片详细信息
     */
    @ApiOperation("获取活动图片详细信息")
    @PreAuthorize("@ss.hasPermi('system:activityImg:query')")
    @GetMapping("/{id}")
    public AjaxResult<TActivityImgVo> getInfo(@NotNull(message = "主键不能为空")
                                                  @PathVariable("id") Long id) {
        return AjaxResult.success(iTActivityImgService.queryById(id));
    }

    /**
     * 新增活动图片
     */
    @ApiOperation("新增活动图片")
    @PreAuthorize("@ss.hasPermi('system:activityImg:add')")
    @Log(title = "活动图片", businessType = BusinessType.INSERT)
    @RepeatSubmit
    @PostMapping()
    public AjaxResult<Void> add(@Validated @RequestBody TActivityImgAddBo bo) {
        return toAjax(iTActivityImgService.insertByAddBo(bo) ? 1 : 0);
    }

    /**
     * 修改活动图片
     */
    @ApiOperation("修改活动图片")
    @PreAuthorize("@ss.hasPermi('system:activityImg:edit')")
    @Log(title = "活动图片", businessType = BusinessType.UPDATE)
    @RepeatSubmit
    @PutMapping()
    public AjaxResult<Void> edit(@Validated @RequestBody TActivityImgEditBo bo) {
        return toAjax(iTActivityImgService.updateByEditBo(bo) ? 1 : 0);
    }

    /**
     * 删除活动图片
     */
    @ApiOperation("删除活动图片")
    @PreAuthorize("@ss.hasPermi('system:activityImg:remove')")
    @Log(title = "活动图片" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
                                       @PathVariable Long[] ids) {
        return toAjax(iTActivityImgService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
    }
}
