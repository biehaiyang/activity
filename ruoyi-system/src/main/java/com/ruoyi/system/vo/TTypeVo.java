package com.ruoyi.system.vo;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;



/**
 * 所有分类视图对象 t_type
 *
 * @author ruoyi
 * @date 2021-09-12
 */
@Data
@ApiModel("所有分类视图对象")
public class TTypeVo {

	private static final long serialVersionUID = 1L;

	/**
     *  $pkColumn.columnComment
     */
	@ApiModelProperty("$pkColumn.columnComment")
	private Long id;

    /**
     * 分类名称
     */
	@Excel(name = "分类名称")
	@ApiModelProperty("分类名称")
	private String typeName;

    /**
     * 分类图标
     */
	@Excel(name = "分类图标")
	@ApiModelProperty("分类图标")
	private String typeImg;

    /**
     * 跳转链接
     */
	@Excel(name = "跳转链接")
	@ApiModelProperty("跳转链接")
	private String hrefUrl;

    /**
     * 排序
     */
	@Excel(name = "排序")
	@ApiModelProperty("排序")
	private Long sort;


}
