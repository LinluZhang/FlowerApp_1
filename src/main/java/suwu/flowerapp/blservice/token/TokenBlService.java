package suwu.flowerapp.blservice.token;

import suwu.flowerapp.exception.TokenDoesNotExistException;
import suwu.flowerapp.exception.TokenIdDoesNotExistException;
import suwu.flowerapp.parameters.token.TokenAddParameters;
import suwu.flowerapp.parameters.token.TokenBuyParameters;
import suwu.flowerapp.parameters.token.TokenConsumeParameters;
import suwu.flowerapp.response.token.*;

public interface TokenBlService {
    /**
     * load all tokens
     * @return
     */
    TokenLoadResponse loadTokens();

    /**
     * load someone's tokens
     * @param username
     * @return
     */
    TokenSelfLoadResponse loadSelfToken(String username);

    /**
     * buy tokens
     * @param tokenBuyParameters
     * @param username
     * @return
     * @throws TokenDoesNotExistException
     */
    TokenBuyResponse buyToken(TokenBuyParameters tokenBuyParameters, String username) throws TokenIdDoesNotExistException;

    /**
     * consume someone's token
     * @param tokenConsumeParameters
     * @param username
     * @return
     * @throws TokenDoesNotExistException
     * @throws TokenIdDoesNotExistException
     */
    TokenConsumeResponse consumeToken(TokenConsumeParameters tokenConsumeParameters, String username) throws TokenDoesNotExistException, TokenIdDoesNotExistException;

    /**
     * add token
     * @param tokenAddParameters
     * @return
     */
    TokenAddResponse addToken(TokenAddParameters tokenAddParameters);

    /**
     * delete token
     * @param tokenId
     * @return
     * @throws TokenDoesNotExistException
     */
    TokenDeleteResponse deleteToken(int tokenId);
}
