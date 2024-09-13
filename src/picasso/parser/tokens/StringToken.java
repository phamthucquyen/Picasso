package picasso.parser.tokens;

import java.util.Objects;

/**
 * Represents a String entered in the window.
 * @author John Schleider
 */
public class StringToken extends Token {
	
	private final String str;

	public StringToken(String expressionString) {
		super("String Token");
		this.str = expressionString;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(str);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StringToken other = (StringToken) obj;
		return Objects.equals(str, other.str);
	}

	public String getString() {
		return this.str;
	}

	@Override
	public boolean isConstant() {
		return true;
	}

	@Override
	public boolean isFunction() {
		return false;
	}

}
