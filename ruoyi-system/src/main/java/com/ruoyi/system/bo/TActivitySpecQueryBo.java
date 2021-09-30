package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

import java.math.BigDecimal;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 活动规格分页查询对象 t_activity_spec
 *
 * @author ruoyi
 * @date 2021-09-11
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("活动规格分页查询对象")
public class TActivitySpecQueryBo extends BaseEntity {

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
     * 规格名称
     */
	@ApiModelProperty("规格名称")
	private String specName;
    /**
     * 价格
     */
	@ApiModelProperty("价格")
	private BigDecimal money;
    /**
     * 活动id
     */
	@ApiModelProperty("活动id")
	private Long activityId;

}
