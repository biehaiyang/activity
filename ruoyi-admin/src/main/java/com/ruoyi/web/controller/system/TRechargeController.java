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
import com.ruoyi.system.vo.TRechargeVo;
import com.ruoyi.system.bo.TRechargeQueryBo;
import com.ruoyi.system.bo.TRechargeAddBo;
import com.ruoyi.system.bo.TRechargeEditBo;
import com.ruoyi.system.service.ITRechargeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 充值Controller
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Validated
@Api(value = "充值控制器", tags = {"充值管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/system/recharge")
public class TRechargeController extends BaseController {

    private final ITRechargeService iTRechargeService;

    /**
     * 查询充值列表
     */
    @ApiOperation("查询充值列表")
    @PreAuthorize("@ss.hasPermi('system:recharge:list')")
    @GetMapping("/list")
    public TableDataInfo<TRechargeVo> list(@Validated TRechargeQueryBo bo) {
        return iTRechargeService.queryPageList(bo);
    }

    /**
     * 导出充值列表
     */
    @ApiOperation("导出充值列表")
    @PreAuthorize("@ss.hasPermi('system:recharge:export')")
    @Log(title = "充值", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult<TRechargeVo> export(@Validated TRechargeQueryBo bo) {
        List<TRechargeVo> list = iTRechargeService.queryList(bo);
        ExcelUtil<TRechargeVo> util = new ExcelUtil<TRechargeVo>(TRechargeVo.class);
        return util.exportExcel(list, "充值");
    }

    /**
     * 获取充值详细信息
     */
    @ApiOperation("获取充值详细信息")
    @PreAuthorize("@ss.hasPermi('system:recharge:query')")
    @GetMapping("/{id}")
    public AjaxResult<TRechargeVo> getInfo(@NotNull(message = "主键不能为空")
                                                  @PathVariable("id") Long id) {
        return AjaxResult.success(iTRechargeService.queryById(id));
    }

    /**
     * 新增充值
     */
    @ApiOperation("新增充值")
    @PreAuthorize("@ss.hasPermi('system:recharge:add')")
    @Log(title = "充值", businessType = BusinessType.INSERT)
    @RepeatSubmit
    @PostMapping()
    public AjaxResult<Void> add(@Validated @RequestBody TRechargeAddBo bo) {
        return toAjax(iTRechargeService.insertByAddBo(bo) ? 1 : 0);
    }

    /**
     * 修改充值
     */
    @ApiOperation("修改充值")
    @PreAuthorize("@ss.hasPermi('system:recharge:edit')")
    @Log(title = "充值", businessType = BusinessType.UPDATE)
    @RepeatSubmit
    @PutMapping()
    public AjaxResult<Void> edit(@Validated @RequestBody TRechargeEditBo bo) {
        return toAjax(iTRechargeService.updateByEditBo(bo) ? 1 : 0);
    }

    /**
     * 删除充值
     */
    @ApiOperation("删除充值")
    @PreAuthorize("@ss.hasPermi('system:recharge:remove')")
    @Log(title = "充值" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
                                       @PathVariable Long[] ids) {
        return toAjax(iTRechargeService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
    }
}
