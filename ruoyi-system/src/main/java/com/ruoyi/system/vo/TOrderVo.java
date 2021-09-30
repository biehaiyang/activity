package com.ruoyi.system.vo;

import com.ruoyi.common.annotation.Excel;
import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;



/**
 * 订单视图对象 t_order
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@ApiModel("订单视图对象")
public class TOrderVo {

	private static final long serialVersionUID = 1L;

	/**
     *  $pkColumn.columnComment
     */
	@ApiModelProperty("$pkColumn.columnComment")
	private Long id;

    /**
     * 活动标题
     */
	@Excel(name = "活动标题")
	@ApiModelProperty("活动标题")
	private String orderTitle;

    /**
     * 参加活动时间
     */
	@Excel(name = "参加活动时间" , width = 30, dateFormat = "yyyy-MM-dd")
	@ApiModelProperty("参加活动时间")
	private Date takeTime;

    /**
     * 规格
     */
	@Excel(name = "规格")
	@ApiModelProperty("规格")
	private String orderSpec;

    /**
     * 人数
     */
	@Excel(name = "人数")
	@ApiModelProperty("人数")
	private Long peopleNum;

    /**
     * 订单总金额
     */
	@Excel(name = "订单总金额")
	@ApiModelProperty("订单总金额")
	private BigDecimal orderMoney;

    /**
     * 活动地址
     */
	@Excel(name = "活动地址")
	@ApiModelProperty("活动地址")
	private String address;

    /**
     * 单价
     */
	@Excel(name = "单价")
	@ApiModelProperty("单价")
	private BigDecimal unitMoney;

    /**
     * 订单状态 0 待付款 1 待参加 2 待评价 3 已取消
     */
	@Excel(name = "订单状态 0 待付款 1 待参加 2 待评价 3 已取消")
	@ApiModelProperty("订单状态 0 待付款 1 待参加 2 待评价 3 已取消")
	private String orderStatus;

    /**
     * 支付id
     */
	@Excel(name = "支付id")
	@ApiModelProperty("支付id")
	private String payId;

    /**
     * 支付时间
     */
	@Excel(name = "支付时间" , width = 30, dateFormat = "yyyy-MM-dd")
	@ApiModelProperty("支付时间")
	private Date payTime;

    /**
     * 1 余额 2 微信 3 支付宝
     */
	@Excel(name = "1 余额 2 微信 3 支付宝")
	@ApiModelProperty("1 余额 2 微信 3 支付宝")
	private String payType;


}
