package com.example.demo.mapper;

import com.example.demo.model.RandomKey;
import org.apache.ibatis.annotations.*;

@Mapper
public interface RandomKeyMapper {
	@Insert("INSERT INTO randomkeys (lecturecode, randomkey, used, createdat) VALUES (#{lectureCode}, #{randomKey}, true, NOW())")
    void insertRandomKey(@Param("lectureCode") String lectureCode, @Param("randomKey") String randomKey);

    @Select("SELECT * FROM randomkeys WHERE randomkeyid = #{randomKeyId}")
    RandomKey getRandomKeyById(Integer randomKeyId);

    @Update("UPDATE randomkeys SET used = #{used} WHERE randomkeyid = #{randomKeyId}")
    void updateRandomKeyUsedStatus(@Param("randomKeyId") Integer randomKeyId, @Param("used") Boolean used);

    @Delete("DELETE FROM randomkeys WHERE randomkeyid = #{randomKeyId}")
    void deleteRandomKey(Integer randomKeyId);
    
    @Select("SELECT * FROM randomkeys WHERE lecturecode = #{lectureCode}")
    RandomKey getLectureRk(@Param("lectureCode") String lectureCode);
}
