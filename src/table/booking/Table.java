package table.booking;

public class Table implements Comparable<Table> {
    private long _id;
    private String _number;
    private String _capacity;

    public Table() {
    }

    public Table(long _id, String _number, String _capacity) {
        this._id = _id;
        this._number = _number;
        this._capacity = _capacity;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String get_number() {
        return _number;
    }

    public void set_number(String _number) {
        this._number = _number;
    }

    public String get_capacity() {
        return _capacity;
    }

    public void set_capacity(String _capacity) {
        this._capacity = _capacity;
    }

    @Override
    public int compareTo(Table table) {
        return (int) (this._id - table._id);
    }

    public static Table CreateTable(String line) {
        Table tempTable = null;
        String[] tableDetails = line.split(",");
        if (tableDetails.length == 3) {
            long _id = Long.valueOf(tableDetails[0]);
            String _number = tableDetails[1];
            String _capacity = tableDetails[2];
            tempTable = new Table(_id, _number, _capacity);
        }
        return tempTable;
    }
}
