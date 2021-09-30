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
import com.ruoyi.system.vo.TTypeVo;
import com.ruoyi.system.bo.TTypeQueryBo;
import com.ruoyi.system.bo.TTypeAddBo;
import com.ruoyi.system.bo.TTypeEditBo;
import com.ruoyi.system.service.ITTypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 所有分类Controller
 *
 * @author ruoyi
 * @date 2021-09-12
 */
@Validated
@Api(value = "所有分类控制器", tags = {"所有分类管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/system/type")
public class TTypeController extends BaseController {

    private final ITTypeService iTTypeService;

    /**
     * 查询所有分类列表
     */
    @ApiOperation("查询所有分类列表")
    @PreAuthorize("@ss.hasPermi('system:type:list')")
    @GetMapping("/list")
    public TableDataInfo<TTypeVo> list(@Validated TTypeQueryBo bo) {
        return iTTypeService.queryPageList(bo);
    }

    /**
     * 导出所有分类列表
     */
    @ApiOperation("导出所有分类列表")
    @PreAuthorize("@ss.hasPermi('system:type:export')")
    @Log(title = "所有分类", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult<TTypeVo> export(@Validated TTypeQueryBo bo) {
        List<TTypeVo> list = iTTypeService.queryList(bo);
        ExcelUtil<TTypeVo> util = new ExcelUtil<TTypeVo>(TTypeVo.class);
        return util.exportExcel(list, "所有分类");
    }

    /**
     * 获取所有分类详细信息
     */
    @ApiOperation("获取所有分类详细信息")
    @PreAuthorize("@ss.hasPermi('system:type:query')")
    @GetMapping("/{id}")
    public AjaxResult<TTypeVo> getInfo(@NotNull(message = "主键不能为空")
                                                  @PathVariable("id") Long id) {
        return AjaxResult.success(iTTypeService.queryById(id));
    }

    /**
     * 新增所有分类
     */
    @ApiOperation("新增所有分类")
    @PreAuthorize("@ss.hasPermi('system:type:add')")
    @Log(title = "所有分类", businessType = BusinessType.INSERT)
    @RepeatSubmit
    @PostMapping()
    public AjaxResult<Void> add(@Validated @RequestBody TTypeAddBo bo) {
        return toAjax(iTTypeService.insertByAddBo(bo) ? 1 : 0);
    }

    /**
     * 修改所有分类
     */
    @ApiOperation("修改所有分类")
    @PreAuthorize("@ss.hasPermi('system:type:edit')")
    @Log(title = "所有分类", businessType = BusinessType.UPDATE)
    @RepeatSubmit
    @PutMapping()
    public AjaxResult<Void> edit(@Validated @RequestBody TTypeEditBo bo) {
        return toAjax(iTTypeService.updateByEditBo(bo) ? 1 : 0);
    }

    /**
     * 删除所有分类
     */
    @ApiOperation("删除所有分类")
    @PreAuthorize("@ss.hasPermi('system:type:remove')")
    @Log(title = "所有分类" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
                                       @PathVariable Long[] ids) {
        return toAjax(iTTypeService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
    }
}
