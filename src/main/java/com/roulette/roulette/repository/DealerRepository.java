package com.roulette.roulette.repository;

import com.roulette.roulette.model.Dealer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealerRepository extends CrudRepository<Dealer, Long> {

    Dealer findByName(String name);
    List<Dealer> findAll();

}
