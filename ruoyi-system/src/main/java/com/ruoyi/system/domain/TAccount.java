package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 账户详情对象 t_account
 *
 * @author ruoyi
 * @date 2021-10-10
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("t_account")
public class TAccount implements Serializable {

    private static final long serialVersionUID=1L;


    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 0 收入 1 支出 2 提现
     */
    private String type;

    /**
     * 金额
     */
    private BigDecimal money;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名称
     */
    private String userName;

}
