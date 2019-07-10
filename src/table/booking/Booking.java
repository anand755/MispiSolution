package table.booking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Booking {
    private long _id;
    private String _customerName;
    private Table _table;
    private int _membersPresent;
    private double _billamount;
    private Date _bookingTime;

    public Booking() {
    }

    public Booking(long _id, String _customerName, Table _table, int _membersPresent, double _billamount, Date _bookingTime) {
        this._id = _id;
        this._customerName = _customerName;
        this._table = _table;
        this._membersPresent = _membersPresent;
        this._billamount = _billamount;
        this._bookingTime = _bookingTime;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String get_customerName() {
        return _customerName;
    }

    public void set_customerName(String _customerName) {
        this._customerName = _customerName;
    }

    public Table get_table() {
        return _table;
    }

    public void set_table(Table _table) {
        this._table = _table;
    }

    public int get_membersPresent() {
        return _membersPresent;
    }

    public void set_membersPresent(int _membersPresent) {
        this._membersPresent = _membersPresent;
    }

    public double get_billamount() {
        return _billamount;
    }

    public void set_billamount(double _billamount) {
        this._billamount = _billamount;
    }

    public Date get_bookingTime() {
        return _bookingTime;
    }

    public void set_bookingTime(Date _bookingTime) {
        this._bookingTime = _bookingTime;
    }

    public static void CreateBooking(List<Table> tableList, List<Booking> bookingList, String line) {

        /*This is the number list of all the tables*/
        List<String> tableNumberList = new ArrayList<>();
        for (int i = 0; i < tableList.size(); i++) {
            tableNumberList.add(tableList.get(i).get_number());
        }

        /*This is the number list of only booked tables*/
        List<String> bookedTableNumbers = new ArrayList<>();
        for (int i = 0; i < bookingList.size(); i++) {
            bookedTableNumbers.add(bookingList.get(i).get_table().get_number());
        }

        /*We are taking all the fields of new booking*/
        String[] newBookingDetails = line.split(",");
        int _id = Integer.valueOf(newBookingDetails[0]);
        String _customerName = newBookingDetails[1];
        String _tableNumber = newBookingDetails[2];
        int _membersPresent = Integer.valueOf(newBookingDetails[3]);
        double _billamount = Double.valueOf(newBookingDetails[4]);
        Date _bookingTime = null;
        try {
            _bookingTime = new SimpleDateFormat("dd-MM-yyyy").parse(newBookingDetails[5]);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        /*Checking if the entered table number is there in the table list or not*/
        if (!tableNumberList.contains(_tableNumber)) {
            System.out.println("Sorry there is no table with this table id");

        } else {

            /*If the entered table number is present then there would be 3 case
             * 1------------> All Tables are booked*/
            if (TableBookingDriver.bookingList.size() == tableList.size()) {
                System.out.println("Sorry, No tables available");
            } else {

                /*2-------------> Entered table is booked but alternate table =s are available*/
                if (bookedTableNumbers.contains(_tableNumber)) {
                    System.out.println("Already booked");

                    //showing alternate tables here
                    List<Table> alternateTable = new ArrayList<>(tableList);// tableList;
                    List<Table> bookedTable = new ArrayList<>();
                    for (Booking booking : TableBookingDriver.bookingList) {
                        bookedTable.add(booking.get_table());
                    }
                    alternateTable.removeAll(bookedTable);
                    Collections.sort(alternateTable);

                    System.out.println("The available tables are");
                    System.out.println("ID" + "\t" + "Number" + "\t" + "Capacity");
                    for (Table table : alternateTable) {
                        System.out.println(table.get_id() + "\t" + table.get_number() + "\t" + table.get_capacity());
                    }

                } else {
                    /*3----------> Entered table is available so book the table*/
                    Table tempTable = null;
                    for (int i = 0; i < tableList.size(); i++) {
                        if (_tableNumber.equalsIgnoreCase(tableList.get(i).get_number()))
                            tempTable = tableList.get(i);
                    }

                    /*Updating the booking list here which will be passed again from TableBookingDriver class*/
                    TableBookingDriver.bookingList.add(new Booking(_id, _customerName, tempTable, _membersPresent, _billamount, _bookingTime));
                    System.out.println("Table successfully booked");
                }
            }
        }
    }
}
