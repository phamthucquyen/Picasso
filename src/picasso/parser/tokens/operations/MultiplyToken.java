package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the multiple (*) token
 * @author John Schleider
 */

public class MultiplyToken extends CharToken implements OperationInterface {

	public MultiplyToken() {
		super(CharConstants.STAR);
	}

}
