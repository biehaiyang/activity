package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.TDynamic;
import com.ruoyi.common.core.mybatisplus.core.BaseMapperPlus;
import com.ruoyi.common.core.mybatisplus.cache.MybatisPlusRedisCache;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 动态Mapper接口
 *
 * @author ruoyi
 * @date 2021-09-11
 */
public interface TDynamicMapper extends BaseMapperPlus<TDynamic> {

    List<TDynamic> selectDynamic(@Param("page") Integer page,
                                 @Param("size") Integer size);
}
