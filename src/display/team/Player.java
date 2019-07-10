package display.team;

public class Player implements Comparable<Player> {
    private String _name;

    public Player() {
    }

    public Player(String _name) {
        this._name = _name;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }


    @Override
    public int compareTo(Player player) {
        return this._name.compareTo(player.get_name());
    }
}
