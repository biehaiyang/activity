package com.ruoyi.system.vo;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;



/**
 * 动态评论视图对象 t_dynamic_comment
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@ApiModel("动态评论视图对象")
public class TDynamicCommentVo {

	private static final long serialVersionUID = 1L;

	/**
     *  主键id
     */
	@ApiModelProperty("主键id")
	private Integer id;

    /**
     * 动态评论内容
     */
	@Excel(name = "动态评论内容")
	@ApiModelProperty("动态评论内容")
	private String comment;

    /**
     * 根评论id，第一条评论id的根为0

     */
	@Excel(name = "根评论id，第一条评论id的根为0 ")
	@ApiModelProperty("根评论id，第一条评论id的根为0 ")
	private Long rId;

    /**
     * 目评论的id，第一条评论的目的评论为0

     */
	@Excel(name = "目评论的id，第一条评论的目的评论为0 ")
	@ApiModelProperty("目评论的id，第一条评论的目的评论为0 ")
	private Long pId;

    /**
     * 用户id
     */
	@Excel(name = "用户id")
	@ApiModelProperty("用户id")
	private Long userId;

    /**
     * 动态id
     */
	@Excel(name = "动态id")
	@ApiModelProperty("动态id")
	private Long dynamicId;

    /**
     * 是否允许展示， 默认可以（违规可以删除或者直接隐藏掉，
）
     */
	@Excel(name = "是否允许展示， 默认可以" , readConverterExp = "违=规可以删除或者直接隐藏掉， ")
	@ApiModelProperty("是否允许展示， 默认可以（违规可以删除或者直接隐藏掉，）")
	private Integer showFlag;

    /**
     * 被回复用户id，
     */
	@Excel(name = "被回复用户id，")
	@ApiModelProperty("被回复用户id，")
	private Long repliedUserId;


}
