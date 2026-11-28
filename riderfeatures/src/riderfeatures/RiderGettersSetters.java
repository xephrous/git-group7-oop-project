package riderfeatures;

public class RiderGettersSetters {
	
	private String riderId;
	private String riderName;
	private String contactNum;
	
	private int maxOrders;
	private int activeOrders;
	
	//setting it up
	public RiderGettersSetters(String riderId, String riderName, String contactNum, int maxOrders, int activeOrders){
		this.riderId = riderId;
		this.riderName = riderName;
		this.contactNum = contactNum;
		this.maxOrders = maxOrders;
		this.activeOrders = activeOrders;
	}
	
	public String getRiderId(){
		return riderId;
	}
	
	public String getRiderName() {
		return riderName;
	}
	
	public String getContactNum() {
		return contactNum;
	}
	
	public int getMaxOrders() {
		return maxOrders;
	}
	
	public int getActiveOrders() {
		return activeOrders;
	}
	
	//getting the remaining orders
	public int getRemainingOrders() {
		return maxOrders - activeOrders;
	}
	
	//status if available and full
	public String getStatus() {
		if (getRemainingOrders() <= 0) {
			return "Full";
		}
		
		return "Available";
	}
	
	//Setters
	public void setRiderName(String riderName) { 
		this.riderName = riderName;
	}
	
	public void setRiderContactNum(String contactNum) {
		this.contactNum = contactNum;
	}
	
	public void setMaxOrders(int maxOrders) {
		this.maxOrders = maxOrders;
	}
	
	public void setActiveOrders(int activeOrders) {
		this.activeOrders = activeOrders;
	}
}
