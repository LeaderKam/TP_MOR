package test.testjpa.domain.strategy;

import test.testjpa.domain.Reunion;

import java.util.Date;
import java.util.List;

public interface IStrategy {
    public void choix(List<Date> dates, Reunion reunion);
}