package com.mcworkshop.pto.web;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Base64;

/**
 * Created by markfredchen on 5/23/15.
 */
@Controller
public class WeChatToken {

    private static final String TOKEN = "MCPTO";

    private static final String AESKEY = "YsY3st3zVCoCQFC04am4C8nOShirIofGDHJSaDaSPjj";

    private static final String CORPID = "wxe4aff45f5aba161b";

    @RequestMapping(value = "/weChat", method = RequestMethod.GET)
    @ResponseBody
    public String check(
            @RequestParam("msg_signature") String signature,
            @RequestParam("echostr") String echostr,
            @RequestParam("timestamp") String timestamp,
            @RequestParam("nonce") String nonce) throws AesException {
        return new WXBizMsgCrypt(TOKEN, AESKEY, CORPID).VerifyURL(signature, timestamp, nonce, echostr);
    }

    @RequestMapping(value = "/weChat", method = RequestMethod.POST)
    public @ResponseBody
    String post(@RequestBody String requestBody, HttpServletRequest request) {
        System.out.println(request.getParameterMap().keySet());
        System.out.println(requestBody);
        return "";
    }
}
