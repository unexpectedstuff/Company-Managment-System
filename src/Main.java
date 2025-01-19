import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//Main class 
//1. Create objects for Client, Manager and RegularWorker. 
//2. Populate data (spending, working hours, vacation days…) using 
//private helper methods with random values. 
//3. Use Scanner for user interaction, allowing the user to: 
//○ View data. 
//○ Perform operations (log hours, update spending, manage 
//teams…). 
//4. Print results using appropriate class methods.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<Worker> workers = new ArrayList<>();
        
        
        // 1. Create Clients and Workers
        Client client1 = new Client("Client 1", "Company A");
        Client client2 = new Client("Client 2", "Company B");
        
        Manager manager1 = new Manager("Manager 1", 3000.00);
        RegularWorker worker1 = new RegularWorker("Worker 1", 1500.00);
        RegularWorker worker2 = new RegularWorker("Worker 2", 1600.00);
        
        // Add Clients and Workers to lists created for them
        clients.add(client1);
        clients.add(client2);
        workers.add(manager1);
        workers.add(worker1);
        workers.add(worker2);

        // Used random values to generate data
        generateData(client1, worker1);
        generateData(client2, worker2);
        
        // Add workers to manager's team
        manager1.addTeamMember(worker1);
        manager1.addTeamMember(worker2);
        
        // Menu 
        while (true) {
            System.out.println("\n1. View Data");
            System.out.println("2. Log Hours");
            System.out.println("3. Update Spending");
            System.out.println("4. Manage Teams");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    // View data
                    System.out.println("\n--- Clients Data ---");
                    for (Client client : clients) {
                        client.displayInfo();
                    }
                    System.out.println("\n--- Workers Data ---");
                    for (Worker worker : workers) {
                        worker.displayInfo();
                    }
                    break;
                    
                case 2:
                    // Log hours for workers
                    System.out.print("Enter worker name to log hours (e.g., Worker 1): ");
                    String workerName = scanner.nextLine();
                    System.out.print("Enter day (1-30): ");
                    int day = scanner.nextInt();
                    System.out.print("Enter hours worked (0-24): ");
                    double hours = scanner.nextDouble();
                    scanner.nextLine(); // consume newline

                    Worker workerToLog = findWorkerByName(workerName, workers);
                    if (workerToLog != null) {
                        workerToLog.logHours(day, hours);
                        System.out.println("Hours logged successfully.");
                    } else {
                        System.out.println("Worker not found.");
                    }
                    break;

                case 3:
                    // Update spending for clients
                    System.out.print("Enter client name to update spending (e.g., Client 1): ");
                    String clientName = scanner.nextLine();
                    System.out.print("Enter day (1-30): ");
                    int spendingDay = scanner.nextInt();
                    System.out.print("Enter spending amount: ");
                    double spending = scanner.nextDouble();
                    scanner.nextLine(); // consume newline

                    Client clientToUpdate = findClientByName(clientName, clients);
                    if (clientToUpdate != null) {
                        clientToUpdate.updateDailySpending(spendingDay, spending);
                        System.out.println("Spending updated successfully.");
                    } else {
                        System.out.println("Client not found.");
                    }
                    break;

                case 4:
                    // Manage teams (add new worker to a team)
                    System.out.print("Enter manager name to add a worker (e.g., Manager 1): ");
                    String managerName = scanner.nextLine();
                    System.out.print("Enter worker name to add (e.g., Worker 1): ");
                    String newWorkerName = scanner.nextLine();

                    Manager managerToAdd = findManagerByName(managerName, workers);
                    Worker newWorkerToAdd = findWorkerByName(newWorkerName, workers);
                    if (managerToAdd != null && newWorkerToAdd != null) {
                        managerToAdd.addTeamMember(newWorkerToAdd);
                        System.out.println("Worker added to team.");
                    } else {
                        System.out.println("Manager or Worker not found.");
                    }
                    break;
                    
                case 5:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Method for creating randomg data
    private static void generateData(Client client, Worker worker) {
        Random rand = new Random();
        
        // Generate Client data (spending)
        for (int i = 0; i < 30; i++) {
            double spending = rand.nextDouble() * 1000;  // Random spending between 0 and 1000
            client.updateDailySpending(i + 1, spending);
        }

        // Generate Worker data (hours and vacation)
        for (int i = 0; i < 30; i++) {
            double hours = rand.nextDouble() * 8;  // Random hours between 0 and 8
            worker.logHours(i + 1, hours);
        }
    }

    // Methods to find Worker and Client by name
    private static Worker findWorkerByName(String name, ArrayList<Worker> workers) {
        for (Worker worker : workers) {
            if (worker.getName().equals(name)) {
                return worker;
            }
        }
        return null;
    }

    private static Client findClientByName(String name, ArrayList<Client> clients) {
        for (Client client : clients) {
            if (client.getName().equals(name)) {
                return client;
            }
        }
        return null;
    }

    private static Manager findManagerByName(String name, ArrayList<Worker> workers) {
        for (Worker worker : workers) {
            if (worker instanceof Manager && worker.getName().equals(name)) {
                return (Manager) worker;
            }
        }
        return null;
    }
}
