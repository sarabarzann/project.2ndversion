package club.system;

import java.util.ArrayList;
import java.util.Scanner;

public class Players extends Member {
    private String teamName;
    private String position;
    private int gamesPlayed;
    private int gamesWon;
    private static ArrayList<Players> players = new ArrayList<>();

    public Players() {
        super();
    }

    public Players(int memberId, String name, String mobileNo, String gender,
                   String teamName, String position, int gamesPlayed, int gamesWon) {
        super(memberId, name, mobileNo, gender);
        this.teamName = teamName;
        this.position = position;
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    @Override
    public String toString() {
        return String.format("%s\nTeam: %s\nPosition: %s\nGames Played: %d\nGames Won: %d\nWin Rate: %.2f%%",
                             super.toString(), teamName, position, gamesPlayed, gamesWon, calculateWinRate());
    }

    public double calculateWinRate() {
        return gamesPlayed == 0 ? 0 : (double) gamesWon / gamesPlayed * 100;
    }

    public static void addPlayer(Players player) {
        players.add(player);
        System.out.println("Player added successfully!");
    }

    public static void removePlayer(int memberId) {
        boolean found = false;
        for (Players player : players) {
            if (player.getMemberId() == memberId) {
                players.remove(player);
                System.out.println("Player with ID " + memberId + " removed.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Player with ID " + memberId + " not found.");
        }
    }

    public static void updatePlayer(int memberId) {
        Scanner scanner = new Scanner(System.in);
        boolean found = false;
        for (Players player : players) {
            if (player.getMemberId() == memberId) {
                found = true;
                System.out.println("Updating details for player with ID " + memberId);
                System.out.println("Enter new team name: ");
                player.setTeamName(scanner.nextLine());
                System.out.println("Enter new position: ");
                player.setPosition(scanner.nextLine());
                System.out.println("Enter games played: ");
                player.setGamesPlayed(scanner.nextInt());
                System.out.println("Enter games won: ");
                player.setGamesWon(scanner.nextInt());
                scanner.nextLine(); 
                System.out.println("Player updated successfully!");
                break;
            }
        }
        if (!found) {
            System.out.println("Player with ID " + memberId + " not found.");
        }
    }

    public static void displayAllPlayers() {
        if (players.isEmpty()) {
            System.out.println("No players to display.");
        } else {
            for (Players player : players) {
                System.out.println(player);
            }
        }
    }
}