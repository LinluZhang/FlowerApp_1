package suwu.flowerapp.blservice.upload;

import suwu.flowerapp.exception.FoodIdDoesNotExistException;
import suwu.flowerapp.exception.SystemException;
import suwu.flowerapp.response.upload.UploadImageResponse;
import org.springframework.web.multipart.MultipartFile;
import suwu.flowerapp.exception.FoodIdDoesNotExistException;
import suwu.flowerapp.exception.SystemException;

public interface ImageUploadBlService {
    /**
     * Upload the image of the food
     *
     * @param foodId
     * @param multipartFile
     * @return the url of the image
     */
    UploadImageResponse uploadFiles(int foodId, MultipartFile multipartFile) throws SystemException, FoodIdDoesNotExistException;
}
