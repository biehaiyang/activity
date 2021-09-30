package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 广告图片分页查询对象 t_banner
 *
 * @author ruoyi
 * @date 2021-09-11
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("广告图片分页查询对象")
public class TBannerQueryBo extends BaseEntity {

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
     * 广告名称
     */
	@ApiModelProperty("广告名称")
	private String name;
    /**
     * 图片链接
     */
	@ApiModelProperty("图片链接")
	private String imgUrl;
    /**
     * 访问链接
     */
	@ApiModelProperty("访问链接")
	private String clickUrl;
    /**
     * 顺序
     */
	@ApiModelProperty("顺序")
	private String sort;

}
