package com.employee.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialLink;

public class uifirst extends Composite implements HasText {

	private static uifirstUiBinder uiBinder = GWT.create(uifirstUiBinder.class);
	GreetingServiceAsync a1 = GWT.create(GreetingService.class);

	interface uifirstUiBinder extends UiBinder<Widget, uifirst> {
	}

	@UiField
	MaterialLink su;
	@UiField
	MaterialLink si;

	public uifirst() {
		initWidget(uiBinder.createAndBindUi(this));
		su.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				RootPanel.get("first").setVisible(false);
				RootPanel.get("signin").setVisible(false);
				RootPanel.get("signup").setVisible(true);
				//RootPanel.get("select").setVisible(false);
				//RootPanel.get("rec").setVisible(false);
				//RootPanel.get("emp").setVisible(false);
			}
		});
		si.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				RootPanel.get("first").setVisible(false);
				RootPanel.get("signup").setVisible(false);
				//RootPanel.get("select").setVisible(false);
				//RootPanel.get("rec").setVisible(false);
				//RootPanel.get("emp").setVisible(false);
				RootPanel.get("signin").setVisible(true);
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
