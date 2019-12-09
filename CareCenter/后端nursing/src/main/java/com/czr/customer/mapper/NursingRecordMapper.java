package com.czr.customer.mapper;

import com.czr.customer.model.NursingRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "nursingRecordMapper")
public interface NursingRecordMapper {

    int insert(NursingRecord record);

    List<NursingRecord> selectAll();

    List<NursingRecord> selectSpecify(NursingRecord nursingRecord);

    void updateByPrimaryKey(NursingRecord nursingRecord);

//    int updateByPrimaryKey(Food record);

    /**
     * 设置删除
     * @param nursingRecord
     */
    void delNursingRecord(NursingRecord nursingRecord);
}
