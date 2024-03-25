import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/CalculateSalaryServlet")
public class CalculateSalaryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
       String name = request.getParameter("name");
        String empId = request.getParameter("empid");
        double basicPay = Double.parseDouble(request.getParameter("basicpay"));
        double hra = Double.parseDouble(request.getParameter("hra"));
        double da = 0.5 * basicPay;
       double grossPay = basicPay + hra + da;
       out.println("<html><head><title>Salary Calculation Result</title></head><body>");
        out.println("<h1>Salary Calculation Result</h1>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Employee ID: " + empId + "</p>");
        out.println("<p>Basic Pay: $" + basicPay + "</p>");
        out.println("<p>HRA: $" + hra + "</p>");
        out.println("<p>DA: $" + da + "</p>");
        out.println("<p>Gross Pay: $" + grossPay + "</p>");
        out.println("</body></html>");
    }
}
