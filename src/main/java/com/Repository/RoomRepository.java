
package com.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
	
	@Query(value = "FROM Room r WHERE r.roomName LIKE %:name% ")
	List<Room> findByRoomName(String name);
	
	@Query(value ="FROM Room r WHERE r.cinema.cinemaId = :cinemaId ")
	List<Room> getRoomByCinema(Integer cinemaId);
	
}



