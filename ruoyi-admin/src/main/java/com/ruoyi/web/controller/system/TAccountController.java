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
import com.ruoyi.system.vo.TAccountVo;
import com.ruoyi.system.bo.TAccountQueryBo;
import com.ruoyi.system.bo.TAccountAddBo;
import com.ruoyi.system.bo.TAccountEditBo;
import com.ruoyi.system.service.ITAccountService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 账户详情Controller
 *
 * @author ruoyi
 * @date 2021-10-10
 */
@Validated
@Api(value = "账户详情控制器", tags = {"账户详情管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/system/account")
public class TAccountController extends BaseController {

    private final ITAccountService iTAccountService;

    /**
     * 查询账户详情列表
     */
    @ApiOperation("查询账户详情列表")
    @PreAuthorize("@ss.hasPermi('system:account:list')")
    @GetMapping("/list")
    public TableDataInfo<TAccountVo> list(@Validated TAccountQueryBo bo) {
        return iTAccountService.queryPageList(bo);
    }

    /**
     * 导出账户详情列表
     */
    @ApiOperation("导出账户详情列表")
    @PreAuthorize("@ss.hasPermi('system:account:export')")
    @Log(title = "账户详情", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult<TAccountVo> export(@Validated TAccountQueryBo bo) {
        List<TAccountVo> list = iTAccountService.queryList(bo);
        ExcelUtil<TAccountVo> util = new ExcelUtil<TAccountVo>(TAccountVo.class);
        return util.exportExcel(list, "账户详情");
    }

    /**
     * 获取账户详情详细信息
     */
    @ApiOperation("获取账户详情详细信息")
    @PreAuthorize("@ss.hasPermi('system:account:query')")
    @GetMapping("/{id}")
    public AjaxResult<TAccountVo> getInfo(@NotNull(message = "主键不能为空")
                                                  @PathVariable("id") Long id) {
        return AjaxResult.success(iTAccountService.queryById(id));
    }

    /**
     * 新增账户详情
     */
    @ApiOperation("新增账户详情")
    @PreAuthorize("@ss.hasPermi('system:account:add')")
    @Log(title = "账户详情", businessType = BusinessType.INSERT)
    @RepeatSubmit
    @PostMapping()
    public AjaxResult<Void> add(@Validated @RequestBody TAccountAddBo bo) {
        return toAjax(iTAccountService.insertByAddBo(bo) ? 1 : 0);
    }

    /**
     * 修改账户详情
     */
    @ApiOperation("修改账户详情")
    @PreAuthorize("@ss.hasPermi('system:account:edit')")
    @Log(title = "账户详情", businessType = BusinessType.UPDATE)
    @RepeatSubmit
    @PutMapping()
    public AjaxResult<Void> edit(@Validated @RequestBody TAccountEditBo bo) {
        return toAjax(iTAccountService.updateByEditBo(bo) ? 1 : 0);
    }

    /**
     * 删除账户详情
     */
    @ApiOperation("删除账户详情")
    @PreAuthorize("@ss.hasPermi('system:account:remove')")
    @Log(title = "账户详情" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
                                       @PathVariable Long[] ids) {
        return toAjax(iTAccountService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
    }
}
