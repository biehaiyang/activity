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
import com.ruoyi.system.vo.TMessageVo;
import com.ruoyi.system.bo.TMessageQueryBo;
import com.ruoyi.system.bo.TMessageAddBo;
import com.ruoyi.system.bo.TMessageEditBo;
import com.ruoyi.system.service.ITMessageService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 消息通知
Controller
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Validated
@Api(value = "消息通知 控制器", tags = {"消息通知 管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/system/message")
public class TMessageController extends BaseController {

    private final ITMessageService iTMessageService;

    /**
     * 查询消息通知
列表
     */
    @ApiOperation("查询消息通知 列表")
    @PreAuthorize("@ss.hasPermi('system:message:list')")
    @GetMapping("/list")
    public TableDataInfo<TMessageVo> list(@Validated TMessageQueryBo bo) {
        return iTMessageService.queryPageList(bo);
    }

    /**
     * 导出消息通知
列表
     */
    @ApiOperation("导出消息通知 列表")
    @PreAuthorize("@ss.hasPermi('system:message:export')")
    @Log(title = "消息通知 ", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult<TMessageVo> export(@Validated TMessageQueryBo bo) {
        List<TMessageVo> list = iTMessageService.queryList(bo);
        ExcelUtil<TMessageVo> util = new ExcelUtil<TMessageVo>(TMessageVo.class);
        return util.exportExcel(list, "消息通知 ");
    }

    /**
     * 获取消息通知
详细信息
     */
    @ApiOperation("获取消息通知 详细信息")
    @PreAuthorize("@ss.hasPermi('system:message:query')")
    @GetMapping("/{id}")
    public AjaxResult<TMessageVo> getInfo(@NotNull(message = "主键不能为空")
                                                  @PathVariable("id") Long id) {
        return AjaxResult.success(iTMessageService.queryById(id));
    }

    /**
     * 新增消息通知

     */
    @ApiOperation("新增消息通知 ")
    @PreAuthorize("@ss.hasPermi('system:message:add')")
    @Log(title = "消息通知 ", businessType = BusinessType.INSERT)
    @RepeatSubmit
    @PostMapping()
    public AjaxResult<Void> add(@Validated @RequestBody TMessageAddBo bo) {
        return toAjax(iTMessageService.insertByAddBo(bo) ? 1 : 0);
    }

    /**
     * 修改消息通知

     */
    @ApiOperation("修改消息通知 ")
    @PreAuthorize("@ss.hasPermi('system:message:edit')")
    @Log(title = "消息通知 ", businessType = BusinessType.UPDATE)
    @RepeatSubmit
    @PutMapping()
    public AjaxResult<Void> edit(@Validated @RequestBody TMessageEditBo bo) {
        return toAjax(iTMessageService.updateByEditBo(bo) ? 1 : 0);
    }

    /**
     * 删除消息通知

     */
    @ApiOperation("删除消息通知 ")
    @PreAuthorize("@ss.hasPermi('system:message:remove')")
    @Log(title = "消息通知 " , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
                                       @PathVariable Long[] ids) {
        return toAjax(iTMessageService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
    }
}
