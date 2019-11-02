package com.course.httpclient.cookies;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {

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
    public void testGetWithCookies() throws IOException {
        String uri = bundle.getString("test.get.with.cookies");
        String testUrl = this.url + uri;
        HttpGet httpGet = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();

        client.setCookieStore(this.cookieStore);
        HttpResponse response = client.execute(httpGet);

        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode = " + statusCode);

    }

}
