package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 动态点赞对象 t_dynamic_star
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("t_dynamic_star")
public class TDynamicStar implements Serializable {

    private static final long serialVersionUID=1L;


    /**
     * 动态点赞表
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 动态id
     */
    private Long dynamicId;

    /**
     * 点赞用户id
     */
    private Long userId;

    /**
     * 被点赞用户id
     */
    private Long starUserId;

    /**
     * 点赞时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

}
