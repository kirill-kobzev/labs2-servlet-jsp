package servlets.controllers.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class InnerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession httpSession = httpServletRequest.getSession();
        if(httpSession.getAttribute("login")!=null){
            chain.doFilter(request,response);
        }else{
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            ((HttpServletResponse) response).sendRedirect(
                    "/login?action=noAuth");
        }
    }

    @Override
    public void destroy() {

    }
}
