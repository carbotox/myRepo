package com.radu.test.spring.store.error;

import java.util.Date;

/**
 * Class for handling error details.
 * @author Radu Nicoara
 *
 */
public class ErrorData {
	
	private Date timestamp;
	private String message;
	private String details;
	private String statusCode;

	public ErrorData(Date timestamp, String message, String details, String statusCode) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.statusCode = statusCode;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
	
	public String getStatusCode() {
		return statusCode;
	}
}
