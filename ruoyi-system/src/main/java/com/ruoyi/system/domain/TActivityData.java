package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import java.util.List;

/**
 * 活动数据对象 t_activity_data
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("t_activity_data")
public class TActivityData implements Serializable {

    private static final long serialVersionUID=1L;


    /**
     * $column.columnComment
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 标题
     */
    private String title;

    /**
     * 分类id
     */
    private String type;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 活动费用 / 人
     */
    private BigDecimal money;

    /**
     * 活动最大限制人数
     */
    private Long maxPeople;

    /**
     * 主办方手机号
     */
    private String sponsorPhone;

    /**
     * 发布人id
     */
    private Long userId;

    /**
     * 发布人名字
     */
    private String userName;

    /**
     * 是否启用规格 0 启用 1 否
     */
    private String specFlag;

    /**
     * 是否启用活动时间 0 启用 1 否
     */
    private String dateFlag;

    /**
     * 浏览数量
     */
    private Long browseNum;

    /**
     * 已报名人数
     */
    private Long alreadyPeople;

    /**
     * 是否推荐 0 否 1 是
     */
    private String isRecommend;

    /**
     * 活动地址
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 详细地址
     */
    private String address;

    @TableField(exist = false)
    private List<TActivityDate> activityDate;

    @TableField(exist = false)
    private List<TActivitySpec> activitySpecs;

}
