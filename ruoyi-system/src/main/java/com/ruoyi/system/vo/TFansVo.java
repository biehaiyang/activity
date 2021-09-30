package com.ruoyi.system.vo;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;



/**
 * 用户关注视图对象 t_fans
 *
 * @author ruoyi
 * @date 2021-09-11
 */
@Data
@ApiModel("用户关注视图对象")
public class TFansVo {

	private static final long serialVersionUID = 1L;

	/**
     *  $pkColumn.columnComment
     */
	@ApiModelProperty("$pkColumn.columnComment")
	private Long id;

    /**
     * 用户id
     */
	@Excel(name = "用户id")
	@ApiModelProperty("用户id")
	private Long userId;

    /**
     * 关注者id
     */
	@Excel(name = "关注者id")
	@ApiModelProperty("关注者id")
	private Long focusId;


}
