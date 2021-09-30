package com.ruoyi.system.vo;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;



/**
 * 客服视图对象 t_center
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@ApiModel("客服视图对象")
public class TCenterVo {

	private static final long serialVersionUID = 1L;

	/**
     *  $pkColumn.columnComment
     */
	@ApiModelProperty("$pkColumn.columnComment")
	private Long id;

    /**
     * 手机号
     */
	@Excel(name = "手机号")
	@ApiModelProperty("手机号")
	private String phone;

    /**
     * 微信号
     */
	@Excel(name = "微信号")
	@ApiModelProperty("微信号")
	private String wxcode;

    /**
     * 客服图片
     */
	@Excel(name = "客服图片")
	@ApiModelProperty("客服图片")
	private String imgUrl;


}
