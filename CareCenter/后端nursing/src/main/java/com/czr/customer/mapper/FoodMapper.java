package com.czr.customer.mapper;

import com.czr.customer.model.Food;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "foodMapper")
public interface FoodMapper {
//    int deleteByPrimaryKey(Integer id);

    int insert(Food record);

//    Food selectByPrimaryKey(Integer id);

    List<Food> selectAll();

    List<Food> selectSpecify(Food food);

    void updateByPrimaryKey(Food food);

//    int updateByPrimaryKey(Food record);

    /**
     * 设置删除
     * @param food
     */
    void delFood(Food food);
}