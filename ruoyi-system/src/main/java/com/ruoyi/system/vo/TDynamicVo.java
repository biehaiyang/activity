package com.ruoyi.system.vo;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;



/**
 * 动态视图对象 t_dynamic
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@ApiModel("动态视图对象")
public class TDynamicVo {

	private static final long serialVersionUID = 1L;

	/**
     *  $pkColumn.columnComment
     */
	@ApiModelProperty("$pkColumn.columnComment")
	private Long id;

    /**
     * 标题
     */
	@Excel(name = "标题")
	@ApiModelProperty("标题")
	private String title;

    /**
     * 详细内容
     */
	@Excel(name = "详细内容")
	@ApiModelProperty("详细内容")
	private String content;

    /**
     * 是否显示定位 0 否 1 是
     */
	@Excel(name = "是否显示定位 0 否 1 是")
	@ApiModelProperty("是否显示定位 0 否 1 是")
	private String isAddress;

    /**
     * 定位地址
     */
	@Excel(name = "定位地址")
	@ApiModelProperty("定位地址")
	private String address;

    /**
     * 0 未删除 1 已删除
     */
	@Excel(name = "0 未删除 1 已删除")
	@ApiModelProperty("0 未删除 1 已删除")
	private String deleteFlag;

    /**
     * 点赞数量
     */
	@Excel(name = "点赞数量")
	@ApiModelProperty("点赞数量")
	private Long giveNum;

    /**
     * 用户id
     */
	@Excel(name = "用户id")
	@ApiModelProperty("用户id")
	private Long userId;


}
