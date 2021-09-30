package com.ruoyi.system.mapper;

import com.ruoyi.common.core.mybatisplus.core.BaseMapperPlus;
import com.ruoyi.system.domain.TWebUser;
import org.apache.ibatis.annotations.Param;

/**
 * 用户Mapper接口
 *
 * @author ruoyi
 * @date 2021-09-12
 */
public interface TWebUserMapper extends BaseMapperPlus<TWebUser> {

    TWebUser selectUserByPhone(@Param("phone") String phone);
}
