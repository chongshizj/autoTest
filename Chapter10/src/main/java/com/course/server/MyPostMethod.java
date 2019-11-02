package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/",description = "这是我全部的post请求")
@RequestMapping("/v1")
public class MyPostMethod {

    public static Cookie cookie;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，成功后获取cookies信息", httpMethod = "POST")
    public String login(HttpServletResponse httpServletResponse,
                        @RequestParam(value = "userName", required = true) String username,
                        @RequestParam(value = "passWord", required = true) String password){

        if (username.equals("zhangsan") && password.equals("123456")){
            Cookie cookie = new Cookie("login", "true");
            httpServletResponse.addCookie(cookie);
            return "恭喜你登录成功了";
        }

        return "用户名或者密码错误";
    }

    @RequestMapping(value = "getUserList", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表", httpMethod = "POST")
    public String getUserList(HttpServletRequest httpServletRequest,
                            @RequestBody User user){
        User user1;
        Cookie[] cookies = httpServletRequest.getCookies();
        for (Cookie cookie1 : cookies) {
            if(cookie1.getName().equals("login")
                    && cookie1.getValue().equals("true")
                    && user.getUserName().equals("zhangsan")
                    && user.getPassWord().equals("123456")
                    ){

                user1 = new User();
                user1.setName("lisi");
                user1.setAge("18");
                user1.setSex("man");

                return user1.toString();

            }
        }
        return "参数不合法";
    }
}
