package com.course.controller;


import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j
@RestController
@Api(value = "v1", description = "这是我第一个demo")
@RequestMapping("v1")
public class Demo {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @RequestMapping(value = "/getUserCount", method = RequestMethod.GET)
    @ApiOperation(value = "可以获取到用户数", httpMethod = "GET")
    public int getUserCount(){
        return sqlSessionTemplate.selectOne("getUserCount");
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public int addUser(@RequestBody User user){
        int result = sqlSessionTemplate.insert("addUser", user);

        return result;
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public int updateUser(@RequestBody User user){
        int updateUser = sqlSessionTemplate.update("updateUser", user);
        return updateUser;
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public int deleteUser(@RequestParam int id){
        int deleteStatus = sqlSessionTemplate.delete("deleteUser", id);

        return deleteStatus;
    }

}
