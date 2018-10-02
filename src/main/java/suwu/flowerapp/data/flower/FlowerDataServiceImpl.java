package suwu.flowerapp.data.flower;

import org.springframework.beans.factory.annotation.Autowired;
import suwu.flowerapp.data.dao.flower.FlowerDao;
import suwu.flowerapp.data.dao.flower.FlowerTypeDao;
import suwu.flowerapp.dataservice.flower.FlowerDataService;
import suwu.flowerapp.entity.flower.Flower;
import suwu.flowerapp.entity.flower.FlowerType;
import suwu.flowerapp.exception.FlowerIdNotExistedException;
import suwu.flowerapp.exception.FlowerTypeDoesNotExistException;
import java.util.List;
import java.util.Optional;

public class FlowerDataServiceImpl implements FlowerDataService {
    private final FlowerDao flowerDao;
    private final FlowerTypeDao flowerTypeDao;

    @Autowired
    public FlowerDataServiceImpl(FlowerDao _flowerDao, FlowerTypeDao _flowerTypeDao){
        this.flowerDao = _flowerDao;
        this.flowerTypeDao = _flowerTypeDao;
    }

    /**
     * get flowers by flower id
     * @param typeId
     * @return
     * @throws FlowerTypeDoesNotExistException
     */
    @Override
    public List<Flower> getFlowersByTypeId(int typeId) throws FlowerTypeDoesNotExistException {
        Optional<FlowerType> optionalFlowerType = flowerTypeDao.findById(typeId);
        if (optionalFlowerType.isPresent()) {
            FlowerType flowerType = optionalFlowerType.get();
            return flowerType.getFlowers();
        }else{
            throw new FlowerTypeDoesNotExistException();
        }
    }

    /**
     * get flower by flower id
     * @param flowerId
     * @return
     * @throws FlowerIdNotExistedException
     */
    @Override
    public Flower getFlowerByFlowerId(int flowerId) throws FlowerIdNotExistedException {
       Optional<Flower> optionalFlower = flowerDao.findById(flowerId);
       if(optionalFlower.isPresent()){
           return optionalFlower.get();
       }else{
           throw new FlowerIdNotExistedException();
       }
    }

    /**
     * delete flower type by type id
     * @param id
     */
    @Override
    public void deleteFlowerType(int id){
     flowerTypeDao.deleteById(id);
    }

    /**
     * delete flower by flower id
     * @param flowerId
     */
    @Override
    public void deleteFlowerByFlowerId(int flowerId){
      flowerDao.deleteById(flowerId);
    }

    /**
     * save flower
     * @param flower
     * @return
     */
    @Override
    public Flower saveFlower(Flower flower) {
        return flowerDao.save(flower);
    }
}
