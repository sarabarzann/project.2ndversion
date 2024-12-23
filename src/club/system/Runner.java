package club.system;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.sql.*;

public class Runner {
    private Scanner scanner;
    private ArrayList<Member> members;
    private ArrayList<Session> sessions;
    private ArrayList<Players> players;
    private ArrayList<Staff> staffList;
    private ArrayList<Sports> sportsList;

    public Runner() {
        scanner = new Scanner(System.in);
        members = new ArrayList<>();
        sessions = new ArrayList<>();
        players = new ArrayList<>();
        staffList = new ArrayList<>();
        sportsList = new ArrayList<>();
    }

    public void start() {
        System.out.println("Welcome to Ashti Club Management System!");
        mainMenu();
        scanner.close(); 
    }

    private void mainMenu() {
        while (true) {
            System.out.println("\n--- Ashti Club Main Menu ---");
            System.out.println("1. Staff Management");
            System.out.println("2. Player Management");
            System.out.println("3. Sports Management");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    staffManagement();
                    break;
                case 2:
                    playerManagement();
                    break;
                case 3:
                    sportsManagement();
                    break;
                case 4:
                    System.out.println("Thank you for using Ashti Club Management System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void staffManagement() {
        while (true) {
            System.out.println("\n--- Staff Management ---");
            System.out.println("1. Add Staff");
            System.out.println("2. Remove Staff");
            System.out.println("3. Update Staff");
            System.out.println("4. Display Staff");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addStaff();
                    break;
                case 2:
                    removeStaff();
                    break;
                case 3:
                    updateStaff();
                    break;
                case 4:
                    displayStaff();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void addStaff() {
        System.out.println("\nChoose Staff Type:");
        System.out.println("1. Coach");
        System.out.println("2. Administrator");
        System.out.println("3. Doctor");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); 

        Staff staff;
        switch (choice) {
            case 1:
                staff = new Coach();
                break;
            case 2:
                staff = new Administrator();
                break;
            case 3:
                staff = new Doctor();
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        staff.input();
        staffList.add(staff);
        System.out.println("Staff added successfully!");
    }

    private void removeStaff() {
        System.out.print("Enter Staff ID to remove: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();

        boolean removed = staffList.removeIf(staff -> staff.getMemberId() == memberId);
        if (removed) {
            System.out.println("Staff removed successfully.");
        } else {
            System.out.println("No staff found with the given ID.");
        }
    }
    

    private void updateStaff() {
        System.out.print("Enter Staff ID to update: ");
        int memberId = scanner.nextInt();
        scanner.nextLine(); 

        for (Staff staff : staffList) {
            if (staff.getMemberId() == memberId) {
                staff.input();
                System.out.println("Staff updated successfully!");
                return;
            }
        }
        System.out.println("Staff not found.");
    }

    private void displayStaff() {
        if (staffList.isEmpty()) {
            System.out.println("No staff to display.");
            return;
        }
        for (Staff staff : staffList) {
            System.out.println(staff);
        }
    }

    private void playerManagement() {
        while (true) {
            System.out.println("\n--- Player Management ---");
            System.out.println("1. Add Player");
            System.out.println("2. Remove Player");
            System.out.println("3. Update Player");
            System.out.println("4. Display Players");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Players player = new Players();
                    player.input();
                    players.add(player);
                    System.out.println("Player added successfully!");
                    break;
                case 2:
                    System.out.print("Enter Player ID to remove: ");
                    int memberId = scanner.nextInt();
                    scanner.nextLine();
                    removePlayer(memberId);
                    break;
                case 3:
                    System.out.print("Enter Player ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); 
                    updatePlayer(updateId);
                    break;
                case 4:
                    displayPlayers();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void removePlayer(int memberId) {
        boolean removed = players.removeIf(player -> player.getMemberId() == memberId);
        if (removed) {
            System.out.println("Player removed successfully.");
        } else {
            System.out.println("No player found with the given ID.");
        }
    }

    private void updatePlayer(int memberId) {
        for (Players player : players) {
            if (player.getMemberId() == memberId) {
                player.input();
                System.out.println("Player updated successfully!");
                return;
            }
        }
        System.out.println("Player not found.");
    }

    private void displayPlayers() {
        if (players.isEmpty()) {
            System.out.println("No players to display.");
            return;
        }
        for (Players player : players) {
            System.out.println(player);
        }
    }

    private void sportsManagement() {
        while (true) {
            System.out.println("\n--- Sports Management ---");
            System.out.println("1. Add Sports");
            System.out.println("2. Remove Sports");
            System.out.println("3. Display Sports");
            System.out.println("4. Add Session to Sports");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addSports();
                    break;
                case 2:
                    removeSports();
                    break;
                case 3:
                    displaySports();
                    break;
                case 4:
                    addSessionToSports();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void addSports() {
        System.out.println("Choose Sports Type:");
        System.out.println("1. Football");
        System.out.println("2. Volleyball");
        System.out.println("3. Basketball");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); 

        Sports sport;
        switch (choice) {
            case 1:
                sport = new Football();
                break;
            case 2:
                sport = new Volleyball();
                break;
            case 3:
                sport = new Basketball();
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        sport.input();
        sportsList.add(sport);
        System.out.println("Sports added successfully!");
    }
private void removeSports() {
    System.out.print("Enter Sports Name to remove: ");
    String sportName = scanner.nextLine();

    boolean removed = false;

    for (int i = 0; i < sportsList.size(); i++) {
        if (sportsList.get(i).getSportName().equalsIgnoreCase(sportName)) {
            sportsList.remove(i); 
            removed = true;
            break; 
        }
    }

    if (removed) {
        System.out.println("Sports removed successfully.");
    } else {
        System.out.println("No sports found with the given name.");
    }
}

    private void displaySports() {
        if (sportsList.isEmpty()) {
            System.out.println("No sports to display.");
            return;
        }
        for (Sports sport : sportsList) {
            System.out.println(sport);
            sport.displaySpecificDetails();
            System.out.println("---");
        }
    }

    private void addSessionToSports() {
        if (sportsList.isEmpty()) {
            System.out.println("No sports available. Add a sport first.");
            return;
        }

        System.out.println("Choose a sport to add a session:");
        for (int i = 0; i < sportsList.size(); i++) {
            System.out.println((i + 1) + ". " + sportsList.get(i).getSportName());
        }
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); 

        if (choice < 1 || choice > sportsList.size()) {
            System.out.println("Invalid choice.");
            return;
        }

       Sports selectedSport = sportsList.get(choice - 1);
        Session session = new Session();
        session.input();
        selectedSport.addSession(session);
        System.out.println("Session added to " + selectedSport.getSportName() + " successfully!");
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/club_registration";
String username = "root"; 
String password = "Sar8.bb8912@3443"; 

try {
// Load MySQL JDBC Driver (optional for Java 8+)
Class.forName("com.mysql.cj.jdbc.Driver");

// Establish the connection
Connection conn = DriverManager.getConnection(url, username, password);




System.out.println("Connected to the database!");

conn.close();
} catch (ClassNotFoundException e) {
System.out.println("MySQL Driver not found. Add the JDBC driver to your classpath.");
} catch (SQLException e) {
 System.out.println("Error connecting to the database: " + e.getMessage());
 
}
        Runner runner = new Runner();
        runner.start();
    }

}