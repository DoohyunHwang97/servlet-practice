package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request);

        printHeaders(request);
    }

    private void printHeaders(HttpServletRequest request) {
        System.out.println("print headers --------");
        request.getHeaderNames().asIterator().forEachRemaining((name) -> System.out.println(name + " = " + request.getHeader(name)));
        System.out.println("end headers --------");
    }

    private void printStartLine(HttpServletRequest request) {
        String method = request.getMethod();
        String protocol = request.getProtocol();
        StringBuffer requestURL = request.getRequestURL();
        String scheme = request.getScheme();
        String queryString = request.getQueryString();
        boolean secure = request.isSecure();

        System.out.println("print start line --------");
        System.out.println("method = " + method);
        System.out.println("protocol = " + protocol);
        System.out.println("scheme = " + scheme);
        System.out.println("requestURL = " + requestURL);
        System.out.println("queryString = " + queryString);
        System.out.println("secure = " + secure);
        System.out.println("end start line --------");
    }
}
