package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 所有分类对象 t_type
 *
 * @author ruoyi
 * @date 2021-09-12
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("t_type")
public class TType implements Serializable {

    private static final long serialVersionUID=1L;


    /**
     * $column.columnComment
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 分类名称
     */
    private String typeName;

    /**
     * 分类图标
     */
    private String typeImg;

    /**
     * 跳转链接
     */
    private String hrefUrl;

    /**
     * 排序
     */
    private Long sort;

}
