package suwu.flowerapp.data.flower;

import suwu.flowerapp.data.dao.flower.FlowerDao;
import suwu.flowerapp.data.dao.flower.FlowerTypeDao;
import suwu.flowerapp.dataservice.flower.FlowerTypeDataService;
import suwu.flowerapp.entity.flower.FlowerType;
import suwu.flowerapp.publicdatas.flower.FlowerTypeState;
import java.util.ArrayList;
import java.util.List;

public class FlowerTypeDataServiceImpl implements FlowerTypeDataService {
    private final FlowerDao flowerDao;
    private final FlowerTypeDao flowerTypeDao;

    public FlowerTypeDataServiceImpl(FlowerDao _flowerDao, FlowerTypeDao _flowerTypeDao) {
        this.flowerDao = _flowerDao;
        this.flowerTypeDao = _flowerTypeDao;
    }

    /**
     * get all flower types.
     *
     * @return
     */
    @Override
    public List<FlowerType> getAllFlowerTypes() {
        return flowerTypeDao.findAll();
    }

    /**
     * add flower type
     *
     * @param name
     * @return
     */
    @Override
    public FlowerType addType(String name) {
        return flowerTypeDao.save(new FlowerType(name, FlowerTypeState.ACTIVE, new ArrayList<>()));
    }

    /**
     * save flower type
     *
     * @param flowerType
     * @return
     */
    @Override
    public FlowerType saveFlowerType(FlowerType flowerType) {
        return flowerTypeDao.save(flowerType);
    }

    /**
     * get flower type by flower type id
     *
     * @param flowerId
     * @return
     */
    @Override
    public FlowerType getFlowerTypeByFlowerId(int flowerId){
        return flowerDao.findFlowerTypeById(flowerId);
    }

}
