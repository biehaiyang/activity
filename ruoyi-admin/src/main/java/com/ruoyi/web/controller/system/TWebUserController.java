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
import com.ruoyi.system.vo.TWebUserVo;
import com.ruoyi.system.bo.TWebUserQueryBo;
import com.ruoyi.system.bo.TWebUserAddBo;
import com.ruoyi.system.bo.TWebUserEditBo;
import com.ruoyi.system.service.ITWebUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户Controller
 *
 * @author ruoyi
 * @date 2021-09-12
 */
@Validated
@Api(value = "用户控制器", tags = {"用户管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/system/webuser")
public class TWebUserController extends BaseController {

    private final ITWebUserService iTWebUserService;

    /**
     * 查询用户列表
     */
    @ApiOperation("查询用户列表")
    @PreAuthorize("@ss.hasPermi('system:webuser:list')")
    @GetMapping("/list")
    public TableDataInfo<TWebUserVo> list(@Validated TWebUserQueryBo bo) {
        return iTWebUserService.queryPageList(bo);
    }

    /**
     * 导出用户列表
     */
    @ApiOperation("导出用户列表")
    @PreAuthorize("@ss.hasPermi('system:webuser:export')")
    @Log(title = "用户", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult<TWebUserVo> export(@Validated TWebUserQueryBo bo) {
        List<TWebUserVo> list = iTWebUserService.queryList(bo);
        ExcelUtil<TWebUserVo> util = new ExcelUtil<TWebUserVo>(TWebUserVo.class);
        return util.exportExcel(list, "用户");
    }

    /**
     * 获取用户详细信息
     */
    @ApiOperation("获取用户详细信息")
    @PreAuthorize("@ss.hasPermi('system:webuser:query')")
    @GetMapping("/{id}")
    public AjaxResult<TWebUserVo> getInfo(@NotNull(message = "主键不能为空")
                                                  @PathVariable("id") Long id) {
        return AjaxResult.success(iTWebUserService.queryById(id));
    }

    /**
     * 新增用户
     */
    @ApiOperation("新增用户")
    @PreAuthorize("@ss.hasPermi('system:webuser:add')")
    @Log(title = "用户", businessType = BusinessType.INSERT)
    @RepeatSubmit
    @PostMapping()
    public AjaxResult<Void> add(@Validated @RequestBody TWebUserAddBo bo) {
        return toAjax(iTWebUserService.insertByAddBo(bo) ? 1 : 0);
    }

    /**
     * 修改用户
     */
    @ApiOperation("修改用户")
    @PreAuthorize("@ss.hasPermi('system:webuser:edit')")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @RepeatSubmit
    @PutMapping()
    public AjaxResult<Void> edit(@Validated @RequestBody TWebUserEditBo bo) {
        return toAjax(iTWebUserService.updateByEditBo(bo) ? 1 : 0);
    }

    /**
     * 删除用户
     */
    @ApiOperation("删除用户")
    @PreAuthorize("@ss.hasPermi('system:webuser:remove')")
    @Log(title = "用户" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
                                       @PathVariable Long[] ids) {
        return toAjax(iTWebUserService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
    }
}
