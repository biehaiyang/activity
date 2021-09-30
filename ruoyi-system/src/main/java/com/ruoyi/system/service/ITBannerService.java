package com.ruoyi.system.service;

import com.ruoyi.system.domain.TBanner;
import com.ruoyi.system.vo.TBannerVo;
import com.ruoyi.system.bo.TBannerQueryBo;
import com.ruoyi.system.bo.TBannerAddBo;
import com.ruoyi.system.bo.TBannerEditBo;
import com.ruoyi.common.core.mybatisplus.core.IServicePlus;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 广告图片Service接口
 *
 * @author ruoyi
 * @date 2021-09-11
 */
public interface ITBannerService extends IServicePlus<TBanner> {
	/**
	 * 查询单个
	 * @return
	 */
	TBannerVo queryById(Long id);

	/**
	 * 查询列表
	 */
    TableDataInfo<TBannerVo> queryPageList(TBannerQueryBo bo);

	/**
	 * 查询列表
	 */
	List<TBannerVo> queryList(TBannerQueryBo bo);

	/**
	 * 根据新增业务对象插入广告图片
	 * @param bo 广告图片新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(TBannerAddBo bo);

	/**
	 * 根据编辑业务对象修改广告图片
	 * @param bo 广告图片编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(TBannerEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
