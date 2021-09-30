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
import com.ruoyi.system.vo.TDynamicStarVo;
import com.ruoyi.system.bo.TDynamicStarQueryBo;
import com.ruoyi.system.bo.TDynamicStarAddBo;
import com.ruoyi.system.bo.TDynamicStarEditBo;
import com.ruoyi.system.service.ITDynamicStarService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 动态点赞Controller
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Validated
@Api(value = "动态点赞控制器", tags = {"动态点赞管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/system/star")
public class TDynamicStarController extends BaseController {

    private final ITDynamicStarService iTDynamicStarService;

    /**
     * 查询动态点赞列表
     */
    @ApiOperation("查询动态点赞列表")
    @PreAuthorize("@ss.hasPermi('system:star:list')")
    @GetMapping("/list")
    public TableDataInfo<TDynamicStarVo> list(@Validated TDynamicStarQueryBo bo) {
        return iTDynamicStarService.queryPageList(bo);
    }

    /**
     * 导出动态点赞列表
     */
    @ApiOperation("导出动态点赞列表")
    @PreAuthorize("@ss.hasPermi('system:star:export')")
    @Log(title = "动态点赞", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult<TDynamicStarVo> export(@Validated TDynamicStarQueryBo bo) {
        List<TDynamicStarVo> list = iTDynamicStarService.queryList(bo);
        ExcelUtil<TDynamicStarVo> util = new ExcelUtil<TDynamicStarVo>(TDynamicStarVo.class);
        return util.exportExcel(list, "动态点赞");
    }

    /**
     * 获取动态点赞详细信息
     */
    @ApiOperation("获取动态点赞详细信息")
    @PreAuthorize("@ss.hasPermi('system:star:query')")
    @GetMapping("/{id}")
    public AjaxResult<TDynamicStarVo> getInfo(@NotNull(message = "主键不能为空")
                                                  @PathVariable("id") Long id) {
        return AjaxResult.success(iTDynamicStarService.queryById(id));
    }

    /**
     * 新增动态点赞
     */
    @ApiOperation("新增动态点赞")
    @PreAuthorize("@ss.hasPermi('system:star:add')")
    @Log(title = "动态点赞", businessType = BusinessType.INSERT)
    @RepeatSubmit
    @PostMapping()
    public AjaxResult<Void> add(@Validated @RequestBody TDynamicStarAddBo bo) {
        return toAjax(iTDynamicStarService.insertByAddBo(bo) ? 1 : 0);
    }

    /**
     * 修改动态点赞
     */
    @ApiOperation("修改动态点赞")
    @PreAuthorize("@ss.hasPermi('system:star:edit')")
    @Log(title = "动态点赞", businessType = BusinessType.UPDATE)
    @RepeatSubmit
    @PutMapping()
    public AjaxResult<Void> edit(@Validated @RequestBody TDynamicStarEditBo bo) {
        return toAjax(iTDynamicStarService.updateByEditBo(bo) ? 1 : 0);
    }

    /**
     * 删除动态点赞
     */
    @ApiOperation("删除动态点赞")
    @PreAuthorize("@ss.hasPermi('system:star:remove')")
    @Log(title = "动态点赞" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
                                       @PathVariable Long[] ids) {
        return toAjax(iTDynamicStarService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
    }
}
