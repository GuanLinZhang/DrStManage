package cn.drst.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieFilter extends OncePerRequestFilter {

    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        // 不过滤的uri
        String[] notFilter = new String[]{"Verifying.html", "index.html", "do", "/js", "/html", "/css"};
        // 请求的uri
        String uri = httpServletRequest.getRequestURI();
        // 是否过滤
        boolean doFilter = true;
        for (String s : notFilter) {
            if (uri.contains(s)) {
                // 如果uri中包含不过滤的uri，则不进行过滤
                doFilter = false;
                break;
            }
        }
        if (doFilter) {
            boolean flg = false;
            Cookie[] cookies = httpServletRequest.getCookies();
            if (null != cookies) {
                for (Cookie cookie : cookies) {
                    if ("organization".equals(cookie.getName())) {
                        flg = true;
                    }
                }
                if (flg) {
                    httpServletResponse.sendRedirect("Verifying.html");
                } else {
                    filterChain.doFilter(httpServletRequest, httpServletResponse);//不执行过滤,继续执行操作
                }
            } else {
                filterChain.doFilter(httpServletRequest, httpServletResponse);//不执行过滤,继续执行操作
            }
        } else {
            filterChain.doFilter(httpServletRequest, httpServletResponse);//不执行过滤,继续执行操作
        }
    }
}
