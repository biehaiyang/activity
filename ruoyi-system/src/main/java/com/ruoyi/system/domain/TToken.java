package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;

/**
 * 【请填写功能名称】对象 t_token
 *
 * @author ruoyi
 * @date 2021-04-13
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("t_token")
public class TToken implements Serializable {

private static final long serialVersionUID=1L;


    /** $column.columnComment */
    private Long userId;

    /** token */
    private String token;

    /** 过期时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expireTime;

    /** 更新时间 */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
