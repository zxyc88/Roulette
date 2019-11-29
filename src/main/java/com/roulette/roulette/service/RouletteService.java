package com.roulette.roulette.service;

import com.roulette.roulette.model.*;
import com.roulette.roulette.repository.DealerRepository;
import com.roulette.roulette.repository.ViewDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouletteService {

    @Autowired
    DealerRepository dealerRepository;

    @Autowired
    ViewDataRepository viewDataRepository;

    @Autowired
    DataService dataService;

    public Information getData(String dealerName, int start){
        return dataService.bestNumbers(dealerName,start);
    }

    public boolean addData(ViewData viewdata)
    {
        Dealer dealer = dealerRepository.findByName(viewdata.getDealer().getName());
        if (dealer != null) {
            viewdata.setDealer(dealer);
            ViewData viewData = viewDataRepository.save(viewdata);
            if (viewData == null){
                return false;
            }
            dataService.addMathematics(viewdata);
            return true;
        }
        return false;
    }

    public List<Dealer> getDealers(){
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

    public List<Dealer> deleteDealer(Dealer dealer){
        Dealer dealerInDb = dealerRepository.findByName(dealer.getName());
        if (dealerInDb != null){
            dealerRepository.delete(dealerInDb);
        }
        return getDealers();
    }

}
