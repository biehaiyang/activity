package com.ruoyi.system.service;

import com.ruoyi.system.domain.TOrder;
import com.ruoyi.system.vo.TOrderVo;
import com.ruoyi.system.bo.TOrderQueryBo;
import com.ruoyi.system.bo.TOrderAddBo;
import com.ruoyi.system.bo.TOrderEditBo;
import com.ruoyi.common.core.mybatisplus.core.IServicePlus;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 订单Service接口
 *
 * @author ruoyi
 * @date 2021-09-11
 */
public interface ITOrderService extends IServicePlus<TOrder> {
	/**
	 * 查询单个
	 * @return
	 */
	TOrderVo queryById(Long id);

	/**
	 * 查询列表
	 */
    TableDataInfo<TOrderVo> queryPageList(TOrderQueryBo bo);

	/**
	 * 查询列表
	 */
	List<TOrderVo> queryList(TOrderQueryBo bo);

	/**
	 * 根据新增业务对象插入订单
	 * @param bo 订单新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(TOrderAddBo bo);

	/**
	 * 根据编辑业务对象修改订单
	 * @param bo 订单编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(TOrderEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
