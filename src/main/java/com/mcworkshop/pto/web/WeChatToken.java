package com.mcworkshop.pto.web;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(HttpServletRequest request) {
        String signature = request.getParameter("signature");
        String echostr = request.getParameter("echostr");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        System.out.println(request.getParameterMap().keySet());

        return echostr;
//        if(StringUtils.isEmpty(signature)
//                || StringUtils.isEmpty(echostr)
//                || StringUtils.isEmpty(timestamp)
//                || StringUtils.isEmpty(nonce)) {
//            return "invalid request";
//        }else {
////            String[] str = { TOKEN, timestamp, nonce };
////            Arrays.sort(str);
////            String bigStr = str[0] + str[1] + str[2];
////            String digest = DigestUtils.sha1Hex(bigStr).toLowerCase();
////            return digest.equals(signature) ? echostr: "error";
//        }
    }
}
