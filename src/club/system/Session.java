
package club.system;
import java.util.Scanner;
public class Session {
    private String sessionName;
    private String startTime;
    private String endTime;
    private String instructor;
    private int maxParticipants;
    private int currentParticipants;

    public Session() {}

    public Session(String sessionName, String startTime, String endTime, 
                   String instructor, int maxParticipants) {
        this.sessionName = sessionName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.instructor = instructor;
        this.maxParticipants = maxParticipants;
        this.currentParticipants = 0;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public int getCurrentParticipants() {
        return currentParticipants;
    }

    public void addParticipant() {
        if (currentParticipants < maxParticipants) {
            currentParticipants++;
        } else {
            System.out.println("Session is full. Cannot add more participants.");
        }
    }

    public void removeParticipant() {
        if (currentParticipants > 0) {
            currentParticipants--;
        }
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter Session Name: ");
        this.sessionName = scanner.nextLine();
        
        System.out.println("Enter Start Time: ");
        this.startTime = scanner.nextLine();
        
        System.out.println("Enter End Time: ");
        this.endTime = scanner.nextLine();
        
        System.out.println("Enter Instructor Name: ");
        this.instructor = scanner.nextLine();
        
        System.out.println("Enter Maximum Participants: ");
        this.maxParticipants = scanner.nextInt();
        
        this.currentParticipants = 0;
    }

    @Override
    public String toString() {
        return String.format("Session: %s\nTime: %s - %s\nInstructor: %s\n" +
                             "Participants: %d/%d", 
                             sessionName, startTime, endTime, 
                             instructor, currentParticipants, maxParticipants);
    }
}