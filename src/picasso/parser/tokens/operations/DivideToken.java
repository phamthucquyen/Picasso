package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the divide binary operator
 * 
 * @author John Schleider
 */
public class DivideToken extends CharToken implements OperationInterface {

	public DivideToken() {
		super(CharConstants.SLASH);
	}

}
