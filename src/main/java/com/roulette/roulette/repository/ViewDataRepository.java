package com.roulette.roulette.repository;

import com.roulette.roulette.model.Dealer;
import com.roulette.roulette.model.ViewData;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface ViewDataRepository extends CrudRepository<ViewData, Long> {

    List<ViewData> findByDealer(Dealer dealer);
    List<ViewData> findFirst10ById();
}

