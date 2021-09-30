package com.ruoyi.system.vo;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;



/**
 * 动态点赞视图对象 t_dynamic_star
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@ApiModel("动态点赞视图对象")
public class TDynamicStarVo {

	private static final long serialVersionUID = 1L;

	/**
     *  动态点赞表
     */
	@ApiModelProperty("动态点赞表")
	private Long id;

    /**
     * 动态id
     */
	@Excel(name = "动态id")
	@ApiModelProperty("动态id")
	private Long dynamicId;

    /**
     * 点赞用户id
     */
	@Excel(name = "点赞用户id")
	@ApiModelProperty("点赞用户id")
	private Long userId;

    /**
     * 被点赞用户id
     */
	@Excel(name = "被点赞用户id")
	@ApiModelProperty("被点赞用户id")
	private Long starUserId;


}
