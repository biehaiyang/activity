package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 动态评论分页查询对象 t_dynamic_comment
 *
 * @author ruoyi
 * @date 2021-09-11
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("动态评论分页查询对象")
public class TDynamicCommentQueryBo extends BaseEntity {

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
     * 动态评论内容
     */
	@ApiModelProperty("动态评论内容")
	private String comment;
    /**
     * 根评论id，第一条评论id的根为0

     */
	@ApiModelProperty("根评论id，第一条评论id的根为0 ")
	private Long rId;
    /**
     * 目评论的id，第一条评论的目的评论为0

     */
	@ApiModelProperty("目评论的id，第一条评论的目的评论为0 ")
	private Long pId;
    /**
     * 用户id
     */
	@ApiModelProperty("用户id")
	private Long userId;
    /**
     * 动态id
     */
	@ApiModelProperty("动态id")
	private Long dynamicId;
    /**
     * 是否允许展示， 默认可以（违规可以删除或者直接隐藏掉，
）
     */
	@ApiModelProperty("是否允许展示， 默认可以（违规可以删除或者直接隐藏掉，）")
	private Integer showFlag;
    /**
     * 被回复用户id，
     */
	@ApiModelProperty("被回复用户id，")
	private Long repliedUserId;

}
