package display.team;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TeamDriver {
    public static void main(String[] args) {
        System.out.println("Enter Number of Player and followed by TeamName|PlayerName");
        Scanner scanner = new Scanner(System.in);
        int playerCount = scanner.nextInt();
        scanner.nextLine();

        Team team = new Team();

        for (int i = 0; i < playerCount; i++) {
            String teamPlayer = scanner.nextLine();
            team.AddPlayer(teamPlayer);
        }
        System.out.println("Team and Players in ascending order");
        List<Map<String, List<Player>>> playerList = team.PlayerList();
        Map<String, List<Player>> teamPlayerMap = playerList.get(0);
        for (Map.Entry<String, List<Player>> entry : teamPlayerMap.entrySet()) {
            System.out.println(entry.getKey());//This is Team Name
            for (Player player : entry.getValue()) {
                System.out.println("--" + player.get_name());
            }
        }
    }
}
