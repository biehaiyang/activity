package com.ruoyi.system.service;

import com.ruoyi.system.domain.TCollect;
import com.ruoyi.system.vo.TCollectVo;
import com.ruoyi.system.bo.TCollectQueryBo;
import com.ruoyi.system.bo.TCollectAddBo;
import com.ruoyi.system.bo.TCollectEditBo;
import com.ruoyi.common.core.mybatisplus.core.IServicePlus;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 收藏Service接口
 *
 * @author ruoyi
 * @date 2021-09-11
 */
public interface ITCollectService extends IServicePlus<TCollect> {
	/**
	 * 查询单个
	 * @return
	 */
	TCollectVo queryById(Long id);

	/**
	 * 查询列表
	 */
    TableDataInfo<TCollectVo> queryPageList(TCollectQueryBo bo);

	/**
	 * 查询列表
	 */
	List<TCollectVo> queryList(TCollectQueryBo bo);

	/**
	 * 根据新增业务对象插入收藏
	 * @param bo 收藏新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(TCollectAddBo bo);

	/**
	 * 根据编辑业务对象修改收藏
	 * @param bo 收藏编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(TCollectEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
