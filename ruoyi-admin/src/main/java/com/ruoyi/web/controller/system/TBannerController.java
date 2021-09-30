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
import com.ruoyi.system.vo.TBannerVo;
import com.ruoyi.system.bo.TBannerQueryBo;
import com.ruoyi.system.bo.TBannerAddBo;
import com.ruoyi.system.bo.TBannerEditBo;
import com.ruoyi.system.service.ITBannerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 广告图片Controller
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Validated
@Api(value = "广告图片控制器", tags = {"广告图片管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/system/banner")
public class TBannerController extends BaseController {

    private final ITBannerService iTBannerService;

    /**
     * 查询广告图片列表
     */
    @ApiOperation("查询广告图片列表")
    @PreAuthorize("@ss.hasPermi('system:banner:list')")
    @GetMapping("/list")
    public TableDataInfo<TBannerVo> list(@Validated TBannerQueryBo bo) {
        return iTBannerService.queryPageList(bo);
    }

    /**
     * 导出广告图片列表
     */
    @ApiOperation("导出广告图片列表")
    @PreAuthorize("@ss.hasPermi('system:banner:export')")
    @Log(title = "广告图片", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult<TBannerVo> export(@Validated TBannerQueryBo bo) {
        List<TBannerVo> list = iTBannerService.queryList(bo);
        ExcelUtil<TBannerVo> util = new ExcelUtil<TBannerVo>(TBannerVo.class);
        return util.exportExcel(list, "广告图片");
    }

    /**
     * 获取广告图片详细信息
     */
    @ApiOperation("获取广告图片详细信息")
    @PreAuthorize("@ss.hasPermi('system:banner:query')")
    @GetMapping("/{id}")
    public AjaxResult<TBannerVo> getInfo(@NotNull(message = "主键不能为空")
                                                  @PathVariable("id") Long id) {
        return AjaxResult.success(iTBannerService.queryById(id));
    }

    /**
     * 新增广告图片
     */
    @ApiOperation("新增广告图片")
    @PreAuthorize("@ss.hasPermi('system:banner:add')")
    @Log(title = "广告图片", businessType = BusinessType.INSERT)
    @RepeatSubmit
    @PostMapping()
    public AjaxResult<Void> add(@Validated @RequestBody TBannerAddBo bo) {
        return toAjax(iTBannerService.insertByAddBo(bo) ? 1 : 0);
    }

    /**
     * 修改广告图片
     */
    @ApiOperation("修改广告图片")
    @PreAuthorize("@ss.hasPermi('system:banner:edit')")
    @Log(title = "广告图片", businessType = BusinessType.UPDATE)
    @RepeatSubmit
    @PutMapping()
    public AjaxResult<Void> edit(@Validated @RequestBody TBannerEditBo bo) {
        return toAjax(iTBannerService.updateByEditBo(bo) ? 1 : 0);
    }

    /**
     * 删除广告图片
     */
    @ApiOperation("删除广告图片")
    @PreAuthorize("@ss.hasPermi('system:banner:remove')")
    @Log(title = "广告图片" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
                                       @PathVariable Long[] ids) {
        return toAjax(iTBannerService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
    }
}
