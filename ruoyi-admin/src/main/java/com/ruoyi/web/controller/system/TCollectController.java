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
import com.ruoyi.system.vo.TCollectVo;
import com.ruoyi.system.bo.TCollectQueryBo;
import com.ruoyi.system.bo.TCollectAddBo;
import com.ruoyi.system.bo.TCollectEditBo;
import com.ruoyi.system.service.ITCollectService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 收藏Controller
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Validated
@Api(value = "收藏控制器", tags = {"收藏管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/system/collect")
public class TCollectController extends BaseController {

    private final ITCollectService iTCollectService;

    /**
     * 查询收藏列表
     */
    @ApiOperation("查询收藏列表")
    @PreAuthorize("@ss.hasPermi('system:collect:list')")
    @GetMapping("/list")
    public TableDataInfo<TCollectVo> list(@Validated TCollectQueryBo bo) {
        return iTCollectService.queryPageList(bo);
    }

    /**
     * 导出收藏列表
     */
    @ApiOperation("导出收藏列表")
    @PreAuthorize("@ss.hasPermi('system:collect:export')")
    @Log(title = "收藏", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult<TCollectVo> export(@Validated TCollectQueryBo bo) {
        List<TCollectVo> list = iTCollectService.queryList(bo);
        ExcelUtil<TCollectVo> util = new ExcelUtil<TCollectVo>(TCollectVo.class);
        return util.exportExcel(list, "收藏");
    }

    /**
     * 获取收藏详细信息
     */
    @ApiOperation("获取收藏详细信息")
    @PreAuthorize("@ss.hasPermi('system:collect:query')")
    @GetMapping("/{id}")
    public AjaxResult<TCollectVo> getInfo(@NotNull(message = "主键不能为空")
                                                  @PathVariable("id") Long id) {
        return AjaxResult.success(iTCollectService.queryById(id));
    }

    /**
     * 新增收藏
     */
    @ApiOperation("新增收藏")
    @PreAuthorize("@ss.hasPermi('system:collect:add')")
    @Log(title = "收藏", businessType = BusinessType.INSERT)
    @RepeatSubmit
    @PostMapping()
    public AjaxResult<Void> add(@Validated @RequestBody TCollectAddBo bo) {
        return toAjax(iTCollectService.insertByAddBo(bo) ? 1 : 0);
    }

    /**
     * 修改收藏
     */
    @ApiOperation("修改收藏")
    @PreAuthorize("@ss.hasPermi('system:collect:edit')")
    @Log(title = "收藏", businessType = BusinessType.UPDATE)
    @RepeatSubmit
    @PutMapping()
    public AjaxResult<Void> edit(@Validated @RequestBody TCollectEditBo bo) {
        return toAjax(iTCollectService.updateByEditBo(bo) ? 1 : 0);
    }

    /**
     * 删除收藏
     */
    @ApiOperation("删除收藏")
    @PreAuthorize("@ss.hasPermi('system:collect:remove')")
    @Log(title = "收藏" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
                                       @PathVariable Long[] ids) {
        return toAjax(iTCollectService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
    }
}
