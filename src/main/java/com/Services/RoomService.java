package com.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.Entity.Room;

@Service
public interface RoomService {
	/**
	 * Find all entity Room
	 * 
	 * @return List<Room>
	 */
	List<Room> getAll();

	/**
	 * Saves a entity Room
	 * 
	 * @return Room
	 */
	Room add(Room room);

	/**
	 * Search an entity Room by its id
	 * 
	 * @return the entity with the RoomId entered or Optional#empty() if none found.
	 */
	Optional<Room> findById(Integer id);

	/**
	 * Search list Room with the same name(roomName) entered
	 * 
	 * @return List<Room>
	 */
	List<Room> findByName(String name);

	/**
	 * Saves an entity and flushes changes instantly.
	 * 
	 * @return entity Room
	 */
	Room save(Room room);
	
	/**
	 * The function that search all the entity Room by entity Cinema's id.
	 * 
	 * @return entity Room
	 */
	List<Room> getRoomByCinema(Integer cinemaId);
	
}
