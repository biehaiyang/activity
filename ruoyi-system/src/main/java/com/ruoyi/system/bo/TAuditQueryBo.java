package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户审核分页查询对象 t_audit
 *
 * @author ruoyi
 * @date 2021-09-11
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("用户审核分页查询对象")
public class TAuditQueryBo extends BaseEntity {

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
     * 身份证正面照片
     */
	@ApiModelProperty("身份证正面照片")
	private String cardFront;
    /**
     * 身份证背面照片
     */
	@ApiModelProperty("身份证背面照片")
	private String cardBack;
    /**
     * 营业执照
     */
	@ApiModelProperty("营业执照")
	private String businessImg;
    /**
     * 认证类型 1 个人 2 商家
     */
	@ApiModelProperty("认证类型 1 个人 2 商家")
	private String type;
    /**
     * 0 审核失败 1 审核成功
     */
	@ApiModelProperty("0 审核失败 1 审核成功")
	private String status;

}
