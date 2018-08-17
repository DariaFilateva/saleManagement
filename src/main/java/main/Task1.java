package main;

import salemanagement.SaleManagement;
import salemanagement.SalePoints;

public class Task1 {

    public static void main(String[] args) {
        /*
        * args[0] - файл точек продаж
        * args[1] - количество операций
        * args[2] - куда пишем информацию
        */
        SalePoints salePoints = new SalePoints(args[0]);
        SaleManagement saleManagement = new SaleManagement(salePoints, args[1], args[2]);
        saleManagement.report();
    }
}
