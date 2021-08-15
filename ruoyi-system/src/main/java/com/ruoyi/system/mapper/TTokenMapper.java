package com.ruoyi.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.system.domain.TToken;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author edu
 * @date 2021-04-13
 */
public interface TTokenMapper extends BaseMapper<TToken> {

    void updateByUserId(TToken oldToken);
}
