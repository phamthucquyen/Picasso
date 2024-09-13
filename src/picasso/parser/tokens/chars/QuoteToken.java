package picasso.parser.tokens.chars;

import picasso.parser.language.CharConstants;

/**
 * Represents both a left and right quote in the Picasso language
 * 
 * @author John Schleider
 */

public class QuoteToken extends CharToken {

	public QuoteToken() {
		super(CharConstants.QUOTE);
	}

}
