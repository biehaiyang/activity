package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import javax.validation.constraints.*;



/**
 * 动态图片添加对象 t_dynamic_img
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@ApiModel("动态图片添加对象")
public class TDynamicImgAddBo {


    /** 动态图片 */
    @ApiModelProperty("动态图片")
    private String imgUrl;
}
