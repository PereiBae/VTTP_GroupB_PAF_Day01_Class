package vttp.paf.day21.classroom.utils;

public class sql {

    public static final String sql_getAllRooms = "SELECT * FROM room";
    public static final String sql_getAllCustomers_LimitOffset = "SELECT * FROM customer limit ? offset ?";

    public static final String sql_getAllCustomers = "SELECT * FROM customer";

}
