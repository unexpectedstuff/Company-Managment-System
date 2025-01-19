
abstract class Person {
	private static int idCounter;
	private String name;
	private final String id;
	//i'm using private from name and id since I'll use getters 
	public Person(String name) {
		this.name = name;
		this.id = generateId();
	}
	
    private String generateId() {
        return String.format("P-%03d", idCounter++);
    }
    
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
    
    public abstract void displayInfo(); 
}
