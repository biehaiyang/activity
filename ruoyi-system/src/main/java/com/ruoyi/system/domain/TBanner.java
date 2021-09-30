package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 广告图片对象 t_banner
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("t_banner")
public class TBanner implements Serializable {

    private static final long serialVersionUID=1L;


    /**
     * $column.columnComment
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 广告名称
     */
    private String name;

    /**
     * 图片链接
     */
    private String imgUrl;

    /**
     * 访问链接
     */
    private String clickUrl;

    /**
     * 顺序
     */
    private String sort;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

}
