package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import javax.validation.constraints.*;


/**
 * 动态点赞编辑对象 t_dynamic_star
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@ApiModel("动态点赞编辑对象")
public class TDynamicStarEditBo {


    /**
     * 动态点赞表
     */
    @ApiModelProperty("动态点赞表")
    private Long id;

    /**
     * 动态id
     */
    @ApiModelProperty("动态id")
    @NotNull(message = "动态id不能为空")
    private Long dynamicId;

    /**
     * 点赞用户id
     */
    @ApiModelProperty("点赞用户id")
    @NotNull(message = "点赞用户id不能为空")
    private Long userId;

    /**
     * 被点赞用户id
     */
    @ApiModelProperty("被点赞用户id")
    @NotNull(message = "被点赞用户id不能为空")
    private Long starUserId;
}
