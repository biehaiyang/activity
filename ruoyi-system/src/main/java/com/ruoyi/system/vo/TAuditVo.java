package com.ruoyi.system.vo;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;



/**
 * 用户审核视图对象 t_audit
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@ApiModel("用户审核视图对象")
public class TAuditVo {

	private static final long serialVersionUID = 1L;

	/**
     *  $pkColumn.columnComment
     */
	@ApiModelProperty("$pkColumn.columnComment")
	private Long id;

    /**
     * 用户id
     */
	@Excel(name = "用户id")
	@ApiModelProperty("用户id")
	private Long userId;

    /**
     * 身份证正面照片
     */
	@Excel(name = "身份证正面照片")
	@ApiModelProperty("身份证正面照片")
	private String cardFront;

    /**
     * 身份证背面照片
     */
	@Excel(name = "身份证背面照片")
	@ApiModelProperty("身份证背面照片")
	private String cardBack;

    /**
     * 营业执照
     */
	@Excel(name = "营业执照")
	@ApiModelProperty("营业执照")
	private String businessImg;

    /**
     * 认证类型 1 个人 2 商家
     */
	@Excel(name = "认证类型 1 个人 2 商家")
	@ApiModelProperty("认证类型 1 个人 2 商家")
	private String type;

    /**
     * 0 审核失败 1 审核成功
     */
	@Excel(name = "0 审核失败 1 审核成功")
	@ApiModelProperty("0 审核失败 1 审核成功")
	private String status;


}
