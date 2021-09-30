package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import javax.validation.constraints.*;



/**
 * 用户浏览历史添加对象 t_history
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@ApiModel("用户浏览历史添加对象")
public class THistoryAddBo {


    /** 创建时间 */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /** 用户id */
    @ApiModelProperty("用户id")
    private Long userId;

    /** 活动id */
    @ApiModelProperty("活动id")
    private Long acvitityId;
}
