package edu.lcu.masterfollies.client.ui;

import java.util.List;
import java.util.Map;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.lcu.masterfollies.shared.Log;

public class SuperViewImpl extends Composite implements SuperView {
	TabLayoutPanel tabLayoutPanel;
	VerticalPanel vp;
	public SuperViewImpl() {
		Log.debug("Starting the SuperViewImpl");
		vp = new VerticalPanel();
		
		vp.setWidth("700px");
		
		TabLayoutPanel tabLayoutPanel = new TabLayoutPanel(1.5, Unit.EM);
		
		LayoutPanel layoutPanel = new LayoutPanel();
		tabLayoutPanel.add(layoutPanel, "New Widget", false);
		
		ListBox listBox_2 = new ListBox();
		listBox_2.setVisibleItemCount(5);
		layoutPanel.add(listBox_2);
		listBox_2.setSize("138px", "255px");
		
		Button button_2 = new Button("<<");
		layoutPanel.add(button_2);
		layoutPanel.setWidgetTopHeight(button_2, 97.0, Unit.PX, 45.0, Unit.PX);
		layoutPanel.setWidgetLeftWidth(button_2, 144.0, Unit.PX, 58.0, Unit.PX);
		
		Button button_3 = new Button(">>");
		layoutPanel.add(button_3);
		layoutPanel.setWidgetTopHeight(button_3, 148.0, Unit.PX, 45.0, Unit.PX);
		layoutPanel.setWidgetLeftWidth(button_3, 144.0, Unit.PX, 58.0, Unit.PX);
		
		ListBox listBox_4 = new ListBox();
		listBox_4.setVisibleItemCount(5);
		layoutPanel.add(listBox_4);
		layoutPanel.setWidgetLeftWidth(listBox_4, 208.0, Unit.PX, 138.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(listBox_4, 0.0, Unit.PX, 255.0, Unit.PX);
		
		Button btnChangeOrder = new Button("Change Order");
		layoutPanel.add(btnChangeOrder);
		layoutPanel.setWidgetLeftWidth(btnChangeOrder, 352.0, Unit.PX, 86.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnChangeOrder, 58.0, Unit.PX, 39.0, Unit.PX);
		
		Button button_4 = new Button("Reset Order");
		button_4.setText("Reset Order");
		layoutPanel.add(button_4);
		layoutPanel.setWidgetLeftWidth(button_4, 352.0, Unit.PX, 86.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(button_4, 103.0, Unit.PX, 39.0, Unit.PX);
		
		initWidget(tabLayoutPanel);
	}

	@Override
	public void displayOrder(List<Map<String, Object>> results) {
		Log.debug("Starting For Loop");
		try {
			for (Map<String,Object> m: results){
				
				String question = (String) m.get("question");
				Log.debug("Question: " + question);
				String description = (String) m.get("description");
				Log.debug("description: " + description);
				final Integer resultId  = (Integer) m.get("id");
				Integer points = (Integer) m.get("points");
				String notes = (String) m.get("notes");
				
				

				
			} // end for loop
		} catch (Exception e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		
			
	} // end method
		
	

	@Override
	public void setOrder() {
		
	}
		
}
