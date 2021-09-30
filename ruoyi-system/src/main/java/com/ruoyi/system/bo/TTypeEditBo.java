package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import javax.validation.constraints.*;


/**
 * 所有分类编辑对象 t_type
 *
 * @author ruoyi
 * @date 2021-09-12
 */
@Data
@ApiModel("所有分类编辑对象")
public class TTypeEditBo {


    /**
     * $column.columnComment
     */
    @ApiModelProperty("$column.columnComment")
    private Long id;

    /**
     * 分类名称
     */
    @ApiModelProperty("分类名称")
    private String typeName;

    /**
     * 分类图标
     */
    @ApiModelProperty("分类图标")
    private String typeImg;

    /**
     * 跳转链接
     */
    @ApiModelProperty("跳转链接")
    private String hrefUrl;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Long sort;
}
