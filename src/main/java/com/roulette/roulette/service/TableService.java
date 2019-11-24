package com.roulette.roulette.service;

import com.roulette.roulette.model.*;
import com.roulette.roulette.repository.DealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableService {

//    @Autowired
//    DealerRepository dealerRepository;

    private static List<ViewData> data = new ArrayList<>();
    private RouletteWheel rouletteWheel = new RouletteWheel();

    public List<Block> viewNumber(Block block, Dealer dealer){
        List<Block> bestNumbers = new ArrayList<>();
        //call database and get me list of dealerData for this dealer
        List<DealerData> dataRows = new ArrayList<>();
        for (DealerData dealerData : dataRows){
            dealerData.getStart();
            dealerData.getEnd();
            //do your logic shit - find delta average and apply it to block, return that list
        }
        return bestNumbers;
    }

    public List<ViewData> addData(ViewData viewdata)
    {
        data.add(viewdata);
        return data;
    }

    public List<Dealer> getDealers()
    {
//        return dealerRepository.findAll();
        return new ArrayList<>();
    }

    public List<Dealer> addDealer(Dealer dealer){
//        Dealer dealerInDb = dealerRepository.findByName(dealer.getName());
//        if (dealerInDb == null){
//            Dealer dealerToSave = new Dealer(dealer.getName());
//            dealerRepository.save(dealerToSave);
//        }
//        return getDealers();
        return new ArrayList<>();
    }

}
