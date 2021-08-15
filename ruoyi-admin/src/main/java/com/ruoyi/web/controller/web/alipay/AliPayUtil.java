package com.ruoyi.web.controller.web.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.*;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import com.ruoyi.common.constant.Constants;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 支付宝支付相关工具
 * @date 2020/11/19 10:12
*/
@RestController
@RequestMapping("/web/AliPayUtil")
public class AliPayUtil {
    /**
     * 判断是否为支付宝发起
    */
    @ResponseBody
    @RequestMapping("/votifyUrlCerification")
    public Map<String, Object> votifyUrlCerification(HttpServletRequest request) {
        //获取支付宝GET过来反馈信息
        Map<String, Object> result = new TreeMap<String, Object>();
        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        //        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
        boolean verifyResult = false;
        try {
            //商户订单号
            String orderNo = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
            result.put("orderNo", orderNo);
            //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
            String tradeStatus = request.getParameter("trade_status");
            //计算得出通知验证结果
            //读取支付宝账号信息
            verifyResult = AlipaySignature.rsaCheckV1(params, Constants.alipaypublickey,
                    "utf-8", "RSA2");
            //验证成功
            if (verifyResult) {
                result.put("check", "1");
                //支付成功
                if ("TRADE_FINISHED".equals(tradeStatus) || "TRADE_SUCCESS".equals(tradeStatus)) {
                    result.put("status", "1");
                    result.put("orderNo", orderNo);
            } else {
                result.put("status", "0");
            }
            } else {
                result.put("check", "0");
                System.out.println("阿里云支付回调取消支付");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("check", "0");
        }
        return result;
    }

    /**
     * 发起APP支付
    */
    @PostMapping("/aliAPPPay")
    public Map<String, Object> aliAPPPay(String orderNo, BigDecimal money, String url, String body) {
        Map<String, Object> map = new TreeMap<String, Object>();
        //实例化客户端
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
                Constants.appId,Constants.privatekey,"json", "UTF-8",Constants.alipaypublickey,"RSA2");
        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();

        AlipayTradePagePayRequest tradePagePayRequest = new AlipayTradePagePayRequest();

        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradePagePayModel model = new AlipayTradePagePayModel();
        model.setBody(body);
        model.setOutTradeNo(orderNo);

        model.setTimeoutExpress("30m");
        model.setTotalAmount("" + money.setScale(2, RoundingMode.HALF_UP));
        model.setSubject("订单支付");
//        model.setTotalAmount("" + 0.01);
        tradePagePayRequest.setBizModel(model);
//        request.setBizModel(model);
//        request.setNotifyUrl(url);
        try {
            //这里和普通的接口调用不同，使用的是sdkExecute
//            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
            AlipayTradePagePayResponse response = alipayClient.pageExecute(tradePagePayRequest);
            map.put("orderString", response.getBody());
            map.put("orderNo", orderNo);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static Map<String, Object> callBack(HttpServletRequest request) {
        //获取支付宝GET过来反馈信息
        Map<String, Object> result = new TreeMap<String, Object>();
        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        //        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
        boolean verifyResult = false;
        try {
            //商户订单号
            String orderNo = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
            //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
            String tradeStatus = request.getParameter("trade_status");
            //计算得出通知验证结果
            //读取支付宝账号信息
            verifyResult = AlipaySignature.rsaCheckV1(params, Constants.alipaypublickey,
                    "utf-8", "RSA2");
            //验证成功
            if (verifyResult) {
                result.put("check", "1");
                //支付成功
                if ("TRADE_FINISHED".equals(tradeStatus) || "TRADE_SUCCESS".equals(tradeStatus)) {
                    result.put("status", "1");
                    result.put("orderNo", orderNo);
                } else {
                    result.put("status", "0");
                }
            } else {
                result.put("check", "0");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("check", "0");
        }
        return result;
    }


    @PostMapping("/queryOrder")
    public String queryOrder(String outTradeNo){

        try {
            //实例化客户端（参数：网关地址、商户appid、商户私钥、格式、编码、支付宝公钥、加密类型）
            AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
                    Constants.appId,Constants.privatekey,"json", "UTF-8",Constants.alipaypublickey,"RSA2");
            AlipayTradeQueryRequest alipayTradeQueryRequest = new AlipayTradeQueryRequest();
            alipayTradeQueryRequest.setBizContent("{" +
                    "\"out_trade_no\":\""+outTradeNo+"\"" +
                    "}");
            AlipayTradeQueryResponse alipayTradeQueryResponse = alipayClient.execute(alipayTradeQueryRequest);
            String body = alipayTradeQueryResponse.getBody();
            return body;
        } catch (AlipayApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "123";
    }

    @GetMapping("/h5Pay")
    public Map<String, Object> h5Pay(String orderNo, BigDecimal money, String url, String body, Long orderId) {

        //获取要向支付宝支付的参数,由页面传过来
        //付款金额，必填
        String totalMoney = money.setScale(2, RoundingMode.HALF_UP).toString();

        Map<String, Object> map = new HashMap<>();

        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
                Constants.appId,Constants.privatekey,"json", "UTF-8",Constants.alipaypublickey,"RSA2");
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl("http://hnztjy.com.cn/#/guideResults?orderId="+orderId);  //设置同步回调通知
        alipayRequest.setNotifyUrl(url);  //设置异步回调通知
        //设置支付参数
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + orderNo + "\","
                + "\"total_amount\":\"" + totalMoney + "\","
                + "\"subject\":\"" + body + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        try {
            AlipayTradePagePayResponse response = alipayClient.pageExecute(alipayRequest);
            map.put("orderString", response.getBody());
            map.put("orderNo", orderNo);
            return map;
        } catch (AlipayApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return map;
    }

    @GetMapping("phoneH5Pay")
    public Map<String, Object> phoneH5Pay(String orderNo, BigDecimal money, String url, String body, Long orderId) {
        //获取要向支付宝支付的参数,由页面传过来
        //付款金额，必填
        String totalMoney = money.setScale(2, RoundingMode.HALF_UP).toString();

        Map<String, Object> map = new HashMap<>();

        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
                Constants.appId,Constants.privatekey,"json", "UTF-8",Constants.alipaypublickey,"RSA2");
        //设置请求参数
        AlipayTradeWapPayRequest alipayRequest =new AlipayTradeWapPayRequest();
        alipayRequest.setReturnUrl("http://hnztjy.com.cn/#/guideResults?orderId="+orderId);  //设置同步回调通知
        alipayRequest.setNotifyUrl(url);  //设置异步回调通知
        //设置支付参数
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + orderNo + "\","
                + "\"total_amount\":\"" + totalMoney + "\","
                + "\"subject\":\"" + body + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"QUICK_WAP_WAY\"}");
        //请求

        try {
            AlipayTradeWapPayResponse response = alipayClient.pageExecute(alipayRequest);
            map.put("orderString", response.getBody());
            map.put("orderNo", orderNo);

        } catch (AlipayApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return map;
    }


    @GetMapping("navPay")
    public Map<String, Object> navPay(String orderNo, BigDecimal money, String url, String body) {
        //获取要向支付宝支付的参数,由页面传过来
        //付款金额，必填
        String totalMoney = money.setScale(2, RoundingMode.HALF_UP).toString();

        Map<String, Object> map = new HashMap<>();

        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
                Constants.appId,Constants.privatekey,"json", "UTF-8",Constants.alipaypublickey,"RSA2");

        //设置请求参数
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();
        model.setOutTradeNo(orderNo);
        model.setTotalAmount(totalMoney);
        model.setSubject(body);
        model.setBody(body);
        //如果没有店铺号可不设置
        model.setQrCodeTimeoutExpress("10m");
        request.setBizModel(model);
        //支付宝异步通知地址
        request.setNotifyUrl(url);

        try {
            //调用接口
            AlipayTradePrecreateResponse response = alipayClient.execute(request);
            map.put("orderString", response.getQrCode());
            map.put("orderNo", orderNo);

        } catch (AlipayApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return map;
    }
}