package suwu.flowerapp.data.dao.account;

import suwu.flowerapp.entity.account.User;
import org.springframework.data.jpa.repository.JpaRepository;
import suwu.flowerapp.entity.account.User;

public interface UserDao extends JpaRepository<User, String> {
    User findUserByUsername(String username);
}
