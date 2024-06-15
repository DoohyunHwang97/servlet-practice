package hello.servlet.basic;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.springframework.util.StreamUtils;

@WebServlet(name = "requestDataServlet", urlPatterns = "/request-data")
public class RequestDataServlet extends HttpServlet {
    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        HelloUser helloUser = objectMapper.readValue(messageBody, HelloUser.class);
        System.out.println("helloUser = " + helloUser);
        System.out.println("helloUser.getUsername() = " + helloUser.getUsername());
        System.out.println("helloUser.getAge() = " + helloUser.getAge());
    }
}
