package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import javax.validation.constraints.*;



/**
 * 动态添加对象 t_dynamic
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@ApiModel("动态添加对象")
public class TDynamicAddBo {


    /** 标题 */
    @ApiModelProperty("标题")
    private String title;

    /** 详细内容 */
    @ApiModelProperty("详细内容")
    private String content;

    /** 是否显示定位 0 否 1 是 */
    @ApiModelProperty("是否显示定位 0 否 1 是")
    private String isAddress;

    /** 定位地址 */
    @ApiModelProperty("定位地址")
    private String address;

    /** 0 未删除 1 已删除 */
    @ApiModelProperty("0 未删除 1 已删除")
    private String deleteFlag;

    /** 点赞数量 */
    @ApiModelProperty("点赞数量")
    private Long giveNum;

    /** 用户id */
    @ApiModelProperty("用户id")
    @NotNull(message = "用户id不能为空")
    private Long userId;

    /** 动态发布时间 */
    @ApiModelProperty("动态发布时间")
    @NotNull(message = "动态发布时间不能为空")
    private Date createTime;
}
