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

import gwt.material.design.addins.client.overlay.MaterialOverlay;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

public class uisignup extends Composite implements HasText {

	private static uisignupUiBinder uiBinder = GWT.create(uisignupUiBinder.class);
	GreetingServiceAsync a1=GWT.create(GreetingService.class);

	interface uisignupUiBinder extends UiBinder<Widget, uisignup> {
	}
    @UiField MaterialTextBox p1;
    @UiField MaterialTextBox p2;
    @UiField MaterialTextBox p3;
    @UiField MaterialTextBox p4;
    @UiField MaterialTextBox p5;
    @UiField MaterialButton b1;
    @UiField MaterialLink link1;
	public uisignup() {
		initWidget(uiBinder.createAndBindUi(this));
		link1.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub

				RootPanel.get("signin").setVisible(false);
				RootPanel.get("signup").setVisible(false);
				RootPanel.get("select").setVisible(false);
				RootPanel.get("rec").setVisible(false);
				RootPanel.get("emp").setVisible(false);
				RootPanel.get("first").setVisible(true);
			}
		});
		b1.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub\
				String s1=p1.getText();
				String s2=p2.getText();
				String s3=p3.getText();
				String s4=p4.getText();
				String s5=p5.getText();
				
				a1.signup(s1,s2,s3,s4,s5,new AsyncCallback<String>() {
					
					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						MaterialToast.fireToast(result);
						if(result.equals("Signed In"))
						{

						RootPanel.get("first").setVisible(false);
						RootPanel.get("signin").setVisible(false);
						RootPanel.get("signup").setVisible(false);
						RootPanel.get("rec").setVisible(false);
						RootPanel.get("emp").setVisible(false);
						RootPanel.get("select").setVisible(true);
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
