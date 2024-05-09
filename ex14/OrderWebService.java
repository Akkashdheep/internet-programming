import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Path("/orders")
public class OrderWebService {

    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getUserOrders(@PathParam("userId") int userId) {
        List<Order> orders = new ArrayList<>();
        
        try {
            // Establish database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM orders WHERE user_id = ?");
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                int orderId = rs.getInt("order_id");
                Timestamp orderDate = rs.getTimestamp("order_date");
                
                // Get products for this order
                List<Product> products = getProductsForOrder(conn, orderId);
                
                // Create Order object and add it to the list
                Order order = new Order(orderId, orderDate, products);
                orders.add(order);
            }
            
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return orders;
    }

    private List<Product> getProductsForOrder(Connection conn, int orderId) throws SQLException {
        List<Product> products = new ArrayList<>();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM order_details WHERE order_id = ?");
        stmt.setInt(1, orderId);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            int productId = rs.getInt("product_id");
            String productName = rs.getString("product_name");
            double price = rs.getDouble("price");
            int quantity = rs.getInt("quantity");
            
            Product product = new Product(productId, productName, price, quantity);
            products.add(product);
        }
        
        return products;
    }
}
