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
import com.ruoyi.system.vo.TDynamicVo;
import com.ruoyi.system.bo.TDynamicQueryBo;
import com.ruoyi.system.bo.TDynamicAddBo;
import com.ruoyi.system.bo.TDynamicEditBo;
import com.ruoyi.system.service.ITDynamicService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 动态Controller
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Validated
@Api(value = "动态控制器", tags = {"动态管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/system/dynamic")
public class TDynamicController extends BaseController {

    private final ITDynamicService iTDynamicService;

    /**
     * 查询动态列表
     */
    @ApiOperation("查询动态列表")
    @PreAuthorize("@ss.hasPermi('system:dynamic:list')")
    @GetMapping("/list")
    public TableDataInfo<TDynamicVo> list(@Validated TDynamicQueryBo bo) {
        return iTDynamicService.queryPageList(bo);
    }

    /**
     * 导出动态列表
     */
    @ApiOperation("导出动态列表")
    @PreAuthorize("@ss.hasPermi('system:dynamic:export')")
    @Log(title = "动态", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult<TDynamicVo> export(@Validated TDynamicQueryBo bo) {
        List<TDynamicVo> list = iTDynamicService.queryList(bo);
        ExcelUtil<TDynamicVo> util = new ExcelUtil<TDynamicVo>(TDynamicVo.class);
        return util.exportExcel(list, "动态");
    }

    /**
     * 获取动态详细信息
     */
    @ApiOperation("获取动态详细信息")
    @PreAuthorize("@ss.hasPermi('system:dynamic:query')")
    @GetMapping("/{id}")
    public AjaxResult<TDynamicVo> getInfo(@NotNull(message = "主键不能为空")
                                                  @PathVariable("id") Long id) {
        return AjaxResult.success(iTDynamicService.queryById(id));
    }

    /**
     * 新增动态
     */
    @ApiOperation("新增动态")
    @PreAuthorize("@ss.hasPermi('system:dynamic:add')")
    @Log(title = "动态", businessType = BusinessType.INSERT)
    @RepeatSubmit
    @PostMapping()
    public AjaxResult<Void> add(@Validated @RequestBody TDynamicAddBo bo) {
        return toAjax(iTDynamicService.insertByAddBo(bo) ? 1 : 0);
    }

    /**
     * 修改动态
     */
    @ApiOperation("修改动态")
    @PreAuthorize("@ss.hasPermi('system:dynamic:edit')")
    @Log(title = "动态", businessType = BusinessType.UPDATE)
    @RepeatSubmit
    @PutMapping()
    public AjaxResult<Void> edit(@Validated @RequestBody TDynamicEditBo bo) {
        return toAjax(iTDynamicService.updateByEditBo(bo) ? 1 : 0);
    }

    /**
     * 删除动态
     */
    @ApiOperation("删除动态")
    @PreAuthorize("@ss.hasPermi('system:dynamic:remove')")
    @Log(title = "动态" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
                                       @PathVariable Long[] ids) {
        return toAjax(iTDynamicService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
    }
}
