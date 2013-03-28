package edu.lcu.masterfollies.client.ui;

import java.util.List;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.cellview.client.CellTable;
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
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.CheckBox;

public class SuperViewImpl extends Composite implements SuperView {
	private SuperActivity listener;
	private TabLayoutPanel tabLayoutPanel;
	private ListBox listBox_2;
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
		layoutPanel.setSize("722px", "704px");
		
			listBox_2 = new ListBox();
			
			listBox_2.setVisibleItemCount(5);
			layoutPanel.add(listBox_2);
			layoutPanel.setWidgetLeftWidth(listBox_2, 0.0, Unit.PX, 160.0, Unit.PX);
			layoutPanel.setWidgetTopHeight(listBox_2, 24.0, Unit.PX, 160.0, Unit.PX);
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
		
	
		LayoutPanel layoutPanel_1 = new LayoutPanel();
		tabLayoutPanel.add(layoutPanel_1, "Judge", false);
		
		Label lblAddAJudge = new Label("Add a Judge - * indicated reqiured");
		layoutPanel_1.add(lblAddAJudge);
		layoutPanel_1.setWidgetLeftWidth(lblAddAJudge, 0.0, Unit.PX, 477.0, Unit.PX);
		layoutPanel_1.setWidgetTopHeight(lblAddAJudge, 0.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblFirstName = new Label("First Name");
		layoutPanel_1.add(lblFirstName);
		layoutPanel_1.setWidgetLeftWidth(lblFirstName, 0.0, Unit.PX, 75.0, Unit.PX);
		layoutPanel_1.setWidgetTopHeight(lblFirstName, 40.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblLastName = new Label("Last Name");
		layoutPanel_1.add(lblLastName);
		layoutPanel_1.setWidgetLeftWidth(lblLastName, 0.0, Unit.PX, 75.0, Unit.PX);
		layoutPanel_1.setWidgetTopHeight(lblLastName, 71.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblUserName = new Label("User Name*");
		layoutPanel_1.add(lblUserName);
		layoutPanel_1.setWidgetLeftWidth(lblUserName, 0.0, Unit.PX, 75.0, Unit.PX);
		layoutPanel_1.setWidgetTopHeight(lblUserName, 102.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblPassword = new Label("Password*");
		layoutPanel_1.add(lblPassword);
		layoutPanel_1.setWidgetLeftWidth(lblPassword, 0.0, Unit.PX, 75.0, Unit.PX);
		layoutPanel_1.setWidgetTopHeight(lblPassword, 133.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblSuperJudge = new Label("Super Judge");
		layoutPanel_1.add(lblSuperJudge);
		layoutPanel_1.setWidgetLeftWidth(lblSuperJudge, 0.0, Unit.PX, 75.0, Unit.PX);
		layoutPanel_1.setWidgetTopHeight(lblSuperJudge, 157.0, Unit.PX, 18.0, Unit.PX);
		
		TextBox textBoxFirstName = new TextBox();
		layoutPanel_1.add(textBoxFirstName);
		layoutPanel_1.setWidgetLeftWidth(textBoxFirstName, 81.0, Unit.PX, 157.0, Unit.PX);
		layoutPanel_1.setWidgetTopHeight(textBoxFirstName, 33.0, Unit.PX, 25.0, Unit.PX);
		
		TextBox textBoxLastName = new TextBox();
		layoutPanel_1.add(textBoxLastName);
		layoutPanel_1.setWidgetLeftWidth(textBoxLastName, 81.0, Unit.PX, 157.0, Unit.PX);
		layoutPanel_1.setWidgetTopHeight(textBoxLastName, 64.0, Unit.PX, 25.0, Unit.PX);
		
		TextBox textBoxUserName = new TextBox();
		layoutPanel_1.add(textBoxUserName);
		layoutPanel_1.setWidgetLeftWidth(textBoxUserName, 81.0, Unit.PX, 157.0, Unit.PX);
		layoutPanel_1.setWidgetTopHeight(textBoxUserName, 95.0, Unit.PX, 25.0, Unit.PX);
		
		TextBox textBoxPassword = new TextBox();
		layoutPanel_1.add(textBoxPassword);
		layoutPanel_1.setWidgetLeftWidth(textBoxPassword, 81.0, Unit.PX, 157.0, Unit.PX);
		layoutPanel_1.setWidgetTopHeight(textBoxPassword, 126.0, Unit.PX, 25.0, Unit.PX);
		
		CheckBox chckbxCheckOnlyIf = new CheckBox("Check *ONLY* if Super");
		layoutPanel_1.add(chckbxCheckOnlyIf);
		layoutPanel_1.setWidgetLeftWidth(chckbxCheckOnlyIf, 81.0, Unit.PX, 157.0, Unit.PX);
		layoutPanel_1.setWidgetTopHeight(chckbxCheckOnlyIf, 157.0, Unit.PX, 19.0, Unit.PX);
		
		Button btnNewJudge = new Button("Add Judge");
		layoutPanel_1.add(btnNewJudge);
		layoutPanel_1.setWidgetLeftWidth(btnNewJudge, 105.0, Unit.PX, 86.0, Unit.PX);
		layoutPanel_1.setWidgetTopHeight(btnNewJudge, 194.0, Unit.PX, 24.0, Unit.PX);
		
		Label lblCurrentJudgeList = new Label("Current Judge list");
		layoutPanel_1.add(lblCurrentJudgeList);
		layoutPanel_1.setWidgetLeftWidth(lblCurrentJudgeList, 365.0, Unit.PX, 201.0, Unit.PX);
		layoutPanel_1.setWidgetTopHeight(lblCurrentJudgeList, 0.0, Unit.PX, 18.0, Unit.PX);
		
		ListBox listBoxCurrentJudge = new ListBox();
		layoutPanel_1.add(listBoxCurrentJudge);
		layoutPanel_1.setWidgetLeftWidth(listBoxCurrentJudge, 365.0, Unit.PX, 201.0, Unit.PX);
		layoutPanel_1.setWidgetTopHeight(listBoxCurrentJudge, 24.0, Unit.PX, 151.0, Unit.PX);
		listBoxCurrentJudge.setVisibleItemCount(5);
		
		Button btnDeleteJudge = new Button("Delete Judge");
		layoutPanel_1.add(btnDeleteJudge);
		layoutPanel_1.setWidgetLeftWidth(btnDeleteJudge, 401.0, Unit.PX, 115.0, Unit.PX);
		layoutPanel_1.setWidgetTopHeight(btnDeleteJudge, 194.0, Unit.PX, 24.0, Unit.PX);
		

		
		initWidget(tabLayoutPanel);
		tabLayoutPanel.setSize("715px", "580px");
		}
	    
	
    @Override
	public ListBox getListBox_2() {
		return listBox_2;
	}
    
   @Override
	public void displayOrder(List<ClubNames> results) {
		// TODO Auto-generated method stub
		
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


	@Override
	public void setOrder() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setEventBus(HandlerManager eventBus) {
		// TODO Auto-generated method stub
		
	}
}
