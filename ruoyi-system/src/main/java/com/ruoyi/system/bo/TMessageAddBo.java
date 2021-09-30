package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import javax.validation.constraints.*;



/**
 * 消息通知
添加对象 t_message
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@ApiModel("消息通知 添加对象")
public class TMessageAddBo {


    /** 创建时间 */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /** 通知标题 */
    @ApiModelProperty("通知标题")
    private String title;

    /** 通知内容 */
    @ApiModelProperty("通知内容")
    private String content;

    /** 0 未读 1 已读 */
    @ApiModelProperty("0 未读 1 已读")
    private String isRead;

    /** 用户id */
    @ApiModelProperty("用户id")
    private Long userId;
}
