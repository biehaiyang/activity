package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 动态图片对象 t_dynamic_img
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("t_dynamic_img")
public class TDynamicImg implements Serializable {

    private static final long serialVersionUID=1L;


    /**
     * $column.columnComment
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 动态图片
     */
    private String imgUrl;

}
