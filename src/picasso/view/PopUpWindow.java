package picasso.view;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import picasso.Main;
import picasso.model.Pixmap;
import picasso.view.commands.Evaluator;


/**
 * Class that represents a pop up window
 * @author Bianca Pham
 */
public class PopUpWindow extends JFrame {

	private String newName;
	Canvas newCanvas = new Canvas(this);

	public PopUpWindow(String expression) {
		setTitle(expression);
		setVisible(true);
		newCanvas.setSize(Main.SIZE);
		newCanvas.getPixmap().setSize(Main.SIZE);

		// add canvas to pop up window
		getContentPane().add(newCanvas, BorderLayout.CENTER);
		pack();
	}

	public Pixmap getPixmap() {
		return newCanvas.getPixmap();
	}

	public void refresh() {
		newCanvas.refresh();

	}
}
