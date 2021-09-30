package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import javax.validation.constraints.*;


/**
 * 广告图片编辑对象 t_banner
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@ApiModel("广告图片编辑对象")
public class TBannerEditBo {


    /**
     * $column.columnComment
     */
    @ApiModelProperty("$column.columnComment")
    private Long id;

    /**
     * 广告名称
     */
    @ApiModelProperty("广告名称")
    private String name;

    /**
     * 图片链接
     */
    @ApiModelProperty("图片链接")
    private String imgUrl;

    /**
     * 访问链接
     */
    @ApiModelProperty("访问链接")
    private String clickUrl;

    /**
     * 顺序
     */
    @ApiModelProperty("顺序")
    private String sort;
}
