/**
 * 
 */
package application;

/**
 * @author orekunrin
 *
 */
public class JuniorSuite extends DeluxeRoom {

	
	private String sofa;
	private int price;
	
	public JuniorSuite() {
		// TODO Auto-generated constructor stub
		super();
		this.sofa = "";
		this.price = 200;
	}
	
	
	
	// display method is just to show your variables (like a toString)
	@Override
	public String Display() {
		return this.sofa.toString() + "" + price;
		
	}
	
	public int Cost(int days) {
		price = days * price;
		System.out.println("Your price for staying " + days + " days in the stand room is $" + price + ".");
		return price;
	}

}
