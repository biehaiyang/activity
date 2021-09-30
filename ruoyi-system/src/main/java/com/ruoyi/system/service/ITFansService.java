package com.ruoyi.system.service;

import com.ruoyi.system.domain.TFans;
import com.ruoyi.system.vo.TFansVo;
import com.ruoyi.system.bo.TFansQueryBo;
import com.ruoyi.system.bo.TFansAddBo;
import com.ruoyi.system.bo.TFansEditBo;
import com.ruoyi.common.core.mybatisplus.core.IServicePlus;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 用户关注Service接口
 *
 * @author ruoyi
 * @date 2021-09-11
 */
public interface ITFansService extends IServicePlus<TFans> {
	/**
	 * 查询单个
	 * @return
	 */
	TFansVo queryById(Long id);

	/**
	 * 查询列表
	 */
    TableDataInfo<TFansVo> queryPageList(TFansQueryBo bo);

	/**
	 * 查询列表
	 */
	List<TFansVo> queryList(TFansQueryBo bo);

	/**
	 * 根据新增业务对象插入用户关注
	 * @param bo 用户关注新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(TFansAddBo bo);

	/**
	 * 根据编辑业务对象修改用户关注
	 * @param bo 用户关注编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(TFansEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
