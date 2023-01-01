import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isProgrammeEnded = false;
        MetierProduitImpl job = new MetierProduitImpl(
              new ArrayList<>(
                    List.of(
                          new Produit(1, "Product1", "A", 15.89, "Description of product1", 15),
                          new Produit(2, "Product2", "B", 17.99, "Description of product2", 20),
                          new Produit(3, "Product3", "C", 20.79, "Description of product3", 30),
                          new Produit(4, "Product4", "D", 49.99, "Description of product4", 20)
                    )
              )
        );

        while (true) {
            System.out.println("----------------------------------");
            System.out.println("1. Afficher la liste des produits");
            System.out.println("2. Rechercher un produit par son id");
            System.out.println("3. Ajouter un nouveau produit dans la liste");
            System.out.println("4. Supprimer un produit par id");
            System.out.println("5. Quitter ce programme");

            switch (sc.nextInt()) {
                case 1:
                    System.out.println("------ all products -------");
                    for (Produit produit : job.getAll())
                        System.out.println(produit);
                    break;
                case 2:
                    System.out.println("Enter the product id to find: ");
                    long id = sc.nextLong();
                    Produit p = job.findById(id);
                    if (p == null)
                        System.out.println("No product found with id: " + id);
                    else
                        System.out.println(p);
                    break;
                case 3:
                    System.out.println("Enter the information for the new product: ");
                    System.out.println("Id");
                    id = sc.nextLong();
                    if (job.findById(id) != null) {
                        System.out.println("Product with id " + id + " already exist");
                        break;
                    }
                    System.out.println("Name");
                    String nom = sc.next();
                    System.out.println("Brand");
                    String marque = sc.next();
                    System.out.println("Price");
                    double prix = sc.nextDouble();
                    System.out.println("Description");
                    String description = sc.next();
                    System.out.println("Quantity");
                    int quantity = sc.nextInt();
                    job.add(new Produit(id, nom, marque, prix, description, quantity));
                    break;
                case 4:
                    System.out.println("Enter the id of the product to delete: ");
                    id = sc.nextLong();
                    job.delete(id);
                    break;
                case 5:
                    //End the program
                    isProgrammeEnded = true;
                    break;
            }

            if (isProgrammeEnded)
                break;
        }

    }
}