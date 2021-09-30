package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import javax.validation.constraints.*;


/**
 * 动态评论编辑对象 t_dynamic_comment
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@ApiModel("动态评论编辑对象")
public class TDynamicCommentEditBo {


    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    private Integer id;

    /**
     * 动态评论内容
     */
    @ApiModelProperty("动态评论内容")
    @NotBlank(message = "动态评论内容不能为空")
    private String comment;

    /**
     * 根评论id，第一条评论id的根为0

     */
    @ApiModelProperty("根评论id，第一条评论id的根为0 ")
    @NotNull(message = "根评论id，第一条评论id的根为0 不能为空")
    private Long rId;

    /**
     * 目评论的id，第一条评论的目的评论为0

     */
    @ApiModelProperty("目评论的id，第一条评论的目的评论为0 ")
    @NotNull(message = "目评论的id，第一条评论的目的评论为0 不能为空")
    private Long pId;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    @NotNull(message = "用户id不能为空")
    private Long userId;

    /**
     * 动态id
     */
    @ApiModelProperty("动态id")
    @NotNull(message = "动态id不能为空")
    private Long dynamicId;

    /**
     * 是否允许展示， 默认可以（违规可以删除或者直接隐藏掉，
）
     */
    @ApiModelProperty("是否允许展示， 默认可以（违规可以删除或者直接隐藏掉，）")
    @NotNull(message = "是否允许展示， 默认可以（违规可以删除或者直接隐藏掉，）不能为空")
    private Integer showFlag;

    /**
     * 被回复用户id，
     */
    @ApiModelProperty("被回复用户id，")
    @NotNull(message = "被回复用户id，不能为空")
    private Long repliedUserId;
}
