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
import com.ruoyi.system.vo.TActivitySpecVo;
import com.ruoyi.system.bo.TActivitySpecQueryBo;
import com.ruoyi.system.bo.TActivitySpecAddBo;
import com.ruoyi.system.bo.TActivitySpecEditBo;
import com.ruoyi.system.service.ITActivitySpecService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 活动规格Controller
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Validated
@Api(value = "活动规格控制器", tags = {"活动规格管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/system/spec")
public class TActivitySpecController extends BaseController {

    private final ITActivitySpecService iTActivitySpecService;

    /**
     * 查询活动规格列表
     */
    @ApiOperation("查询活动规格列表")
    @PreAuthorize("@ss.hasPermi('system:spec:list')")
    @GetMapping("/list")
    public TableDataInfo<TActivitySpecVo> list(@Validated TActivitySpecQueryBo bo) {
        return iTActivitySpecService.queryPageList(bo);
    }

    /**
     * 导出活动规格列表
     */
    @ApiOperation("导出活动规格列表")
    @PreAuthorize("@ss.hasPermi('system:spec:export')")
    @Log(title = "活动规格", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult<TActivitySpecVo> export(@Validated TActivitySpecQueryBo bo) {
        List<TActivitySpecVo> list = iTActivitySpecService.queryList(bo);
        ExcelUtil<TActivitySpecVo> util = new ExcelUtil<TActivitySpecVo>(TActivitySpecVo.class);
        return util.exportExcel(list, "活动规格");
    }

    /**
     * 获取活动规格详细信息
     */
    @ApiOperation("获取活动规格详细信息")
    @PreAuthorize("@ss.hasPermi('system:spec:query')")
    @GetMapping("/{id}")
    public AjaxResult<TActivitySpecVo> getInfo(@NotNull(message = "主键不能为空")
                                                  @PathVariable("id") Long id) {
        return AjaxResult.success(iTActivitySpecService.queryById(id));
    }

    /**
     * 新增活动规格
     */
    @ApiOperation("新增活动规格")
    @PreAuthorize("@ss.hasPermi('system:spec:add')")
    @Log(title = "活动规格", businessType = BusinessType.INSERT)
    @RepeatSubmit
    @PostMapping()
    public AjaxResult<Void> add(@Validated @RequestBody TActivitySpecAddBo bo) {
        return toAjax(iTActivitySpecService.insertByAddBo(bo) ? 1 : 0);
    }

    /**
     * 修改活动规格
     */
    @ApiOperation("修改活动规格")
    @PreAuthorize("@ss.hasPermi('system:spec:edit')")
    @Log(title = "活动规格", businessType = BusinessType.UPDATE)
    @RepeatSubmit
    @PutMapping()
    public AjaxResult<Void> edit(@Validated @RequestBody TActivitySpecEditBo bo) {
        return toAjax(iTActivitySpecService.updateByEditBo(bo) ? 1 : 0);
    }

    /**
     * 删除活动规格
     */
    @ApiOperation("删除活动规格")
    @PreAuthorize("@ss.hasPermi('system:spec:remove')")
    @Log(title = "活动规格" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
                                       @PathVariable Long[] ids) {
        return toAjax(iTActivitySpecService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
    }
}
