package com.ruoyi.system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import javax.validation.constraints.*;


import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 活动数据添加对象 t_activity_data
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@ApiModel("活动数据添加对象")
public class TActivityDataAddBo {


    /** 创建时间 */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /** 标题 */
    @ApiModelProperty("标题")
    private String title;

    /** 分类id */
    @ApiModelProperty("分类id")
    private String type;

    /** 开始时间 */
    @ApiModelProperty("开始时间")
    private Date startTime;

    /** 结束时间 */
    @ApiModelProperty("结束时间")
    private Date endTime;

    /** 活动费用 / 人 */
    @ApiModelProperty("活动费用 / 人")
    private BigDecimal money;

    /** 活动最大限制人数 */
    @ApiModelProperty("活动最大限制人数")
    private Long maxPeople;

    /** 主办方手机号 */
    @ApiModelProperty("主办方手机号")
    private String sponsorPhone;

    /** 发布人id */
    @ApiModelProperty("发布人id")
    private Long userId;

    /** 发布人名字 */
    @ApiModelProperty("发布人名字")
    private String userName;

    /** 是否启用规格 0 启用 1 否 */
    @ApiModelProperty("是否启用规格 0 启用 1 否")
    private String specFlag;

    /** 是否启用活动时间 0 启用 1 否 */
    @ApiModelProperty("是否启用活动时间 0 启用 1 否")
    private String dateFlag;

    /** 浏览数量 */
    @ApiModelProperty("浏览数量")
    private Long browseNum;

    /** 已报名人数 */
    @ApiModelProperty("已报名人数")
    private Long alreadyPeople;

    /** 是否推荐 0 否 1 是 */
    @ApiModelProperty("是否推荐 0 否 1 是")
    private String isRecommend;

    /** 活动地址 */
    @ApiModelProperty("活动地址")
    private String province;

    /** 市 */
    @ApiModelProperty("市")
    private String city;

    /** 详细地址 */
    @ApiModelProperty("详细地址")
    private String address;
}
