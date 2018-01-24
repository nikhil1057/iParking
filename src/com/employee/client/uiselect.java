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

import gwt.material.design.addins.client.overlay.MaterialOverlay;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLink;

public class uiselect extends Composite implements HasText {

	private static uiselectUiBinder uiBinder = GWT.create(uiselectUiBinder.class);
	GreetingServiceAsync a1=GWT.create(GreetingService.class);
	
   // @UiField MaterialOverlay overlay;
    @UiField MaterialLink rec;
    @UiField MaterialLink emp;
   // @UiField MaterialButton btnclose;
	//@UiField MaterialLink card;
	@UiField MaterialLink home;
	interface uiselectUiBinder extends UiBinder<Widget, uiselect> {
	}

	public uiselect() {
		initWidget(uiBinder.createAndBindUi(this));
		home.addClickHandler(new ClickHandler() {
			
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
		/*
		card.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				overlay.open(card);
			}
		});
		*/
		
		rec.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				RootPanel.get("emp").setVisible(false);
				RootPanel.get("first").setVisible(false);
				RootPanel.get("signin").setVisible(false);
				RootPanel.get("signup").setVisible(false);
				RootPanel.get("select").setVisible(false);
				RootPanel.get("rec").setVisible(true);
			}
		});
		emp.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				RootPanel.get("first").setVisible(false);
				RootPanel.get("signin").setVisible(false);
				RootPanel.get("signup").setVisible(false);
				RootPanel.get("select").setVisible(false);
				RootPanel.get("rec").setVisible(false);
				RootPanel.get("emp").setVisible(true);
			}
		});
		/*
		btnclose.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				overlay.close();
			}
		});
         */
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
