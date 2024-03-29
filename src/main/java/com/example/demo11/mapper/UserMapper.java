package com.example.demo11.mapper;

import com.example.demo11.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    @Insert("INSERT INTO `community`.`user` (`name`, `account_id`, `token`, `gmt_create`, `gmt_modified`,`avatar_url`) " +
            "VALUES (#{name}, #{accountId}, #{token},#{gmtCreate},#{gmtModified},#{avatarUrl});")
    void insert(User user);

    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where account_id=#{accountId}")
    User findByAccountId(@Param("accountId") String accountId);

    @Select("select * from user where id=#{id}")
    User findById(@Param("id") int id);

    @Update("update user set name=#{name},token=#{token},gmt_modified=#{gmtModified},avatar_url=#{avatarUrl} where id = #{id}")
    void update(User dbUser);
}
