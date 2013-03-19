package edu.lcu.masterfollies.client.ui;

import java.util.List;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TabLayoutPanel;

import edu.lcu.masterfollies.client.activity.SuperActivity;
import edu.lcu.masterfollies.domain.ClubNames;
import edu.lcu.masterfollies.shared.Log;

public class SuperViewImpl extends Composite implements SuperView {
	private SuperActivity listener;
	private TabLayoutPanel tabLayoutPanel;
	private ListBox listBox_2;
	private FlexTable flexTable;
	private Button btnDownArrow;
	private Button btnUpArrow;
	
	/**
	 * 
	 */
    public SuperViewImpl() {
		Log.debug("Starting the SuperViewImpl");
		tabLayoutPanel = new TabLayoutPanel(1.5, Unit.EM);
		
		LayoutPanel layoutPanel = new LayoutPanel();
		tabLayoutPanel.add(layoutPanel, "Club", false);
		layoutPanel.setHeight("704px");
		
			listBox_2 = new ListBox();
			
			listBox_2.setVisibleItemCount(20);
			layoutPanel.add(listBox_2);
			layoutPanel.setWidgetLeftWidth(listBox_2, 0.0, Unit.PX, 160.0, Unit.PX);
			layoutPanel.setWidgetTopHeight(listBox_2, 24.0, Unit.PX, 164.0, Unit.PX);
			listBox_2.setSize("160px", "160px");
			
			btnDownArrow = new Button("&#8595;");
			layoutPanel.add(btnDownArrow);
			layoutPanel.setWidgetTopHeight(btnDownArrow, 105.0, Unit.PX, 45.0, Unit.PX);
			layoutPanel.setWidgetLeftWidth(btnDownArrow, 166.0, Unit.PX, 41.0, Unit.PX);
			
			Label lblClubShowOrder = new Label("Club Show Order");
			layoutPanel.add(lblClubShowOrder);
			layoutPanel.setWidgetLeftWidth(lblClubShowOrder, 0.0, Unit.PX, 138.0, Unit.PX);
			layoutPanel.setWidgetTopHeight(lblClubShowOrder, 0.0, Unit.PX, 18.0, Unit.PX);
			
			btnUpArrow = new Button("&#8593;");
			layoutPanel.add(btnUpArrow);
			layoutPanel.setWidgetLeftWidth(btnUpArrow, 166.0, Unit.PX, 41.0, Unit.PX);
			layoutPanel.setWidgetTopHeight(btnUpArrow, 54.0, Unit.PX, 45.0, Unit.PX);
			listBox_2.clear();
			
		    flexTable = new FlexTable();
			layoutPanel.add(flexTable);
			//layoutPanel.setWidgetTopHeight(flexTable, 24.0, Unit.PX, 24.0, Unit.PX);
			flexTable.setWidth("160px");
			layoutPanel.setWidgetLeftWidth(flexTable, 223.0, Unit.PX, 160.0, Unit.PX);
			
	
		LayoutPanel layoutPanel_1 = new LayoutPanel();
		tabLayoutPanel.add(layoutPanel_1, "Judge", false);
		
		initWidget(tabLayoutPanel);
		tabLayoutPanel.setHeight("302px");
		}
	    
	
    @Override
	public ListBox getListBox_2() {
		return listBox_2;
	}

    @Override
	public FlexTable getFlexTable() {
		// TODO Auto-generated method stub
		return flexTable;
	}
    
   @Override
	public void displayOrder(List<ClubNames> results) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOrder() {
		
	}

	@Override
	public void setEventBus(HandlerManager eventBus) {
		// Auto-generated method stub
		
	}

	@Override
	public void setPresenter(SuperActivity superActivity) {
		Log.debug("SuperViewImpl setPresenter");
		listener = superActivity;
		
	}

	@Override
	public TabLayoutPanel getTabLayoutPanel() {
		// Auto-generated method stub
		return tabLayoutPanel;
	}


	@Override
	public HasClickHandlers getUpArrow() {
		return btnUpArrow;
	}


	@Override
	public HasClickHandlers getDownArrow() {
		return btnDownArrow;
	}


	
}
