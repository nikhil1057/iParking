package com.employee.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	String signup(String s1, String s2, String s3, String s4, String s5) throws IllegalArgumentException;
	String singin(String s1, String s2) throws IllegalArgumentException;
	String val(String s1, String s2) throws IllegalArgumentException;
	String rec(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8);
}
