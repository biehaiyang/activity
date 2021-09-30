package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 用户对象 t_web_user
 *
 * @author ruoyi
 * @date 2021-09-12
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("t_web_user")
public class TWebUser implements Serializable {

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
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 个性签名
     */
    private String userSignature;

    /**
     * 用户头像
     */
    private String headPhoto;

    /**
     * 背景图
     */
    private String backgroundPhoto;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 地址
     */
    private String address;

    /**
     * 用户级别  0 普通会员 1 个人用户 2 商家
     */
    private String userLevel;

    /**
     * 总金额
     */
    private BigDecimal sumMoney;

    /**
     * 冻结金额
     */
    private BigDecimal lockMoney;

    /**
     * 可提现金额
     */
    private BigDecimal allowMoney;

    /**
     * 0 正常 1 封禁
     */
    private String status;

    /**
     * 信誉分
     */
    private BigDecimal creditNum;

    @TableField (exist = false)
    private String token;

}
