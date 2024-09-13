package picasso.view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Refers to where past expressions will be collected.
 * @author Ashton Dill 
 */

public class HistoryPanel extends JPanel {
    private JTextArea historyTextArea;

    public HistoryPanel() {
        setLayout(new BorderLayout());
        historyTextArea = new JTextArea();
        historyTextArea.setEditable(false);
        add(new JScrollPane(historyTextArea), BorderLayout.CENTER);
    }

    public void updateHistory(List<String> expressionHistory) {
        historyTextArea.setText("");
        for (String expression : expressionHistory) {
            historyTextArea.append(expression + "\n");
        }
    }
}
