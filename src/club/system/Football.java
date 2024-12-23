
package club.system;
import java.util.Scanner;
    public class Football extends Sports {
    private String league;
    private int championshipsWon;

    public Football() {
        super();
    }

    public Football(String sportName, int teamSize, String venue, 
                    String league, int championshipsWon) {
        super(sportName, teamSize, venue);
        this.league = league;
        this.championshipsWon = championshipsWon;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public int getChampionshipsWon() {
        return championshipsWon;
    }

    public void setChampionshipsWon(int championshipsWon) {
        this.championshipsWon = championshipsWon;
    }

    @Override
    public void input() {
        super.input();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter Football League: ");
        this.league = scanner.nextLine();
        
        System.out.println("Enter Number of Championships Won: ");
        this.championshipsWon = scanner.nextInt();
    }

    @Override
    public void displaySpecificDetails() {
        System.out.println("Football Specific Details:");
        System.out.println("League: " + league);
        System.out.println("Championships Won: " + championshipsWon);
    }

    @Override
    public String toString() {
        return super.toString() + 
               String.format("\nLeague: %s\nChampionships Won: %d", 
               league, championshipsWon);
    }
}


