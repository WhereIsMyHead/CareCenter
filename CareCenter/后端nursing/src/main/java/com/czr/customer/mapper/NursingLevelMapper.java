package com.czr.customer.mapper;

import com.czr.customer.model.NursingLevel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "nursingLevelMapper")
public interface NursingLevelMapper {

    int insert(NursingLevel record);

    List<NursingLevel> selectAll();

    List<NursingLevel> selectSpecify(NursingLevel nursingLevel);

    void updateByPrimaryKey(NursingLevel nursingLevel);

//    int updateByPrimaryKey(Food record);

    /**
     * 设置删除
     * @param nursingLevel
     */
    void delNursingLevel(NursingLevel nursingLevel);
}
