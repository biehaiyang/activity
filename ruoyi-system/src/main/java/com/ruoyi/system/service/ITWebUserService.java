package com.ruoyi.system.service;

import com.ruoyi.system.bo.TWebUserAddBo;
import com.ruoyi.system.bo.TWebUserEditBo;
import com.ruoyi.system.bo.TWebUserQueryBo;
import com.ruoyi.system.domain.TWebUser;
import com.ruoyi.system.vo.TWebUserVo;
import com.ruoyi.common.core.mybatisplus.core.IServicePlus;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 用户Service接口
 *
 * @author ruoyi
 * @date 2021-09-12
 */
public interface ITWebUserService extends IServicePlus<TWebUser> {
	/**
	 * 查询单个
	 * @return
	 */
	TWebUserVo queryById(Long id);

	/**
	 * 查询列表
	 */
    TableDataInfo<TWebUserVo> queryPageList(TWebUserQueryBo bo);

	/**
	 * 查询列表
	 */
	List<TWebUserVo> queryList(TWebUserQueryBo bo);

	/**
	 * 根据新增业务对象插入用户
	 * @param bo 用户新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(TWebUserAddBo bo);

	/**
	 * 根据编辑业务对象修改用户
	 * @param bo 用户编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(TWebUserEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);

	TWebUser registerUser(String phone, String code);

	String sendPhone(String phone);

}
