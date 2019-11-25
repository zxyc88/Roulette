package com.roulette.roulette.controller;

import com.roulette.roulette.model.Block;
import com.roulette.roulette.model.Dealer;
import com.roulette.roulette.model.ViewData;
import com.roulette.roulette.service.RouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RouletteController {

    @Autowired
    private RouletteService rouletteService;

    @RequestMapping(value="/addData" , method = RequestMethod.POST)
    public @ResponseBody boolean addData (@RequestBody ViewData viewdata){
        return rouletteService.addData(viewdata);
    }

    @RequestMapping(value="/getData", method = RequestMethod.GET)
    public @ResponseBody List<Block> getData(@RequestParam String dealer,  @RequestParam int start){
        ViewData viewData = new ViewData();
        viewData.setDealer(new Dealer(dealer));
        viewData.setStartAt(start);
        return rouletteService.getData(viewData);
    }

    @RequestMapping(value="/addDealer" , method = RequestMethod.POST)
    public @ResponseBody List<Dealer> addData (@RequestBody Dealer dealer){
        return rouletteService.addDealer(dealer);
    }

    @RequestMapping(value="/getDealers", method = RequestMethod.GET)
    public @ResponseBody List<Dealer> getDealers ()
    {
        return rouletteService.getDealers();
    }

}