package com.roulette.roulette.service;

import com.roulette.roulette.model.Block;
import com.roulette.roulette.model.RouletteWheel;
import com.roulette.roulette.model.ViewData;
import com.roulette.roulette.repository.ViewDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {

    @Autowired
    ViewDataRepository viewDataRepository;

    private RouletteWheel rouletteWheel = new RouletteWheel();


    public List<Block> bestNumbers(List<ViewData> viewData){
        List<Block> numbers = new ArrayList<>();

        //LOGIC HERE
        //Given all INFO fully,

        return numbers;
    }

    public void addMathematics(ViewData viewData){
        //given start/end/dealer this should full out ALL other table values we want to store
    }
}
