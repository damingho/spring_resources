package com.microvideo.springboot_resource_analysis.mapper;

import com.microvideo.springboot_resource_analysis.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * @Description: TODO
 * @Author: Hujm
 * @Date: Created in 13:42 2020/6/8
 * @Version: 1.0
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user(id,username,age) values(#{id}, #{username},#{age})")
    int addUser(User user);

    @Update("update user set age = #{age} where id = 1")
    void updateUser(User user);
}
