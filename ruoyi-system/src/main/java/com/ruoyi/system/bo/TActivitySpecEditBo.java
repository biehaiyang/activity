package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import javax.validation.constraints.*;

import java.math.BigDecimal;

/**
 * 活动规格编辑对象 t_activity_spec
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@ApiModel("活动规格编辑对象")
public class TActivitySpecEditBo {


    /**
     * $column.columnComment
     */
    @ApiModelProperty("$column.columnComment")
    private Long id;

    /**
     * 规格名称
     */
    @ApiModelProperty("规格名称")
    private String specName;

    /**
     * 价格
     */
    @ApiModelProperty("价格")
    private BigDecimal money;

    /**
     * 活动id
     */
    @ApiModelProperty("活动id")
    private Long activityId;
}
