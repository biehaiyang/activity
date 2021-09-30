package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import javax.validation.constraints.*;


import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 订单添加对象 t_order
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@ApiModel("订单添加对象")
public class TOrderAddBo {


    /** 创建时间 */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /** 活动标题 */
    @ApiModelProperty("活动标题")
    private String orderTitle;

    /** 参加活动时间 */
    @ApiModelProperty("参加活动时间")
    private Date takeTime;

    /** 规格 */
    @ApiModelProperty("规格")
    private String orderSpec;

    /** 人数 */
    @ApiModelProperty("人数")
    private Long peopleNum;

    /** 订单总金额 */
    @ApiModelProperty("订单总金额")
    private BigDecimal orderMoney;

    /** 活动地址 */
    @ApiModelProperty("活动地址")
    private String address;

    /** 单价 */
    @ApiModelProperty("单价")
    private BigDecimal unitMoney;

    /** 订单状态 0 待付款 1 待参加 2 待评价 3 已取消 */
    @ApiModelProperty("订单状态 0 待付款 1 待参加 2 待评价 3 已取消")
    private String orderStatus;

    /** 支付id */
    @ApiModelProperty("支付id")
    private String payId;

    /** 支付时间 */
    @ApiModelProperty("支付时间")
    private Date payTime;

    /** 1 余额 2 微信 3 支付宝 */
    @ApiModelProperty("1 余额 2 微信 3 支付宝")
    private String payType;
}
