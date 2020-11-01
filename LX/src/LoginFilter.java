import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"/addServlet"})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest servletRequest = (HttpServletRequest)req;
        HttpServletResponse servletResponse = (HttpServletResponse)resp;
        HttpSession session = servletRequest.getSession();
        if(session == null || session.getAttribute("user") != "success"){
            servletResponse.sendRedirect(servletRequest.getContextPath() + "/login.html");
        }
        else{
            //servletResponse.sendRedirect("/hello");
            chain.doFilter(req, resp);
        }


        //chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) {

    }

}
