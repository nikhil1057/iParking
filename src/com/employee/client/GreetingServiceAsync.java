package com.employee.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {

	void signup(String s1, String s2, String s3, String s4, String s5, AsyncCallback<String> asyncCallback) throws IllegalArgumentException;

	void singin(String s1, String s2, AsyncCallback<String> asyncCallback) throws IllegalArgumentException;

	void val(String s1, String s2, AsyncCallback<String> asyncCallback) throws IllegalArgumentException;


	void rec(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8 ,AsyncCallback<String> asyncCallback);
}
