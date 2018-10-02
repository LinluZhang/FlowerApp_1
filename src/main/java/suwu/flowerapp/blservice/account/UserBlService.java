package suwu.flowerapp.blservice.account;

import suwu.flowerapp.exception.*;
import suwu.flowerapp.response.user.AvatarSaveResponse;
import suwu.flowerapp.response.user.OpenIdAndSessionKeyResponse;
import suwu.flowerapp.response.user.PhoneNumberGetResponse;
import suwu.flowerapp.response.user.UserLoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserBlService {
    /**
     * login
     *
     * @param username the username of the user
     * @param password the password of the user
     * @return the login info to  response
     * @throws WrongUsernameOrPasswordException the username or password is error
     */
    UserLoginResponse login(String username, String password) throws WrongUsernameOrPasswordException, CannotRegisterException;

    /**
     * get user openid
     *
     * @param jsCode wechat js code
     * @return whether the operation is success or not
     */
    OpenIdAndSessionKeyResponse getOpenIdAndSessionKey(String jsCode) throws CannotGetOpenIdAndSessionKeyException;

    /**
     * register
     *
     * @param username
     * @param password
     * @return
     */
    UserLoginResponse register(String username, String password);

    /**
     * decrypt data
     *
     * @param encryptData
     * @param sessionKey
     * @param ivCode
     * @return
     */
    PhoneNumberGetResponse decryptData(String encryptData, String sessionKey, String ivCode) throws PhoneNumberGetWrongException;

    /**
     * save avatar to a user
     *
     * @param avatarUrl
     */
    AvatarSaveResponse saveAvatar(String username, String avatarUrl) throws UsernameDoesNotFoundException;
}
