import java.util.Arrays;

public class Client extends Person {
	private String companyName;
	private double[] dailySpending;
	
	public Client(String name, String companyName) {
		super(name);
		this.companyName = companyName;
		this.dailySpending = new double[30];
	}
	
	public void  updateDailySpending(int day, double amount) {
		if (day >= 1 && day <= 30 && amount >= 0) {
			dailySpending[day - 1] = amount;
		} else {
			System.out.println("Invalid day or amount");
		}
	}
	
	@Override
    public void displayInfo() {
        System.out.println("Client ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Company: " + companyName);
        System.out.println("Daily Spending: " + Arrays.toString(dailySpending));
        //spending tracking
        for (double spending : dailySpending) {
            System.out.print(spending + " ");
        }
        System.out.println();
    }
}
