package br.com.springboot.service.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import br.com.springboot.service.CookieService;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    
    public boolean preHandle
    (HttpServletRequest request, HttpServletResponse response, Object handler)
    throws Exception{
        System.out.println("Pre Handle method is Calling - ");

        if(CookieService.getCookie(request, "userId") != null){
            return true;
        }
        
        response.sendRedirect("/login");
        return false;
    }
}
