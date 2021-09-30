package com.ruoyi.system.service;

import com.ruoyi.system.domain.TDynamicImg;
import com.ruoyi.system.vo.TDynamicImgVo;
import com.ruoyi.system.bo.TDynamicImgQueryBo;
import com.ruoyi.system.bo.TDynamicImgAddBo;
import com.ruoyi.system.bo.TDynamicImgEditBo;
import com.ruoyi.common.core.mybatisplus.core.IServicePlus;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 动态图片Service接口
 *
 * @author ruoyi
 * @date 2021-09-11
 */
public interface ITDynamicImgService extends IServicePlus<TDynamicImg> {
	/**
	 * 查询单个
	 * @return
	 */
	TDynamicImgVo queryById(Long id);

	/**
	 * 查询列表
	 */
    TableDataInfo<TDynamicImgVo> queryPageList(TDynamicImgQueryBo bo);

	/**
	 * 查询列表
	 */
	List<TDynamicImgVo> queryList(TDynamicImgQueryBo bo);

	/**
	 * 根据新增业务对象插入动态图片
	 * @param bo 动态图片新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(TDynamicImgAddBo bo);

	/**
	 * 根据编辑业务对象修改动态图片
	 * @param bo 动态图片编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(TDynamicImgEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
