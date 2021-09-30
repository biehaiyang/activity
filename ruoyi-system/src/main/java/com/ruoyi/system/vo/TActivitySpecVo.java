package com.ruoyi.system.vo;

import com.ruoyi.common.annotation.Excel;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;



/**
 * 活动规格视图对象 t_activity_spec
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@ApiModel("活动规格视图对象")
public class TActivitySpecVo {

	private static final long serialVersionUID = 1L;

	/**
     *  $pkColumn.columnComment
     */
	@ApiModelProperty("$pkColumn.columnComment")
	private Long id;

    /**
     * 规格名称
     */
	@Excel(name = "规格名称")
	@ApiModelProperty("规格名称")
	private String specName;

    /**
     * 价格
     */
	@Excel(name = "价格")
	@ApiModelProperty("价格")
	private BigDecimal money;

    /**
     * 活动id
     */
	@Excel(name = "活动id")
	@ApiModelProperty("活动id")
	private Long activityId;


}
