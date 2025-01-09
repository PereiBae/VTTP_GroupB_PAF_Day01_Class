package vttp.paf.day21.classroom.utils;

public class sql {

    public static final String sql_getAllRooms = "SELECT * FROM room";
    public static final String sql_getAllRooms_Limit_Offset = "SELECT * FROM room LIMIT ? OFFSET ?";
    public static final String sql_getRoom_ById = "SELECT * FROM room WHERE id = ?";
    public static final String sql_deleteRoom_ById = "DELETE FROM room WHERE id = ?";
    public static final String sql_updateRoom_ById = "UPDATE room SET room_type = ?, price = ? WHERE id = ?";

    public static final String sql_getAllCustomers = "SELECT * FROM customer";
    public static final String sql_getAllCustomers_LimitOffset = "SELECT * FROM customer limit ? offset ?";
    public static final String sql_getCustomers_ById = "SELECT * FROM customer WHERE id = ?";
    public static final String sql_deleteCustomerById = "DELETE FROM customer WHERE id = ?";
    public static final String sql_updateCustomerById = "UPDATE customer SET customer_name = ?, email = ? WHERE id = ?";

}
