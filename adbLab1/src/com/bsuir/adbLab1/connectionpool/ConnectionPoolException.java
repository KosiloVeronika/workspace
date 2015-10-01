package com.bsuir.adbLab1.connectionpool;

public class ConnectionPoolException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConnectionPoolException() {
	}

	public ConnectionPoolException(String arg0) {
		super(arg0);
	}

	public ConnectionPoolException(Throwable arg0) {
		super(arg0);
	}

	public ConnectionPoolException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ConnectionPoolException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
