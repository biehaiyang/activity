package com.ruoyi.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.system.bo.TTokenAddBo;
import com.ruoyi.system.bo.TTokenEditBo;
import com.ruoyi.system.bo.TTokenQueryBo;
import com.ruoyi.system.domain.TToken;
import com.ruoyi.system.vo.TTokenVo;
import java.util.Collection;
import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author edu
 * @date 2021-04-13
 */
public interface ITTokenService extends IService<TToken> {
	/**
	 * 查询单个
	 * @return
	 */
	TTokenVo queryById(Long userId);

	/**
	 * 查询列表
	 */
	List<TTokenVo> queryList(TTokenQueryBo bo);

	/**
	 * 根据新增业务对象插入【请填写功能名称】
	 * @param bo 【请填写功能名称】新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(TTokenAddBo bo);

	/**
	 * 根据编辑业务对象修改【请填写功能名称】
	 * @param bo 【请填写功能名称】编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(TTokenEditBo bo);

	/**
	 * 校验并删除数据
	 * @param ids 主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);

	/**
	 * 生成token
	 * @param id
	 * @return
	 */
    TToken createToken(Long id);
}
