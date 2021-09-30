package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 动态评论对象 t_dynamic_comment
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("t_dynamic_comment")
public class TDynamicComment implements Serializable {

    private static final long serialVersionUID=1L;


    /**
     * 主键id
     */
    @TableId(value = "id")
    private Integer id;

    /**
     * 动态评论内容
     */
    private String comment;

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
     * 动态id
     */
    private Long dynamicId;

    /**
     * 是否允许展示， 默认可以（违规可以删除或者直接隐藏掉，
）
     */
    private Integer showFlag;

    /**
     * 被回复用户id，
     */
    private Long repliedUserId;

}
