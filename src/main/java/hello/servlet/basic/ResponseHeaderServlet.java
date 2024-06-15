package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(200);

        response.setHeader("Cache-Control", "no-cache, no-store, must- revalidate");
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        Cookie cookie = new Cookie("hello", "servlet");
        cookie.setMaxAge(600);
        response.addCookie(cookie);

        response.sendRedirect("/basic/hello-form.html");
    }
}
