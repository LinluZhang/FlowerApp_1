package suwu.flowerapp.bl.token;

import suwu.flowerapp.blservice.token.TokenBlService;
import suwu.flowerapp.dataservice.account.UserDataService;
import suwu.flowerapp.dataservice.token.TokenDataService;
import suwu.flowerapp.entity.account.User;
import suwu.flowerapp.entity.token.Token;
import suwu.flowerapp.exception.TokenDoesNotExistException;
import suwu.flowerapp.exception.TokenIdDoesNotExistException;
import suwu.flowerapp.parameters.token.TokenAddParameters;
import suwu.flowerapp.parameters.token.TokenBuyParameters;
import suwu.flowerapp.parameters.token.TokenConsumeParameters;
import suwu.flowerapp.publicdatas.token.TokenState;
import suwu.flowerapp.response.token.*;
import java.util.ArrayList;
import java.util.List;

public class TokenBlServiceImpl implements TokenBlService {
    private final TokenDataService tokenDataService;
    private final UserDataService userDataService;

    public TokenBlServiceImpl(TokenDataService _tokenDataService, UserDataService _userDataService){
        this.tokenDataService = _tokenDataService;
        this.userDataService = _userDataService;
    }

    /**
     * load all tokens
     * @return
     */
    @Override
    public TokenLoadResponse loadTokens() {
        List<Token> tokens = tokenDataService.getAllTokens();
        List<SimpleTokenItem> simpleTokenItems = tokens.stream().filter((token) -> token.getTokenState() == TokenState.ACTIVE).collect(ArrayList::new, (list, token) -> list.add(new SimpleTokenItem(token.getId(), token.getPrice(), token.getStartDate(), token.getEndDate())), ArrayList::addAll);
        return new TokenLoadResponse(simpleTokenItems);
    }

    /**
     * load someone's tokens
     * @param username
     * @return
     */
    @Override
    public TokenSelfLoadResponse loadSelfToken(String username) {
        List<Token> tokens = tokenDataService.getTokenByUsername(username);
        List<TokenItem> tokenItems = tokens.stream().collect(ArrayList::new, (list, token) -> list.add(new TokenItem(token.getId(), token.getCredits(), token.getMinLimit(), token.getPrice(), token.getStartDate(), token.getEndDate())), ArrayList::addAll);
        return new TokenSelfLoadResponse(tokenItems);
    }

    /**
     * buy token
     * @param tokenBuyParameters
     * @param username
     * @return
     * @throws TokenIdDoesNotExistException
     */
    @Override
    public TokenBuyResponse buyToken(TokenBuyParameters tokenBuyParameters, String username) throws TokenIdDoesNotExistException {
        User user =userDataService.getUserByUsername(username);
        List<Token> tokens = user.getTokens();
        tokens.add(tokenDataService.getTokenByTokenId(tokenBuyParameters.getTokenId()));
        return new TokenBuyResponse("success");
    }

    /**
     * consume token
     * @param tokenConsumeParameters
     * @param username
     * @return
     * @throws TokenDoesNotExistException
     * @throws TokenIdDoesNotExistException
     */
    @Override
    public TokenConsumeResponse consumeToken(TokenConsumeParameters tokenConsumeParameters, String username) throws TokenDoesNotExistException, TokenIdDoesNotExistException {
        User user = userDataService.getUserByUsername(username);
        List<Token> tokens = user.getTokens();
        if(tokens.contains(tokenDataService.getTokenByTokenId(tokenConsumeParameters.getTokenId()))){
            tokens.remove(tokenDataService.getTokenByTokenId(tokenConsumeParameters.getTokenId()));
            return new TokenConsumeResponse(tokenConsumeParameters.getTokenId());
        }else{
            throw new TokenDoesNotExistException();
        }
    }

    /**
     * add token
     * @param tokenAddParameters
     * @return
     */
    @Override
    public TokenAddResponse addToken(TokenAddParameters tokenAddParameters) {
        Token token = tokenDataService.saveToken(new Token(TokenState.INACTIVE, tokenAddParameters.getCredits(), tokenAddParameters.getMinLimit(), tokenAddParameters.getPrice(), tokenAddParameters.getStartDate(), tokenAddParameters.getEndDate()));
        return new TokenAddResponse(token.getId());
    }

    /**
     * delete token
     * @param tokenId
     * @return
     */
    @Override
    public TokenDeleteResponse deleteToken(int tokenId) {
        tokenDataService.deleteToken(tokenId);
        return new TokenDeleteResponse(tokenId);
    }
}
