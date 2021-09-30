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
import com.ruoyi.system.vo.TActivityDataVo;
import com.ruoyi.system.bo.TActivityDataQueryBo;
import com.ruoyi.system.bo.TActivityDataAddBo;
import com.ruoyi.system.bo.TActivityDataEditBo;
import com.ruoyi.system.service.ITActivityDataService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 活动数据Controller
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Validated
@Api(value = "活动数据控制器", tags = {"活动数据管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/system/data")
public class TActivityDataController extends BaseController {

    private final ITActivityDataService iTActivityDataService;

    /**
     * 查询活动数据列表
     */
    @ApiOperation("查询活动数据列表")
    @PreAuthorize("@ss.hasPermi('system:data:list')")
    @GetMapping("/list")
    public TableDataInfo<TActivityDataVo> list(@Validated TActivityDataQueryBo bo) {
        return iTActivityDataService.queryPageList(bo);
    }

    /**
     * 导出活动数据列表
     */
    @ApiOperation("导出活动数据列表")
    @PreAuthorize("@ss.hasPermi('system:data:export')")
    @Log(title = "活动数据", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult<TActivityDataVo> export(@Validated TActivityDataQueryBo bo) {
        List<TActivityDataVo> list = iTActivityDataService.queryList(bo);
        ExcelUtil<TActivityDataVo> util = new ExcelUtil<TActivityDataVo>(TActivityDataVo.class);
        return util.exportExcel(list, "活动数据");
    }

    /**
     * 获取活动数据详细信息
     */
    @ApiOperation("获取活动数据详细信息")
    @PreAuthorize("@ss.hasPermi('system:data:query')")
    @GetMapping("/{id}")
    public AjaxResult<TActivityDataVo> getInfo(@NotNull(message = "主键不能为空")
                                                  @PathVariable("id") Long id) {
        return AjaxResult.success(iTActivityDataService.queryById(id));
    }

    /**
     * 新增活动数据
     */
    @ApiOperation("新增活动数据")
    @PreAuthorize("@ss.hasPermi('system:data:add')")
    @Log(title = "活动数据", businessType = BusinessType.INSERT)
    @RepeatSubmit
    @PostMapping()
    public AjaxResult<Void> add(@Validated @RequestBody TActivityDataAddBo bo) {
        return toAjax(iTActivityDataService.insertByAddBo(bo) ? 1 : 0);
    }

    /**
     * 修改活动数据
     */
    @ApiOperation("修改活动数据")
    @PreAuthorize("@ss.hasPermi('system:data:edit')")
    @Log(title = "活动数据", businessType = BusinessType.UPDATE)
    @RepeatSubmit
    @PutMapping()
    public AjaxResult<Void> edit(@Validated @RequestBody TActivityDataEditBo bo) {
        return toAjax(iTActivityDataService.updateByEditBo(bo) ? 1 : 0);
    }

    /**
     * 删除活动数据
     */
    @ApiOperation("删除活动数据")
    @PreAuthorize("@ss.hasPermi('system:data:remove')")
    @Log(title = "活动数据" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
                                       @PathVariable Long[] ids) {
        return toAjax(iTActivityDataService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
    }
}
