package MortgageInformationSystem;

import java.util.Observer;

/**
 * Created by zhazha on 10/21/17.
 */
public interface MortgageObservable {
    public void addObserver(MortgageObserver observer);
    public void removeObserver(MortgageObserver observer);
    public void alertObservers();
}
