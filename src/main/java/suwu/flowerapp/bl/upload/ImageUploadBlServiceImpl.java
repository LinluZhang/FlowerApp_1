package suwu.flowerapp.bl.upload;

import suwu.flowerapp.blservice.upload.ImageUploadBlService;
import suwu.flowerapp.dataservice.food.FoodDataService;
import suwu.flowerapp.dataservice.upload.ImageDataService;
import suwu.flowerapp.entity.food.Food;
import suwu.flowerapp.exception.FoodIdDoesNotExistException;
import suwu.flowerapp.exception.SystemException;
import suwu.flowerapp.response.upload.UploadImageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import suwu.flowerapp.blservice.upload.ImageUploadBlService;
import suwu.flowerapp.dataservice.food.FoodDataService;
import suwu.flowerapp.dataservice.upload.ImageDataService;
import suwu.flowerapp.entity.food.Food;
import suwu.flowerapp.exception.FoodIdDoesNotExistException;
import suwu.flowerapp.exception.SystemException;
import suwu.flowerapp.response.upload.UploadImageResponse;

import java.io.IOException;


@Service
public class ImageUploadBlServiceImpl implements ImageUploadBlService {

    private final ImageDataService imageDataService;
    private final FoodDataService foodDataService;

    @Autowired
    public ImageUploadBlServiceImpl(ImageDataService imageDataService, FoodDataService foodDataService) {
        this.imageDataService = imageDataService;
        this.foodDataService = foodDataService;
    }

    /**
     * Upload the image of the mission
     *
     * @param foodId
     * @param multipartFile
     * @return the url of the image
     */
    @Override
    public UploadImageResponse uploadFiles(int foodId, MultipartFile multipartFile) throws SystemException, FoodIdDoesNotExistException {
        try {
            Food food = foodDataService.getFoodById(foodId);
            if (food != null) {
                String url = imageDataService.uploadImage(generateImageKey(foodId), multipartFile.getBytes());
                food.setUrl(url);
                foodDataService.saveFood(food);
                return new UploadImageResponse(url);
            } else {
                throw new FoodIdDoesNotExistException();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new SystemException();
        }
    }

    private String generateImageKey(int foodId) {
        return "food_" + foodId;
    }
}
