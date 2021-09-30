package com.ruoyi.system.vo;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;



/**
 * 收藏视图对象 t_collect
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@ApiModel("收藏视图对象")
public class TCollectVo {

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
     * 活动id
     */
	@Excel(name = "活动id")
	@ApiModelProperty("活动id")
	private Long acvitityId;


}
