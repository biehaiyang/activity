package com.ruoyi.system.vo;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;



/**
 * 消息通知
视图对象 t_message
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@ApiModel("消息通知 视图对象")
public class TMessageVo {

	private static final long serialVersionUID = 1L;

	/**
     *  $pkColumn.columnComment
     */
	@ApiModelProperty("$pkColumn.columnComment")
	private Long id;

    /**
     * 通知标题
     */
	@Excel(name = "通知标题")
	@ApiModelProperty("通知标题")
	private String title;

    /**
     * 通知内容
     */
	@Excel(name = "通知内容")
	@ApiModelProperty("通知内容")
	private String content;

    /**
     * 0 未读 1 已读
     */
	@Excel(name = "0 未读 1 已读")
	@ApiModelProperty("0 未读 1 已读")
	private String isRead;

    /**
     * 用户id
     */
	@Excel(name = "用户id")
	@ApiModelProperty("用户id")
	private Long userId;


}
