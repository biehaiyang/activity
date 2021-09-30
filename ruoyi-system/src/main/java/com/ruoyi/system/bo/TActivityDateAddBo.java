package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import javax.validation.constraints.*;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 活动时间（分场次）添加对象 t_activity_date
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@ApiModel("活动时间（分场次）添加对象")
public class TActivityDateAddBo {


    /** 创建时间 */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /** 活动id */
    @ApiModelProperty("活动id")
    private Long activityId;

    /** 活动时间 */
    @ApiModelProperty("活动时间")
    private Date activityDate;
}
