package pl.dstelmaszynski.service;

public class Main {
    public static void main(String[] args) {

        ResultPrint resultPrint = new ResultPrint();
        resultPrint.dataFillerLauncher();
        resultPrint.resultPrinter();
        resultPrint.carsBrandWithPriceAndCostPrinter(
                resultPrint.dataController.usageCalculator.dataProvider.carsMapIntStr,
                resultPrint.dataController.usageCalculator.dataProvider.carsPrice,
                resultPrint.dataController.usageCalculator.gasCostOverallResult);

    }
}
