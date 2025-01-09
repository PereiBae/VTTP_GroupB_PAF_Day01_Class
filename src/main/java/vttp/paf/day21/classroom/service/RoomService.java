package vttp.paf.day21.classroom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vttp.paf.day21.classroom.model.Room;
import vttp.paf.day21.classroom.repository.RoomRepository;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepo;

    public List<Room> getAllRooms() {
        return roomRepo.getAllRooms();
    }

    public List<Room> getRooms(int limit, int offset) {
        return roomRepo.getRooms(limit, offset);
    }

    public Room getRoom(int id) {
        return roomRepo.getRoomById(id);
    }

    public boolean deleteRoom(int id) {
        return roomRepo.deleteRoomById(id);
    }

    public boolean updateRoom(int id, Room room) {
        return roomRepo.updateRoom(id, room);
    }

}
