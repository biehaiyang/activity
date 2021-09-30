package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import javax.validation.constraints.*;



/**
 * 用户审核添加对象 t_audit
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@ApiModel("用户审核添加对象")
public class TAuditAddBo {


    /** 创建时间 */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /** 用户id */
    @ApiModelProperty("用户id")
    private Long userId;

    /** 身份证正面照片 */
    @ApiModelProperty("身份证正面照片")
    private String cardFront;

    /** 身份证背面照片 */
    @ApiModelProperty("身份证背面照片")
    private String cardBack;

    /** 营业执照 */
    @ApiModelProperty("营业执照")
    private String businessImg;

    /** 认证类型 1 个人 2 商家 */
    @ApiModelProperty("认证类型 1 个人 2 商家")
    private String type;

    /** 0 审核失败 1 审核成功 */
    @ApiModelProperty("0 审核失败 1 审核成功")
    private String status;
}
