package task2.main;

import task1.salemanagement.SaleManagement;
import task1.salemanagement.SalePoints;
import task2.salestatistic.SaleStatistic;

public class Task2 {
    public static void main(String[] args) {
 /*
        * args[0] - файл отчета по операциям
        * args[1] - файл статистики по датам
        * args[2] - файл статистики по офисам
        */
        SaleStatistic saleStatistic = new SaleStatistic(args[0], args[1], args[2]);
        saleStatistic.report();
    }
}
