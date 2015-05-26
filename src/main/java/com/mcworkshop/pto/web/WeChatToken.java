package com.mcworkshop.pto.web;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by markfredchen on 5/23/15.
 */
@Controller
public class WeChatToken {

    private static final String TOKEN = "MC_PTO";

    @RequestMapping(value = "/weChat", method = RequestMethod.GET)
    @ResponseBody
    public String check(@RequestParam("signature") String signature, @RequestParam("echostr") String echostr, @RequestParam("timestamp") String timestamp, @RequestParam("nonce") String nonce) {
        System.out.println("Enter weChat get access_token");
        String[] str = { TOKEN, timestamp, nonce };
        Arrays.sort(str);
        String bigStr = str[0] + str[1] + str[2];
        String digest = DigestUtils.sha1Hex(bigStr).toLowerCase();

        return digest.equals(signature) ? echostr: "";
    }

    @RequestMapping(value = "/weChat", method = RequestMethod.POST)
    public @ResponseBody
    String post(@RequestBody String requestBody) {
        System.out.println(requestBody);
        return "";
    }
}
