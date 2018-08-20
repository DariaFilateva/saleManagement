package task2.statistic;

import task1.salemanagement.Operation;

import java.util.*;

public class StatisticByDate extends Statistic {


    public StatisticByDate(ArrayList<Operation> operations, String file) {
        super(operations, file);
        data = createStatistic();
    }

    @Override
    protected Map<Date, Double> createStatistic() {
        Map<Date, Double> sortingOffices = new HashMap<>();
        for (Operation operation : operations) {
            if (sortingOffices.containsKey(operation.getDate())) {
                Double newSum = sortingOffices.get(operation.getSalePoint()) + operation.getSum();
                sortingOffices.put(operation.getDate(), newSum);
            } else {
                sortingOffices.put(operation.getDate(), operation.getSum());
            }
        }
        return sortingOffices;
    }

    @Override
    protected Map sortStatistic() {
        Map<String, Double> result = new LinkedHashMap<>();
        List<Map.Entry<String, Double>> list = new ArrayList(data.entrySet());
        list.sort(Map.Entry.comparingByKey());
        for (Map.Entry<String, Double> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    @Override
    public String toString() {
        return null;
    }
}
