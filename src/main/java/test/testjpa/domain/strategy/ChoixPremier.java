package test.testjpa.domain.strategy;

import test.testjpa.domain.Reunion;

import java.util.Date;
import java.util.List;

public class ChoixPremier implements IStrategy {
    @Override
    public void choix(List<Date> dates, Reunion reunion) {
        reunion.setDate_reunion(dates.get(0));
    }
}
