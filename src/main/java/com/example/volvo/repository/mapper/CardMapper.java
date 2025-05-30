package com.example.volvo.repository.mapper;

import com.example.volvo.repository.entities.Card;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CardMapper {

    @Insert("INSERT INTO cards(contract_id, card_number) VALUES(#{contractId}, #{cardNumber})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Card card);

    @Update("UPDATE cards SET contract_id=#{contractId} WHERE card_number=#{cardNumber}")
    int updateContractId(Card card);

    @Update("UPDATE cards SET active=#{active} WHERE card_number=#{cardNumber}")
    int updateStatus(Card card);

    @Select("SELECT * FROM cards where contract_id=#{contractId} order by update_timestamp")
    List<Card> selectByContractId(Card card);
}
