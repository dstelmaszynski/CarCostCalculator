package pl.dstelmaszynski.service;

import pl.dstelmaszynski.data.DataProvider;

public class DataController {
    UsageCalculator usageCalculator = new UsageCalculator();

    public void dataFiller() {
        DataProvider dataProviderUserCalc = usageCalculator.dataProvider;

        dataProviderUserCalc.carList();

        dataProviderUserCalc.carPrice();

        dataProviderUserCalc.milesAgePerYear();

        dataProviderUserCalc.gasConsumePerHundred();

        dataProviderUserCalc.gasPrice();


            usageCalculator.gasCost(dataProviderUserCalc.gasPrice, dataProviderUserCalc.gasConsumePerHundred);
            usageCalculator.gasCostOverall(usageCalculator.gasCostPerHundredResult, dataProviderUserCalc.milesAgePerYear.get(0));


        usageCalculator.listWithValuesProducer(
                dataProviderUserCalc.carsMapIntStr,
                dataProviderUserCalc.carsPrice,
                dataProviderUserCalc.milesAgePerYear,
                dataProviderUserCalc.gasConsumePerHundred,
                dataProviderUserCalc.gasPrice,
                usageCalculator.gasCostPerHundredResult,
                usageCalculator.gasCostOverallResult
        );
    }
}