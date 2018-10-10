import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {

    private int counter = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

//        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        counter += 1;
        response.getWriter().println("<h1>The count is " + counter + ".</h1>");
        out.println("Hello" +
                "<h1 align = \"center\">This does something</h1><h2 align = \"center\">This should be in h2</h2><h3 align = \"center\">This should be in h3</h3><h4 align = \"center\">This should be in h4</h4><h5 align = \"center\">This should be in h5</h5><h6 align = \"center\">This should be in h6</h6><body bgcolor =\"#f0f0f0\"");

        String searchedName = request.getParameter("name");
        if (searchedName == null) {
            searchedName = "World";
        }

        out.println("<h1 align =\"center\"> Hello, " + searchedName + "</h1>");
    }

}
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//@WebServlet(name = "Adlister Server", urlPatterns = "/hello")
//public class HelloWorldServlet extends HttpServlet {
//    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
//        PrintWriter out = res.getWriter();
//        out.println("<h1>Hello World</h1>");
//
//    }
//
//}