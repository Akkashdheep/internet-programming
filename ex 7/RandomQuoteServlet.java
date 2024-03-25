import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/RandomQuoteServlet")
public class RandomQuoteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
   private final String[] quotes = {
        "The only way to do great work is to love what you do. – Steve Jobs",
        "Life is what happens when you're busy making other plans. – John Lennon",
        "In the end, it's not the years in your life that count. It's the life in your years. – Abraham Lincoln",
        "The greatest glory in living lies not in never falling, but in rising every time we fall. – Nelson Mandela",
        "The future belongs to those who believe in the beauty of their dreams. – Eleanor Roosevelt",
        "You only live once, but if you do it right, once is enough. – Mae West"
    };
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Random Quote</title></head><body>");
        out.println("<h1>Random Quote Generator</h1>");
        out.println("<div>");
        out.println("<p>" + getRandomQuote() + "</p>");
        out.println("</div>");
        out.println("</body></html>");
    }
 private String getRandomQuote() {
        Random random = new Random();
        int randomNumber = random.nextInt(quotes.length);
        return quotes[randomNumber];
    }
}  
