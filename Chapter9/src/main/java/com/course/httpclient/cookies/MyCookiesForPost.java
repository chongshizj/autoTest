package com.course.httpclient.cookies;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {

    private String url;
    private ResourceBundle bundle;
    CookieStore cookieStore;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        String cookiesUri = bundle.getString("getCookies.uri");
        String testUrl = this.url + cookiesUri;
        HttpGet httpGet = new HttpGet(testUrl);

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity, "utf8");
        System.out.println("result = " + result);

        this.cookieStore = httpClient.getCookieStore();
        List<Cookie> cookies = cookieStore.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("name = " + name);
            System.out.println("value = " + value);
        }
    }


    @Test(dependsOnMethods = "testGetCookies")
    public void testPostMethod() throws IOException {
        String uri = bundle.getString("test.post.with.cookies");
        String testUrl = this.url + uri;

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(testUrl);

        JSONObject param = new JSONObject();
        param.put("name", "huhansan");
        param.put("age", "18");

        //设置请求头信息
        httpPost.setHeader("content-type","application/json");
        //将参数信息添加到方法中
        StringEntity stringEntity = new StringEntity(param.toString(), "utf-8");
        httpPost.setEntity(stringEntity);
        httpClient.setCookieStore(this.cookieStore);
        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        System.out.println("result = " + result);

        JSONObject jsonObject = new JSONObject(result);
        String success = (String) jsonObject.get("huhansan");
        if (success.equals("success")){
            System.out.println("success = " + success);
        }
    }
}
