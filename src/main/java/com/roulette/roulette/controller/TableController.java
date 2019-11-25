package com.roulette.roulette.controller;

import com.roulette.roulette.model.Block;
import com.roulette.roulette.model.Dealer;
import com.roulette.roulette.model.Table;
import com.roulette.roulette.model.ViewData;
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

    @RequestMapping(value="/addData" , method = RequestMethod.POST)
    public @ResponseBody String addData (@RequestBody ViewData viewdata){
        tableService.addData(viewdata);
        return "cool";
    }

    @RequestMapping(value="/addDealer" , method = RequestMethod.POST)
    public @ResponseBody List<Dealer> addData (@RequestBody Dealer dealer){
        return tableService.addDealer(dealer);
    }


    @RequestMapping(value="/viewData", method = RequestMethod.GET)
    public @ResponseBody List<Block> viewData (@RequestBody ViewData viewdata){
        return tableService.viewNumber(viewdata);
    }

    @RequestMapping(value="/getDealers", method = RequestMethod.GET)
    public @ResponseBody List<Dealer> getDealers ()
    {
        return tableService.getDealers();
    }

}