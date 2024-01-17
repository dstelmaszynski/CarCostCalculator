package pl.dstelmaszynski.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ResultPrint {
    DataController dataController = new DataController();

    public void dataFillerLauncher() {
        dataController.dataFiller();
    }

    public void resultPrinter() {
        dataController.usageCalculator.carsAndValuesMapProducer(
                dataController.usageCalculator.dataProvider.carsMapIntStr,
                dataController.usageCalculator.gasParameters);

        System.out.println();
        System.out.println("::::::::::::::::::Result pattern::::::::::::::::::");
        System.out.println("The result pattern:" +
                "\n1. car brand" +
                "\n1. car price" +
                "\n2. miles age per year" +
                "\n3. petrol consume per 100 km" +
                "\n4. petrol cost" +
                "\n5. per 100 km cost" +
                "\n6. year cost");

        System.out.println();
        System.out.println("::::::::::::::::::Summary::::::::::::::::::");
        Map<String, Object> map = dataController.usageCalculator.mapFilledWithCarsAndListOfValues;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("Car: " + key + "\nparameters: " + value + "\n");
        }

    }
    public void carsBrandWithPriceAndCostPrinter(
            Map<Integer, String> carsMapIntStr, List<BigDecimal> carsPrice, List<BigDecimal> gasCostOverallResult) {

        for (int i = 0; i < carsMapIntStr.size(); i++) {
            System.out.println();
            System.out.println("Car: " + carsMapIntStr.get(i) + " , total per year cost: " +
                    carsPrice.get(i).add(gasCostOverallResult.get(i)) + " zl");
        }
    }
}
