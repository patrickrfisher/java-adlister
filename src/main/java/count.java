import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;




@WebServlet(name = "count", urlPatterns = "/count")
public class count extends HttpServlet {
    private int counter=0;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//        PrintWriter out= response.getWriter();
         boolean reset = Boolean.valueOf(request.getParameter("reset"));
            if(reset){
                counter=0;
            }
//        request.getParameter("reset").equals("true");
        counter += 1;
        response.getWriter().println("<h1>The count is " + counter + ".</h1>");
//        out.println("Hello" +
//                "<h1 align = \"center\">This does something</h1><h2 align = \\\"center\\\">This should be in h2</h2><h3 align = \\\"center\\\">This should be in h3</h3><h4 align = \\\"center\\\">This should be in h4</h4><h5 align = \\\"center\\\">This should be in h5</h5><h6 align = \\\"center\\\">This should be in h6</h6>");

    }

}