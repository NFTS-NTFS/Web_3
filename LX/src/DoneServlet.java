import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DoneServlet",urlPatterns = {"/DoneServlet"})
public class DoneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        int a = Integer.parseInt(request.getParameter("a"));
        int b = Integer.parseInt(request.getParameter("b"));
        System.out.println(a);
        int c = a + b;
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println("<html>");
        out.println("<head>");
        out.println("The result is:"+c);
        out.println("</body>");
        out.println("</html>");
        System.out.println(c);
    }
}
