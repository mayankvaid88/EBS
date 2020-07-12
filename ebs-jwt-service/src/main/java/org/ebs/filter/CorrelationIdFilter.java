package org.ebs.filter;

import io.jaegertracing.internal.JaegerTracer;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@Order(1)
public class CorrelationIdFilter implements Filter {

    @Autowired
    private JaegerTracer jaegerTracer;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String traceId = jaegerTracer.activeSpan().context().toTraceId();
        if (traceId == null || traceId.equals("")) {
            traceId = "no-trace-id";
        }
        MDC.put("traceId", traceId);
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            MDC.remove(traceId);
        }
    }
}
