package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 动态对象 t_dynamic
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("t_dynamic")
public class TDynamic implements Serializable {

    private static final long serialVersionUID=1L;


    /**
     * $column.columnComment
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 详细内容
     */
    private String content;

    /**
     * 是否显示定位 0 否 1 是
     */
    private String isAddress;

    /**
     * 定位地址
     */
    private String address;

    /**
     * 0 未删除 1 已删除
     */
    private String deleteFlag;

    /**
     * 点赞数量
     */
    private Long giveNum;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 动态发布时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

}
