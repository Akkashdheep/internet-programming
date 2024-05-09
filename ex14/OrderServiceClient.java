import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

public class OrderServiceClient {
    public static void main(String[] args) {
        int userId = 123; // User ID for whom orders need to be retrieved

        // Create client
        Client client = ClientBuilder.newClient();

        // Invoke web service
        Response response = client.target("http://localhost:8080/orders/" + userId)
                                  .request()
                                  .get();

        if (response.getStatus() == 200) {
            // If response is successful, retrieve orders
            List<Order> orders = response.readEntity(new GenericType<List<Order>>() {});
            for (Order order : orders) {
                System.out.println("Order ID: " + order.getOrderId());
                System.out.println("Order Date: " + order.getOrderDate());
                System.out.println("Products:");
                for (Product product : order.getProducts()) {
                    System.out.println("\tProduct ID: " + product.getProductId());
                    System.out.println("\tProduct Name: " + product.getProductName());
                    System.out.println("\tPrice: " + product.getPrice());
                    System.out.println("\tQuantity: " + product.getQuantity());
                }
                System.out.println("----------------------------------");
            }
        } else {
            System.out.println("Failed to retrieve orders. Status code: " + response.getStatus());
        }

        // Close client
        client.close();
    }
}
