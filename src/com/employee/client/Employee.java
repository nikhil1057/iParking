package com.employee.client;

import com.employee.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Employee implements EntryPoint {
	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub
		

	    RootPanel.get("select").add(new uiselect());
	    RootPanel.get("rec").add(new uirec());
		RootPanel.get("emp").add(new uiemp());
		RootPanel.get("first").add(new uifirst());
		RootPanel.get("signin").add(new uisignin());
		RootPanel.get("signup").add(new uisignup());		
	    RootPanel.get("select").setVisible(false);
	    RootPanel.get("rec").setVisible(false);
	    RootPanel.get("emp").setVisible(false); 
	    RootPanel.get("first").setVisible(true);
	    RootPanel.get("signup").setVisible(false);
	    RootPanel.get("signin").setVisible(false);

	}
}
