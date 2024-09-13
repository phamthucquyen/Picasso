package picasso.view;



import picasso.model.HistoryManager;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.util.Stack;
import picasso.parser.tokens.Token;
import picasso.parser.ExpressionTreeGenerator;
import picasso.random.RandomExpressionGenerator;


import java.awt.Dimension;
import java.util.List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import picasso.model.Pixmap;
import picasso.util.Command;
import picasso.util.NamedCommand;
//import picasso.util.ThreadedCommand;
//import picasso.view.commands.Evaluator;
//import picasso.view.commands.Reader;
//import picasso.view.commands.Writer;

import javax.swing.*;
//import javax.swing.text.*;
// 
//import java.awt.*;              
//import java.awt.event.*;       
// 
//import java.net.URL;
import java.io.IOException;

/**
 * The collection of commands represented as buttons that apply to the active
 * image.
 * 
 * @author Robert C Duvall
 * @author Ashton Dill
 * @author Bianca Pham
 */
@SuppressWarnings("serial")
public class ButtonPanel extends JPanel {
	private Canvas myView;
	private Command<Pixmap> evaluateAction;
    
	
	private JTextField textField = new JTextField(50);
	
//  Adding the HistoryManager
	private HistoryManager historyManager;
	
//  Adding the HistoryPanel
    private HistoryPanel historyPanel;
	
	protected static final String textFieldString = "JTextField";
    protected static final String ftfString = "JFormattedTextField";
    protected static final String buttonString = "JButton";

    protected JLabel actionLabel;
    
    
    
	/**
	 * Create panel that will update the given picasso.view.
	 * 
	 * @param view the Canvas that the panel's buttons update
	 */
	public ButtonPanel(Canvas view, HistoryManager historyManager) { // Added historyManager
	    // Initializing the HistoryManager
	    this.historyManager = historyManager;

	    // Set a preferred size for the ButtonPanel
	    setPreferredSize(new Dimension(800, 200));

	    // Use FlowLayout for the main panel
	    setLayout(new FlowLayout());

	    // Create a new panel to hold the label and historyPanel
	    JPanel historyPanelContainer = new JPanel();
	    historyPanelContainer.setLayout(new BorderLayout());

	    // Add a label above the historyPanel in the container panel
	    JLabel label = new JLabel("Expression History", JLabel.CENTER);
	    historyPanelContainer.add(label, BorderLayout.NORTH);

	    // Initializing the HistoryPanel with a preferred size
	    this.historyPanel = new HistoryPanel();
	    historyPanel.setPreferredSize(new Dimension(664, 100));

	    // Add the HistoryPanel to the container panel
	    historyPanelContainer.add(historyPanel, BorderLayout.CENTER);

	    // Add the container panel to the main panel
	    add(historyPanelContainer);

	    // Add the text field
	    textField.setActionCommand(textFieldString);
	    add(textField);

	    // Set the Canvas
	    myView = view;

	    // Force a repaint
	    revalidate();
	    repaint();

	    // Update the UI component with the new history
	    historyPanel.updateHistory(historyManager.getExpressionHistory());
	}
	
	public String getExpression() {
		return textField.getText();
	}
	
	/**
	 * Add the given Command as a button with the given button text. When the button
	 * is clicked, the command is executed and the associated canvas is updated.
	 * 
	 * @param buttonText the text for the button
	 * @param action     the action associated with the new button
	 */
	public void add(String buttonText, final Command<Pixmap> action) {
		JButton button = new JButton(buttonText);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (buttonText.equals("I'm Feeling Lucky")) {
					RandomExpressionGenerator r = new RandomExpressionGenerator();
					String randomExpr = r.expressionBuilder();
					textField.setText(randomExpr);
					addExpressionToHistory(textField.getText());
				}
				action.execute(myView.getPixmap());
				myView.refresh();
				if (buttonText.equals("Evaluate")) {
					evaluateAction = action;
					addExpressionToHistory(textField.getText()); // Calls helper method to add the expression to history
				}

				// I don't know why commenting this out doesn't impact anything...
				//PopUpWindow newWindow = new PopUpWindow();
			}
		});
		add(button);
		if (buttonText.equals("Evaluate")) {
			evaluateAction = action;
			
		}
	}
	
	/**
     * Add the entered expression to history if it has a valid postfix result.
     *
     * @param expression the expression to add to history
     */
    private void addExpressionToHistory(String expression) {
        // Check for a valid postfix result
        Stack<Token> postfixResult = new ExpressionTreeGenerator().infixToPostfix(expression);
        if (postfixResult != null) {
            // Add the expression to history
            historyManager.addToHistory(expression);

            // Update the UI component with the new history
            historyPanel.updateHistory(historyManager.getExpressionHistory());
        }
    }
	
	public void endExpressionWithEnter(final Command<Pixmap> action) {
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action.execute(myView.getPixmap());
				// Calls helper method to add expression to history
				addExpressionToHistory(textField.getText());
				myView.refresh();
//				PopUpWindow newWindow = new PopUpWindow();
			}
		});	
	}


	
	/**
	 * Add the given Command as a button. The button's text will be the given
	 * command's name.
	 * 
	 * @param action the command associated with the new button
	 */
	public void add(NamedCommand<Pixmap> action) {
		add(action.getName(), action);
	}
}
