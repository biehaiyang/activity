package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 活动时间（分场次）分页查询对象 t_activity_date
 *
 * @author ruoyi
 * @date 2021-09-11
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("活动时间（分场次）分页查询对象")
public class TActivityDateQueryBo extends BaseEntity {

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
     * 活动id
     */
	@ApiModelProperty("活动id")
	private Long activityId;
    /**
     * 活动时间
     */
	@ApiModelProperty("活动时间")
	private Date activityDate;

}
