package edu.lcu.masterfollies.client.ui;

import java.util.List;
import java.util.Map;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimpleRadioButton;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.TabBar;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.lcu.masterfollies.domain.Results;
import edu.lcu.masterfollies.shared.Log;

public class ResultsViewImpl extends Composite implements ResultsView {
	StackLayoutPanel stackLayoutPanel;
	HTMLPanel panel;
	
	public ResultsViewImpl() {
		
		stackLayoutPanel = new StackLayoutPanel(Unit.EM);
		
		
		
		
		initWidget(stackLayoutPanel);
	}

	@Override
	public void setLblTitle(String string) {
		// TODO Auto-generated method stub
		
	}
	


	@Override
	public void setListener(Presenter listener) {
		// TODO Auto-generated method stub
		
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

	@Override
	public void setResults(List<Map<String, String>> results) {
		Log.debug("Starting For Loop");
		panel = new HTMLPanel("");
		for (Map<String,String> m: results){
			
			String question = m.get("question");
			Log.debug("Question: " + question);
			String desc = m.get("desc");
			Log.debug("desc: " + desc);
			HorizontalPanel horizontalPanel = new HorizontalPanel();
			panel.add(horizontalPanel);
			horizontalPanel.setSize("442px", "41px");
			
			HTML htmlDescHtml = new HTML("desc HTML", true);
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
			
			SimpleRadioButton simpleRadioButton_1 = new SimpleRadioButton("new name");
			verticalPanel_1.add(simpleRadioButton_1);
			
			Label label_1 = new Label("1");
			label_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			label_1.setDirection(Direction.RTL);
			verticalPanel_1.add(label_1);
			verticalPanel_1.setCellHorizontalAlignment(label_1, HasHorizontalAlignment.ALIGN_CENTER);
			
			VerticalPanel verticalPanel_2 = new VerticalPanel();
			horizontalPanel_1.add(verticalPanel_2);
			
			SimpleRadioButton simpleRadioButton_2 = new SimpleRadioButton("new name");
			verticalPanel_2.add(simpleRadioButton_2);
			
			Label label_2 = new Label("2");
			label_2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			label_2.setDirection(Direction.RTL);
			verticalPanel_2.add(label_2);
			
			VerticalPanel verticalPanel_3 = new VerticalPanel();
			horizontalPanel_1.add(verticalPanel_3);
			
			SimpleRadioButton simpleRadioButton_3 = new SimpleRadioButton("new name");
			verticalPanel_3.add(simpleRadioButton_3);
			
			Label label_3 = new Label("3");
			label_3.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			label_3.setDirection(Direction.RTL);
			verticalPanel_3.add(label_3);
			
			VerticalPanel verticalPanel_4 = new VerticalPanel();
			horizontalPanel_1.add(verticalPanel_4);
			
			SimpleRadioButton simpleRadioButton_4 = new SimpleRadioButton("new name");
			verticalPanel_4.add(simpleRadioButton_4);
			
			Label label_4 = new Label("4");
			label_4.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			label_4.setDirection(Direction.RTL);
			verticalPanel_4.add(label_4);
			
			VerticalPanel verticalPanel_5 = new VerticalPanel();
			horizontalPanel_1.add(verticalPanel_5);
			
			SimpleRadioButton simpleRadioButton_5 = new SimpleRadioButton("new name");
			verticalPanel_5.add(simpleRadioButton_5);
			
			Label label_5 = new Label("5");
			label_5.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			label_5.setDirection(Direction.RTL);
			verticalPanel_5.add(label_5);
			
			VerticalPanel verticalPanel_6 = new VerticalPanel();
			horizontalPanel_1.add(verticalPanel_6);
			
			SimpleRadioButton simpleRadioButton_6 = new SimpleRadioButton("new name");
			verticalPanel_6.add(simpleRadioButton_6);
			
			Label label_6 = new Label("6");
			label_6.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			label_6.setDirection(Direction.RTL);
			verticalPanel_6.add(label_6);
			
			VerticalPanel verticalPanel_7 = new VerticalPanel();
			horizontalPanel_1.add(verticalPanel_7);
			
			SimpleRadioButton simpleRadioButton_7 = new SimpleRadioButton("new name");
			verticalPanel_7.add(simpleRadioButton_7);
			
			Label label_7 = new Label("7");
			label_7.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			label_7.setDirection(Direction.RTL);
			verticalPanel_7.add(label_7);
			
			VerticalPanel verticalPanel_8 = new VerticalPanel();
			horizontalPanel_1.add(verticalPanel_8);
			
			SimpleRadioButton simpleRadioButton_8 = new SimpleRadioButton("new name");
			verticalPanel_8.add(simpleRadioButton_8);
			
			Label label_8 = new Label("8");
			label_8.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			label_8.setDirection(Direction.RTL);
			verticalPanel_8.add(label_8);
			
			VerticalPanel verticalPanel_9 = new VerticalPanel();
			horizontalPanel_1.add(verticalPanel_9);
			
			SimpleRadioButton simpleRadioButton_9 = new SimpleRadioButton("new name");
			verticalPanel_9.add(simpleRadioButton_9);
			
			Label label_9 = new Label("9");
			label_9.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			label_9.setDirection(Direction.RTL);
			verticalPanel_9.add(label_9);
			
			VerticalPanel verticalPanel_10 = new VerticalPanel();
			horizontalPanel_1.add(verticalPanel_10);
			
			SimpleRadioButton simpleRadioButton_10 = new SimpleRadioButton("new name");
			verticalPanel_10.add(simpleRadioButton_10);
			
			Label label_10 = new Label("10");
			label_10.setDirection(Direction.RTL);
			verticalPanel_10.add(label_10);
			
			Label label = new Label("Excellent");
			label.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			horizontalPanel_1.add(label);
			horizontalPanel_1.setCellHorizontalAlignment(label, HasHorizontalAlignment.ALIGN_CENTER);
			horizontalPanel_1.setCellVerticalAlignment(label, HasVerticalAlignment.ALIGN_MIDDLE);
			panel = new HTMLPanel("");
			stackLayoutPanel.add(panel, new HTML(question), 3.0);
			
		}
		
	}

	

}
