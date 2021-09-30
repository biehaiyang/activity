package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 活动评论分页查询对象 t_activity_comment
 *
 * @author ruoyi
 * @date 2021-09-11
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("活动评论分页查询对象")
public class TActivityCommentQueryBo extends BaseEntity {

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
     * 评论内容
     */
	@ApiModelProperty("评论内容")
	private String comment;
    /**
     * 满意度星级:1~5,发帖评论为0
     */
	@ApiModelProperty("满意度星级:1~5,发帖评论为0")
	private Integer starLv;
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
     * 活动id， 发帖评论填0
     */
	@ApiModelProperty("活动id， 发帖评论填0")
	private Long activityId;
    /**
     * 是否允许展示， 默认可以（违规可以删除或者直接隐藏掉）
     */
	@ApiModelProperty("是否允许展示， 默认可以（违规可以删除或者直接隐藏掉，")
	private Integer showFlag;
    /**
     * 被回复用户id，
     */
	@ApiModelProperty("被回复用户id，")
	private Long repliedId;

}
