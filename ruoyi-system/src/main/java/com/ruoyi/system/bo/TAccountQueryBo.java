package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

import java.math.BigDecimal;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 账户详情分页查询对象 t_account
 *
 * @author ruoyi
 * @date 2021-10-10
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("账户详情分页查询对象")
public class TAccountQueryBo extends BaseEntity {

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
     * 0 收入 1 支出 2 提现
     */
	@ApiModelProperty("0 收入 1 支出 2 提现")
	private String type;
    /**
     * 金额
     */
	@ApiModelProperty("金额")
	private BigDecimal money;
    /**
     * 用户id
     */
	@ApiModelProperty("用户id")
	private Long userId;
    /**
     * 用户名称
     */
	@ApiModelProperty("用户名称")
	private String userName;

}
