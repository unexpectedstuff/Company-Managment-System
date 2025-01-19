
public class RegularWorker extends Worker {
	private final static int START_SICK_DAYS = 15;
	private int sickDays;
	
	public RegularWorker(String name, double basicSalary) {
		super(name, basicSalary);
		this.sickDays = START_SICK_DAYS;
	}
	
	@Override
	double calculatePaycheck() {
		double totalHours = 0;
		for (double hours : dailyHours) {
            totalHours += hours;
        }
        return basicSalary + totalHours * 10; //sample salary calculation by hour
	}
	
	public boolean takeSickDays(int days) {
        if (sickDays >= days) {
            sickDays -= days;
            return true;
        }
        return false;
    }

    @Override
    protected void resetDays() {
        super.resetDays();
        this.sickDays = START_SICK_DAYS;  // Sick days reset for workers
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Sick Days: " + sickDays);
    }
}
