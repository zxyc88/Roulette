package com.roulette.roulette.controller;

import com.roulette.roulette.model.Block;
import com.roulette.roulette.model.Colour;
import com.roulette.roulette.model.Table;
import com.roulette.roulette.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TableController {

    @Autowired
    private TableService tableService;


    @RequestMapping("/Table")
    public void listOfNumbers (Table table){
        System.out.println("Test: " + table.toString());
    }

    @RequestMapping(value="/add" , method = RequestMethod.POST)
    public @ResponseBody Table addNumber (@RequestBody Table table){
        tableService.addTable(table);
        return table;
    }

    @RequestMapping(value="/get", method = RequestMethod.GET)
    public @ResponseBody List<Table> printTable ()
    {
        return tableService.getTables();
    }
}