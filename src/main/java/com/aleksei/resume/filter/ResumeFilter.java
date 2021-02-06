package com.aleksei.resume.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ResumeFilter extends AbstractFilter {

    @Value("${application.production}")
    private boolean production;

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        String requestUrl = req.getRequestURI();
        req.setAttribute("REQUEST_URL", requestUrl);
        try {
            chain.doFilter(req, resp);
        } catch (Throwable e) {
            LOGGER.error("Process request failed: " + requestUrl, e);
            handleException(e, requestUrl, resp);
        }
    }

    private void handleException(Throwable e, String requestUrl, HttpServletResponse resp) throws ServletException, IOException {
        if (production) {
            if ("/error".equals(requestUrl)) {
                throw new ServletException(e);
            } else {
                resp.sendRedirect("/error?url=" + requestUrl);
            }
        } else {
            throw new ServletException(e);
        }
    }
}
