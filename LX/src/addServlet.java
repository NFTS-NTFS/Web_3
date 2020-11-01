import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

@WebServlet(name = "addServlet",urlPatterns = {"/addServlet"})
public class addServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try{

            String a = request.getParameter("a");
            String b = request.getParameter("b");
            if(!"".equals(a) && !"".equals(b)){
                //HttpServletResponse servletResponse = (HttpServletResponse)response;
                try {
                    boolean flag_a = true;
                    boolean flag_b = true;

                    for(int i = 0;i < a.length(); i ++){
                        if(a.charAt(i) > '9' || a.charAt(i) < '0')
                            flag_a = false;
                        break;
                    }
                    for(int j = 0;j < b.length();j ++){
                        if(a.charAt(j) > '9' || a.charAt(j) < '0')
                            flag_b = false;
                        break;
                    }
                    if(flag_a == false || flag_b == false){
                        System.out.println("参数错误");
                    }
                    else{
                        try {
                            request.getRequestDispatcher("/DoneServlet").forward(request,response);
                        } catch (ServletException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            try {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().append("参数错误！");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }

        }
}
