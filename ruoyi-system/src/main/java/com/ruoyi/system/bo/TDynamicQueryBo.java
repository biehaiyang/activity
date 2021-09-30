package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 动态分页查询对象 t_dynamic
 *
 * @author ruoyi
 * @date 2021-09-11
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("动态分页查询对象")
public class TDynamicQueryBo extends BaseEntity {

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
     * 标题
     */
	@ApiModelProperty("标题")
	private String title;
    /**
     * 详细内容
     */
	@ApiModelProperty("详细内容")
	private String content;
    /**
     * 是否显示定位 0 否 1 是
     */
	@ApiModelProperty("是否显示定位 0 否 1 是")
	private String isAddress;
    /**
     * 定位地址
     */
	@ApiModelProperty("定位地址")
	private String address;
    /**
     * 0 未删除 1 已删除
     */
	@ApiModelProperty("0 未删除 1 已删除")
	private String deleteFlag;
    /**
     * 点赞数量
     */
	@ApiModelProperty("点赞数量")
	private Long giveNum;
    /**
     * 用户id
     */
	@ApiModelProperty("用户id")
	private Long userId;

}
