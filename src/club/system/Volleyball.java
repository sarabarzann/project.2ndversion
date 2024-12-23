
package club.system;
import java.util.Scanner;
    public class Volleyball extends Sports {
    private int nationalTeamMembers;
    private String coach;

    public Volleyball() {
        super();
    }

    public Volleyball(String sportName, int teamSize, String venue, 
                      int nationalTeamMembers, String coach) {
        super(sportName, teamSize, venue);
        this.nationalTeamMembers = nationalTeamMembers;
        this.coach = coach;
    }

    public int getNationalTeamMembers() {
        return nationalTeamMembers;
    }

    public void setNationalTeamMembers(int nationalTeamMembers) {
        this.nationalTeamMembers = nationalTeamMembers;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    @Override
    public void input() {
        super.input();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter Number of National Team Members: ");
        this.nationalTeamMembers = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.println("Enter Coach Name: ");
        this.coach = scanner.nextLine();
    }

    @Override
    public void displaySpecificDetails() {
        System.out.println("Volleyball Specific Details:");
        System.out.println("National Team Members: " + nationalTeamMembers);
        System.out.println("Coach: " + coach);
    }

    @Override
    public String toString() {
        return super.toString() + 
               String.format("\nNational Team Members: %d\nCoach: %s", 
               nationalTeamMembers, coach);
    }
}

