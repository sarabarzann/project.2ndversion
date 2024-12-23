
package club.system;
import java.util.Scanner;
    public class Basketball extends Sports {
    private String division;
    private int conferenceRank;

    public Basketball() {
        super();
    }

    public Basketball(String sportName, int teamSize, String venue, 
                      String division, int conferenceRank) {
        super(sportName, teamSize, venue);
        this.division = division;
        this.conferenceRank = conferenceRank;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public int getConferenceRank() {
        return conferenceRank;
    }

    public void setConferenceRank(int conferenceRank) {
        this.conferenceRank = conferenceRank;
    }

    @Override
    public void input() {
        super.input();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter Basketball Division: ");
        this.division = scanner.nextLine();
        
        System.out.println("Enter Conference Rank: ");
        this.conferenceRank = scanner.nextInt();
    }

    @Override
    public void displaySpecificDetails() {
        System.out.println("Basketball Specific Details:");
        System.out.println("Division: " + division);
        System.out.println("Conference Rank: " + conferenceRank);
    }

    @Override
    public String toString() {
        return super.toString() + 
               String.format("\nDivision: %s\nConference Rank: %d", 
               division, conferenceRank);
    }
}

