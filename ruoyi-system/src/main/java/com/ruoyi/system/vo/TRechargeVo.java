package com.ruoyi.system.vo;

import com.ruoyi.common.annotation.Excel;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;



/**
 * 充值视图对象 t_recharge
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@ApiModel("充值视图对象")
public class TRechargeVo {

	private static final long serialVersionUID = 1L;

	/**
     *  $pkColumn.columnComment
     */
	@ApiModelProperty("$pkColumn.columnComment")
	private Long id;

    /**
     * 订单号
     */
	@Excel(name = "订单号")
	@ApiModelProperty("订单号")
	private String orderNo;

    /**
     * 流水号
     */
	@Excel(name = "流水号")
	@ApiModelProperty("流水号")
	private String seqNoNo;

    /**
     * 充值金额
     */
	@Excel(name = "充值金额")
	@ApiModelProperty("充值金额")
	private BigDecimal amt;

    /**
     * 充值类型： 1-支付宝，2-银行卡
     */
	@Excel(name = "充值类型： 1-支付宝，2-银行卡")
	@ApiModelProperty("充值类型： 1-支付宝，2-银行卡")
	private Integer payType;

    /**
     * 充值状态： 0-初始创建，1-待对账，2-对账失败，3-对账成功，99-充值成功
     */
	@Excel(name = "充值状态： 0-初始创建，1-待对账，2-对账失败，3-对账成功，99-充值成功")
	@ApiModelProperty("充值状态： 0-初始创建，1-待对账，2-对账失败，3-对账成功，99-充值成功")
	private Integer done;

    /**
     * 备注
     */
	@Excel(name = "备注")
	@ApiModelProperty("备注")
	private String summary;

    /**
     * 对账失败原因
     */
	@Excel(name = "对账失败原因")
	@ApiModelProperty("对账失败原因")
	private String reason;

    /**
     * 充值用户id
     */
	@Excel(name = "充值用户id")
	@ApiModelProperty("充值用户id")
	private Long userId;


}
