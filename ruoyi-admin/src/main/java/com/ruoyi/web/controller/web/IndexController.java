package com.ruoyi.web.controller.web;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.web.controller.token.Token;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping ("/web/index")
@RestController
public class IndexController {

    @PostMapping ("/index")
    @Token
    public AjaxResult index () {

        //广告图

        //分类

        

        return AjaxResult.success();
    }

}
