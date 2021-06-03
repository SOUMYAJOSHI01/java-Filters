package com.filterdemo.filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "webf", urlPatterns = {"/*"})

public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
       
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
       
        PrintWriter out=resp.getWriter();  
   
        out.print("Write Conditions for applying filter on web app here.");  
          
        chain.doFilter(req, resp);//sends request to next resource  
          
        out.print("filter applied successfully.");  
      
    }  

    @Override
    public void destroy() {}
}
