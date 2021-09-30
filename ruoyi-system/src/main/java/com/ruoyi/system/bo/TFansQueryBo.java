package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户关注分页查询对象 t_fans
 *
 * @author ruoyi
 * @date 2021-09-11
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("用户关注分页查询对象")
public class TFansQueryBo extends BaseEntity {

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
     * 用户id
     */
	@ApiModelProperty("用户id")
	private Long userId;
    /**
     * 关注者id
     */
	@ApiModelProperty("关注者id")
	private Long focusId;

}
