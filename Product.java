package OnlineShoppingProject;

import java.io.Serializable;

public class Product implements Serializable {//using serializable here for writing an object to file
	String prodid;
	String prodname;
	String category;
	String price;
	String quantity;
	
	
	


	public Product(String prodid, String prodname, String category, String price, String quantity) {
		super();
		this.prodid = prodid;
		this.prodname = prodname;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "Product [prodid=" + prodid + ", prodname=" + prodname + ", category=" + category + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
	
	
    
}
