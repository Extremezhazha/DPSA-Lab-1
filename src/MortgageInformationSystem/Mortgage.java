package MortgageInformationSystem;

import java.time.LocalDate;
import java.util.*;

/**
 * Created by matthias on 10/15/17.
 */
public class Mortgage implements MortgageObservable{
    private int initialLoan;
    private int currentLoan;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate lastPaymentDate;
    private int interestPoints;//points per year
    private Map<LocalDate, Payment> payments;
    private MortgageStrategy ms;
    private Set<MortgageObserver> observers;

    public Mortgage(int initialLoan, LocalDate startDate, LocalDate endDate, int interestPoints) {
        this.initialLoan = initialLoan;
        this.currentLoan = initialLoan;
        this.startDate = startDate;
        this.lastPaymentDate = startDate;
        this.endDate = endDate;
        this.interestPoints = interestPoints;
        this.payments = new HashMap<>();
        this.observers = new HashSet<>();
    }

    @Override
    public void addObserver(MortgageObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(MortgageObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void alertObservers() {
        for (MortgageObserver o: observers)
            o.update(this);
    }

    public Payment getRequiredPayment(LocalDate date) {
        return ms.calculatePayment(this.getMonthlyInterest(), date);
    }

    public void makePayment(Payment p) {
        this.currentLoan = this.currentLoan - p.getRedemption();
        this.lastPaymentDate = p.getDate();
        payments.put(lastPaymentDate, p);
        alertObservers();
    }

    public LocalDate iterateMonth(LocalDate date) {
        makePayment(getRequiredPayment(date));
        return date.plusMonths(1);
    }

    public void fullyRepay(LocalDate date) {
        Payment p = getRequiredPayment(date);
        makePayment(p.expand(currentLoan - p.getRedemption()));
    }

    public void setMortgageStrategy(MortgageStrategy ms) {
        this.ms = ms;
    }

    public int getInitialLoan() {
        return initialLoan;
    }

    public int getCurrentLoan() {
        return currentLoan;
    }

    public int getInterestPoints() {
        return interestPoints;
    }

    public int getYearlyInterest() {
        return interestPoints * currentLoan / 100;
    }

    public int getMonthlyInterest() {
        return interestPoints * currentLoan / 1200;
    }

    public String toString() {
        return "This mortgage was started at " + startDate.toString()
                + " and will finish at " + endDate.toString()
                + ". Initial loan is " + initialLoan + " yuan and current loan is " + currentLoan
                + " yuan."
                ;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public MortgageStrategy getMortgageStrategy() {
        return ms;
    }

    public LocalDate getLastPaymentDate() {
        return lastPaymentDate;
    }

    public static int relativeMonths(LocalDate endDate, LocalDate startDate) {
        return 12 * (endDate.getYear() - startDate.getYear())
                + (endDate.getMonth().getValue() - startDate.getMonth().getValue());
    }
}
