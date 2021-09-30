package com.ruoyi.system.service;

import com.ruoyi.system.domain.TMessage;
import com.ruoyi.system.vo.TMessageVo;
import com.ruoyi.system.bo.TMessageQueryBo;
import com.ruoyi.system.bo.TMessageAddBo;
import com.ruoyi.system.bo.TMessageEditBo;
import com.ruoyi.common.core.mybatisplus.core.IServicePlus;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 消息通知
Service接口
 *
 * @author ruoyi
 * @date 2021-09-11
 */
public interface ITMessageService extends IServicePlus<TMessage> {
	/**
	 * 查询单个
	 * @return
	 */
	TMessageVo queryById(Long id);

	/**
	 * 查询列表
	 */
    TableDataInfo<TMessageVo> queryPageList(TMessageQueryBo bo);

	/**
	 * 查询列表
	 */
	List<TMessageVo> queryList(TMessageQueryBo bo);

	/**
	 * 根据新增业务对象插入消息通知

	 * @param bo 消息通知
新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(TMessageAddBo bo);

	/**
	 * 根据编辑业务对象修改消息通知

	 * @param bo 消息通知
编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(TMessageEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
