package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/",description = "这是我全部的get方法")
public class MyGetMethod {

    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    @ApiOperation(value = "同个这个方法可以获取cookies", httpMethod = "get")
    public String getCookies(HttpServletResponse httpServletResponse){

        //HttpServletRequest装请求信息
        //HttpServletResponse装响应信息
        Cookie cookie = new Cookie("login","true");
        httpServletResponse.addCookie(cookie);
        return "恭喜你获得cookies成功";
    }

    @RequestMapping(value = "/get/with/cookies", method = RequestMethod.GET)
    @ApiOperation(value = "要求客户端携带cookies访问", httpMethod = "get")
    public String getWithCookies(HttpServletRequest httpServletRequest){
        Cookie[] cookies = httpServletRequest.getCookies();
        if (Objects.isNull(cookies)){
            return "你必须携带cookies信息!!";
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login")&&cookie.getValue().equals("true")){
                return "恭喜你访问成功";
            }
        }
        return "你必须携带cookies信息";
    }

    @RequestMapping(value = "/get/with/param", method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数访问的get请求1", httpMethod = "get")
    public Map<String, Integer> getList(@RequestParam Integer start,
                                        @RequestParam Integer end){
        Map<String, Integer> myList = new HashMap<>();
        myList.put("鞋", 400);
        myList.put("衣服", 200);
        myList.put("方便面", 20);

        return myList;
    }

    //第二种需要携带参数访问的get请求
    @RequestMapping(value = "/get/with/param/{start}/{end}", method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数访问的get请求2", httpMethod = "get")
    public Map<String, Integer> myGetList(@PathVariable Integer start,
                                          @PathVariable Integer end){
        Map<String, Integer> myList = new HashMap<>();
        myList.put("鞋", 400);
        myList.put("衣服", 200);
        myList.put("方便面", 20);

        return myList;
    }
}
