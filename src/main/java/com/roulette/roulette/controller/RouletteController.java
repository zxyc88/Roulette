package com.roulette.roulette.controller;

import com.roulette.roulette.model.Block;
import com.roulette.roulette.model.Dealer;
import com.roulette.roulette.model.Information;
import com.roulette.roulette.model.ViewData;
import com.roulette.roulette.service.RouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.View;
import java.util.List;

@Controller
public class RouletteController {

    @Autowired
    private RouletteService rouletteService;

    @RequestMapping(value="/addData" , method = RequestMethod.POST)
    public @ResponseBody boolean addData (@RequestBody ViewData viewdata){
        //Check if Start/End are Numbers between 0 and 37
        return rouletteService.addData(viewdata);
    }

    @RequestMapping(value="/getData", method = RequestMethod.GET)
    public @ResponseBody Information getData(@RequestParam String dealer,  @RequestParam int start){
        //Check if Start Number is between 0 and 37
        return rouletteService.getData(dealer,start);
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