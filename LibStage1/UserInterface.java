import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private MemberList memberList; // Assuming you have a class for handling members
    private ProductList productList; // Assuming you have a class for handling products
    private WishlistManager wishlistManager; // Assuming you have a class for handling wishlists

    public UserInterface(MemberList memberList, ProductList productList, WishlistManager wishlistManager) {
        this.scanner = new Scanner(System.in);
        this.memberList = memberList;
        this.productList = productList;
        this.wishlistManager = wishlistManager;
    }

    public void start() {
        while (true) {
            displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addClient();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    addProductToWishlist();
                    break;
                case 4:
                    displayClients();
                    break;
                case 5:
                    displayProducts();
                    break;
                case 6:
                    displayWishlist();
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Add Client");
        System.out.println("2. Add Product");
        System.out.println("3. Add Product to Wishlist");
        System.out.println("4. Display Clients");
        System.out.println("5. Display Products");
        System.out.println("6. Display Wishlist for Client");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addClient() {
        System.out.print("Enter client name: ");
        String name = scanner.nextLine();
        System.out.print("Enter client address: ");
        String address = scanner.nextLine();

        memberList.addClient(name, address); // Delegating to the MemberList class
        System.out.println("Client added successfully.");
    }

    private void addProduct() {
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // consume newline

        productList.addProduct(productName, price, quantity); // Delegating to ProductList class
        System.out.println("Product added successfully.");
    }

    private void addProductToWishlist() {
        System.out.print("Enter client ID: ");
        int clientId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter product ID: ");
        int productId = scanner.nextInt();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // consume newline

        wishlistManager.addToWishlist(clientId, productId, quantity); // Delegating to WishlistManager class
        System.out.println("Product added to wishlist successfully.");
    }

    private void displayClients() {
        memberList.displayAllClients(); // Delegating to MemberList class
    }

    private void displayProducts() {
        productList.displayAllProducts(); // Delegating to ProductList class
    }

    private void displayWishlist() {
        System.out.print("Enter client ID: ");
        int clientId = scanner.nextInt();
        wishlistManager.displayWishlistForClient(clientId); // Delegating to WishlistManager class
    }
}
