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
import com.ruoyi.system.vo.THistoryVo;
import com.ruoyi.system.bo.THistoryQueryBo;
import com.ruoyi.system.bo.THistoryAddBo;
import com.ruoyi.system.bo.THistoryEditBo;
import com.ruoyi.system.service.ITHistoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户浏览历史Controller
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Validated
@Api(value = "用户浏览历史控制器", tags = {"用户浏览历史管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/system/history")
public class THistoryController extends BaseController {

    private final ITHistoryService iTHistoryService;

    /**
     * 查询用户浏览历史列表
     */
    @ApiOperation("查询用户浏览历史列表")
    @PreAuthorize("@ss.hasPermi('system:history:list')")
    @GetMapping("/list")
    public TableDataInfo<THistoryVo> list(@Validated THistoryQueryBo bo) {
        return iTHistoryService.queryPageList(bo);
    }

    /**
     * 导出用户浏览历史列表
     */
    @ApiOperation("导出用户浏览历史列表")
    @PreAuthorize("@ss.hasPermi('system:history:export')")
    @Log(title = "用户浏览历史", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult<THistoryVo> export(@Validated THistoryQueryBo bo) {
        List<THistoryVo> list = iTHistoryService.queryList(bo);
        ExcelUtil<THistoryVo> util = new ExcelUtil<THistoryVo>(THistoryVo.class);
        return util.exportExcel(list, "用户浏览历史");
    }

    /**
     * 获取用户浏览历史详细信息
     */
    @ApiOperation("获取用户浏览历史详细信息")
    @PreAuthorize("@ss.hasPermi('system:history:query')")
    @GetMapping("/{id}")
    public AjaxResult<THistoryVo> getInfo(@NotNull(message = "主键不能为空")
                                                  @PathVariable("id") Long id) {
        return AjaxResult.success(iTHistoryService.queryById(id));
    }

    /**
     * 新增用户浏览历史
     */
    @ApiOperation("新增用户浏览历史")
    @PreAuthorize("@ss.hasPermi('system:history:add')")
    @Log(title = "用户浏览历史", businessType = BusinessType.INSERT)
    @RepeatSubmit
    @PostMapping()
    public AjaxResult<Void> add(@Validated @RequestBody THistoryAddBo bo) {
        return toAjax(iTHistoryService.insertByAddBo(bo) ? 1 : 0);
    }

    /**
     * 修改用户浏览历史
     */
    @ApiOperation("修改用户浏览历史")
    @PreAuthorize("@ss.hasPermi('system:history:edit')")
    @Log(title = "用户浏览历史", businessType = BusinessType.UPDATE)
    @RepeatSubmit
    @PutMapping()
    public AjaxResult<Void> edit(@Validated @RequestBody THistoryEditBo bo) {
        return toAjax(iTHistoryService.updateByEditBo(bo) ? 1 : 0);
    }

    /**
     * 删除用户浏览历史
     */
    @ApiOperation("删除用户浏览历史")
    @PreAuthorize("@ss.hasPermi('system:history:remove')")
    @Log(title = "用户浏览历史" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
                                       @PathVariable Long[] ids) {
        return toAjax(iTHistoryService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
    }
}
