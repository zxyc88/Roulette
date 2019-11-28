package com.roulette.roulette.service;

import com.roulette.roulette.model.*;
import com.roulette.roulette.repository.ViewDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

@Service
public class DataService{

    @Autowired
    ViewDataRepository viewDataRepository;

    private RouletteWheel rouletteWheel = new RouletteWheel();


    public Information bestNumbers(ViewData viewData){
        //This is being passed ALL the data for ONE dealer and request the best numbers as a List
        Information information = new Information();

        String dealerName = viewData.getDealer().getName();
        double delta = viewData.getDelta();
        double deltaSD = viewData.getSdDelta();
        int deltaSDInt = (int)ceil(deltaSD);
        int startAt = viewData.getStartAt();
        int startAtIndex = rouletteWheel.getWheelIndex(startAt);
        int deltaInt = (int) delta;

        List<Integer> bestNumbers = new ArrayList<>();
        for (int i = (startAtIndex + deltaInt - deltaSDInt); i < ((2*deltaInt)+1);i++){
            bestNumbers.add(rouletteWheel.getWheelNumber(i));
        }
        information.setDealerName(dealerName);
        information.setDelta(deltaInt);
        information.setDeltaSD(deltaSDInt);
        information.setBestNumbers(bestNumbers);
        return information;
    }

    public void addMathematics(ViewData viewData){
        //This is being passed the Data (start, finish, dealer being added)
        //given start/end/dealer this should full out ALL other table values we want to store
        Integer startIndex = rouletteWheel.getWheelIndex(viewData.getStartAt());
        Integer endingIndex = rouletteWheel.getWheelIndex(viewData.getFinishAt());
        Double delta;
        String deltaDirection;
        if (endingIndex > startIndex)
        {
            delta = (double)(endingIndex - startIndex);
            deltaDirection = "Right";
        }
        else
        {
            delta = (double)(startIndex - endingIndex);
            deltaDirection = "Left";
        }
        viewData.setDelta(delta);
        viewData.setDirection(deltaDirection);

        viewDataRepository.save(viewData);
        List<ViewData> dataForDealer = viewDataRepository.findByDealer(viewData.getDealer());
        Double sdDelta = getSDDelta(dataForDealer);
        viewData.setSdDelta(sdDelta);
        viewDataRepository.save(viewData);
    }

    private double getSDDelta(List<ViewData> viewData){
        int count = 0;
        List<Double> delta = new ArrayList<>();
        double deltaSum = 0;
        double sdDelta;

        for (int i = viewData.size()-1; i > 0 ; i--)
        {
            int j = 0;
            delta.add(viewData.get(i).getDelta());
            deltaSum = deltaSum + delta.get(j);
            count++;
            j++;
            if (count == 10)
            {
                break;
            }
        }

        double runningTotal = 0;

        for (int i = 0; i < delta.size(); i++) {
            runningTotal = delta.get(i) - (deltaSum/count);
        }

        sdDelta = sqrt(runningTotal / (count - 1));
        return sdDelta;
    }
}
