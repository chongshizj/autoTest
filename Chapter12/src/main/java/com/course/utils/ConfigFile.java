package com.course.utils;

import com.course.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("application",
            Locale.CHINA);

    public static String getUrl(InterfaceName name){
        String address = resourceBundle.getString("test.url");
        String uri = "";
        String testUrl;

        if(name == InterfaceName.GETUSERLIST){
            uri = resourceBundle.getString("getUserList.uri");
        }

        if (name == InterfaceName.LOGIN){
            uri = resourceBundle.getString("login.uri");
        }

        if (name == InterfaceName.UPDATEUSERINFO){
            uri = resourceBundle.getString("updateUserInfo.uri");
        }

        if (name == InterfaceName.GETUSERINFO){
            uri = resourceBundle.getString("getUserInfo.uri");
        }

        if (name == InterfaceName.ADDUSERINFO){
            uri = resourceBundle.getString("addUser.uri");
        }

        testUrl = address + uri;
        return testUrl;
    }
}
