package task1.salemanagement;

import task1.randomUtils.RandomUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SalePoints {

    private List<String> salePoints;

    public SalePoints(String filePath) {
        this.salePoints = getSalePointFromFile(filePath);
    }

    public List<String> getSalePoints() {
        return salePoints;
    }

    public String getRandomSalePoints() {
        return salePoints.get(RandomUtils.getRandom(0, salePoints.size() - 1));
    }

    private List<String> getSalePointFromFile(String path) {
        List<String> listOfPoints = new ArrayList<>();
        try {
            FileInputStream fstream = new FileInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                listOfPoints.add(strLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfPoints;
    }
}
