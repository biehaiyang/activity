package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import javax.validation.constraints.*;


/**
 * 收藏编辑对象 t_collect
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@ApiModel("收藏编辑对象")
public class TCollectEditBo {


    /**
     * $column.columnComment
     */
    @ApiModelProperty("$column.columnComment")
    private Long id;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Long userId;

    /**
     * 活动id
     */
    @ApiModelProperty("活动id")
    private Long acvitityId;
}
