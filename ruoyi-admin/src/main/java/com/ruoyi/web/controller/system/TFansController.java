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
import com.ruoyi.system.vo.TFansVo;
import com.ruoyi.system.bo.TFansQueryBo;
import com.ruoyi.system.bo.TFansAddBo;
import com.ruoyi.system.bo.TFansEditBo;
import com.ruoyi.system.service.ITFansService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户关注Controller
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Validated
@Api(value = "用户关注控制器", tags = {"用户关注管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/system/fans")
public class TFansController extends BaseController {

    private final ITFansService iTFansService;

    /**
     * 查询用户关注列表
     */
    @ApiOperation("查询用户关注列表")
    @PreAuthorize("@ss.hasPermi('system:fans:list')")
    @GetMapping("/list")
    public TableDataInfo<TFansVo> list(@Validated TFansQueryBo bo) {
        return iTFansService.queryPageList(bo);
    }

    /**
     * 导出用户关注列表
     */
    @ApiOperation("导出用户关注列表")
    @PreAuthorize("@ss.hasPermi('system:fans:export')")
    @Log(title = "用户关注", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult<TFansVo> export(@Validated TFansQueryBo bo) {
        List<TFansVo> list = iTFansService.queryList(bo);
        ExcelUtil<TFansVo> util = new ExcelUtil<TFansVo>(TFansVo.class);
        return util.exportExcel(list, "用户关注");
    }

    /**
     * 获取用户关注详细信息
     */
    @ApiOperation("获取用户关注详细信息")
    @PreAuthorize("@ss.hasPermi('system:fans:query')")
    @GetMapping("/{id}")
    public AjaxResult<TFansVo> getInfo(@NotNull(message = "主键不能为空")
                                                  @PathVariable("id") Long id) {
        return AjaxResult.success(iTFansService.queryById(id));
    }

    /**
     * 新增用户关注
     */
    @ApiOperation("新增用户关注")
    @PreAuthorize("@ss.hasPermi('system:fans:add')")
    @Log(title = "用户关注", businessType = BusinessType.INSERT)
    @RepeatSubmit
    @PostMapping()
    public AjaxResult<Void> add(@Validated @RequestBody TFansAddBo bo) {
        return toAjax(iTFansService.insertByAddBo(bo) ? 1 : 0);
    }

    /**
     * 修改用户关注
     */
    @ApiOperation("修改用户关注")
    @PreAuthorize("@ss.hasPermi('system:fans:edit')")
    @Log(title = "用户关注", businessType = BusinessType.UPDATE)
    @RepeatSubmit
    @PutMapping()
    public AjaxResult<Void> edit(@Validated @RequestBody TFansEditBo bo) {
        return toAjax(iTFansService.updateByEditBo(bo) ? 1 : 0);
    }

    /**
     * 删除用户关注
     */
    @ApiOperation("删除用户关注")
    @PreAuthorize("@ss.hasPermi('system:fans:remove')")
    @Log(title = "用户关注" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
                                       @PathVariable Long[] ids) {
        return toAjax(iTFansService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
    }
}
