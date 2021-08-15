package com.ruoyi.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.ruoyi.common.utils.CharUtil;
import com.ruoyi.system.bo.TTokenAddBo;
import com.ruoyi.system.bo.TTokenEditBo;
import com.ruoyi.system.bo.TTokenQueryBo;
import com.ruoyi.system.domain.TToken;
import com.ruoyi.system.mapper.TTokenMapper;
import com.ruoyi.system.service.ITTokenService;
import com.ruoyi.system.vo.TTokenVo;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author edu
 * @date 2021-04-13
 */
@Service
public class TTokenServiceImpl extends ServiceImpl<TTokenMapper, TToken> implements ITTokenService {

    @Override
    public TTokenVo queryById(Long userId){
        TToken db = this.baseMapper.selectById(userId);
        return BeanUtil.toBean(db, TTokenVo.class);
    }

    @Override
    public List<TTokenVo> queryList(TTokenQueryBo bo) {
        LambdaQueryWrapper<TToken> lqw = Wrappers.lambdaQuery();
        lqw.eq(StrUtil.isNotBlank(bo.getToken()), TToken::getToken, bo.getToken());
        lqw.eq(bo.getExpireTime() != null, TToken::getExpireTime, bo.getExpireTime());
        return entity2Vo(this.list(lqw));
    }

    /**
    * 实体类转化成视图对象
    *
    * @param collection 实体类集合
    * @return
    */
    private List<TTokenVo> entity2Vo(Collection<TToken> collection) {
        List<TTokenVo> voList = collection.stream()
                .map(any -> BeanUtil.toBean(any, TTokenVo.class))
                .collect(Collectors.toList());
        if (collection instanceof Page) {
            Page<TToken> page = (Page<TToken>)collection;
            Page<TTokenVo> pageVo = new Page<>();
            BeanUtil.copyProperties(page,pageVo);
            pageVo.addAll(voList);
            voList = pageVo;
        }
        return voList;
    }

    @Override
    public Boolean insertByAddBo(TTokenAddBo bo) {
        TToken add = BeanUtil.toBean(bo, TToken.class);
        validEntityBeforeSave(add);
        return this.save(add);
    }

    @Override
    public Boolean updateByEditBo(TTokenEditBo bo) {
        TToken update = BeanUtil.toBean(bo, TToken.class);
        validEntityBeforeSave(update);
        return this.updateById(update);
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(TToken entity){
        //TODO 做一些数据校验,如唯一约束
    }

    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return this.removeByIds(ids);
    }

    @Override
    public TToken createToken(Long id) {

        QueryWrapper<TToken> wrapper = new QueryWrapper<TToken>()
                .eq("user_id", id);

        TToken oldToken = baseMapper.selectOne(wrapper);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 7);
        Date time = cal.getTime();

        //生成一个token
        String token = CharUtil.getRandomString(32);

        if (oldToken != null) {
            oldToken.setToken(token);
            oldToken.setExpireTime(time);

            baseMapper.updateByUserId(oldToken);

            return oldToken;
        }

        TToken tToken = new TToken();
        tToken.setUserId(id);
        tToken.setUpdateTime(new Date());

        //设置过期时间为7天
        tToken.setExpireTime(time);

        tToken.setToken(token);

        //保存
        boolean save = this.save(tToken);

        return tToken;
    }
}
