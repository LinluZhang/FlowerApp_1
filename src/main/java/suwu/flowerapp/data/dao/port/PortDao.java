package suwu.flowerapp.data.dao.port;

import suwu.flowerapp.entity.port.Port;
import org.springframework.data.jpa.repository.JpaRepository;
import suwu.flowerapp.entity.port.Port;

public interface PortDao extends JpaRepository<Port, Integer> {
    Port findPortByName(String name);
}
