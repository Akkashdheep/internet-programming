import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] selectedProducts = request.getParameterValues("product");
             if (selectedProducts != null && selectedProducts.length > 0) {
            StringBuilder cartItems = new StringBuilder();
            for (String product : selectedProducts) {
                cartItems.append(product).append(",");
            }
            cartItems.deleteCharAt(cartItems.length() - 1);
            Cookie cookie = new Cookie("cartItems", cartItems.toString());
            cookie.setMaxAge(24 * 60 * 60); 
            response.addCookie(cookie);
        }
        response.sendRedirect("ShoppingCartServlet");
    }
}
