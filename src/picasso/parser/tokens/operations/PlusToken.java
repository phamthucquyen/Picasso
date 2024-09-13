package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the plus sign token
 * @author John Schleider
 */
public class PlusToken extends CharToken implements OperationInterface {
	public PlusToken() {
		super(CharConstants.PLUS);
	}
}
