package com.ruoyi.system.bo;

import com.ruoyi.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 【请填写功能名称】分页查询对象 t_token
 *
 * @author ruoyi
 * @date 2021-04-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("【请填写功能名称】分页查询对象")
public class TTokenQueryBo extends BaseEntity {

	/** 分页大小 */
	@ApiModelProperty("分页大小")
	private Integer pageSize;
	/** 当前页数 */
	@ApiModelProperty("当前页数")
	private Integer pageNum;
	/** 排序列 */
	@ApiModelProperty("排序列")
	private String orderByColumn;
	/** 排序的方向desc或者asc */
	@ApiModelProperty(value = "排序的方向", example = "asc,desc")
	private String isAsc;


	/** token */
	@ApiModelProperty("token")
	private String token;
	/** 过期时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty("过期时间")
	private Date expireTime;

}
