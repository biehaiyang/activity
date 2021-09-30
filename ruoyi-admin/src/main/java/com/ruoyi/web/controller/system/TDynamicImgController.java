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
import com.ruoyi.system.vo.TDynamicImgVo;
import com.ruoyi.system.bo.TDynamicImgQueryBo;
import com.ruoyi.system.bo.TDynamicImgAddBo;
import com.ruoyi.system.bo.TDynamicImgEditBo;
import com.ruoyi.system.service.ITDynamicImgService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 动态图片Controller
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Validated
@Api(value = "动态图片控制器", tags = {"动态图片管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/system/img")
public class TDynamicImgController extends BaseController {

    private final ITDynamicImgService iTDynamicImgService;

    /**
     * 查询动态图片列表
     */
    @ApiOperation("查询动态图片列表")
    @PreAuthorize("@ss.hasPermi('system:img:list')")
    @GetMapping("/list")
    public TableDataInfo<TDynamicImgVo> list(@Validated TDynamicImgQueryBo bo) {
        return iTDynamicImgService.queryPageList(bo);
    }

    /**
     * 导出动态图片列表
     */
    @ApiOperation("导出动态图片列表")
    @PreAuthorize("@ss.hasPermi('system:img:export')")
    @Log(title = "动态图片", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult<TDynamicImgVo> export(@Validated TDynamicImgQueryBo bo) {
        List<TDynamicImgVo> list = iTDynamicImgService.queryList(bo);
        ExcelUtil<TDynamicImgVo> util = new ExcelUtil<TDynamicImgVo>(TDynamicImgVo.class);
        return util.exportExcel(list, "动态图片");
    }

    /**
     * 获取动态图片详细信息
     */
    @ApiOperation("获取动态图片详细信息")
    @PreAuthorize("@ss.hasPermi('system:img:query')")
    @GetMapping("/{id}")
    public AjaxResult<TDynamicImgVo> getInfo(@NotNull(message = "主键不能为空")
                                                  @PathVariable("id") Long id) {
        return AjaxResult.success(iTDynamicImgService.queryById(id));
    }

    /**
     * 新增动态图片
     */
    @ApiOperation("新增动态图片")
    @PreAuthorize("@ss.hasPermi('system:img:add')")
    @Log(title = "动态图片", businessType = BusinessType.INSERT)
    @RepeatSubmit
    @PostMapping()
    public AjaxResult<Void> add(@Validated @RequestBody TDynamicImgAddBo bo) {
        return toAjax(iTDynamicImgService.insertByAddBo(bo) ? 1 : 0);
    }

    /**
     * 修改动态图片
     */
    @ApiOperation("修改动态图片")
    @PreAuthorize("@ss.hasPermi('system:img:edit')")
    @Log(title = "动态图片", businessType = BusinessType.UPDATE)
    @RepeatSubmit
    @PutMapping()
    public AjaxResult<Void> edit(@Validated @RequestBody TDynamicImgEditBo bo) {
        return toAjax(iTDynamicImgService.updateByEditBo(bo) ? 1 : 0);
    }

    /**
     * 删除动态图片
     */
    @ApiOperation("删除动态图片")
    @PreAuthorize("@ss.hasPermi('system:img:remove')")
    @Log(title = "动态图片" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
                                       @PathVariable Long[] ids) {
        return toAjax(iTDynamicImgService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
    }
}
