package com.example.superduperdrive.mapper;

import com.example.superduperdrive.model.Credential;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CredentialsMapper {

    @Select("SELECT * FROM credentials")
    List<Credential> findAll();

    @Select("SELECT * FROM credentials WHERE userId = #{userId}")
    List<Credential> findByUserId(Long userId);

    @Select("SELECT * FROM credentials WHERE credentialid = #{id}")
    Credential findById(Long id);

    @Insert("INSERT INTO credentials (url, username, key, password, userId) VALUES (#{credential.url}, #{credential.username}, #{credential.key}, #{credential.password}, #{userId})")
    Integer create(@Param("credential") Credential credential, Long userId);

    @Update("UPDATE credentials SET url = #{credential.url}, username = #{credential.username}, key = #{credential.key}, password = #{credential.password} WHERE credentialid = #{credential.credentialId} AND userId = #{userId}")
    Integer update(@Param("credential") Credential credential, Long userId);

    @Delete("DELETE FROM credentials WHERE credentialid = #{id} AND userId = #{userId}")
    Integer delete(Long id, Long userId);
}
