package com.example.demo.repository;

import com.example.demo.entity.Coin;

import java.util.Collection;
import java.util.List;

/**
 * @author meow
 */
public interface CoinRepo extends BaseRepo<Coin, String>{

    List<Coin> findByCodeIn(Collection<String> codeList);
}
