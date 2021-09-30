package com.ruoyi.system.vo;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;



/**
 * 广告图片视图对象 t_banner
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@ApiModel("广告图片视图对象")
public class TBannerVo {

	private static final long serialVersionUID = 1L;

	/**
     *  $pkColumn.columnComment
     */
	@ApiModelProperty("$pkColumn.columnComment")
	private Long id;

    /**
     * 广告名称
     */
	@Excel(name = "广告名称")
	@ApiModelProperty("广告名称")
	private String name;

    /**
     * 图片链接
     */
	@Excel(name = "图片链接")
	@ApiModelProperty("图片链接")
	private String imgUrl;

    /**
     * 访问链接
     */
	@Excel(name = "访问链接")
	@ApiModelProperty("访问链接")
	private String clickUrl;

    /**
     * 顺序
     */
	@Excel(name = "顺序")
	@ApiModelProperty("顺序")
	private String sort;


}
