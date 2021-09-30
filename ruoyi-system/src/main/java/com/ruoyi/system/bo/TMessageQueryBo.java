package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 消息通知
分页查询对象 t_message
 *
 * @author ruoyi
 * @date 2021-09-11
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("消息通知 分页查询对象")
public class TMessageQueryBo extends BaseEntity {

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
     * 通知标题
     */
	@ApiModelProperty("通知标题")
	private String title;
    /**
     * 通知内容
     */
	@ApiModelProperty("通知内容")
	private String content;
    /**
     * 0 未读 1 已读
     */
	@ApiModelProperty("0 未读 1 已读")
	private String isRead;
    /**
     * 用户id
     */
	@ApiModelProperty("用户id")
	private Long userId;

}
