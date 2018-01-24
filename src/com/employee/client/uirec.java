package com.employee.client;

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
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

public class uirec extends Composite implements HasText {

	private static uirecUiBinder uiBinder = GWT.create(uirecUiBinder.class);
	GreetingServiceAsync a1=GWT.create(GreetingService.class);

	@UiField MaterialTextArea t1;
	@UiField MaterialTextArea t2;
	@UiField MaterialTextBox t3;
	@UiField MaterialTextBox t4;
	@UiField MaterialTextBox t5;
	@UiField MaterialTextBox t6;
	@UiField MaterialTextBox t7;
	@UiField MaterialTextBox t8;
	@UiField MaterialLink link1;
	@UiField MaterialButton subbtn;
	
	interface uirecUiBinder extends UiBinder<Widget, uirec> {
	}

	public uirec() {
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
		
		subbtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				String s1=t1.getText();
				String s2=t2.getText();
				String s3=t3.getText();
				String s4=t4.getText();
				String s5=t5.getText();
				String s6=t6.getText();
				String s7=t7.getText();
				String s8=t8.getText();
				a1.rec(s1,s2,s3,s4,s5,s6,s7,s8,new AsyncCallback<String>() {
					
					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						if(result.equals("Thank you For Registration"))
						{
							MaterialToast.fireToast(result);
							RootPanel.get("signin").setVisible(false);
							RootPanel.get("first").setVisible(false);
							RootPanel.get("signup").setVisible(false);
							RootPanel.get("rec").setVisible(false);
							RootPanel.get("emp").setVisible(false);
							RootPanel.get("select").setVisible(true);
						}
						
						else
						{
							MaterialToast.fireToast(result);
						}
					}
					
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MaterialToast.fireToast(caught.getMessage());
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
