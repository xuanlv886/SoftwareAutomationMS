package cn.lzy.server.softwareautomationms.util;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @Desc 跨域访问拦截器
 * @Author lzy
 * @Date 2018/11/22 10:36
 * @Version 1.0
 **/
@Component("CrossDomainFilter")
public class CrossDomainFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // 跨域
        String origin = httpRequest.getHeader("Origin");
        if (origin == null) {
            httpResponse.addHeader("Access-Control-Allow-Origin", "*");
        } else {
            String rqHeader = URLEncoder.encode(origin, StandardCharsets.UTF_8.displayName());
            httpResponse.addHeader("Access-Control-Allow-Origin", rqHeader);
        }
        httpResponse.addHeader("Access-Control-Allow-Headers", "Origin, x-requested-with, Content-Type, Accept,X-Cookie");
        httpResponse.addHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,OPTIONS,DELETE");
        if ( httpRequest.getMethod().equals("OPTIONS") ) {
            httpResponse.setStatus(HttpServletResponse.SC_OK);
            return;
        }
        chain.doFilter(request, response);
    }
    @Override
    public void destroy() {
    }
}