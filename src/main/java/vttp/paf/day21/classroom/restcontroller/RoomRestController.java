package vttp.paf.day21.classroom.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vttp.paf.day21.classroom.model.Room;
import vttp.paf.day21.classroom.service.RoomService;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomRestController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return ResponseEntity.ok().body(rooms);
    }

    @GetMapping("/limit")
    public ResponseEntity<List<Room>> getRoomLimit(@RequestParam ("limit") int limit, @RequestParam ("offset") int offset) {
        List<Room> rooms = roomService.getRooms(limit, offset);
        return ResponseEntity.ok().body(rooms);
    }

    @GetMapping("/{room-id}")
    public ResponseEntity<Room> getRoomById(@PathVariable("room-id") int roomId) {
        Room room = roomService.getRoom(roomId);
        return ResponseEntity.ok().body(room);
    }

    @DeleteMapping("/{room-id}")
    public ResponseEntity<Boolean> deleteRoomById(@PathVariable("room-id") int roomId) {
        boolean roomDeleted = roomService.deleteRoom(roomId);
        return ResponseEntity.ok().body(roomDeleted);
    }

    @PutMapping("/{room-id}")
    public ResponseEntity<Boolean> updateRoom(@PathVariable("room-id") int roomId, @RequestBody Room room) {
        Room r = roomService.getRoom(roomId);
        boolean roomUpdated = roomService.updateRoom(roomId, room);
        if(r != null){
            return ResponseEntity.ok().body(roomUpdated);
        }
        return ResponseEntity.ok().body(roomUpdated);
    }

}
