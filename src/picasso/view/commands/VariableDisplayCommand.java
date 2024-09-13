package picasso.view.commands;

import picasso.model.Pixmap;
import picasso.util.Command;
import picasso.view.VariableDisplay;

/**
 * Displays the variable list.
 * 
 * @author Alexandra Thorpe
 */
public class VariableDisplayCommand implements Command<Pixmap> {
	

	public VariableDisplayCommand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Pixmap target) {
		// TODO Auto-generated method stub
		new VariableDisplay();
	}
	
}
