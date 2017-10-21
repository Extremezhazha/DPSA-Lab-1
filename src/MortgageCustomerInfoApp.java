import MortgageInformationSystem.AmortizedMortgageStrategy;
import MortgageInformationSystem.LinearMortgageStrategy;
import MortgageInformationSystem.Mortgage;
import MortgageInformationSystem.NoRepaymentStrategy;

import java.time.LocalDate;

/**
 * Created by matthias on 10/17/17.
 */
public class MortgageCustomerInfoApp {
    public static void main(String args[]){
        Mortgage mortgage = new Mortgage(100000, LocalDate.of(2000,1,1),LocalDate.of(2030,2,1),18);
       // mortgage.setMortgageStrategy(new LinearMortgageStrategy());
        //mortgage.setMortgageStrategy(new NoRepaymentStrategy());
        mortgage.setMortgageStrategy(new AmortizedMortgageStrategy(1508));

//            for(int j = 2;j<13;j++){
//                mortgage.makePayment(mortgage.getRequiredPayment(LocalDate.of(2000,j,1)));
//                System.out.println(mortgage.getCurrentLoan());}



    }
}
