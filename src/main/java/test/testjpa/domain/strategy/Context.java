package test.testjpa.domain.strategy;

import test.testjpa.domain.Reunion;

import java.util.Date;
import java.util.List;

public class Context {
    protected IStrategy strategy;

    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void appliquerStrategy(IStrategy strategy, List<Date> dates, Reunion reunion){
        strategy.choix(dates, reunion);
    }

    public void setStrategy(IStrategy strategy) {
        this.strategy=strategy;
    }
}
