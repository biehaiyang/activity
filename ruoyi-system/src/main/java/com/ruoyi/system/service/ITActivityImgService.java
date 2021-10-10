package com.ruoyi.system.service;

import com.ruoyi.system.domain.TActivityImg;
import com.ruoyi.system.vo.TActivityImgVo;
import com.ruoyi.system.bo.TActivityImgQueryBo;
import com.ruoyi.system.bo.TActivityImgAddBo;
import com.ruoyi.system.bo.TActivityImgEditBo;
import com.ruoyi.common.core.mybatisplus.core.IServicePlus;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 活动图片Service接口
 *
 * @author ruoyi
 * @date 2021-10-07
 */
public interface ITActivityImgService extends IServicePlus<TActivityImg> {
	/**
	 * 查询单个
	 * @return
	 */
	TActivityImgVo queryById(Long id);

	/**
	 * 查询列表
	 */
    TableDataInfo<TActivityImgVo> queryPageList(TActivityImgQueryBo bo);

	/**
	 * 查询列表
	 */
	List<TActivityImgVo> queryList(TActivityImgQueryBo bo);

	/**
	 * 根据新增业务对象插入活动图片
	 * @param bo 活动图片新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(TActivityImgAddBo bo);

	/**
	 * 根据编辑业务对象修改活动图片
	 * @param bo 活动图片编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(TActivityImgEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
