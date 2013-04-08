package edu.lcu.masterfollies.client.ui;

import java.util.List;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;

import edu.lcu.masterfollies.client.activity.SuperActivity;
import edu.lcu.masterfollies.domain.ClubNames;
import edu.lcu.masterfollies.shared.Log;

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
		
		LayoutPanel layoutPanelClub = new LayoutPanel();
		tabLayoutPanel.add(layoutPanelClub, "Club", false);
		layoutPanelClub.setSize("722px", "704px");
		
			listBox_2 = new ListBox();
			
			listBox_2.setVisibleItemCount(5);
			layoutPanelClub.add(listBox_2);
			layoutPanelClub.setWidgetLeftWidth(listBox_2, 322.0, Unit.PX, 172.0, Unit.PX);
			layoutPanelClub.setWidgetTopHeight(listBox_2, 35.0, Unit.PX, 160.0, Unit.PX);
			listBox_2.setSize("160px", "160px");
			
			btnDownArrow = new Button("&#8595;");
			layoutPanelClub.add(btnDownArrow);
			layoutPanelClub.setWidgetTopHeight(btnDownArrow, 116.0, Unit.PX, 45.0, Unit.PX);
			layoutPanelClub.setWidgetLeftWidth(btnDownArrow, 499.0, Unit.PX, 41.0, Unit.PX);
			
			Label lblClubShowOrder = new Label("Club Show Order");
			layoutPanelClub.add(lblClubShowOrder);
			layoutPanelClub.setWidgetLeftWidth(lblClubShowOrder, 333.0, Unit.PX, 138.0, Unit.PX);
			layoutPanelClub.setWidgetTopHeight(lblClubShowOrder, 11.0, Unit.PX, 18.0, Unit.PX);
			
			btnUpArrow = new Button("&#8593;");
			layoutPanelClub.add(btnUpArrow);
			layoutPanelClub.setWidgetLeftWidth(btnUpArrow, 499.0, Unit.PX, 41.0, Unit.PX);
			layoutPanelClub.setWidgetTopHeight(btnUpArrow, 65.0, Unit.PX, 45.0, Unit.PX);
			listBox_2.clear();
			
			Label lblAdddeleteAClub = new Label("Add/Delete a Club");
			layoutPanelClub.add(lblAdddeleteAClub);
			layoutPanelClub.setWidgetLeftWidth(lblAdddeleteAClub, 21.0, Unit.PX, 174.0, Unit.PX);
			layoutPanelClub.setWidgetTopHeight(lblAdddeleteAClub, 11.0, Unit.PX, 18.0, Unit.PX);
			
			Label lblClubName = new Label("Club Name");
			layoutPanelClub.add(lblClubName);
			layoutPanelClub.setWidgetLeftWidth(lblClubName, 21.0, Unit.PX, 67.0, Unit.PX);
			layoutPanelClub.setWidgetTopHeight(lblClubName, 35.0, Unit.PX, 18.0, Unit.PX);
			
			Label lblContactEmail = new Label("Contact Email");
			layoutPanelClub.add(lblContactEmail);
			layoutPanelClub.setWidgetLeftWidth(lblContactEmail, 21.0, Unit.PX, 96.0, Unit.PX);
			layoutPanelClub.setWidgetTopHeight(lblContactEmail, 74.0, Unit.PX, 18.0, Unit.PX);
			
			CheckBox chckbxCheckIfClub = new CheckBox("Check if Club is Girls");
			layoutPanelClub.add(chckbxCheckIfClub);
			layoutPanelClub.setWidgetLeftWidth(chckbxCheckIfClub, 132.0, Unit.PX, 213.0, Unit.PX);
			layoutPanelClub.setWidgetTopHeight(chckbxCheckIfClub, 98.0, Unit.PX, 19.0, Unit.PX);
			
			TextBox textBoxClubName = new TextBox();
			layoutPanelClub.add(textBoxClubName);
			layoutPanelClub.setWidgetLeftWidth(textBoxClubName, 132.0, Unit.PX, 143.0, Unit.PX);
			layoutPanelClub.setWidgetTopHeight(textBoxClubName, 35.0, Unit.PX, 25.0, Unit.PX);
			
			TextBox textBoxContactInfo = new TextBox();
			layoutPanelClub.add(textBoxContactInfo);
			layoutPanelClub.setWidgetLeftWidth(textBoxContactInfo, 132.0, Unit.PX, 143.0, Unit.PX);
			layoutPanelClub.setWidgetTopHeight(textBoxContactInfo, 67.0, Unit.PX, 25.0, Unit.PX);
			
			Button btnAddClub = new Button("Add Club");
			layoutPanelClub.add(btnAddClub);
			layoutPanelClub.setWidgetLeftWidth(btnAddClub, 44.0, Unit.PX, 86.0, Unit.PX);
			layoutPanelClub.setWidgetTopHeight(btnAddClub, 160.0, Unit.PX, 24.0, Unit.PX);
			
			Button btnDeleteClub = new Button("Delete Club");
			layoutPanelClub.add(btnDeleteClub);
			layoutPanelClub.setWidgetLeftWidth(btnDeleteClub, 160.0, Unit.PX, 86.0, Unit.PX);
			layoutPanelClub.setWidgetTopHeight(btnDeleteClub, 160.0, Unit.PX, 24.0, Unit.PX);
		
	
		LayoutPanel layoutPanelJudge = new LayoutPanel();
		tabLayoutPanel.add(layoutPanelJudge, "Judge", false);
		
		Label lblAddAJudge = new Label("Add a Judge - * indicated reqiured");
		layoutPanelJudge.add(lblAddAJudge);
		layoutPanelJudge.setWidgetLeftWidth(lblAddAJudge, 19.0, Unit.PX, 236.0, Unit.PX);
		layoutPanelJudge.setWidgetTopHeight(lblAddAJudge, 11.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblFirstName = new Label("First Name");
		layoutPanelJudge.add(lblFirstName);
		layoutPanelJudge.setWidgetLeftWidth(lblFirstName, 19.0, Unit.PX, 75.0, Unit.PX);
		layoutPanelJudge.setWidgetTopHeight(lblFirstName, 51.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblLastName = new Label("Last Name");
		layoutPanelJudge.add(lblLastName);
		layoutPanelJudge.setWidgetLeftWidth(lblLastName, 19.0, Unit.PX, 75.0, Unit.PX);
		layoutPanelJudge.setWidgetTopHeight(lblLastName, 82.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblUserName = new Label("User Name*");
		layoutPanelJudge.add(lblUserName);
		layoutPanelJudge.setWidgetLeftWidth(lblUserName, 19.0, Unit.PX, 75.0, Unit.PX);
		layoutPanelJudge.setWidgetTopHeight(lblUserName, 113.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblPassword = new Label("Password*");
		layoutPanelJudge.add(lblPassword);
		layoutPanelJudge.setWidgetLeftWidth(lblPassword, 19.0, Unit.PX, 75.0, Unit.PX);
		layoutPanelJudge.setWidgetTopHeight(lblPassword, 144.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblSuperJudge = new Label("Super Judge");
		layoutPanelJudge.add(lblSuperJudge);
		layoutPanelJudge.setWidgetLeftWidth(lblSuperJudge, 19.0, Unit.PX, 75.0, Unit.PX);
		layoutPanelJudge.setWidgetTopHeight(lblSuperJudge, 168.0, Unit.PX, 18.0, Unit.PX);
		
		TextBox textBoxFirstName = new TextBox();
		layoutPanelJudge.add(textBoxFirstName);
		layoutPanelJudge.setWidgetLeftWidth(textBoxFirstName, 100.0, Unit.PX, 157.0, Unit.PX);
		layoutPanelJudge.setWidgetTopHeight(textBoxFirstName, 44.0, Unit.PX, 25.0, Unit.PX);
		
		TextBox textBoxLastName = new TextBox();
		layoutPanelJudge.add(textBoxLastName);
		layoutPanelJudge.setWidgetLeftWidth(textBoxLastName, 100.0, Unit.PX, 157.0, Unit.PX);
		layoutPanelJudge.setWidgetTopHeight(textBoxLastName, 75.0, Unit.PX, 25.0, Unit.PX);
		
		TextBox textBoxUserName = new TextBox();
		layoutPanelJudge.add(textBoxUserName);
		layoutPanelJudge.setWidgetLeftWidth(textBoxUserName, 100.0, Unit.PX, 157.0, Unit.PX);
		layoutPanelJudge.setWidgetTopHeight(textBoxUserName, 106.0, Unit.PX, 25.0, Unit.PX);
		
		TextBox textBoxPassword = new TextBox();
		layoutPanelJudge.add(textBoxPassword);
		layoutPanelJudge.setWidgetLeftWidth(textBoxPassword, 100.0, Unit.PX, 157.0, Unit.PX);
		layoutPanelJudge.setWidgetTopHeight(textBoxPassword, 137.0, Unit.PX, 25.0, Unit.PX);
		
		CheckBox chckbxCheckOnlyIf = new CheckBox("Check *ONLY* if Super");
		layoutPanelJudge.add(chckbxCheckOnlyIf);
		layoutPanelJudge.setWidgetLeftWidth(chckbxCheckOnlyIf, 100.0, Unit.PX, 201.0, Unit.PX);
		layoutPanelJudge.setWidgetTopHeight(chckbxCheckOnlyIf, 168.0, Unit.PX, 19.0, Unit.PX);
		
		Button btnNewJudge = new Button("Add Judge");
		layoutPanelJudge.add(btnNewJudge);
		layoutPanelJudge.setWidgetLeftWidth(btnNewJudge, 30.0, Unit.PX, 86.0, Unit.PX);
		layoutPanelJudge.setWidgetTopHeight(btnNewJudge, 205.0, Unit.PX, 24.0, Unit.PX);
		
		Label lblCurrentJudgeList = new Label("Current Judge list");
		layoutPanelJudge.add(lblCurrentJudgeList);
		layoutPanelJudge.setWidgetLeftWidth(lblCurrentJudgeList, 365.0, Unit.PX, 201.0, Unit.PX);
		layoutPanelJudge.setWidgetTopHeight(lblCurrentJudgeList, 11.0, Unit.PX, 18.0, Unit.PX);
		
		ListBox listBoxCurrentJudge = new ListBox();
		layoutPanelJudge.add(listBoxCurrentJudge);
		layoutPanelJudge.setWidgetLeftWidth(listBoxCurrentJudge, 365.0, Unit.PX, 201.0, Unit.PX);
		layoutPanelJudge.setWidgetTopHeight(listBoxCurrentJudge, 35.0, Unit.PX, 151.0, Unit.PX);
		listBoxCurrentJudge.setVisibleItemCount(5);
		
		Button btnDeleteJudge = new Button("Delete Judge");
		layoutPanelJudge.add(btnDeleteJudge);
		layoutPanelJudge.setWidgetLeftWidth(btnDeleteJudge, 131.0, Unit.PX, 115.0, Unit.PX);
		layoutPanelJudge.setWidgetTopHeight(btnDeleteJudge, 205.0, Unit.PX, 24.0, Unit.PX);
		
		LayoutPanel layoutPanelData = new LayoutPanel();
		tabLayoutPanel.add(layoutPanelData, "Data", false);
		
		Button btnDelete = new Button("Delete");
		layoutPanelData.add(btnDelete);
		layoutPanelData.setWidgetLeftWidth(btnDelete, 313.0, Unit.PX, 86.0, Unit.PX);
		layoutPanelData.setWidgetTopHeight(btnDelete, 203.0, Unit.PX, 24.0, Unit.PX);
		
		Label lblDeleteWarning = new Label("By clicking the button below, you will delete the data in the database that has the judge results");
		layoutPanelData.add(lblDeleteWarning);
		layoutPanelData.setWidgetLeftWidth(lblDeleteWarning, 13.0, Unit.PX, 698.0, Unit.PX);
		layoutPanelData.setWidgetTopHeight(lblDeleteWarning, 170.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblEmailJudgeNotes = new Label("Email judge notes ");
		layoutPanelData.add(lblEmailJudgeNotes);
		layoutPanelData.setWidgetLeftWidth(lblEmailJudgeNotes, 13.0, Unit.PX, 132.0, Unit.PX);
		layoutPanelData.setWidgetTopHeight(lblEmailJudgeNotes, 11.0, Unit.PX, 18.0, Unit.PX);
		
		TextBox textBoxNotesEmail = new TextBox();
		layoutPanelData.add(textBoxNotesEmail);
		layoutPanelData.setWidgetLeftWidth(textBoxNotesEmail, 151.0, Unit.PX, 156.0, Unit.PX);
		layoutPanelData.setWidgetTopHeight(textBoxNotesEmail, 11.0, Unit.PX, 25.0, Unit.PX);
		
		Button btnSendNotes = new Button("Send");
		layoutPanelData.add(btnSendNotes);
		layoutPanelData.setWidgetLeftWidth(btnSendNotes, 313.0, Unit.PX, 86.0, Unit.PX);
		layoutPanelData.setWidgetTopHeight(btnSendNotes, 11.0, Unit.PX, 24.0, Unit.PX);
		
		Label lblSendCurrentResults = new Label("Send current results");
		layoutPanelData.add(lblSendCurrentResults);
		layoutPanelData.setWidgetLeftWidth(lblSendCurrentResults, 13.0, Unit.PX, 136.0, Unit.PX);
		layoutPanelData.setWidgetTopHeight(lblSendCurrentResults, 62.0, Unit.PX, 18.0, Unit.PX);
		
		TextBox textBoxResultsEmail = new TextBox();
		layoutPanelData.add(textBoxResultsEmail);
		layoutPanelData.setWidgetLeftWidth(textBoxResultsEmail, 151.0, Unit.PX, 156.0, Unit.PX);
		layoutPanelData.setWidgetTopHeight(textBoxResultsEmail, 55.0, Unit.PX, 25.0, Unit.PX);
		
		Button btnSendResults = new Button("Send");
		layoutPanelData.add(btnSendResults);
		layoutPanelData.setWidgetLeftWidth(btnSendResults, 313.0, Unit.PX, 86.0, Unit.PX);
		layoutPanelData.setWidgetTopHeight(btnSendResults, 55.0, Unit.PX, 24.0, Unit.PX);
		

		
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
