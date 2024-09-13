package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the equal sign token
 * @author Bianca Pham
 */
public class EqualsToken extends CharToken implements OperationInterface {
	public EqualsToken() {
		super(CharConstants.EQUAL);
	}
}
