package com.ruoyi.system.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


/**
 * 【请填写功能名称】视图对象 mall_package
 *
 * @author ruoyi
 * @date 2021-04-13
 */
@Data
@ApiModel("【请填写功能名称】视图对象")
public class TTokenVo {
	private static final long serialVersionUID = 1L;

	/** $pkColumn.columnComment */
	@ApiModelProperty("$pkColumn.columnComment")
	private Long userId;

	/** token */
	@ApiModelProperty("token")
	private String token;
	/** 过期时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty("过期时间")
	private Date expireTime;

}
