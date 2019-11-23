package com.roulette.roulette.service;

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

}
