package com.ruoyi.system.vo;

import com.ruoyi.common.annotation.Excel;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;



/**
 * 活动时间（分场次）视图对象 t_activity_date
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@ApiModel("活动时间（分场次）视图对象")
public class TActivityDateVo {

	private static final long serialVersionUID = 1L;

	/**
     *  $pkColumn.columnComment
     */
	@ApiModelProperty("$pkColumn.columnComment")
	private Long id;

    /**
     * 活动id
     */
	@Excel(name = "活动id")
	@ApiModelProperty("活动id")
	private Long activityId;

    /**
     * 活动时间
     */
	@Excel(name = "活动时间" , width = 30, dateFormat = "yyyy-MM-dd")
	@ApiModelProperty("活动时间")
	private Date activityDate;


}
