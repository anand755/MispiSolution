package table.booking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TableBookingDriver {
    public static List<Booking> bookingList = new ArrayList<>();

    public static void main(String[] args) {
        int tableCount;
        Table newTable;
        List<Table> tableList = new ArrayList<>();
        String isContinue = "yes";

        /*Taking the number of tables and looping to take tables input*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of tables: ");
        tableCount = scanner.nextInt();

        for (int i = 0; i < tableCount; i++) {
            String tabelEntry = scanner.next();
            newTable = Table.CreateTable(tabelEntry);
            tableList.add(newTable);
        }

        /*Checking if the user is willing to continue for the next booking or not. For first time its 'yes'*/
        while (isContinue.equalsIgnoreCase("yes")) {
            System.out.println("Enter the booking details: ");

            String newBookingEntry = scanner.next();
            String[] newBookingDetails = newBookingEntry.split(",");

            if (newBookingDetails.length == 6) {
                /*For the first time booking list will be empty. booking list value will be updated in the Booking class upon successfull booking*/
                Booking.CreateBooking(tableList, bookingList, newBookingEntry);
            }
            System.out.println("Do you want to continue(yes/no) : ");
            isContinue = scanner.next();
        }
        System.out.println("Thank you, Programs Ends");
    }
}