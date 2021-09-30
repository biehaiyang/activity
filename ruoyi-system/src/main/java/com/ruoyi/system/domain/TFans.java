package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 用户关注对象 t_fans
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("t_fans")
public class TFans implements Serializable {

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
     * 用户id
     */
    private Long userId;

    /**
     * 关注者id
     */
    private Long focusId;

}
