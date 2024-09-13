package picasso.view.commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import picasso.model.Pixmap;
import picasso.parser.ErrorHandler;
import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.ParseException;
import picasso.parser.language.ExpressionTreeNode;
import picasso.util.FileCommand;
import picasso.view.ButtonPanel;

/**
 * Read expression from a file
 * 
 * @author Robert C Duvall
 * @author Bianca Pham
 * 
 */
public class ExpressionReader extends FileCommand<Pixmap> {


	private Evaluator evalStorage;

	public static final double DOMAIN_MIN = -1;
	public static final double DOMAIN_MAX = 1;

	public ExpressionReader(ButtonPanel userInput, Evaluator eval) {
		super(JFileChooser.OPEN_DIALOG);
		evalStorage = eval;

	}

	public void execute(Pixmap target) {
		String fileName = getFileName();
		if (fileName != null) {
			File myFileName = new File(fileName);
			try {
				BufferedReader br = new BufferedReader(new FileReader(myFileName));
				String st;
				while ((st = br.readLine()) != null) {
					ExpressionTreeNode expr = createExpression(st);
					if (expr != null) {
						evalStorage.execute(target, expr);
					}
				}
				br.close();
			} catch (IOException | ParseException e) {
				//e.printStackTrace();
				ErrorHandler.getInstance().errorMessage(e, "Invalid Expression!");
			}
		}
	}

	protected double imageToDomainScale(int value, int bounds) {
		double range = DOMAIN_MAX - DOMAIN_MIN;
		return ((double) value / bounds) * range + DOMAIN_MIN;
	}

	/**
	 * 
	 * A place holder for a more interesting way to build the expression.
	 * @throws IOException 
	 */
	private ExpressionTreeNode createExpression(String st) throws IOException {
		ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();
		return expTreeGen.makeExpression(st);

	}

}
