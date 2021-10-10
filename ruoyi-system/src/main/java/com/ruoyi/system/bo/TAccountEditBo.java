package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import javax.validation.constraints.*;

import java.math.BigDecimal;

/**
 * 账户详情编辑对象 t_account
 *
 * @author ruoyi
 * @date 2021-10-10
 */
@Data
@ApiModel("账户详情编辑对象")
public class TAccountEditBo {


    /**
     * id
     */
    @ApiModelProperty("id")
    private Long id;

    /**
     * 0 收入 1 支出 2 提现
     */
    @ApiModelProperty("0 收入 1 支出 2 提现")
    private String type;

    /**
     * 金额
     */
    @ApiModelProperty("金额")
    private BigDecimal money;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Long userId;

    /**
     * 用户名称
     */
    @ApiModelProperty("用户名称")
    private String userName;
}
