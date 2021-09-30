package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 订单对象 t_order
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("t_order")
public class TOrder implements Serializable {

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
     * 活动标题
     */
    private String orderTitle;

    /**
     * 参加活动时间
     */
    private Date takeTime;

    /**
     * 规格
     */
    private String orderSpec;

    /**
     * 人数
     */
    private Long peopleNum;

    /**
     * 订单总金额
     */
    private BigDecimal orderMoney;

    /**
     * 活动地址
     */
    private String address;

    /**
     * 单价
     */
    private BigDecimal unitMoney;

    /**
     * 订单状态 0 待付款 1 待参加 2 待评价 3 已取消
     */
    private String orderStatus;

    /**
     * 支付id
     */
    private String payId;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 1 余额 2 微信 3 支付宝
     */
    private String payType;

}
