package suwu.flowerapp.data.dao.flower;

import org.springframework.data.jpa.repository.JpaRepository;
import suwu.flowerapp.entity.flower.Flower;
import suwu.flowerapp.entity.flower.FlowerType;

public interface FlowerDao extends JpaRepository<Flower, Integer> {

    FlowerType findFlowerTypeById(int flowerId);
}
