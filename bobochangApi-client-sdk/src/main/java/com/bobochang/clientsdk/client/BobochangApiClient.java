package com.bobochang.clientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.bobochang.clientsdk.model.User;
import com.bobochang.clientsdk.utils.SignUtil;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: bobochang
 * @description:
 * @date: 2022/11/10 03:32
 */

public class BobochangApiClient {

    private String accessKey;
    private String secretKey;

    public BobochangApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getNameByGet(String name) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);

        //String result= HttpUtil.get("https://http://localhost:8123/api/name/", paramMap);
        return HttpUtil.get("http://localhost:8123/api/name/", paramMap);
    }

    public String getNameByPost(String name) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);

        //String result= HttpUtil.post("https://http://localhost:8123/api/name/url", paramMap);
        return HttpUtil.post("http://localhost:8123/api/name/url", paramMap);
    }

    public String getUserNameByPost(User user) throws Exception {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post("http://localhost:8123/api/name/json")
                .addHeaders(createHeaderMap(json))
                .body(json)
                .execute();
        System.out.println("[请求状态码] " + httpResponse.getStatus());
        return httpResponse.body();
    }


    /**
     * 生成请求头方法
     *
     * @param body 用户信息体
     * @return
     */
    private Map<String, String> createHeaderMap(String body) throws Exception {
        Map<String, String> haspMap = new HashMap<>();
        haspMap.put("accessKey", accessKey);
        // 保证安全性和防止拦截请求恶意获取密钥 不应将密钥发送给前端
        // haspMap.put("secretKey", secretKey);
        haspMap.put("body", URLEncoder.encode(body, "utf-8"));
        haspMap.put("nonce", RandomUtil.randomNumbers(100));
        haspMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        haspMap.put("sign", SignUtil.genSign(body, secretKey));
        return haspMap;
    }
}
