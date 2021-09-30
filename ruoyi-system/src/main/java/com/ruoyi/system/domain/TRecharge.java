package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 充值对象 t_recharge
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("t_recharge")
public class TRecharge implements Serializable {

    private static final long serialVersionUID=1L;


    /**
     * $column.columnComment
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 流水号
     */
    private String seqNoNo;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 充值金额
     */
    private BigDecimal amt;

    /**
     * 充值类型： 1-支付宝，2-银行卡
     */
    private Integer payType;

    /**
     * 充值状态： 0-初始创建，1-待对账，2-对账失败，3-对账成功，99-充值成功
     */
    private Integer done;

    /**
     * 备注
     */
    private String summary;

    /**
     * 对账失败原因
     */
    private String reason;

    /**
     * 充值用户id
     */
    private Long userId;

}
