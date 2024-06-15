package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] -- start");

        request.getParameterNames().asIterator().forEachRemaining((name) ->
                System.out.println(name + "=" + request.getParameter(name)));

        System.out.println("[전체 파라미터 조회] -- end");
        System.out.println();
        System.out.println("[개별 파라미터 조회] -- start");

        System.out.println("username=" + request.getParameter("username"));
        System.out.println("age=" + request.getParameter("age"));

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        String[] names = request.getParameterValues("username");
        for (String name : names) {
            System.out.println("username = " + name);
        }

        response.getWriter().write("OK");
    }
}
