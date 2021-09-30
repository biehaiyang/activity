package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 客服对象 t_center
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("t_center")
public class TCenter implements Serializable {

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
     * 手机号
     */
    private String phone;

    /**
     * 微信号
     */
    private String wxcode;

    /**
     * 客服图片
     */
    private String imgUrl;

}
