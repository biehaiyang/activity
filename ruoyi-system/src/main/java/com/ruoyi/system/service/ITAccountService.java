package com.ruoyi.system.service;

import com.ruoyi.system.domain.TAccount;
import com.ruoyi.system.vo.TAccountVo;
import com.ruoyi.system.bo.TAccountQueryBo;
import com.ruoyi.system.bo.TAccountAddBo;
import com.ruoyi.system.bo.TAccountEditBo;
import com.ruoyi.common.core.mybatisplus.core.IServicePlus;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 账户详情Service接口
 *
 * @author ruoyi
 * @date 2021-10-10
 */
public interface ITAccountService extends IServicePlus<TAccount> {
	/**
	 * 查询单个
	 * @return
	 */
	TAccountVo queryById(Long id);

	/**
	 * 查询列表
	 */
    TableDataInfo<TAccountVo> queryPageList(TAccountQueryBo bo);

	/**
	 * 查询列表
	 */
	List<TAccountVo> queryList(TAccountQueryBo bo);

	/**
	 * 根据新增业务对象插入账户详情
	 * @param bo 账户详情新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(TAccountAddBo bo);

	/**
	 * 根据编辑业务对象修改账户详情
	 * @param bo 账户详情编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(TAccountEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
