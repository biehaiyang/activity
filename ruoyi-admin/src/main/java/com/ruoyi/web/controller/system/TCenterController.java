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
import com.ruoyi.system.vo.TCenterVo;
import com.ruoyi.system.bo.TCenterQueryBo;
import com.ruoyi.system.bo.TCenterAddBo;
import com.ruoyi.system.bo.TCenterEditBo;
import com.ruoyi.system.service.ITCenterService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 客服Controller
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Validated
@Api(value = "客服控制器", tags = {"客服管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/system/center")
public class TCenterController extends BaseController {

    private final ITCenterService iTCenterService;

    /**
     * 查询客服列表
     */
    @ApiOperation("查询客服列表")
    @PreAuthorize("@ss.hasPermi('system:center:list')")
    @GetMapping("/list")
    public TableDataInfo<TCenterVo> list(@Validated TCenterQueryBo bo) {
        return iTCenterService.queryPageList(bo);
    }

    /**
     * 导出客服列表
     */
    @ApiOperation("导出客服列表")
    @PreAuthorize("@ss.hasPermi('system:center:export')")
    @Log(title = "客服", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult<TCenterVo> export(@Validated TCenterQueryBo bo) {
        List<TCenterVo> list = iTCenterService.queryList(bo);
        ExcelUtil<TCenterVo> util = new ExcelUtil<TCenterVo>(TCenterVo.class);
        return util.exportExcel(list, "客服");
    }

    /**
     * 获取客服详细信息
     */
    @ApiOperation("获取客服详细信息")
    @PreAuthorize("@ss.hasPermi('system:center:query')")
    @GetMapping("/{id}")
    public AjaxResult<TCenterVo> getInfo(@NotNull(message = "主键不能为空")
                                                  @PathVariable("id") Long id) {
        return AjaxResult.success(iTCenterService.queryById(id));
    }

    /**
     * 新增客服
     */
    @ApiOperation("新增客服")
    @PreAuthorize("@ss.hasPermi('system:center:add')")
    @Log(title = "客服", businessType = BusinessType.INSERT)
    @RepeatSubmit
    @PostMapping()
    public AjaxResult<Void> add(@Validated @RequestBody TCenterAddBo bo) {
        return toAjax(iTCenterService.insertByAddBo(bo) ? 1 : 0);
    }

    /**
     * 修改客服
     */
    @ApiOperation("修改客服")
    @PreAuthorize("@ss.hasPermi('system:center:edit')")
    @Log(title = "客服", businessType = BusinessType.UPDATE)
    @RepeatSubmit
    @PutMapping()
    public AjaxResult<Void> edit(@Validated @RequestBody TCenterEditBo bo) {
        return toAjax(iTCenterService.updateByEditBo(bo) ? 1 : 0);
    }

    /**
     * 删除客服
     */
    @ApiOperation("删除客服")
    @PreAuthorize("@ss.hasPermi('system:center:remove')")
    @Log(title = "客服" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
                                       @PathVariable Long[] ids) {
        return toAjax(iTCenterService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
    }
}
