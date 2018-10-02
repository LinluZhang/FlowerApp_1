package suwu.flowerapp.data.dao.order;

import suwu.flowerapp.entity.order.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import suwu.flowerapp.entity.order.Comment;

public interface CommentDao extends JpaRepository<Comment, Integer> {
    int countAllByFoodIdsContains(int foodId);
}
