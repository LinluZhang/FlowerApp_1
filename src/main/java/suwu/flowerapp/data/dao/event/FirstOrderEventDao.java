package suwu.flowerapp.data.dao.event;

import suwu.flowerapp.entity.event.FirstOrderEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import suwu.flowerapp.entity.event.FirstOrderEvent;

public interface FirstOrderEventDao extends JpaRepository<FirstOrderEvent, String> {
}
