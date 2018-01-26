package com.jasper;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.UUID;

/**
 * RequestFilter Class
 * 
 * Logging information customize.
 * MDC add user name and requestID and Remote IP Address.
 * 
 * @author moelholm
 * @version 1.0
 * @since 2016/8/17
 *
 */
@Component
public class RequestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            String mdcData = String.format("[userId:%s | requestId:%s | IP:%s]", user(), requestId(),request.getRemoteAddr());
            MDC.put("mdcData", mdcData); //Referenced from logging configuration.
            chain.doFilter(request, response);
        } finally {
            MDC.clear();
        }
    }

    private String requestId() {
        return UUID.randomUUID().toString();
    }

    private String user() {
        return "tux";
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
