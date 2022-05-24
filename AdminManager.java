package OnlineShoppingProject;

import java.util.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AdminManager {

	public static void operations() throws FileNotFoundException, ClassNotFoundException, IOException {
		String prodid;
		String prodname;
		String category;
		String price;
		String quantity;
		Scanner scanner = new Scanner(System.in);
		Scanner scanner1 = new Scanner(System.in);
		ArrayList<Product> list = new ArrayList<Product>();
		File file = new File("product.txt");// initialising file object and passing filename as argument
		ObjectOutputStream out = null;// initially writing the object as null
		ObjectInputStream in = null;
		ListIterator<Product> iterator = null;
		File file1 = new File("User.txt");
		User user = new User();
		ArrayList<User> list1 = new ArrayList<User>();
		ObjectOutputStream out1 = null;
		ObjectInputStream in1 = null;
		ListIterator<User> iterator1 = null;
		char ch = 0;
		do {
			System.out.println("***************************************************");
			System.out.println("****** HII ADMIN******");
			System.out.println("***************************************************");
			System.out.println("1. ADD PRODUCTS");
			System.out.println("2. VIEW PRODUCT ");
			System.out.println("3. DELETE PRODUCT");
			System.out.println("4. VIEW USER INFORMATION");
			
			System.out.println("***************************************************");
			System.out.println();
			System.out.println("Enter your choice ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Welcome Admin!");
	 	 		System.out.println("Please Enter the no of products that you are goin to add");
				int no_of_products = scanner.nextInt();
				for (int i = 0; i < no_of_products; i++) {
					System.out.println("Enter the products id");
					prodid = scanner1.nextLine();
					System.out.println("Enter name of the product");
					prodname = scanner1.nextLine();
					System.out.println("Enter product category");
					category = scanner1.nextLine();
		 			System.out.println("Enter product price");                          
				  price = scanner1.nextLine();
					System.out.println("Enter the product quantity");
				 	quantity = scanner1.nextLine();
					// adding place object to list
					list.add(new Product(prodid, prodname,category, price, quantity));
				}
				// fileoutputstream writes the file"Beautifulplaces.txt and it will be used by
				// objectoutputstream
				out = new ObjectOutputStream(new FileOutputStream(file));
            	out.writeObject(list);// writes the object available in list into the file.
				out.close();
				break;
			case 2:
				System.out.println("--- view all products--");
				in = new ObjectInputStream(new FileInputStream(file));
				list = (ArrayList<Product>) in.readObject();
				in.close();
				iterator = list.listIterator();
				while (iterator.hasNext()) {
					System.out.println(iterator.next());
				}
				break;
			case 3:
				System.out.println("-------DELETION--------");
				boolean found1 = false;
				System.out.println("Enter the PRODUCT to be removed");
				String product_delete = scanner1.nextLine();
				in = new ObjectInputStream(new FileInputStream(file));
				list = (ArrayList<Product>) in.readObject();
				in.close();
				iterator = list.listIterator();
				while (iterator.hasNext()) {
					Product pl = (Product) iterator.next();
					if (pl.prodname.equals(product_delete)) {
						iterator.remove();
						found1 = true;
					}
				}
				if (found1) {
					out = new ObjectOutputStream(new FileOutputStream(file));
					out.writeObject(list);
					out.close();
					System.out.println(product_delete + " is removed sucessfully");
				} else {
					System.out.println(product_delete + " is not in a list");
				}
				break;
			case 4:
				System.out.println("-------viewallusers-------");
				in1 = new ObjectInputStream(new FileInputStream(file1));
				list1 = (ArrayList<User>) in1.readObject();
				in1.close();
				iterator1 = list1.listIterator();
				while (iterator1.hasNext()) {
					System.out.println(iterator1.next());
				}
				break;
			}
			System.out.println("Do u want to continue press y");
			ch = scanner.next().charAt(0);
		} while (ch == 'y');

	}
}
