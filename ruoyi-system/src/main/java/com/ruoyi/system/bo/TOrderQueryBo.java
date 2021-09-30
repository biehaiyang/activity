package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单分页查询对象 t_order
 *
 * @author ruoyi
 * @date 2021-09-11
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("订单分页查询对象")
public class TOrderQueryBo extends BaseEntity {

	/**
	 * 分页大小
	 */
	@ApiModelProperty("分页大小")
	private Integer pageSize;
	/**
	 * 当前页数
	 */
	@ApiModelProperty("当前页数")
	private Integer pageNum;
	/**
	 * 排序列
	 */
	@ApiModelProperty("排序列")
	private String orderByColumn;
	/**
	 * 排序的方向desc或者asc
	 */
	@ApiModelProperty(value = "排序的方向", example = "asc,desc")
	private String isAsc;


    /**
     * 活动标题
     */
	@ApiModelProperty("活动标题")
	private String orderTitle;
    /**
     * 参加活动时间
     */
	@ApiModelProperty("参加活动时间")
	private Date takeTime;
    /**
     * 规格
     */
	@ApiModelProperty("规格")
	private String orderSpec;
    /**
     * 人数
     */
	@ApiModelProperty("人数")
	private Long peopleNum;
    /**
     * 订单总金额
     */
	@ApiModelProperty("订单总金额")
	private BigDecimal orderMoney;
    /**
     * 活动地址
     */
	@ApiModelProperty("活动地址")
	private String address;
    /**
     * 单价
     */
	@ApiModelProperty("单价")
	private BigDecimal unitMoney;
    /**
     * 订单状态 0 待付款 1 待参加 2 待评价 3 已取消
     */
	@ApiModelProperty("订单状态 0 待付款 1 待参加 2 待评价 3 已取消")
	private String orderStatus;
    /**
     * 支付id
     */
	@ApiModelProperty("支付id")
	private String payId;
    /**
     * 支付时间
     */
	@ApiModelProperty("支付时间")
	private Date payTime;
    /**
     * 1 余额 2 微信 3 支付宝
     */
	@ApiModelProperty("1 余额 2 微信 3 支付宝")
	private String payType;

}
