package MortgageInformationSystem;

import java.time.LocalDate;

import static MortgageInformationSystem.Mortgage.relativeMonths;

/**
 * Created by matthias on 10/15/17.
 */
public class LinearMortgageStrategy implements MortgageStrategy {
    int redemption;

    @Override
    public Payment calculatePayment(int interest, LocalDate date) {
        return new Payment(date,
                redemption,
                interest
        );
    }

    public LinearMortgageStrategy(int redemption) {
        this.redemption = redemption;
    }
}
