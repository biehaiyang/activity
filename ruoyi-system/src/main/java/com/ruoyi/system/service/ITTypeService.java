package com.ruoyi.system.service;

import com.ruoyi.system.domain.TType;
import com.ruoyi.system.vo.TTypeVo;
import com.ruoyi.system.bo.TTypeQueryBo;
import com.ruoyi.system.bo.TTypeAddBo;
import com.ruoyi.system.bo.TTypeEditBo;
import com.ruoyi.common.core.mybatisplus.core.IServicePlus;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 所有分类Service接口
 *
 * @author ruoyi
 * @date 2021-09-12
 */
public interface ITTypeService extends IServicePlus<TType> {
	/**
	 * 查询单个
	 * @return
	 */
	TTypeVo queryById(Long id);

	/**
	 * 查询列表
	 */
    TableDataInfo<TTypeVo> queryPageList(TTypeQueryBo bo);

	/**
	 * 查询列表
	 */
	List<TTypeVo> queryList(TTypeQueryBo bo);

	/**
	 * 根据新增业务对象插入所有分类
	 * @param bo 所有分类新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(TTypeAddBo bo);

	/**
	 * 根据编辑业务对象修改所有分类
	 * @param bo 所有分类编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(TTypeEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
