/**
 * 
 */
package application;

/**
 * @author orekunrin
 *
 */
public class DeluxeRoom extends StandRoom {

	/**
	 * 
	 */
	
	private String twinBed;
	private int price;
	
	
	public DeluxeRoom() {
		// TODO Auto-generated constructor stub
		super();
		this.twinBed = "";
		this.price = 160;
	}
	
	public String getTwinBed() {
		return twinBed;
	}

	public void setTwinBed(String twinBed) {
		this.twinBed = twinBed;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public int Cost(int days) {
		price = days * price;
		System.out.println("Your price for staying " + days + " days in the deluxe room is $" + price + ".");
		return price;
	}
	
	// display method is just to show your variables (like a toString)
	@Override
	public String Display() {
		return this.twinBed.toString() + this.price;
		
	}
	
}
