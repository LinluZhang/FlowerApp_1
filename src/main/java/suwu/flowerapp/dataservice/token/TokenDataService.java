package suwu.flowerapp.dataservice.token;

import suwu.flowerapp.entity.token.Token;
import suwu.flowerapp.exception.TokenIdDoesNotExistException;

import java.util.List;

public interface TokenDataService {
    /**
     * load all tokens
     * @return
     */
    List<Token> getAllTokens();

    /**
     * load someone's tokens
     * @param username
     * @return
     */
    List<Token> getTokenByUsername(String username);

    /**
     * get token by token id
     * @param tokenId
     * @return
     * @throws TokenIdDoesNotExistException
     */
    Token getTokenByTokenId(int tokenId) throws TokenIdDoesNotExistException;

    /**
     * save token
     * @param token
     * @return
     */
    Token saveToken(Token token);

    /**
     * delete token
     * @param tokenId
     */
    void deleteToken(int tokenId);
}
