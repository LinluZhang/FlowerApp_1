package suwu.flowerapp.data.dao.event;

import suwu.flowerapp.entity.event.FullSubtractionEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import suwu.flowerapp.entity.event.FullSubtractionEvent;

public interface FullSubtractionEventDao extends JpaRepository<FullSubtractionEvent, String> {
}
