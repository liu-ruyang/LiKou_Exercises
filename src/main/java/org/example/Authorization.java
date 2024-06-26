package org.example;

import com.alibaba.fastjson.JSON;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Authorization {
    public static void main(String[] args) {
        try {
            String key = "1300386381676928834";
            String keySecret = "9f09f63a97514c00abad98c81ee9a680";
            Map<String, Object> map = new HashMap();
            map.put("pageNo", 1);
            map.put("pageSize", 10);
            String body = JSON.toJSONString(map);
            String ContentMd5 = getDigest(body);
            String Date = getGMTTime();
            String path = "/v1/api/userStationList";
            String param = "POST" + "\n" + ContentMd5 + "\n" + "application/json" + "\n" + Date + "\n" + path;
            String sign = HmacSHA1Encrypt(param, keySecret);
            String url = "https://api.ginlong.com:13333" + path;
            OkHttpClient client = new OkHttpClient();
            MediaType xmlType = MediaType.parse("application/json;charset=UTF-8");
            okhttp3.RequestBody requestBody = okhttp3.RequestBody.create(xmlType, body);
            okhttp3.Request request = new okhttp3.Request.Builder()
                    .url(url)
                    .addHeader("Content-type", "application/json;charset=UTF-8")
                    .addHeader("Authorization", "API " + key + ":" + sign)
                    .addHeader("Content-MD5", ContentMd5)
                    .addHeader("Date", Date)
                    .post(requestBody)
                    .build();
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            System.out.println(string);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String HmacSHA1Encrypt(String encryptText, String KeySecret) throws Exception {
        byte[] data = KeySecret.getBytes("UTF-8");
        // 鏍规嵁缁欏畾鐨勫瓧鑺傛暟缁勬瀯閫犱竴涓瘑閽�,绗簩鍙傛暟鎸囧畾涓€涓瘑閽ョ畻娉曠殑鍚嶇О
        SecretKey secretKey = new SecretKeySpec(data, "HmacSHA1");
        // 鐢熸垚涓€涓寚瀹� Mac 绠楁硶 鐨� Mac 瀵硅薄
        Mac mac = Mac.getInstance("HmacSHA1");
        // 鐢ㄧ粰瀹氬瘑閽ュ垵濮嬪寲 Mac 瀵硅薄
        mac.init(secretKey);

        byte[] text = encryptText.getBytes("UTF-8");
        // 瀹屾垚 Mac 鎿嶄綔
        byte[] result = mac.doFinal(text);
        return Base64.encodeBase64String(result);
    }

    public static String getGMTTime() {

        Calendar cd = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT")); // 璁剧疆鏃跺尯涓篏MT
        String str = sdf.format(cd.getTime());
        return str;
    }

    public static String getDigest(String test) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(test.getBytes());
            byte[] b = md.digest();
            result = java.util.Base64.getEncoder().encodeToString(b);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }
}