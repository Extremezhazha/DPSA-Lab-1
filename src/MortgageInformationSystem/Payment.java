package MortgageInformationSystem;

import java.time.LocalDate;

/**
 * Created by matthias on 10/15/17.
 */
public class Payment {
    private LocalDate date;
    private int redemption;
    private int interest;

    public Payment(LocalDate date, int redemption, int interest) {
        this.date = date;
        this.redemption = redemption;
        this.interest = interest;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getRedemption() {
        return redemption;
    }

    public int getInterest() {
        return interest;
    }

    public int getTotal() {
        return interest + redemption;
    }

    public Payment expand(int extra) {
        return extra > 0 ? new Payment(date, redemption + extra, interest) : this;
    }
}
