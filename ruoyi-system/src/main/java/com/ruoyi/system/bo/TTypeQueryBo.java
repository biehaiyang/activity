package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 所有分类分页查询对象 t_type
 *
 * @author ruoyi
 * @date 2021-09-12
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("所有分类分页查询对象")
public class TTypeQueryBo extends BaseEntity {

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
     * 分类名称
     */
	@ApiModelProperty("分类名称")
	private String typeName;
    /**
     * 分类图标
     */
	@ApiModelProperty("分类图标")
	private String typeImg;
    /**
     * 跳转链接
     */
	@ApiModelProperty("跳转链接")
	private String hrefUrl;
    /**
     * 排序
     */
	@ApiModelProperty("排序")
	private Long sort;

}
