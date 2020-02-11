/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cookiesOps;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author USER
 */
public class CookiesMethods {
   public boolean cookieExist(String name, HttpServletRequest request){
        boolean exist = false;
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            //System.out.println(cookie.getName()+"----"+cookie.getValue());
            if (cookie.getName().equals(name)) exist = true;
            else exist = false;
        }
       return exist;
   }
   
   public Cookie getCookie(String name, HttpServletRequest request){
        Cookie myCookie = null;
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if (cookie.getName().equals(name)){
                myCookie = cookie;
            }
        }
        return myCookie;
   }
    
}
