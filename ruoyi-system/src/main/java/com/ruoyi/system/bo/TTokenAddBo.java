package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

/**
 * 【请填写功能名称】添加对象 t_token
 *
 * @author ruoyi
 * @date 2021-04-13
 */
@Data
@ApiModel("【请填写功能名称】添加对象")
public class TTokenAddBo {

    /** token */
    @ApiModelProperty("token")
    private String token;
    /** 过期时间 */
    @ApiModelProperty("过期时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expireTime;
    /** 更新时间 */
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
