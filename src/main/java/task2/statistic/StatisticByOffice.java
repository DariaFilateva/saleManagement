package task2.statistic;

import task1.salemanagement.Operation;

import java.util.*;

public class StatisticByOffice extends Statistic {

    public StatisticByOffice(ArrayList<Operation> operations, String file) {
        super(operations, file);
        data = createStatistic();
    }

    @Override
    protected Map<String, Double> createStatistic() {
        Map<String, Double> sortingOffices = new HashMap<>();
        for (Operation operation : operations) {
            if (sortingOffices.containsKey(operation.getSalePoint())) {
                Double newSum = sortingOffices.get(operation.getSalePoint()) + operation.getSum();
                sortingOffices.put(operation.getSalePoint(), newSum);
            } else {
                sortingOffices.put(operation.getSalePoint(), operation.getSum());
            }
        }
        return sortingOffices;
    }

    @Override
    protected Map sortStatistic() {
        Map<String, Double> result = new LinkedHashMap<>();
        List<Map.Entry<String, Double>> list = new ArrayList(data.entrySet());
        list.sort(Map.Entry.comparingByValue());
        for (Map.Entry<String, Double> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
