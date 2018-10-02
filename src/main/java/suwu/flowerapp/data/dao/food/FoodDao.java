package suwu.flowerapp.data.dao.food;

import suwu.flowerapp.entity.food.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import suwu.flowerapp.entity.food.Food;

import java.util.List;

public interface FoodDao extends JpaRepository<Food, Integer> {
    List<Food> findFoodsByUserUsername(String username);
}
