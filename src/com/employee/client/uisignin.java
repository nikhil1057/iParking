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
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

public class uisignin extends Composite implements HasText {

	private static uisigninUiBinder uiBinder = GWT.create(uisigninUiBinder.class);
	GreetingServiceAsync a1 = GWT.create(GreetingService.class);
	@UiField
	MaterialRow sip;
	@UiField
	MaterialTextBox t1;
	@UiField
	MaterialTextBox t2;
	@UiField
	MaterialButton btn;
	@UiField
	MaterialLink link1;
	boolean signin = false;

	interface uisigninUiBinder extends UiBinder<Widget, uisignin> {
	}

	public uisignin() {
		initWidget(uiBinder.createAndBindUi(this));
		btn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				String s1=t1.getText();
				String s2=t2.getText();
				a1.singin(s1,s2,new AsyncCallback<String>() {
					
					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						if(result.equals("Logged In"))
						{
							MaterialToast.fireToast(result);
							signin=true;
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
							signin=false;
						}
					}
					
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						signin=false;
						MaterialToast.fireToast(caught.getMessage());
					}
				});
			}
		});
	}

	@UiHandler("link1")
	void onClick(ClickEvent e) {
		RootPanel.get("signin").setVisible(false);
		RootPanel.get("signup").setVisible(false);
		RootPanel.get("select").setVisible(false);
		RootPanel.get("rec").setVisible(false);
		RootPanel.get("emp").setVisible(false);
		RootPanel.get("first").setVisible(true);
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
