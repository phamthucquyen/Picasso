package picasso.view;

import picasso.model.HistoryManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

import picasso.model.Pixmap;
//import picasso.util.NamedCommand;
import picasso.util.ThreadedCommand;
import picasso.view.commands.*;

/**
 * Main container for the Picasso application
 *
 * @author Robert Duvall (rcd@cs.duke.edu)
 * @author Ashton Dill
 * @author Bianca Pham
 * 
 */
@SuppressWarnings("serial")
public class Frame extends JFrame {
	public Frame(Dimension size) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
        // create a HistoryManager instance
        HistoryManager historyManager = new HistoryManager();

		// create GUI components
		Canvas canvas = new Canvas(this);
		canvas.setSize(size);

		// add commands to test here
		ButtonPanel commands = new ButtonPanel(canvas, historyManager); // pass historyManager to ButtonPanel
		commands.add("Open Image", new Reader());
		commands.add("Open Expression", new ExpressionReader(commands, new Evaluator(commands)));
		ThreadedCommand<Pixmap> userControl = new ThreadedCommand<Pixmap>(canvas, new Evaluator(commands));
		commands.add("Evaluate", userControl);
		commands.add("I'm Feeling Lucky", userControl);	
		commands.add("Save", new Writer());
		commands.add("Variable List", new VariableDisplayCommand());

		commands.endExpressionWithEnter(userControl);

		// add our container to Frame and show it
		getContentPane().setLayout(new BorderLayout());  // Set BorderLayout explicitly
		getContentPane().add(canvas, BorderLayout.CENTER);
		getContentPane().add(commands, BorderLayout.NORTH);
		pack();
		
	}
}


