package MortgageInformationSystem;

import java.time.LocalDate;

import static MortgageInformationSystem.Mortgage.relativeMonths;

/**
 * Created by matthias on 10/15/17.
 */
public class NoRepaymentStrategy implements MortgageStrategy {
    @Override
    public Payment calculatePayment(int interest, LocalDate date) {
        return new Payment(date, 0, interest);
    }
}
