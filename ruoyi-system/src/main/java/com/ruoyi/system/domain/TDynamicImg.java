package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 动态图片对象 t_dynamic_img
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("t_dynamic_img")
public class TDynamicImg implements Serializable {

    private static final long serialVersionUID=1L;


    /**
     * $column
     */
    private Long id;

    /**
     * 动态图片
     */
    private String imgUrl;

}
