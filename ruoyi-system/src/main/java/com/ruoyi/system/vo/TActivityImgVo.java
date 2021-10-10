package com.ruoyi.system.vo;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;



/**
 * 活动图片视图对象 t_activity_img
 *
 * @author ruoyi
 * @date 2021-10-10
 */
@Data
@ApiModel("活动图片视图对象")
public class TActivityImgVo {

	private static final long serialVersionUID = 1L;

	/**
     *  id
     */
	@ApiModelProperty("id")
	private Long id;

    /**
     * 图片链接
     */
	@Excel(name = "图片链接")
	@ApiModelProperty("图片链接")
	private String imgUrl;

    /**
     * 1 活动图片 2 活动内容
     */
	@Excel(name = "1 活动图片 2 活动内容")
	@ApiModelProperty("1 活动图片 2 活动内容")
	private String type;


}
