package com.dash.rest.security;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.log4j.Log4j;

import org.jboss.logging.MDC;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@Log4j
@WebFilter("/*")
public class FpsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,  ServletException {
        try {
        	
            //log.info("Reports Service Filter called");
            HttpServletRequest httpRequest = (HttpServletRequest)request;   
            String trackId = null;
            Enumeration<String> headers = httpRequest.getHeaders("trackid");
            while (headers.hasMoreElements()) {
            	trackId = headers.nextElement();
            }
        	if(trackId!=null)
               MDC.put("TrackId", trackId);
        	 
        	
            SecurityContext context = SecurityContextHolder.getContext();
            if (context != null) {
                Authentication authentication = context.getAuthentication();
                if (authentication != null && authentication.getPrincipal() != null
                        && authentication.getPrincipal() instanceof Integer) {
                	Integer sid = (Integer) authentication.getPrincipal();
                	
                    MDC.put("SID", sid);             
                   
                    
                   // log.info("SID:"+sid);
                }
            }
        } catch (Throwable e) {
            //log.error("Exception ", e);
        }
        chain.doFilter(request, response);
        MDC.clear();
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }
}