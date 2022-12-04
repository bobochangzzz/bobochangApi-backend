package com.bobochang.apiinterface.controller;

import cn.hutool.http.server.HttpServerRequest;
import com.bobochang.apiinterface.model.User;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;

/**
 * @author: bobochang
 * @description: 查询用户名字的API
 * @date: 2022/11/10 03:16
 */
@RestController
@RequestMapping("/name")
public class QueryNameController {

    @GetMapping("/")
    public String getNameByGet(String name) {
        return "[GET请求方式] 您的名字是:" + name;
    }

    @PostMapping("/url")
    public String getNameByPost(@RequestParam String name) {
        return "[POST请求方式(url传参)] 您的名字是:" + name;
    }

    @PostMapping("/json")
    public String getUserNameByPost(@RequestBody User user, HttpServerRequest request) throws Exception {
        String accessKey = request.getHeader("accessKey");
        String nonce = request.getHeader("nonce");
        String timestamp = request.getHeader("timestamp");
        String sign = request.getHeader("sign");
        String body = URLDecoder.decode(request.getHeader("body"), "utf-8");
        //todo 对于sign签名的校验 通过工具类形成的签名(工具类所需secretKey参数应当从数据库中查询获取)与请求头中签名进行配对
        //todo 实际情况应当查询数据库 将请求头获取的数据与数据库中查询结果匹配
        //todo 对于nonce随机数的存放 应当存放与Redis数据库中 与时间戳形成互补
        //todo 对于timestamp时间戳的校验 应为 请求头存放的时间戳与当前时间不超过5分钟
        return "[POST请求方式(json格式传参数) 您的用户名是:" + user.getUsername();
    }

}
