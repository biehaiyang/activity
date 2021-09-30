package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 用户审核对象 t_audit
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("t_audit")
public class TAudit implements Serializable {

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
     * 身份证正面照片
     */
    private String cardFront;

    /**
     * 身份证背面照片
     */
    private String cardBack;

    /**
     * 营业执照
     */
    private String businessImg;

    /**
     * 认证类型 1 个人 2 商家
     */
    private String type;

    /**
     * 0 审核失败 1 审核成功
     */
    private String status;

}
