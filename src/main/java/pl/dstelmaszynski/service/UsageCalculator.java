package pl.dstelmaszynski.service;

import lombok.Data;
import pl.dstelmaszynski.data.DataProvider;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
public class UsageCalculator {
    DataProvider dataProvider = new DataProvider();
    public List<BigDecimal> gasCostPerHundredResult = new ArrayList<>();
    public List<BigDecimal> gasCostPerHundredResultTemp = new ArrayList<>();

    BigDecimal resultPerHundred;

    public List<BigDecimal> gasCostOverallResult = new ArrayList<>();
    public List<Object> gasParameters = new ArrayList<>();
    public List<Object> gasParametersPerCar = new ArrayList<>();
    public Map<String, Object> mapFilledWithCarsAndListOfValues = new LinkedHashMap<>();


    public BigDecimal gasCost(List<BigDecimal> gasPrice, List<BigDecimal> gasConsumeVal) {
        for (int i = 0; i < dataProvider.carsMapIntStr.size(); i++) {
            resultPerHundred = gasPrice.get(0)
                    .multiply(gasConsumeVal.get(i));
            gasCostPerHundredResult.add(i, resultPerHundred);
        }
        return gasPrice.get(0).multiply(gasConsumeVal.get(0));
    }

    public void gasCostOverall(List<BigDecimal> gasCostPerHundredResult, Integer milesAgePerYear) {
        for (int i = 0; i < dataProvider.carsMapIntStr.size(); i++) {
            BigDecimal resultOverallCost = gasCostPerHundredResult.get(i)
                    .multiply(BigDecimal.valueOf(milesAgePerYear))
                    .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
            gasCostOverallResult.add(i, resultOverallCost);
        }
    }

    public void listWithValuesProducer(Map<Integer, String> carsMapIntStr,
                                       List<BigDecimal> carsPrice,
                                       List<Integer> milesAgePerYear,
                                       List<BigDecimal> gasConsumePerHundred,
                                       List<BigDecimal> gasPrice,
                                       List<BigDecimal> gasCostPerHundredResult,
                                       List<BigDecimal> gasCostOverallResult) {

        for (int i = 0; i < carsMapIntStr.size(); i++) {
            gasParameters.add(carsPrice.get(i));
            gasParameters.add(milesAgePerYear.get(0));
            gasParameters.add(gasConsumePerHundred.get(i));
            gasParameters.add(gasPrice.get(0));
            gasParameters.add(gasCostPerHundredResult.get(i));
            gasParameters.add(gasCostOverallResult.get(i));

        }
    }


    public void carsAndValuesMapProducer(Map<Integer, String> carsMapIntStr, List<Object> gasParameters) {
        int gasParamSize = gasParameters.size();
        int counterStart = 0;
        int counterEnd = 6;
        for (int i = 0; i < gasParamSize; i++) {
            if (gasParamSize >= counterEnd) {
                List<Object> sublistGasParamPerCar = gasParameters.subList(counterStart, counterEnd);
                counterStart = counterStart + 6;
                counterEnd = counterEnd + 6;
                mapFilledWithCarsAndListOfValues.put(carsMapIntStr.get(i), sublistGasParamPerCar);
            }
        }
    }
}


