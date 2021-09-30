package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import javax.validation.constraints.*;


/**
 * 客服编辑对象 t_center
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@ApiModel("客服编辑对象")
public class TCenterEditBo {


    /**
     * $column.columnComment
     */
    @ApiModelProperty("$column.columnComment")
    private Long id;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String phone;

    /**
     * 微信号
     */
    @ApiModelProperty("微信号")
    private String wxcode;

    /**
     * 客服图片
     */
    @ApiModelProperty("客服图片")
    private String imgUrl;
}
