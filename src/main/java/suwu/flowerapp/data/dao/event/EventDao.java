package suwu.flowerapp.data.dao.event;

import suwu.flowerapp.entity.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import suwu.flowerapp.entity.event.Event;

public interface EventDao extends JpaRepository<Event, Integer> {
}
