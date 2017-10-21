package MortgageInformationSystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by zhazha on 10/18/17.
 */
public class MortgageFactory {
    Mortgage getLinearMortgage(int initialLoan, LocalDate startDate, LocalDate endDate, int interestPoints) {
        Mortgage mortgage = new Mortgage(initialLoan, startDate, endDate, interestPoints);
        mortgage.setMortgageStrategy(new LinearMortgageStrategy((int) ChronoUnit.MONTHS.between(startDate, endDate)));
        return mortgage;
    }

    Mortgage getNoRepaymentMortgage(int initialLoan, LocalDate startDate, LocalDate endDate, int interestPoints) {
        Mortgage mortgage = new Mortgage(initialLoan, startDate, endDate, interestPoints);
        mortgage.setMortgageStrategy(new NoRepaymentStrategy());
        return mortgage;
    }

    Mortgage getAmortizedMortgageStrategy(int initialLoan, LocalDate startDate, LocalDate endDate, int interestPoints, int payPerMonth) {
        Mortgage mortgage = new Mortgage(initialLoan, startDate, endDate, interestPoints);
        mortgage.setMortgageStrategy(new AmortizedMortgageStrategy(payPerMonth));
        return mortgage;
    }
}
