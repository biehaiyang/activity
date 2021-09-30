package com.ruoyi.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.aliyuncs.exceptions.ClientException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ruoyi.common.core.mybatisplus.core.ServicePlusImpl;
import com.ruoyi.common.core.page.PagePlus;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.*;
import com.ruoyi.system.bo.TWebUserAddBo;
import com.ruoyi.system.bo.TWebUserEditBo;
import com.ruoyi.system.bo.TWebUserQueryBo;
import com.ruoyi.system.domain.TMessage;
import com.ruoyi.system.domain.TToken;
import com.ruoyi.system.domain.TWebUser;
import com.ruoyi.system.mapper.TWebUserMapper;
import com.ruoyi.system.service.ITTokenService;
import com.ruoyi.system.service.ITWebUserService;
import com.ruoyi.system.vo.TWebUserVo;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.ruoyi.common.constant.Constants.MESSAGE_FLAG;

/**
 * 用户Service业务层处理
 *
 * @author ruoyi
 * @date 2021-09-12
 */
@Service
public class TWebUserServiceImpl extends ServicePlusImpl<TWebUserMapper, TWebUser> implements ITWebUserService {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private ITTokenService itTokenService;

    @Override
    public TWebUserVo queryById(Long id){
        return getVoById(id, TWebUserVo.class);
    }

    @Override
    public TableDataInfo<TWebUserVo> queryPageList(TWebUserQueryBo bo) {
        PagePlus<TWebUser, TWebUserVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), TWebUserVo.class);
        return PageUtils.buildDataInfo(result);
    }

    @Override
    public List<TWebUserVo> queryList(TWebUserQueryBo bo) {
        return listVo(buildQueryWrapper(bo), TWebUserVo.class);
    }

    private LambdaQueryWrapper<TWebUser> buildQueryWrapper(TWebUserQueryBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<TWebUser> lqw = Wrappers.lambdaQuery();
        lqw.like(StrUtil.isNotBlank(bo.getUserName()), TWebUser::getUserName, bo.getUserName());
        lqw.eq(StrUtil.isNotBlank(bo.getPhone()), TWebUser::getPhone, bo.getPhone());
        lqw.eq(StrUtil.isNotBlank(bo.getUserSignature()), TWebUser::getUserSignature, bo.getUserSignature());
        lqw.eq(StrUtil.isNotBlank(bo.getHeadPhoto()), TWebUser::getHeadPhoto, bo.getHeadPhoto());
        lqw.eq(StrUtil.isNotBlank(bo.getBackgroundPhoto()), TWebUser::getBackgroundPhoto, bo.getBackgroundPhoto());
        lqw.eq(bo.getBirthday() != null, TWebUser::getBirthday, bo.getBirthday());
        lqw.eq(StrUtil.isNotBlank(bo.getAddress()), TWebUser::getAddress, bo.getAddress());
        lqw.eq(StrUtil.isNotBlank(bo.getUserLevel()), TWebUser::getUserLevel, bo.getUserLevel());
        lqw.eq(bo.getSumMoney() != null, TWebUser::getSumMoney, bo.getSumMoney());
        lqw.eq(bo.getLockMoney() != null, TWebUser::getLockMoney, bo.getLockMoney());
        lqw.eq(bo.getAllowMoney() != null, TWebUser::getAllowMoney, bo.getAllowMoney());
        lqw.eq(StrUtil.isNotBlank(bo.getStatus()), TWebUser::getStatus, bo.getStatus());
        lqw.eq(bo.getCreditNum() != null, TWebUser::getCreditNum, bo.getCreditNum());
        return lqw;
    }

    @Override
    public Boolean insertByAddBo(TWebUserAddBo bo) {
        TWebUser add = BeanUtil.toBean(bo, TWebUser.class);
        validEntityBeforeSave(add);
        return save(add);
    }

    @Override
    public Boolean updateByEditBo(TWebUserEditBo bo) {
        TWebUser update = BeanUtil.toBean(bo, TWebUser.class);
        validEntityBeforeSave(update);
        return updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(TWebUser entity){
        //TODO 做一些数据校验,如唯一约束
    }

    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return removeByIds(ids);
    }



    @Override
    public TWebUser registerUser(String phone, String code) {

        if (StringUtils.isBlank(code)) {
            throw new RuntimeException("验证码为空");
        }

        boolean hasKey = redisTemplate.hasKey(MESSAGE_FLAG + phone);
        if (hasKey) {
            String phoneCode = redisTemplate.opsForValue().get(MESSAGE_FLAG + phone).toString();
            if (!code.equals(phoneCode)) {
                throw new RuntimeException("验证码输入有误");
            }
        } else {
            throw new RuntimeException("验证码已过期，请重新获取");
        }

        //验证手机号是否正确
        if (!ValidateUtil.isMobile(phone)) {
            throw new RuntimeException("手机号格式错误");
        }



        TWebUser tWebUser = baseMapper.selectUserByPhone(phone);

        //手机号已注册
        if (tWebUser != null) {

            //生成token
            TToken tToken = itTokenService.createToken(tWebUser.getId());

            tWebUser.setToken(tToken.getToken());

            return tWebUser;
        }

        //手机号未注册
        tWebUser.setPhone(phone);
        tWebUser.setAllowMoney(BigDecimal.ZERO);
        tWebUser.setCreditNum(BigDecimal.ZERO);
        tWebUser.setLockMoney(BigDecimal.ZERO);
        tWebUser.setSumMoney(BigDecimal.ZERO);
        this.save(tWebUser);

        //生成token
        TToken tToken = itTokenService.createToken(tWebUser.getId());
        tWebUser.setToken(tToken.getToken());

        return tWebUser;
    }

    @Override
    public String sendPhone(String phone) {

        //验证手机号是否正确
        if (!ValidateUtil.isMobile(phone)) {
            throw new RuntimeException("手机号格式错误");
        }

        String randomCode = RandomStringGenerator.getRandomNumber4();

        try {
            SMSUtil.sendSms(phone, randomCode);

            redisTemplate.opsForValue().set(MESSAGE_FLAG + phone, randomCode, 5, TimeUnit.MINUTES);

        } catch (ClientException e) {
            e.printStackTrace();
        }
        return "发送成功";
    }
}
