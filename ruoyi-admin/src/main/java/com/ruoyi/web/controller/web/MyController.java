package com.ruoyi.web.controller.web;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.TWebUser;
import com.ruoyi.web.controller.token.LoginUser;
import com.ruoyi.web.controller.token.Token;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/web/my")
public class MyController {

    @PostMapping ("/queryMoney")
    @Token
    public AjaxResult queryMoney (@LoginUser TWebUser webUser) {



        Map<String, Object> map = new HashMap<>();
        map.put("user",webUser);
        map.put("account","");
        return AjaxResult.success(map);
    }
}
