import java.util.Scanner;

public class TestUserInterface {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Add Client");
            System.out.println("2. Add Product");
            System.out.println("3. Add to Wishlist");
            System.out.println("4. View Clients");
            System.out.println("5. View Products");
            System.out.println("6. Exit");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1: // Add Client
                    System.out.print("Enter client name: ");
                    String clientName = scanner.nextLine();
                    // Assuming addClient method takes a String name
                    ui.addClient(clientName);
                    System.out.println("Client added: " + clientName);
                    break;
                
                case 2: // Add Product
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    // Assuming addProduct method takes a String name
                    ui.addProduct(productName);
                    System.out.println("Product added: " + productName);
                    break;

                case 3: // Add to Wishlist
                    System.out.print("Enter client name for wishlist: ");
                    String wishlistClient = scanner.nextLine();
                    System.out.print("Enter product name to add to wishlist: ");
                    String wishlistProduct = scanner.nextLine();
                    // Assuming addToWishlist method takes client name and product name
                    ui.addToWishlist(wishlistClient, wishlistProduct);
                    System.out.println("Added " + wishlistProduct + " to " + wishlistClient + "'s wishlist.");
                    break;

                case 4: // View Clients
                    System.out.println("Clients:");
                    ui.viewClients(); // Assuming viewClients prints the list of clients
                    break;

                case 5: // View Products
                    System.out.println("Products:");
                    ui.viewProducts(); // Assuming viewProducts prints the list of products
                    break;

                case 6: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
