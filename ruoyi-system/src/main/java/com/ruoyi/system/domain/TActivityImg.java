package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 活动图片对象 t_activity_img
 *
 * @author ruoyi
 * @date 2021-10-10
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("t_activity_img")
public class TActivityImg implements Serializable {

    private static final long serialVersionUID=1L;


    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 图片链接
     */
    private String imgUrl;

    /**
     * 1 活动图片 2 活动内容
     */
    private String type;

}
