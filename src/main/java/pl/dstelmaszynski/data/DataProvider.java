package pl.dstelmaszynski.data;

import lombok.Data;

import java.math.BigDecimal;
import java.util.*;

@Data
public class DataProvider {
    Scanner scanner = new Scanner(System.in);
    public Map<Integer, String> carsMapIntStr = new LinkedHashMap<>();
    String value;
    List<BigDecimal> tempNumericVal = new ArrayList<>();
    public List<BigDecimal> gasConsumePerHundred = new ArrayList<>();
    public List<Integer> milesAgePerYear = new ArrayList<>();
    public List<BigDecimal> gasPrice = new ArrayList<>();
    public List<BigDecimal> carsPrice = new ArrayList<>();


    public Map<Integer, String> carList() {
        System.out.println("How many cars do you want to compare?");
        scannerNumeric();
        for (int i = 0; i < tempNumericVal.get(0).intValue(); i++) {
            System.out.println("Please enter car brand!");
            scannerString();
            carsMapIntStr.put(i, value);

        }
        return carsMapIntStr;
    }

    public List<BigDecimal> scannerNumeric() {
        tempNumericVal.clear();
        try {
            tempNumericVal.add(scanner.nextBigDecimal());
        } catch (InputMismatchException e) {
            System.out.println("Wrong input! Try numeric values!");
        }
        return tempNumericVal;
    }

    public void scannerString() {
        try {
            value = scanner.next();
        } catch (InputMismatchException e) {
            System.out.println("Wrong input! Try String values!");
        }
    }

    public void carPrice() {
        for (int i = 0; i < carsMapIntStr.size(); i++) {
            String carName = carsMapIntStr.get(i);
            System.out.println("How much car: " + carName + " cost?");
            scannerNumeric();
            carsPrice.add(tempNumericVal.get(0));
        }
    }

    public void milesAgePerYear() {
        System.out.println("How many miles per year?");
        scannerNumeric();
        milesAgePerYear.add(tempNumericVal.get(0).intValue());


    }

    public void gasConsumePerHundred() {
        for (int i = 0; i < carsMapIntStr.size(); i++) {
            String carName = carsMapIntStr.get(i);
            System.out.println("How much gas per 100 km, car: " + carName + "?");
            scannerNumeric();
            gasConsumePerHundred.add(tempNumericVal.get(0));
        }
    }

    public void gasPrice() {
        System.out.println("How much cost petrol now?");
        scannerNumeric();
        gasPrice.add(tempNumericVal.get(0));
    }
}
