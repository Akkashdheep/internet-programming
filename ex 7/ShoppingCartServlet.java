import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String cartItems = "";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cartItems")) {
                    cartItems = cookie.getValue();
                    break;
                }
            }
        }
        response.setContentType("text/html");
        response.getWriter().println("<h2>Shopping Cart</h2>");
        if (!cartItems.isEmpty()) {
            String[] items = cartItems.split(",");
            response.getWriter().println("<ul>");
            for (String item : items) {
                response.getWriter().println("<li>" + item + "</li>");
            }
            response.getWriter().println("</ul>");
        } else {
            response.getWriter().println("<p>Your cart is empty.</p>");
        }
    }
}
