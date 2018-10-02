package suwu.flowerapp.data.dao.order;

import suwu.flowerapp.entity.order.Order;
import suwu.flowerapp.publicdatas.order.OrderState;
import org.springframework.data.jpa.repository.JpaRepository;
import suwu.flowerapp.entity.order.Order;
import suwu.flowerapp.publicdatas.order.OrderState;

import java.util.List;

public interface OrderDao extends JpaRepository<Order, Integer> {
    List<Order> findOrdersByUserUsernameAndOrderStateIsNot(String username, OrderState orderState);

    List<Order> findOrdersByOrderStateIsNot(OrderState orderState);

    List<Order> findOrdersByUserUsername(String username);
}
