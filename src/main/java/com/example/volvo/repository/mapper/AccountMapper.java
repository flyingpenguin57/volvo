package com.example.volvo.repository.mapper;

import com.example.volvo.repository.entities.Account;
import com.example.volvo.repository.entities.Card;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AccountMapper {

    @Insert("INSERT INTO accounts(email, username) VALUES(#{email}, #{username})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Account account);

    @Update("UPDATE accounts SET active=#{active} WHERE email=#{email}")
    int update(Account account);

    @Select("SELECT * FROM accounts where email=#{email}")
    Account selectByEmail(Account account);
}
