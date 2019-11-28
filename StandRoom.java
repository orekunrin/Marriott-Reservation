/**
 * 
 */
package application;

/**
 * @author orekunrin
 *
 */
public class StandRoom extends Main {

	/**
	 * 
	 */
	
	private String name;
	private String queen;
	private boolean safe;
	private int price;
	
	public StandRoom() {
		// TODO Auto-generated constructor stub
		
		this.name = "";
		this.queen = "";
		this.safe = true;
		this.price = 100;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQueen() {
		return queen;
	}

	public void setQueen(String queen) {
		this.queen = queen;
	}

	public boolean isSafe() {
		return safe;
	}

	public void setSafe(boolean safe) {
		this.safe = safe;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public int Cost(int days) {
		price = days * price;
		System.out.println("Your price for staying " + days + " days in the stand room is $" + price + ".");
		return price;
	}
	
	// display method is just to show your variables (like a toString)
	public String Display() {
		return this.name.toString() + "" + this.queen.toString() + "" + this.safe + "" + this.price;
	}
	
	/*
	public int ReserveRoom() {
		
	}
	*/

}
