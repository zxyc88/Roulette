package com.roulette.roulette.service;

import com.roulette.roulette.model.*;
import com.roulette.roulette.repository.DealerRepository;
import com.roulette.roulette.repository.ViewDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableService {

    @Autowired
    DealerRepository dealerRepository;

    @Autowired
    ViewDataRepository viewDataRepository;

    @Autowired
    DataService dataService;

    private static List<ViewData> data = new ArrayList<>();

    public List<Block> viewNumber(ViewData viewData){
        List<Block> bestNumbers = new ArrayList<>();
        Dealer dealer = dealerRepository.findByName(viewData.getDealer().getName());
        List<ViewData> viewDatas = viewDataRepository.findByDealer(dealer);
        dataService.bestNumbers(viewDatas);
        return bestNumbers;
    }

    public void addData(ViewData viewdata)
    {
        Dealer dealer = dealerRepository.findByName(viewdata.getDealer().getName());
        if (dealer != null) {
            viewdata.setDealer(dealer);
            viewDataRepository.save(viewdata);
            dataService.addMathematics(viewdata);
        }
    }

    public List<Dealer> getDealers()
    {
        return dealerRepository.findAll();
    }

    public List<Dealer> addDealer(Dealer dealer){
        Dealer dealerInDb = dealerRepository.findByName(dealer.getName());
        if (dealerInDb == null){
            Dealer dealerToSave = new Dealer(dealer.getName());
            dealerRepository.save(dealerToSave);
        }
        return getDealers();
    }

}
