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
import suwu.flowerapp.parameters.token.TokenAddParameters;
import suwu.flowerapp.response.Response;
import suwu.flowerapp.response.WrongResponse;
import suwu.flowerapp.response.token.TokenAddResponse;
import suwu.flowerapp.response.token.TokenDeleteResponse;

@RestController
public class SupplierTokenController {
    private final TokenBlService tokenBlService;

    @Autowired
    public SupplierTokenController(TokenBlService _tokenBlService){
        this.tokenBlService = _tokenBlService;
    }

    @ApiOperation(value = "增加代金券", notes = "增加代金券")
    @RequestMapping(value = "token/addToken", method = RequestMethod.POST)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = TokenAddResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = WrongResponse.class),
            @ApiResponse(code = 500, message = "Failure", response = WrongResponse.class)})
    @ResponseBody
    public ResponseEntity<Response> postToken(@RequestBody TokenAddParameters tokenAddParameters) {
        return new ResponseEntity<>(tokenBlService.addToken(tokenAddParameters), HttpStatus.CREATED);
    }

    @ApiOperation(value = "删除代金券", notes = "删除代金券")
    @RequestMapping(value = "token/deleteToken/{tokenId}", method = RequestMethod.DELETE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = TokenDeleteResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = WrongResponse.class),
            @ApiResponse(code = 500, message = "Failure", response = WrongResponse.class)})

    @ResponseBody
    public ResponseEntity<Response> deleteToken(@PathVariable(name = "tokenId") int tokenId) {
        return new ResponseEntity<>(tokenBlService.deleteToken(tokenId), HttpStatus.OK);
    }
}
