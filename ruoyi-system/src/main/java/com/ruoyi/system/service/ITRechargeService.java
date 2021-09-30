package com.ruoyi.system.service;

import com.ruoyi.system.domain.TRecharge;
import com.ruoyi.system.vo.TRechargeVo;
import com.ruoyi.system.bo.TRechargeQueryBo;
import com.ruoyi.system.bo.TRechargeAddBo;
import com.ruoyi.system.bo.TRechargeEditBo;
import com.ruoyi.common.core.mybatisplus.core.IServicePlus;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 充值Service接口
 *
 * @author ruoyi
 * @date 2021-09-11
 */
public interface ITRechargeService extends IServicePlus<TRecharge> {
	/**
	 * 查询单个
	 * @return
	 */
	TRechargeVo queryById(Long id);

	/**
	 * 查询列表
	 */
    TableDataInfo<TRechargeVo> queryPageList(TRechargeQueryBo bo);

	/**
	 * 查询列表
	 */
	List<TRechargeVo> queryList(TRechargeQueryBo bo);

	/**
	 * 根据新增业务对象插入充值
	 * @param bo 充值新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(TRechargeAddBo bo);

	/**
	 * 根据编辑业务对象修改充值
	 * @param bo 充值编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(TRechargeEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
