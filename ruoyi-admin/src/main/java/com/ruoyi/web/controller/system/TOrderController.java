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
import com.ruoyi.system.vo.TOrderVo;
import com.ruoyi.system.bo.TOrderQueryBo;
import com.ruoyi.system.bo.TOrderAddBo;
import com.ruoyi.system.bo.TOrderEditBo;
import com.ruoyi.system.service.ITOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 订单Controller
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Validated
@Api(value = "订单控制器", tags = {"订单管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/system/order")
public class TOrderController extends BaseController {

    private final ITOrderService iTOrderService;

    /**
     * 查询订单列表
     */
    @ApiOperation("查询订单列表")
    @PreAuthorize("@ss.hasPermi('system:order:list')")
    @GetMapping("/list")
    public TableDataInfo<TOrderVo> list(@Validated TOrderQueryBo bo) {
        return iTOrderService.queryPageList(bo);
    }

    /**
     * 导出订单列表
     */
    @ApiOperation("导出订单列表")
    @PreAuthorize("@ss.hasPermi('system:order:export')")
    @Log(title = "订单", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult<TOrderVo> export(@Validated TOrderQueryBo bo) {
        List<TOrderVo> list = iTOrderService.queryList(bo);
        ExcelUtil<TOrderVo> util = new ExcelUtil<TOrderVo>(TOrderVo.class);
        return util.exportExcel(list, "订单");
    }

    /**
     * 获取订单详细信息
     */
    @ApiOperation("获取订单详细信息")
    @PreAuthorize("@ss.hasPermi('system:order:query')")
    @GetMapping("/{id}")
    public AjaxResult<TOrderVo> getInfo(@NotNull(message = "主键不能为空")
                                                  @PathVariable("id") Long id) {
        return AjaxResult.success(iTOrderService.queryById(id));
    }

    /**
     * 新增订单
     */
    @ApiOperation("新增订单")
    @PreAuthorize("@ss.hasPermi('system:order:add')")
    @Log(title = "订单", businessType = BusinessType.INSERT)
    @RepeatSubmit
    @PostMapping()
    public AjaxResult<Void> add(@Validated @RequestBody TOrderAddBo bo) {
        return toAjax(iTOrderService.insertByAddBo(bo) ? 1 : 0);
    }

    /**
     * 修改订单
     */
    @ApiOperation("修改订单")
    @PreAuthorize("@ss.hasPermi('system:order:edit')")
    @Log(title = "订单", businessType = BusinessType.UPDATE)
    @RepeatSubmit
    @PutMapping()
    public AjaxResult<Void> edit(@Validated @RequestBody TOrderEditBo bo) {
        return toAjax(iTOrderService.updateByEditBo(bo) ? 1 : 0);
    }

    /**
     * 删除订单
     */
    @ApiOperation("删除订单")
    @PreAuthorize("@ss.hasPermi('system:order:remove')")
    @Log(title = "订单" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
                                       @PathVariable Long[] ids) {
        return toAjax(iTOrderService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
    }
}
