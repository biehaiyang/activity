package com.ruoyi.system.service;

import com.ruoyi.system.domain.THistory;
import com.ruoyi.system.vo.THistoryVo;
import com.ruoyi.system.bo.THistoryQueryBo;
import com.ruoyi.system.bo.THistoryAddBo;
import com.ruoyi.system.bo.THistoryEditBo;
import com.ruoyi.common.core.mybatisplus.core.IServicePlus;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 用户浏览历史Service接口
 *
 * @author ruoyi
 * @date 2021-09-11
 */
public interface ITHistoryService extends IServicePlus<THistory> {
	/**
	 * 查询单个
	 * @return
	 */
	THistoryVo queryById(Long id);

	/**
	 * 查询列表
	 */
    TableDataInfo<THistoryVo> queryPageList(THistoryQueryBo bo);

	/**
	 * 查询列表
	 */
	List<THistoryVo> queryList(THistoryQueryBo bo);

	/**
	 * 根据新增业务对象插入用户浏览历史
	 * @param bo 用户浏览历史新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(THistoryAddBo bo);

	/**
	 * 根据编辑业务对象修改用户浏览历史
	 * @param bo 用户浏览历史编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(THistoryEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
