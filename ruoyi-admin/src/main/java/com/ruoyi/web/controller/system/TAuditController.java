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
import com.ruoyi.system.vo.TAuditVo;
import com.ruoyi.system.bo.TAuditQueryBo;
import com.ruoyi.system.bo.TAuditAddBo;
import com.ruoyi.system.bo.TAuditEditBo;
import com.ruoyi.system.service.ITAuditService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户审核Controller
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Validated
@Api(value = "用户审核控制器", tags = {"用户审核管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/system/audit")
public class TAuditController extends BaseController {

    private final ITAuditService iTAuditService;

    /**
     * 查询用户审核列表
     */
    @ApiOperation("查询用户审核列表")
    @PreAuthorize("@ss.hasPermi('system:audit:list')")
    @GetMapping("/list")
    public TableDataInfo<TAuditVo> list(@Validated TAuditQueryBo bo) {
        return iTAuditService.queryPageList(bo);
    }

    /**
     * 导出用户审核列表
     */
    @ApiOperation("导出用户审核列表")
    @PreAuthorize("@ss.hasPermi('system:audit:export')")
    @Log(title = "用户审核", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult<TAuditVo> export(@Validated TAuditQueryBo bo) {
        List<TAuditVo> list = iTAuditService.queryList(bo);
        ExcelUtil<TAuditVo> util = new ExcelUtil<TAuditVo>(TAuditVo.class);
        return util.exportExcel(list, "用户审核");
    }

    /**
     * 获取用户审核详细信息
     */
    @ApiOperation("获取用户审核详细信息")
    @PreAuthorize("@ss.hasPermi('system:audit:query')")
    @GetMapping("/{id}")
    public AjaxResult<TAuditVo> getInfo(@NotNull(message = "主键不能为空")
                                                  @PathVariable("id") Long id) {
        return AjaxResult.success(iTAuditService.queryById(id));
    }

    /**
     * 新增用户审核
     */
    @ApiOperation("新增用户审核")
    @PreAuthorize("@ss.hasPermi('system:audit:add')")
    @Log(title = "用户审核", businessType = BusinessType.INSERT)
    @RepeatSubmit
    @PostMapping()
    public AjaxResult<Void> add(@Validated @RequestBody TAuditAddBo bo) {
        return toAjax(iTAuditService.insertByAddBo(bo) ? 1 : 0);
    }

    /**
     * 修改用户审核
     */
    @ApiOperation("修改用户审核")
    @PreAuthorize("@ss.hasPermi('system:audit:edit')")
    @Log(title = "用户审核", businessType = BusinessType.UPDATE)
    @RepeatSubmit
    @PutMapping()
    public AjaxResult<Void> edit(@Validated @RequestBody TAuditEditBo bo) {
        return toAjax(iTAuditService.updateByEditBo(bo) ? 1 : 0);
    }

    /**
     * 删除用户审核
     */
    @ApiOperation("删除用户审核")
    @PreAuthorize("@ss.hasPermi('system:audit:remove')")
    @Log(title = "用户审核" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
                                       @PathVariable Long[] ids) {
        return toAjax(iTAuditService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
    }
}
