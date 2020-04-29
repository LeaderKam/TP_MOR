package test.testjpa.domain.strategy;

import test.testjpa.domain.Reunion;

import java.util.Date;
import java.util.List;

public class ChoixMajoritaire implements IStrategy {

    private Date date_choisit;
    @Override
    public void choix(List<Date> dates, Reunion reunion) {
reunion.setDate_reunion(dates.get(0));
    }

}
