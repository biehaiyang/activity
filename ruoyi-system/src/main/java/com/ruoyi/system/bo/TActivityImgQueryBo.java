package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 活动图片分页查询对象 t_activity_img
 *
 * @author ruoyi
 * @date 2021-10-10
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("活动图片分页查询对象")
public class TActivityImgQueryBo extends BaseEntity {

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
     * 图片链接
     */
	@ApiModelProperty("图片链接")
	private String imgUrl;
    /**
     * 1 活动图片 2 活动内容
     */
	@ApiModelProperty("1 活动图片 2 活动内容")
	private String type;

}
