package com.czr.customer.mapper;

import com.czr.customer.model.NursingContent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "nursingContentMapper")
public interface NursingContentMapper {

    int insert(NursingContent record);

    List<NursingContent> selectAll();

    List<NursingContent> selectSpecify(NursingContent nursingContent);

    void updateByPrimaryKey(NursingContent nursingContent);

//    int updateByPrimaryKey(Food record);

    /**
     * 设置删除
     * @param nursingContent
     */
    void delNursingContent(NursingContent nursingContent);
}
