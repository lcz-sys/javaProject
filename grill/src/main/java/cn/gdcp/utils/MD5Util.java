package cn.gdcp.utils;

import org.springframework.util.Base64Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    /**
     * md5加密字符串
     * @param str
     * @return
     */
    public final static String md5(String str){
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        messageDigest.update(str.getBytes());
        return Base64Utils.encodeToString(messageDigest.digest());
    }

    /**
     * sha1加密字符串
     * @param str
     * @return
     */
    public final static String sha1(String str){
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        messageDigest.update(str.getBytes());
        return Base64Utils.encodeToString(messageDigest.digest());
    }

    /**
     * 使用特定加密范式加密
     * @param str
     * @return
     */
    public final static String encode(String str){
        return md5(sha1(md5(str)));
    }
}
