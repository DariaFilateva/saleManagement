package task2.statistic;

import task1.salemanagement.Operation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class StatisticByDate extends Statistic {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat formatForPrint = new SimpleDateFormat("yyyy-MM-dd");

    public StatisticByDate(ArrayList<Operation> operations, String file) {
        super(operations, file);
        data = createStatistic();
    }

    @Override
    protected Map<Date, Double> createStatistic() {
        Map<Date, Double> sortingDate = new HashMap<>();
        for (Operation operation : operations) {
            Date operationDateWithoutTime = null;
            try {
                operationDateWithoutTime = dateFormat.parse(dateFormat.format(operation.getDate()));
                // DateUtils.truncate(new Date(), java.util.Calendar.DAY_OF_MONTH)
                // Date
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (sortingDate.containsKey(operationDateWithoutTime)) {
                Double newSum = sortingDate.get(operationDateWithoutTime) + operation.getSum();
                sortingDate.put(operationDateWithoutTime, newSum);
            } else {
                sortingDate.put(operationDateWithoutTime, operation.getSum());
            }
        }
        return sortingDate;
    }

    @Override
    protected Map sortStatistic() {
        Map<LocalDate, Double> result = new LinkedHashMap<>();
        List<Map.Entry<Date, Double>> list = new ArrayList(data.entrySet());
        list.sort(Map.Entry.comparingByKey());
        for (Map.Entry<Date, Double> entry : list) {
            result.put(dateRemoveTime(entry.getKey()), entry.getValue());
        }
        return result;
    }

    private LocalDate dateRemoveTime(Date date) {
       return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
