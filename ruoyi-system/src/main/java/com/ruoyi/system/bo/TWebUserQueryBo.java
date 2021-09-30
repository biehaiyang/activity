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
 * 用户分页查询对象 t_web_user
 *
 * @author ruoyi
 * @date 2021-09-12
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("用户分页查询对象")
public class TWebUserQueryBo extends BaseEntity {

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
     * 用户名
     */
	@ApiModelProperty("用户名")
	private String userName;
    /**
     * 手机号
     */
	@ApiModelProperty("手机号")
	private String phone;
    /**
     * 个性签名
     */
	@ApiModelProperty("个性签名")
	private String userSignature;
    /**
     * 用户头像
     */
	@ApiModelProperty("用户头像")
	private String headPhoto;
    /**
     * 背景图
     */
	@ApiModelProperty("背景图")
	private String backgroundPhoto;
    /**
     * 生日
     */
	@ApiModelProperty("生日")
	private Date birthday;
    /**
     * 地址
     */
	@ApiModelProperty("地址")
	private String address;
    /**
     * 用户级别  0 普通会员 1 个人用户 2 商家
     */
	@ApiModelProperty("用户级别  0 普通会员 1 个人用户 2 商家")
	private String userLevel;
    /**
     * 总金额
     */
	@ApiModelProperty("总金额")
	private BigDecimal sumMoney;
    /**
     * 冻结金额
     */
	@ApiModelProperty("冻结金额")
	private BigDecimal lockMoney;
    /**
     * 可提现金额
     */
	@ApiModelProperty("可提现金额")
	private BigDecimal allowMoney;
    /**
     * 0 正常 1 封禁
     */
	@ApiModelProperty("0 正常 1 封禁")
	private String status;
    /**
     * 信誉分
     */
	@ApiModelProperty("信誉分")
	private BigDecimal creditNum;

}
