package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

import java.math.BigDecimal;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 充值分页查询对象 t_recharge
 *
 * @author ruoyi
 * @date 2021-09-11
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("充值分页查询对象")
public class TRechargeQueryBo extends BaseEntity {

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
     * 订单号
     */
	@ApiModelProperty("订单号")
	private String orderNo;
    /**
     * 流水号
     */
	@ApiModelProperty("流水号")
	private String seqNoNo;
    /**
     * 充值金额
     */
	@ApiModelProperty("充值金额")
	private BigDecimal amt;
    /**
     * 充值类型： 1-支付宝，2-银行卡
     */
	@ApiModelProperty("充值类型： 1-支付宝，2-银行卡")
	private Integer payType;
    /**
     * 充值状态： 0-初始创建，1-待对账，2-对账失败，3-对账成功，99-充值成功
     */
	@ApiModelProperty("充值状态： 0-初始创建，1-待对账，2-对账失败，3-对账成功，99-充值成功")
	private Integer done;
    /**
     * 备注
     */
	@ApiModelProperty("备注")
	private String summary;
    /**
     * 对账失败原因
     */
	@ApiModelProperty("对账失败原因")
	private String reason;
    /**
     * 充值用户id
     */
	@ApiModelProperty("充值用户id")
	private Long userId;

}
