package OnlineShoppingProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class UserManager {

	public static void operations() throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
	Scanner scanner=new Scanner(System.in);
	Scanner scanner1=new Scanner(System.in);
	ArrayList<Product> list = new ArrayList<Product>();
	File file = new File("product.txt");
	ObjectOutputStream out = null;// initially writing the object as null
	ObjectInputStream in = null;
	ListIterator<Product> iterator = null;
	
	char ch = 0;
	do
	{
		System.out.println("***************************************************");
		System.out.println("******WELCOME TO USER ******");
		System.out.println("***************************************************");
	    System.out.println("1. SEARCH PRODUCT");
		System.out.println("2.VIEW ALL PRODUCT");
		System.out.println("***************************************************");
		System.out.println();
	    System.out.println("Enter your choice ");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("---------------Search-----------");
			boolean found=false; 
            System.out.println("Enter the item to be searched"); 
            String item2=scanner1.nextLine(); 
			in = new ObjectInputStream(new FileInputStream(file));
			list = (ArrayList<Product>) in.readObject();
			in.close();
            iterator=list.listIterator(); 
            while(iterator.hasNext()) 
            { 
            Product pl=(Product)iterator.next(); 
            if(pl.prodname.equals(item2)) 
            { 
            System.out.println(pl); 
            found=true; 
            } 
            } 
            if(found) 
            { 
            System.out.println(item2+" is in a list"); 
            } 
            else 
            { 
            System.out.println(item2+" is not in a list"); 
            } 
            break; 
		case 2:
			System.out.println("--- viewing all products--");
			in = new ObjectInputStream(new FileInputStream(file));
			list = (ArrayList<Product>) in.readObject();
			in.close();
			iterator = list.listIterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
			break;
		}
		System.out.println("Do u want to continue press y");
		ch = scanner.next().charAt(0);
		}while(ch=='y');

}
}
