package in.cozynest.cozyapis.utils;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage implements java.io.Serializable {

	private static final long serialVersionUID = 3341989346276813821L;

	private int errorCode;
	private String message;

	public ErrorMessage() {
	}

	public ErrorMessage(int errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return errorCode + "," + message;
	}

}
