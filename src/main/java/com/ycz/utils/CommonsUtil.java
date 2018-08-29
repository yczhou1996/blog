package com.ycz.utils;

import com.ycz.constant.WebConst;
import com.ycz.model.Vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

@Component
public class CommonsUtil {

    /**
     * 从session获取user
     * @param request
     * @return
     */
    public static UserVo getLoginUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(null == session){
            return null;
        }
        return (UserVo) session.getAttribute(WebConst.LOGIN_SESSION_KEY);
    }

    /**
     * 获取指定cookie
     * @param request
     * @return
     */
    public static Cookie getCookie(HttpServletRequest request, String name){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if(cookie.getName().equals(name)){
                return cookie;
            }
        }
        return null;
    }

    /**
     * 获取cookie 中的userId
     * @param request
     * @return
     */
    public static Integer getCookieId(HttpServletRequest request){
        if(null != request){
            Cookie cookie = getCookie(request, WebConst.USER_IN_COOKIE);
            if(null != cookie && null != cookie.getValue()){
                String id = cookie.getValue();
                if(StringUtils.isNotBlank(id) && isNumber(id)){
                    return Integer.valueOf(id);
                }
            }

        }
        return null;
    }

    /**
     * 判断是否为数字
     * @param str
     * @return
     */
    public static Boolean isNumber(String str){
        if(StringUtils.isBlank(str) && 0 != str.trim().length() && str.matches("\\d*")){
            return true;
        }
        return false;
    }

    public static String[] color = {"primary","secondary","success","warning","danger"};

    /**
     * 获取随机颜色
     * @return
     */
    public static String rand_color(){
        Random random = new Random();
        int rand = random.nextInt(color.length);
        return color[rand];
    }

    /**
     * 判断是否存在
     * @param categories
     * @param categoryName
     * @return
     */
    public static boolean exists_cate(String categories, String categoryName){
        if(StringUtils.isBlank(categories) || StringUtils.isBlank(categoryName)) return false;
        String[] arr = categories.split(",");
        for(String category : arr){
            if(category.trim().equals(categoryName)){
                return true;
            }
        }
        return false;
    }
}
