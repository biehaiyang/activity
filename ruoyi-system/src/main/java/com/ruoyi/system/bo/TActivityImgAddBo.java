package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import javax.validation.constraints.*;



/**
 * 活动图片添加对象 t_activity_img
 *
 * @author ruoyi
 * @date 2021-10-10
 */
@Data
@ApiModel("活动图片添加对象")
public class TActivityImgAddBo {


    /** 创建时间 */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /** 图片链接 */
    @ApiModelProperty("图片链接")
    private String imgUrl;

    /** 1 活动图片 2 活动内容 */
    @ApiModelProperty("1 活动图片 2 活动内容")
    private String type;
}
