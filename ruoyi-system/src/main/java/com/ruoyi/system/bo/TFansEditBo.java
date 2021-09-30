package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import javax.validation.constraints.*;


/**
 * 用户关注编辑对象 t_fans
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@ApiModel("用户关注编辑对象")
public class TFansEditBo {


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
     * 关注者id
     */
    @ApiModelProperty("关注者id")
    private Long focusId;
}
