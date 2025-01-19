
public abstract class Worker extends Person {
	private static final int START_VACATION_DAYS = 10;
	double[] dailyHours;
	int vacationDays;
	double basicSalary;
	
	public  Worker(String name, double basicSalary) {
		super(name);
		this.basicSalary = basicSalary;
		this.dailyHours = new double [30];
		this.vacationDays = START_VACATION_DAYS;
	}
	
    public double getBasicSalary() {
        return basicSalary;  
    }
	
	public void logHours(int day, double hours) {
		if (day >= 1 && day <= 30 && hours >= 0 && hours <= 24) {
			dailyHours [day - 1] = hours;
			} else {
				System.out.println("Invalid day or hours");
			}
	}
	
	public boolean takeVacationDays(int days) {
		if (vacationDays >= days) {
			vacationDays -= days;
			return true;
		}
		return false;
	}
	
	abstract double calculatePaycheck();
	
	@Override
	public void displayInfo() {
        System.out.println("Worker ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Vacation Days: " + vacationDays);
	}
	
    protected void resetDays() {
        this.vacationDays = START_VACATION_DAYS;  // Reset vacation days for workers
    }
}
