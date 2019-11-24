package com.roulette.roulette.service;

import com.roulette.roulette.model.Block;
import com.roulette.roulette.model.Dealer;
import com.roulette.roulette.model.DealerData;
import com.roulette.roulette.model.Table;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableService {

    private static List<Table> tables = new ArrayList<>();

    public void addTable(Table table)
    {
        tables.add(table);
    }

    public List<Table> getTables(){
        return tables;
    }

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


}
