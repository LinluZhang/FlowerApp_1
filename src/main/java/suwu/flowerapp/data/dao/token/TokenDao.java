package suwu.flowerapp.data.dao.token;

import org.springframework.data.jpa.repository.JpaRepository;
import suwu.flowerapp.entity.token.Token;

public interface TokenDao extends JpaRepository<Token, Integer> {

}
