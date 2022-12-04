package com.bobochang.clientsdk.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * @author: bobochang
 * @description: 签名工具
 * @date: 2022/11/10 04:42
 */

public class SignUtil {
    /**
     * 生成签名方法
     *
     * @param body   请求头
     * @param secretKey 访问密钥
     * @return
     */
    public static String genSign(String body, String secretKey) {
        Digester sha256 = new Digester(DigestAlgorithm.SHA256);
        String content = body + "-" + secretKey;
        return sha256.digestHex(content);
    }
}
