package display.team;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.*;

public class Team {
    private String _name;
    private List<Player> _playerList;

    private Map<String, List<Player>> teamPlayerMap = new HashMap<>();

    public Team() {
    }

    public Team(String _name, List<Player> _playerList) {
        this._name = _name;
        this._playerList = _playerList;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public List<Player> get_playerList() {
        return _playerList;
    }

    public void set_playerList(List<Player> _playerList) {
        this._playerList = _playerList;
    }

    public void AddPlayer(String teamPlayer) {
        String teamName = teamPlayer.substring(0, teamPlayer.indexOf("|"));
        String playerName = teamPlayer.substring(teamPlayer.indexOf("|") + 1);

        if (teamPlayerMap.get(teamName) != null) {
            List<Player> players = teamPlayerMap.get(teamName);
            players.add(new Player(playerName));
            teamPlayerMap.put(teamName, players);
        } else {
            List<Player> players = new ArrayList<>();
            players.add(new Player(playerName));
            teamPlayerMap.put(teamName, players);
        }
    }

    public List<Map<String, List<Player>>> PlayerList() {

        Map<String, List<Player>> sortedPlayerMap = new HashMap<>();
        List<Player> playerList;// = new ArrayList<>();
        for (Map.Entry<String, List<Player>> entry : teamPlayerMap.entrySet()) {
            playerList = entry.getValue();
            Collections.sort(entry.getValue());
            sortedPlayerMap.put(entry.getKey(), playerList);
        }
        Map<String, List<Player>> sortedTeamPlayerMap = new TreeMap<>(sortedPlayerMap);

        List<Map<String, List<Player>>> outlist = new ArrayList<>();
        outlist.add(sortedTeamPlayerMap);
        return outlist;

    }

}
