package edu.lcu.masterfollies.client.ui;

import java.util.List;
import java.util.Map;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.SimpleRadioButton;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.TabBar;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.lcu.masterfollies.domain.Results;
import edu.lcu.masterfollies.shared.Log;

public class ResultsViewImpl extends Composite implements ResultsView {
	StackLayoutPanel stackLayoutPanel;
	HTMLPanel panel;
	private Presenter listener;
	
	public ResultsViewImpl() {
		
		stackLayoutPanel = new StackLayoutPanel(Unit.EM);
		
//		HTMLPanel panel_1 = new HTMLPanel("New HTML");
//		
//		HorizontalPanel horizontalPanel = new HorizontalPanel();
//		panel_1.add(horizontalPanel);
//		horizontalPanel.setSize("518px", "146px");
//		
//		VerticalPanel verticalPanel = new VerticalPanel();
//		horizontalPanel.add(verticalPanel);
//		verticalPanel.setHeight("109px");
//		
//		SimpleRadioButton simpleRadioButton = new SimpleRadioButton("new name");
//		verticalPanel.add(simpleRadioButton);
//		
//		VerticalPanel verticalPanel_1 = new VerticalPanel();
//		horizontalPanel.add(verticalPanel_1);
//		verticalPanel_1.setHeight("109px");
//		
//		SimpleRadioButton simpleRadioButton_1 = new SimpleRadioButton("new name");
//		verticalPanel_1.add(simpleRadioButton_1);
//		
//		VerticalPanel verticalPanel_2 = new VerticalPanel();
//		horizontalPanel.add(verticalPanel_2);
//		verticalPanel_2.setHeight("109px");
//		
//		SimpleRadioButton simpleRadioButton_2 = new SimpleRadioButton("new name");
//		verticalPanel_2.add(simpleRadioButton_2);
//		stackLayoutPanel.add(panel_1, new HTML("New Widget"), 2.0);
//		
//		HTMLPanel panel_2 = new HTMLPanel("New HTML");
//		stackLayoutPanel.add(panel_2, new HTML("New Widget"), 2.0);
//		
//		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
//		panel_2.add(horizontalPanel_1);
//		horizontalPanel_1.setSize("495px", "217px");
//		
//		VerticalPanel verticalPanel_3 = new VerticalPanel();
//		horizontalPanel_1.add(verticalPanel_3);
//		verticalPanel_3.setHeight("127px");
//		
//		RadioButton radioButton = new RadioButton("new name", "");
//		verticalPanel_3.add(radioButton);
//		
//		VerticalPanel verticalPanel_4 = new VerticalPanel();
//		horizontalPanel_1.add(verticalPanel_4);
//		verticalPanel_4.setHeight("127px");
//		
//		RadioButton radioButton_1 = new RadioButton("new name", "New radio button");
//		verticalPanel_4.add(radioButton_1);
		//RootLayoutPanel rp = RootLayoutPanel.get();
		//rp.add(stackLayoutPanel);

		initWidget(stackLayoutPanel);
		stackLayoutPanel.setHeight("750px");
	}

	@Override
	public void setResults(List<Map<String, String>> results) {
		Log.debug("Starting For Loop");
		
		for (Map<String,String> m: results){
			
			String question = m.get("question");
			Log.debug("Question: " + question);
			String desc = m.get("desc");
			Log.debug("desc: " + desc);
			String resultId  = m.get("id");
			
			//stackLayoutPanel = new StackLayoutPanel(Unit.EM);
			stackLayoutPanel.setHeight("450px");
			panel = new HTMLPanel("");
			HorizontalPanel horizontalPanel = new HorizontalPanel();
			panel.add(horizontalPanel);
			horizontalPanel.setSize("442px", "41px");
			
			HTML htmlDescHtml = new HTML(desc, true);
			horizontalPanel.add(htmlDescHtml);
			
			HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
			panel.add(horizontalPanel_1);
			horizontalPanel_1.setSize("443px", "25px");
			
			Label label_11 = new Label("Poor");
			label_11.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			horizontalPanel_1.add(label_11);
			horizontalPanel_1.setCellVerticalAlignment(label_11, HasVerticalAlignment.ALIGN_MIDDLE);
			
			VerticalPanel verticalPanel_1 = new VerticalPanel();
			horizontalPanel_1.add(verticalPanel_1);
			
			SimpleRadioButton simpleRadioButton_1 = new SimpleRadioButton("Radiobutton_1_" + resultId);
			verticalPanel_1.add(simpleRadioButton_1);
			simpleRadioButton_1.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					SimpleRadioButton x = (SimpleRadioButton) event.getSource();
					listener.updateResultsPoints(x.getName());
					
				}
			});
			
			Label label_1 = new Label("1");
			label_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			label_1.setDirection(Direction.RTL);
			verticalPanel_1.add(label_1);
			verticalPanel_1.setCellHorizontalAlignment(label_1, HasHorizontalAlignment.ALIGN_CENTER);
			
			VerticalPanel verticalPanel_2 = new VerticalPanel();
			horizontalPanel_1.add(verticalPanel_2);
			
			SimpleRadioButton simpleRadioButton_2 = new SimpleRadioButton("Radiobutton_2_" + resultId);
			verticalPanel_2.add(simpleRadioButton_2);
			simpleRadioButton_2.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					SimpleRadioButton x = (SimpleRadioButton) event.getSource();
					listener.updateResultsPoints(x.getName());
					
				}
			});
			
			Label label_2 = new Label("2");
			label_2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			label_2.setDirection(Direction.RTL);
			verticalPanel_2.add(label_2);
			
			VerticalPanel verticalPanel_3 = new VerticalPanel();
			horizontalPanel_1.add(verticalPanel_3);
			
			SimpleRadioButton simpleRadioButton_3 = new SimpleRadioButton("Radiobutton_3_" + resultId);
			verticalPanel_3.add(simpleRadioButton_3);
			simpleRadioButton_3.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					SimpleRadioButton x = (SimpleRadioButton) event.getSource();
					listener.updateResultsPoints(x.getName());
					
				}
			});
			
			Label label_3 = new Label("3");
			label_3.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			label_3.setDirection(Direction.RTL);
			verticalPanel_3.add(label_3);
			
			VerticalPanel verticalPanel_4 = new VerticalPanel();
			horizontalPanel_1.add(verticalPanel_4);
			
			SimpleRadioButton simpleRadioButton_4 = new SimpleRadioButton("Radiobutton_4_" + resultId);
			verticalPanel_4.add(simpleRadioButton_4);
			simpleRadioButton_4.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					SimpleRadioButton x = (SimpleRadioButton) event.getSource();
					listener.updateResultsPoints(x.getName());
					
				}
			});
			
			Label label_4 = new Label("4");
			label_4.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			label_4.setDirection(Direction.RTL);
			verticalPanel_4.add(label_4);
			
			VerticalPanel verticalPanel_5 = new VerticalPanel();
			horizontalPanel_1.add(verticalPanel_5);
			
			SimpleRadioButton simpleRadioButton_5 = new SimpleRadioButton("Radiobutton_5_" + resultId);
			verticalPanel_5.add(simpleRadioButton_5);
			simpleRadioButton_5.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					SimpleRadioButton x = (SimpleRadioButton) event.getSource();
					listener.updateResultsPoints(x.getName());
					
				}
			});
			
			Label label_5 = new Label("5");
			label_5.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			label_5.setDirection(Direction.RTL);
			verticalPanel_5.add(label_5);
			
			VerticalPanel verticalPanel_6 = new VerticalPanel();
			horizontalPanel_1.add(verticalPanel_6);
			
			SimpleRadioButton simpleRadioButton_6 = new SimpleRadioButton("Radiobutton_6_" + resultId);
			verticalPanel_6.add(simpleRadioButton_6);
			simpleRadioButton_6.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					SimpleRadioButton x = (SimpleRadioButton) event.getSource();
					listener.updateResultsPoints(x.getName());
					
				}
			});
			
			Label label_6 = new Label("6");
			label_6.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			label_6.setDirection(Direction.RTL);
			verticalPanel_6.add(label_6);
			
			VerticalPanel verticalPanel_7 = new VerticalPanel();
			horizontalPanel_1.add(verticalPanel_7);
			
			SimpleRadioButton simpleRadioButton_7 = new SimpleRadioButton("Radiobutton_7_" + resultId);
			verticalPanel_7.add(simpleRadioButton_7);
			simpleRadioButton_7.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					SimpleRadioButton x = (SimpleRadioButton) event.getSource();
					listener.updateResultsPoints(x.getName());
					
				}
			});
			
			Label label_7 = new Label("7");
			label_7.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			label_7.setDirection(Direction.RTL);
			verticalPanel_7.add(label_7);
			
			VerticalPanel verticalPanel_8 = new VerticalPanel();
			horizontalPanel_1.add(verticalPanel_8);
			
			SimpleRadioButton simpleRadioButton_8 = new SimpleRadioButton("Radiobutton_8_" + resultId);
			verticalPanel_8.add(simpleRadioButton_8);
			simpleRadioButton_8.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					SimpleRadioButton x = (SimpleRadioButton) event.getSource();
					listener.updateResultsPoints(x.getName());
					
				}
			});
			
			Label label_8 = new Label("8");
			label_8.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			label_8.setDirection(Direction.RTL);
			verticalPanel_8.add(label_8);
			
			VerticalPanel verticalPanel_9 = new VerticalPanel();
			horizontalPanel_1.add(verticalPanel_9);
			
			SimpleRadioButton simpleRadioButton_9 = new SimpleRadioButton("Radiobutton_9_" + resultId);
			verticalPanel_9.add(simpleRadioButton_9);
			simpleRadioButton_9.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					SimpleRadioButton x = (SimpleRadioButton) event.getSource();
					listener.updateResultsPoints(x.getName());
					
				}
			});
			
			Label label_9 = new Label("9");
			label_9.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			label_9.setDirection(Direction.RTL);
			verticalPanel_9.add(label_9);
			
			VerticalPanel verticalPanel_10 = new VerticalPanel();
			horizontalPanel_1.add(verticalPanel_10);
			
			SimpleRadioButton simpleRadioButton_10 = new SimpleRadioButton("Radiobutton_10_" + resultId);
			verticalPanel_10.add(simpleRadioButton_10);
			simpleRadioButton_10.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					SimpleRadioButton x = (SimpleRadioButton) event.getSource();
					listener.updateResultsPoints(x.getName());
					
				}
			});
			
			
			Label label_10 = new Label("10");
			label_10.setDirection(Direction.RTL);
			verticalPanel_10.add(label_10);
			
			Label label = new Label("Excellent");
			label.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			horizontalPanel_1.add(label);
			horizontalPanel_1.setCellHorizontalAlignment(label, HasHorizontalAlignment.ALIGN_CENTER);
			horizontalPanel_1.setCellVerticalAlignment(label, HasVerticalAlignment.ALIGN_MIDDLE);
			//panel = new HTMLPanel("");
			stackLayoutPanel.add(panel, new HTML(question), 3.0);
			// Chrismahanukwanzakah
			
		} // end for loop
		
			
	} // end method

	@Override
	public void setLblTitle(String string) {
		// TODO Auto-generated method stub
		
	}
	


	@Override
	public void setListener(Presenter listener) {
		this.listener = listener;
		
	}

	@Override
	public CellTable<Results> getTblResultsList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTab() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TabBar getTabBar() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
