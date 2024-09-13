package picasso.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class for the history extension for the Picasso application
 *
 * @author Ashton Dill
 * 
 */
public class HistoryManager {
	private List<String> expressionHistory;

	public HistoryManager() {
		this.expressionHistory = new ArrayList<>();
	}
	
	public void addToHistory(String expression) {
        expressionHistory.add(expression);
    }

    public List<String> getExpressionHistory() {
        return new ArrayList<>(expressionHistory);
    }

    public void clearHistory() {
        expressionHistory.clear();
    }
}
