package vttp.paf.day21.classroom.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import vttp.paf.day21.classroom.model.Room;
import vttp.paf.day21.classroom.utils.sql;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoomRepository {

    @Autowired
    private JdbcTemplate template;

    public List<Room> getRooms() {
        List<Room> rooms = new ArrayList<>();
        SqlRowSet rs= template.queryForRowSet(sql.sql_getAllRooms);
        while (rs.next()) {
            Room rm = new Room(rs.getInt("id"), rs.getString("room_type"), rs.getFloat("price"));
            rooms.add(rm);
        }

        return rooms;
    }

}
