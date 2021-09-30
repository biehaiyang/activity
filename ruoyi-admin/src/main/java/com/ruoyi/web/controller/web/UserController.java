package com.ruoyi.web.controller.web;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.TWebUser;
import com.ruoyi.system.service.ITWebUserService;
import com.ruoyi.web.controller.token.LoginUser;
import com.ruoyi.web.controller.token.Token;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/web/user")
@CrossOrigin
public class UserController {

	@Resource
	private ITWebUserService webUserService;

	@PostMapping("/registerUser")
	public AjaxResult registerUser (
		@ApiParam(value = "手机号", name = "phone", required = true) String phone,
		@ApiParam(value = "验证码", name = "code", required = true) String code ){
		return AjaxResult.success(webUserService.registerUser(phone, code));
	}

	/**
	 * @param phone 手机号
	 * @return
	 * @create 发送验证码 biehy 2021-7-29
	 */
	@PostMapping("/sendPhone")
	@ApiOperation(value = "发送验证码", notes = "发送验证码")
	public AjaxResult sendPhone(
		@ApiParam(value = "手机号", name = "phone", required = true) @RequestParam String phone) {
		return AjaxResult.success(webUserService.sendPhone(phone));
	}

	/**
	 * 修改用户信息
	 * @param user
	 * @param webUser
	 * @return
	 */
	@PostMapping ("/updateUser")
	@Token
	public AjaxResult updateUser (
		@LoginUser TWebUser user
		,TWebUser webUser) {

		webUser.setId(user.getId());

		webUserService.updateById(webUser);

		return AjaxResult.success("修改成功");
	}

	/**
	 * 查询用户详情
	 * @param webUser
	 * @return
	 */
	@Token
	public AjaxResult queryById (@LoginUser TWebUser webUser) {
		return AjaxResult.success(webUser);
	}
}



