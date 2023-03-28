package VideoProject;

public class OrderItem {
	
	//properties
	private int quantity;
	private MenuItem menuItem;
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public MenuItem getMenuItem() {
		return menuItem;
	}
	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}
	
	
	public double getTotal() {
		
		double priceDouble = Double.parseDouble(menuItem.getItemPrice());
		
		double total = quantity * priceDouble;
		
		return total;
		
		
	}

}
