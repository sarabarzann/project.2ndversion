
package club.system;


    import java.util.ArrayList;
import java.util.Scanner;

public abstract class Sports {
    private String sportName;
    private int teamSize;
    private String venue;
    private ArrayList<Session> sessions;

    public Sports() {
        this.sessions = new ArrayList<>();
    }

    public Sports(String sportName, int teamSize, String venue) {
        this.sportName = sportName;
        this.teamSize = teamSize;
        this.venue = venue;
        this.sessions = new ArrayList<>();
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void addSession(Session session) {
        sessions.add(session);
    }

    public void removeSession(Session session) {
        sessions.remove(session);
    }

    public ArrayList<Session> getSessions() {
        return sessions;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Sport Name: ");
        this.sportName = scanner.nextLine();
        
        System.out.println("Enter Team Size: ");
        this.teamSize = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.println("Enter Venue: ");
        this.venue = scanner.nextLine();
    }

    public abstract void displaySpecificDetails();

    @Override
    public String toString() {
        return String.format("Sport: %s\nTeam Size: %d\nVenue: %s\nNumber of Sessions: %d", 
                sportName, teamSize, venue, sessions.size());
    }
}

