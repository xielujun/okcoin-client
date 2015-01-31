package com.redv.okcoin;

import com.xeiam.xchange.exceptions.ExchangeException;

public class OKCoinException extends ExchangeException {

	private static final long serialVersionUID = 20140614L;

	private final int errorCode;

	/**
	 * Constructor.
	 *
	 * @param errorCode the error code.
	 * @param message the exception message.
	 */
	public OKCoinException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	/**
	 * @return the error code.
	 */
	public int getErrorCode() {
		return errorCode;
	}

}