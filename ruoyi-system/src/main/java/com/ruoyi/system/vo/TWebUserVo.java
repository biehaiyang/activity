package com.ruoyi.system.vo;

import com.ruoyi.common.annotation.Excel;
import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;



/**
 * 用户视图对象 t_web_user
 *
 * @author ruoyi
 * @date 2021-09-12
 */
@Data
@ApiModel("用户视图对象")
public class TWebUserVo {

	private static final long serialVersionUID = 1L;

	/**
     *  $pkColumn.columnComment
     */
	@ApiModelProperty("$pkColumn.columnComment")
	private Long id;

    /**
     * 用户名
     */
	@Excel(name = "用户名")
	@ApiModelProperty("用户名")
	private String userName;

    /**
     * 手机号
     */
	@Excel(name = "手机号")
	@ApiModelProperty("手机号")
	private String phone;

    /**
     * 个性签名
     */
	@Excel(name = "个性签名")
	@ApiModelProperty("个性签名")
	private String userSignature;

    /**
     * 用户头像
     */
	@Excel(name = "用户头像")
	@ApiModelProperty("用户头像")
	private String headPhoto;

    /**
     * 背景图
     */
	@Excel(name = "背景图")
	@ApiModelProperty("背景图")
	private String backgroundPhoto;

    /**
     * 生日
     */
	@Excel(name = "生日" , width = 30, dateFormat = "yyyy-MM-dd")
	@ApiModelProperty("生日")
	private Date birthday;

    /**
     * 地址
     */
	@Excel(name = "地址")
	@ApiModelProperty("地址")
	private String address;

    /**
     * 用户级别  0 普通会员 1 个人用户 2 商家
     */
	@Excel(name = "用户级别  0 普通会员 1 个人用户 2 商家")
	@ApiModelProperty("用户级别  0 普通会员 1 个人用户 2 商家")
	private String userLevel;

    /**
     * 总金额
     */
	@Excel(name = "总金额")
	@ApiModelProperty("总金额")
	private BigDecimal sumMoney;

    /**
     * 冻结金额
     */
	@Excel(name = "冻结金额")
	@ApiModelProperty("冻结金额")
	private BigDecimal lockMoney;

    /**
     * 可提现金额
     */
	@Excel(name = "可提现金额")
	@ApiModelProperty("可提现金额")
	private BigDecimal allowMoney;

    /**
     * 0 正常 1 封禁
     */
	@Excel(name = "0 正常 1 封禁")
	@ApiModelProperty("0 正常 1 封禁")
	private String status;

    /**
     * 信誉分
     */
	@Excel(name = "信誉分")
	@ApiModelProperty("信誉分")
	private BigDecimal creditNum;


}
