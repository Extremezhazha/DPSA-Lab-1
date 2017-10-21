package MortgageInformationSystem;

/**
 * Created by zhazha on 10/21/17.
 */
public class SimpleObserver implements MortgageObserver {
    @Override
    public void update(MortgageObservable subject) {
        System.out.println("Mortgage changed, details displayed below:");
        System.out.print(subject.toString());
    }
}
