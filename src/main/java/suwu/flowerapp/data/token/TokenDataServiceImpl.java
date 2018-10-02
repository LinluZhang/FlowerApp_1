package suwu.flowerapp.data.token;

import org.springframework.beans.factory.annotation.Autowired;
import suwu.flowerapp.data.dao.account.UserDao;
import suwu.flowerapp.data.dao.token.TokenDao;
import suwu.flowerapp.dataservice.token.TokenDataService;
import suwu.flowerapp.entity.account.User;
import suwu.flowerapp.entity.token.Token;
import suwu.flowerapp.exception.TokenIdDoesNotExistException;
import java.util.List;
import java.util.Optional;

public class TokenDataServiceImpl implements TokenDataService {
    private final UserDao userDao;
    private final TokenDao tokenDao;

    @Autowired
    public TokenDataServiceImpl(UserDao _userDao, TokenDao _tokenDao){
        this.userDao = _userDao;
        this.tokenDao = _tokenDao;
    }

    /**
     * load all tokens
     * @return
     */
    @Override
    public List<Token> getAllTokens() {
        return tokenDao.findAll();
    }

    /**
     * load someone's tokens
     * @param username
     * @return
     */
    @Override
    public List<Token> getTokenByUsername(String username) {
       User user = userDao.findUserByUsername(username);
       return user.getTokens();
    }

    /**
     * get token by token id
     * @param tokenId
     * @return
     * @throws TokenIdDoesNotExistException
     */
    @Override
    public Token getTokenByTokenId(int tokenId) throws TokenIdDoesNotExistException{
        Optional<Token> optionalToken = tokenDao.findById(tokenId);
        if (optionalToken.isPresent()) {
            return optionalToken.get();
        } else {
            throw new TokenIdDoesNotExistException();
        }
    }

    /**
     * save token
     * @param token
     * @return
     */
    @Override
    public Token saveToken(Token token) {
        return tokenDao.save(token);
    }

    /**
     * delete token
     * @param tokenId
     */
    @Override
    public void deleteToken(int tokenId) {
        tokenDao.deleteById(tokenId);
    }
}
