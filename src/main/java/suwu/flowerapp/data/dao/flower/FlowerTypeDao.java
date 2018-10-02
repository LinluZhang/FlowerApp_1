package suwu.flowerapp.data.dao.flower;

import org.springframework.data.jpa.repository.JpaRepository;
import suwu.flowerapp.entity.flower.FlowerType;

public interface FlowerTypeDao extends JpaRepository<FlowerType, Integer> {

}
