package com.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Constant.Constant;
import com.DTO.CinemaDTO;
import com.DTO.RoomDTO;
import com.DTO.Base.ResponseEntity;
import com.DTO.view.TotalByCinemaView;
import com.Entity.Cinema;
import com.Entity.Room;
import com.Services.CinemaService;
import com.Services.RoomService;

@RestController
@RequestMapping(value = "room")

public class RoomController {

	@Autowired
	private RoomService roomService;

	@GetMapping
	public ResponseEntity<List<Room>> index() {
		return ResponseEntity.body(roomService.getAll());
	}

	@GetMapping(value = "/getroombycinema")
	public ResponseEntity<Object> getRoomByCinema(Integer id){
		if(id==null) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			List<Room> listRoom = roomService.getRoomByCinema(id);
			return ResponseEntity.body(listRoom);
		}
	}

	@PostMapping(value = "/add")
	public ResponseEntity<Object> addRoom(@RequestBody RoomDTO roomDTO) {
		if (roomDTO.isNull(false)) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			// Make sure id is NULL to insert Entity
			roomDTO.setRoomID(null);
			Room room = roomDTO.convertToRoom();
			return ResponseEntity.body(roomService.add(room));
		}
	}

}
