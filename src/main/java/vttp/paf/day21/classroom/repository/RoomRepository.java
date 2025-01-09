package vttp.paf.day21.classroom.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        SqlRowSet rs= template.queryForRowSet(sql.sql_getAllRooms);
        while (rs.next()) {
            Room rm = new Room(rs.getInt("id"), rs.getString("room_type"), rs.getFloat("price"));
            rooms.add(rm);
        }

        return rooms;
    }

    public List<Room> getRooms(final int limit, final int offset) {
        List<Room> rooms = new ArrayList<>();
        SqlRowSet rs= template.queryForRowSet(sql.sql_getAllRooms_Limit_Offset);
        while (rs.next()) {
            Room room = new Room();
            room.setId(rs.getInt("id"));
            room.setRoom_type(rs.getString("room_type"));
            room.setPrice(rs.getFloat("price"));
            rooms.add(room);
        }

        return rooms;
    }

    public Room getRoomById(final int id) {
        return template.queryForObject(sql.sql_getRoom_ById, BeanPropertyRowMapper.newInstance(Room.class), id);
    }

    public boolean deleteRoomById(final int id) {
        int roomDeleted = template.update(sql.sql_deleteRoom_ById, id);
        return roomDeleted > 0;
    }

    public boolean updateRoom(final int id, final Room room) {
        int roomUpdated = template.update(sql.sql_updateRoom_ById,room.getRoom_type(), room.getPrice(), id);
        return roomUpdated > 0;
    }
}
