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
import com.ruoyi.system.vo.TActivityDateVo;
import com.ruoyi.system.bo.TActivityDateQueryBo;
import com.ruoyi.system.bo.TActivityDateAddBo;
import com.ruoyi.system.bo.TActivityDateEditBo;
import com.ruoyi.system.service.ITActivityDateService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 活动时间（分场次）Controller
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Validated
@Api(value = "活动时间（分场次）控制器", tags = {"活动时间（分场次）管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/system/date")
public class TActivityDateController extends BaseController {

    private final ITActivityDateService iTActivityDateService;

    /**
     * 查询活动时间（分场次）列表
     */
    @ApiOperation("查询活动时间（分场次）列表")
    @PreAuthorize("@ss.hasPermi('system:date:list')")
    @GetMapping("/list")
    public TableDataInfo<TActivityDateVo> list(@Validated TActivityDateQueryBo bo) {
        return iTActivityDateService.queryPageList(bo);
    }

    /**
     * 导出活动时间（分场次）列表
     */
    @ApiOperation("导出活动时间（分场次）列表")
    @PreAuthorize("@ss.hasPermi('system:date:export')")
    @Log(title = "活动时间（分场次）", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult<TActivityDateVo> export(@Validated TActivityDateQueryBo bo) {
        List<TActivityDateVo> list = iTActivityDateService.queryList(bo);
        ExcelUtil<TActivityDateVo> util = new ExcelUtil<TActivityDateVo>(TActivityDateVo.class);
        return util.exportExcel(list, "活动时间（分场次）");
    }

    /**
     * 获取活动时间（分场次）详细信息
     */
    @ApiOperation("获取活动时间（分场次）详细信息")
    @PreAuthorize("@ss.hasPermi('system:date:query')")
    @GetMapping("/{id}")
    public AjaxResult<TActivityDateVo> getInfo(@NotNull(message = "主键不能为空")
                                                  @PathVariable("id") Long id) {
        return AjaxResult.success(iTActivityDateService.queryById(id));
    }

    /**
     * 新增活动时间（分场次）
     */
    @ApiOperation("新增活动时间（分场次）")
    @PreAuthorize("@ss.hasPermi('system:date:add')")
    @Log(title = "活动时间（分场次）", businessType = BusinessType.INSERT)
    @RepeatSubmit
    @PostMapping()
    public AjaxResult<Void> add(@Validated @RequestBody TActivityDateAddBo bo) {
        return toAjax(iTActivityDateService.insertByAddBo(bo) ? 1 : 0);
    }

    /**
     * 修改活动时间（分场次）
     */
    @ApiOperation("修改活动时间（分场次）")
    @PreAuthorize("@ss.hasPermi('system:date:edit')")
    @Log(title = "活动时间（分场次）", businessType = BusinessType.UPDATE)
    @RepeatSubmit
    @PutMapping()
    public AjaxResult<Void> edit(@Validated @RequestBody TActivityDateEditBo bo) {
        return toAjax(iTActivityDateService.updateByEditBo(bo) ? 1 : 0);
    }

    /**
     * 删除活动时间（分场次）
     */
    @ApiOperation("删除活动时间（分场次）")
    @PreAuthorize("@ss.hasPermi('system:date:remove')")
    @Log(title = "活动时间（分场次）" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
                                       @PathVariable Long[] ids) {
        return toAjax(iTActivityDateService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
    }
}
