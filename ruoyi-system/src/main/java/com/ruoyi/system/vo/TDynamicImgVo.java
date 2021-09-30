package com.ruoyi.system.vo;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;



/**
 * 动态图片视图对象 t_dynamic_img
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@ApiModel("动态图片视图对象")
public class TDynamicImgVo {

	private static final long serialVersionUID = 1L;

	/**
     *  $pkColumn.columnComment
     */
	@ApiModelProperty("$pkColumn.columnComment")
	private Long id;

    /**
     * 动态图片
     */
	@Excel(name = "动态图片")
	@ApiModelProperty("动态图片")
	private String imgUrl;


}
