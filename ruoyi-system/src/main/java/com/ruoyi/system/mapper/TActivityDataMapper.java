package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.TActivityData;
import com.ruoyi.common.core.mybatisplus.core.BaseMapperPlus;
import com.ruoyi.common.core.mybatisplus.cache.MybatisPlusRedisCache;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 活动数据Mapper接口
 *
 * @author ruoyi
 * @date 2021-09-11
 */
public interface TActivityDataMapper extends BaseMapperPlus<TActivityData> {

    List<TActivityData> selectByType(@Param("id") Long id,
                                     @Param("page") Integer page,
                                     @Param("size") Integer size);
}
