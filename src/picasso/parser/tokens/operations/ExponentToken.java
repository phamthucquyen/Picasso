package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the ^, or exponent token
 * @author Ciel Morrill
 */
public class ExponentToken extends CharToken implements OperationInterface {
	public ExponentToken() {
		super(CharConstants.CARET);
	}
}
