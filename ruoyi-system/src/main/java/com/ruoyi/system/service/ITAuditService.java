package com.ruoyi.system.service;

import com.ruoyi.system.domain.TAudit;
import com.ruoyi.system.vo.TAuditVo;
import com.ruoyi.system.bo.TAuditQueryBo;
import com.ruoyi.system.bo.TAuditAddBo;
import com.ruoyi.system.bo.TAuditEditBo;
import com.ruoyi.common.core.mybatisplus.core.IServicePlus;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 用户审核Service接口
 *
 * @author ruoyi
 * @date 2021-09-11
 */
public interface ITAuditService extends IServicePlus<TAudit> {
	/**
	 * 查询单个
	 * @return
	 */
	TAuditVo queryById(Long id);

	/**
	 * 查询列表
	 */
    TableDataInfo<TAuditVo> queryPageList(TAuditQueryBo bo);

	/**
	 * 查询列表
	 */
	List<TAuditVo> queryList(TAuditQueryBo bo);

	/**
	 * 根据新增业务对象插入用户审核
	 * @param bo 用户审核新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(TAuditAddBo bo);

	/**
	 * 根据编辑业务对象修改用户审核
	 * @param bo 用户审核编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(TAuditEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
