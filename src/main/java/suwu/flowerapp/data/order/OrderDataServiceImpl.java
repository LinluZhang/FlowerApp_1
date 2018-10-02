package suwu.flowerapp.data.order;

import suwu.flowerapp.data.dao.order.CommentDao;
import suwu.flowerapp.data.dao.order.OrderDao;
import suwu.flowerapp.dataservice.order.OrderDataService;
import suwu.flowerapp.entity.order.Comment;
import suwu.flowerapp.entity.order.Order;
import suwu.flowerapp.exception.OrderIdDoesNotExistException;
import suwu.flowerapp.publicdatas.order.OrderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import suwu.flowerapp.dataservice.order.OrderDataService;
import suwu.flowerapp.entity.order.Comment;
import suwu.flowerapp.entity.order.Order;
import suwu.flowerapp.exception.OrderIdDoesNotExistException;
import suwu.flowerapp.publicdatas.order.OrderState;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDataServiceImpl implements OrderDataService {
    private final OrderDao orderDao;
    private final CommentDao commentDao;

    @Autowired
    public OrderDataServiceImpl(OrderDao orderDao, CommentDao commentDao) {
        this.orderDao = orderDao;
        this.commentDao = commentDao;
    }

    /**
     * save order
     *
     * @param order
     */
    @Override
    public Order saveOrder(Order order) {
        return orderDao.save(order);
    }

    /**
     * delete order
     *
     * @param orderId
     */
    @Override
    public void deleteOrder(int orderId) {
        orderDao.deleteById(orderId);
    }

    /**
     * get order list through user username
     *
     * @param username
     * @return
     */
    @Override
    public List<Order> getNotDeletedOrdersByUsername(String username) {
        return orderDao.findOrdersByUserUsernameAndOrderStateIsNot(username, OrderState.DELETED);
    }

    /**
     * get all orders
     *
     * @return
     */
    @Override
    public List<Order> getAllOrders() {
        return orderDao.findOrdersByOrderStateIsNot(OrderState.DELETED);
    }

    /**
     * get order by its id
     *
     * @param orderId
     * @return
     */
    @Override
    public Order getOrderByOrderId(int orderId) throws OrderIdDoesNotExistException {
        Optional<Order> optionalOrder = orderDao.findById(orderId);
        if (optionalOrder.isPresent()) {
            return optionalOrder.get();
        } else {
            throw new OrderIdDoesNotExistException();
        }
    }

    /**
     * update order
     *
     * @param order
     */
    @Override
    public void updateOrder(Order order) {
        orderDao.save(order);
    }

    /**
     * confirm if the user has order a food before
     *
     * @param foodId
     * @param username
     * @return
     */
    @Override
    public boolean hasOrderedTheFoodBefore(int foodId, String username) {
        List<Order> orders = orderDao.findOrdersByUserUsername(username);
        return orders.stream().anyMatch(order -> order.getFoods().stream().anyMatch(orderFood -> orderFood.getId() == foodId));
    }

    /**
     * save a comment
     *
     * @param comment
     */
    @Override
    public void saveComment(Comment comment) {
        commentDao.save(comment);
    }

    /**
     * @return
     */
    @Override
    public List<Comment> loadAllComments() {
        return commentDao.findAll();
    }

    /**
     * @param foodId
     * @return
     */
    @Override
    public int getAmountOfLikePeople(int foodId) {
        return commentDao.countAllByFoodIdsContains(foodId);
    }
}
