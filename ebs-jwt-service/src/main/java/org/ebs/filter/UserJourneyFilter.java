package org.ebs.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(2)
public class UserJourneyFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(UserJourneyFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        logger.info("User Journey started " + request.getRequestURI() + " " + request.getMethod());
        filterChain.doFilter(servletRequest, servletResponse);
        logger.info("User journey ended " + request.getRequestURI() + " " + request.getMethod());
    }
}