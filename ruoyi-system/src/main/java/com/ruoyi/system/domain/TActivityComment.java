package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 活动评论对象 t_activity_comment
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("t_activity_comment")
public class TActivityComment implements Serializable {

    private static final long serialVersionUID=1L;


    /**
     * 主键id
     */
    @TableId(value = "id")
    private Integer id;

    /**
     * 评论内容
     */
    private String comment;

    /**
     * 满意度星级:1~5,发帖评论为0
     */
    private Integer starLv;

    /**
     * 根评论id，第一条评论id的根为0

     */
    private Long rId;

    /**
     * 目评论的id，第一条评论的目的评论为0

     */
    private Long pId;

    /**
     * 评论时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 活动id， 发帖评论填0
     */
    private Long activityId;

    /**
     * 是否允许展示， 默认可以（违规可以删除或者直接隐藏掉，
）
     */
    private Integer showFlag;

    /**
     * 被回复用户id，
     */
    private Long repliedId;

}
