import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        String name = request.getParameter("user");
        String password = request.getParameter("password");
        if(name.equals("admin") && password.equals("123456")){
            HttpSession session = request.getSession();
            //boolean success = true;
            session.setAttribute("user","success");
            response.setContentType("text/html;charset=utf-8");
            try {
                response.getWriter().append("登录成功！");

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
