package com.employee.client;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialDatePicker;
import gwt.material.design.client.ui.MaterialIntegerBox;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialRadioButton;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

public class uiemp extends Composite implements HasText {

	private static uiempUiBinder uiBinder = GWT.create(uiempUiBinder.class);
	GreetingServiceAsync a1=GWT.create(GreetingService.class);
	
	@UiField MaterialTextBox t1;
	@UiField MaterialTextBox t2;
	/*@UiField MaterialTextBox t3;
	@UiField MaterialIntegerBox t4;
	@UiField MaterialTextBox t5;
	@UiField MaterialTextBox t6;
	@UiField MaterialDatePicker t7;
	@UiField MaterialIntegerBox t8;
	@UiField MaterialTextBox t9;
	@UiField MaterialIntegerBox t10;
	@UiField MaterialTextBox t11;
	@UiField MaterialTextBox t12;
	@UiField MaterialTextBox t13;
	@UiField MaterialIntegerBox t14;
	@UiField MaterialTextBox t15;
	@UiField MaterialIntegerBox t16;
	@UiField MaterialTextBox t17;
	@UiField MaterialTextBox t20;
	@UiField MaterialTextBox t21;
	@UiField MaterialTextBox t18;
	@UiField MaterialIntegerBox t19;*/
//	@UiField MaterialButton subbtn;
    @UiField MaterialButton valbtn;
    @UiField MaterialLink link1;
    boolean submit=false;
	interface uiempUiBinder extends UiBinder<Widget, uiemp> {
	}

	public uiemp() {
		initWidget(uiBinder.createAndBindUi(this));
		link1.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				RootPanel.get("signin").setVisible(false);
				RootPanel.get("signup").setVisible(false);
				RootPanel.get("select").setVisible(true);
				RootPanel.get("rec").setVisible(false);
				RootPanel.get("emp").setVisible(false);
				RootPanel.get("first").setVisible(false);
			}
		});
		
		valbtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				String s1=t1.getText();
				String s2=t2.getText();
				a1.val(s1,s2,new AsyncCallback<String>() {
					
					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						if(result.equals("Token updated"))
						{
							MaterialToast.fireToast(result);
						}
						else{
							MaterialToast.fireToast(result);
							valbtn.setEnabled(false);
						}
					}
					
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MaterialToast.fireToast(caught.getMessage());
						valbtn.setEnabled(false);
					}
				});
			}
		});
		
	}

	
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		
	}


}
