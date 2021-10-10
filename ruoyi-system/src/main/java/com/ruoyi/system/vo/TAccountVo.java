package com.ruoyi.system.vo;

import com.ruoyi.common.annotation.Excel;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;



/**
 * 账户详情视图对象 t_account
 *
 * @author ruoyi
 * @date 2021-10-10
 */
@Data
@ApiModel("账户详情视图对象")
public class TAccountVo {

	private static final long serialVersionUID = 1L;

	/**
     *  id
     */
	@ApiModelProperty("id")
	private Long id;

    /**
     * 0 收入 1 支出 2 提现
     */
	@Excel(name = "0 收入 1 支出 2 提现")
	@ApiModelProperty("0 收入 1 支出 2 提现")
	private String type;

    /**
     * 金额
     */
	@Excel(name = "金额")
	@ApiModelProperty("金额")
	private BigDecimal money;

    /**
     * 用户id
     */
	@Excel(name = "用户id")
	@ApiModelProperty("用户id")
	private Long userId;

    /**
     * 用户名称
     */
	@Excel(name = "用户名称")
	@ApiModelProperty("用户名称")
	private String userName;


}
