package JunitTest;

import MortgageInformationSystem.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Created by Matthias on 10/18/2017.
 */
public class MortgageTest {
    Mortgage mortgage;

    @Before
    public void setUp() throws Exception {
        mortgage = new Mortgage(100000, LocalDate.of(2000, 1, 1), LocalDate.of(2000, 1, 1), 18);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void LinearMortgageStrategy() {
        mortgage.setMortgageStrategy(new LinearMortgageStrategy(1000));
        mortgage.iterateMonth(LocalDate.of(2000, 2, 1));
        assertTrue(mortgage.getCurrentLoan() == 99000);

    }

    @Test
    public void AmortizedMortgageStrategy() {
        mortgage.setMortgageStrategy(new AmortizedMortgageStrategy(1508));
        mortgage.iterateMonth(LocalDate.of(2000, 2, 1));
        assertTrue(mortgage.getCurrentLoan() == 99992);
    }

    @Test
    public void NoRepaymentMortgageStrategy() {
        mortgage.setMortgageStrategy(new NoRepaymentStrategy());
        mortgage.iterateMonth(LocalDate.of(2000, 2, 1));
        assertTrue(mortgage.getCurrentLoan() == 100000);
    }

    @Test
    public void Observer(){
        mortgage.setMortgageStrategy(new LinearMortgageStrategy(1000));
        mortgage.addObserver(new SimpleObserver());
        mortgage.iterateMonth(LocalDate.of(2000, 2, 1));
    }

}