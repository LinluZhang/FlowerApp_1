package suwu.flowerapp.springcontroller.token;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import suwu.flowerapp.blservice.token.TokenBlService;
import suwu.flowerapp.exception.TokenDoesNotExistException;
import suwu.flowerapp.exception.TokenIdDoesNotExistException;
import suwu.flowerapp.parameters.token.TokenBuyParameters;
import suwu.flowerapp.parameters.token.TokenConsumeParameters;
import suwu.flowerapp.response.Response;
import suwu.flowerapp.response.WrongResponse;
import suwu.flowerapp.response.token.TokenBuyResponse;
import suwu.flowerapp.response.token.TokenConsumeResponse;
import suwu.flowerapp.response.token.TokenLoadResponse;
import suwu.flowerapp.response.token.TokenSelfLoadResponse;
import suwu.flowerapp.util.UserInfoUtil;

@RestController
public class CustomerTokenController {
    private final TokenBlService tokenBlService;

    @Autowired
    public CustomerTokenController(TokenBlService _tokenBlService){
        this.tokenBlService = _tokenBlService;
    }

    @ApiOperation(value = "加载代金券", notes = "加载所有代金券")
    @RequestMapping(value = "token", method = RequestMethod.GET)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = TokenLoadResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = WrongResponse.class),
            @ApiResponse(code = 500, message = "Failure", response = WrongResponse.class)})
    @ResponseBody
    public ResponseEntity<Response> getTokens() {
        return new ResponseEntity<>(tokenBlService.loadTokens(), HttpStatus.OK);
    }

    @ApiOperation(value = "加载我的代金券", notes = "加载我的代金券")
    @RequestMapping(value = "token/self", method = RequestMethod.GET)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = TokenSelfLoadResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = WrongResponse.class),
            @ApiResponse(code = 500, message = "Failure", response = WrongResponse.class)})
    @ResponseBody
    public ResponseEntity<Response> getMyTokens() {
        return new ResponseEntity<>(tokenBlService.loadSelfToken(UserInfoUtil.getUsername()), HttpStatus.OK);
    }

    @ApiOperation(value = "购买代金券", notes = "积分购买代金券")
    @RequestMapping(value = "token/self/buy", method = RequestMethod.POST)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = TokenBuyResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = WrongResponse.class),
            @ApiResponse(code = 500, message = "Failure", response = WrongResponse.class)})
    @ResponseBody
    public ResponseEntity<Response> buyToken(@RequestBody TokenBuyParameters tokenBuyParameters) {
        try {
            return new ResponseEntity<>(tokenBlService.buyToken(tokenBuyParameters, UserInfoUtil.getUsername()), HttpStatus.OK);
        } catch (TokenIdDoesNotExistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getResponse(), HttpStatus.NOT_EXTENDED);
        }
    }

    @ApiOperation(value = "消费代金券", notes = "消费代金券")
    @RequestMapping(value = "token/self/consume", method = RequestMethod.DELETE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = TokenConsumeResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = WrongResponse.class),
            @ApiResponse(code = 500, message = "Failure", response = WrongResponse.class)})
    @ResponseBody
    public ResponseEntity<Response> useToken(@RequestBody TokenConsumeParameters tokenConsumeParameters) {
        try {
            return new ResponseEntity<>(tokenBlService.consumeToken(tokenConsumeParameters, UserInfoUtil.getUsername()), HttpStatus.OK);
        } catch (TokenDoesNotExistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getResponse(), HttpStatus.NOT_FOUND);
        } catch (TokenIdDoesNotExistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getResponse(), HttpStatus.NOT_EXTENDED);
        }
    }
}
