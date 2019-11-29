package com.roulette.roulette.service;

import com.roulette.roulette.model.*;
import com.roulette.roulette.repository.DealerRepository;
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
    @Autowired
    DealerRepository dealerRepository;

    private RouletteWheel rouletteWheel = new RouletteWheel();


    public Information bestNumbers(String dealerName, int start){
        Information information = new Information();
        Dealer dealer = dealerRepository.findByName(dealerName);
        if (dealer == null) {
            return information;
        }

        List<ViewData> viewData = viewDataRepository.findByDealer(dealer);
        information = getInformation(viewData);

        int startIndex = rouletteWheel.getWheelIndex(start);

        List<Integer> bestNumbers = new ArrayList<>();
        int startingIndex = (startIndex + information.getAvgDelta() - information.getDeltaSD());
        int endingIndex = startingIndex + (((2*information.getDeltaSD())+1));

        for (int i = startingIndex; i < endingIndex; i++){
            bestNumbers.add(rouletteWheel.getWheelNumber(i % 37));
        }
        information.setDealerName(dealerName);
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

        if (endingIndex >= startIndex && endingIndex != null)
        {
            delta = (double)(endingIndex - startIndex);
            deltaDirection = "Right";
        }
        else if (endingIndex != null)
        {
            delta = (double)((endingIndex - startIndex)+rouletteWheel.getWheelSize());
            deltaDirection = "Right";
            //The LeftDirection would be
            //delta = (double)(startIndex - endingIndex)
        }
        else {
            delta = null;
            deltaDirection = "Null";
        }
        viewData.setDelta(delta);
        viewData.setDirection(deltaDirection);

        viewDataRepository.save(viewData);
        List<ViewData> dataForDealer = viewDataRepository.findByDealer(viewData.getDealer());
        Double sdDelta = (double) getInformation(dataForDealer).getDeltaSD();
        viewData.setSdDelta(sdDelta);
        viewDataRepository.save(viewData);
    }

    private Information getInformation(List<ViewData> viewData){
        Information information = new Information();
        int count = 0;
        List<Double> delta = new ArrayList<>();
        double deltaSum = 0;
        double sdDelta;
        int j = 0;

        for (int i = viewData.size()-1; i >= 0 ; i--)
        {
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
            double calc= Math.pow((delta.get(i) - (deltaSum/count)),2);
            runningTotal = runningTotal + calc;
        }

        sdDelta = sqrt(runningTotal / (count - 1));
        information.setAvgDelta((int)ceil(deltaSum/count));
        information.setRealDeltaSD((int)ceil(sdDelta));
        information.setDeltaSD((int)ceil(sdDelta));
        return information;
    }
}
