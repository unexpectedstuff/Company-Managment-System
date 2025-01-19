import java.util.ArrayList;

public class Manager extends Worker {
	private final static int EXTRA_VACATION_DAYS = 10;
	private ArrayList<Worker> team;
	
	public Manager(String name, double basicSalary) {
		super (name, basicSalary);
		this.team = new ArrayList<>();
	}
	
    @Override
    public double calculatePaycheck() {
    	 return super.basicSalary + team.size() * 100; //sample salary calculation with bonuses for employees  
    }
	
	public void addTeamMember(Worker worker) {
		if (!team.contains(worker)) {
			team.add(worker);
		}
	}
	
    public void displayTeam() {
        for (Worker worker : team) {
            worker.displayInfo();
        }
    }
    
    @Override
    protected void resetDays() {
        super.resetDays();
        //additional voc days for managers
        this.vacationDays += EXTRA_VACATION_DAYS; // Add extra vacation days for managers during reset
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Team size: " + team.size());
    }
}
