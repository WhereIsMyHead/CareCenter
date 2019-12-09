package com.czr.customer.mapper;

import com.czr.customer.model.FoodCustomer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component(value = "foodCustomerMapper")
public interface FoodCustomerMapper {
    int insert(FoodCustomer record);

//    Food selectByPrimaryKey(Integer id);

    List<FoodCustomer> selectAll();

    List<FoodCustomer> selectSpecify(FoodCustomer foodCustomer);

    void updateByPrimaryKey(FoodCustomer foodCustomer);

//    int updateByPrimaryKey(Food record);

    /**
     * 设置删除
     * @param foodCustomer
     */
    void delFoodCustomer(FoodCustomer foodCustomer);

    void delFoodCustomer1(FoodCustomer foodCustomer);
}
