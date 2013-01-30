package edu.lcu.masterfollies.client.ui;

import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.cell.client.ClickableTextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ProvidesKey;

import edu.lcu.masterfollies.client.AppConstants;
import edu.lcu.masterfollies.client.activity.ClubListActivity;
import edu.lcu.masterfollies.domain.ClubNames;
import edu.lcu.masterfollies.domain.Judges;
import edu.lcu.masterfollies.shared.Log;

public class ClubListViewImpl extends Composite implements ClubListView {
	private Judges judge;
	
	private HandlerManager eventBus = null;
	private Presenter listener;
	
	
	public void setEventBus(HandlerManager eventBus) {
		this.eventBus = eventBus;
	}

	public HandlerManager getEventBus() {
		return eventBus;
	}
	
	@Override
	public VerticalPanel getPanel() {
		return contentTableDecorator;
	}

	private static final AppConstants CONSTANTS = GWT
			.create(AppConstants.class);
	final Label errorLabel = new Label();
	final DialogBox dialogBox = new DialogBox();
	final Button closeButton = new Button("Close");
	final Label textToServerLabel = new Label();
	final HTML serverResponseLabel = new HTML();
	private SimplePager simplePager;
	private CellTable<ClubNames> tblClubList;
	DateTimeFormat x = DateTimeFormat.getFormat("hh:mm a");
	private Label lblTitle;
	private VerticalPanel contentTableDecorator;
	

	public CellTable<ClubNames> getTblClassList() {
		return tblClubList;
	}

	public void setTblClassList(CellTable<ClubNames> tblCourseList) {
		this.tblClubList = tblCourseList;
	}

	public Label getTextToServerLabel() {
		return textToServerLabel;
	}

	public HTML getServerResponseLabel() {
		return serverResponseLabel;
	}

	public Button getCloseButton() {
		return closeButton;
	}

	public DialogBox getDialogBox() {
		return dialogBox;
	}


	public Label getErrorLabel() {
		return errorLabel;
	}

	public ClubListViewImpl() {
		Log.debug("Create ClubListView");
		contentTableDecorator = new VerticalPanel();
		initWidget(contentTableDecorator);
		contentTableDecorator.setWidth("100%");
		contentTableDecorator.setWidth("50em");

	    ProvidesKey<ClubNames> keyProvider = new ProvidesKey<ClubNames>() {
	        public Object getKey(ClubNames item) {
	          // Always do a null check.
	          return (item == null) ? null : item.getId();
	        }
	      };
		tblClubList = new CellTable<ClubNames>(keyProvider);
		//tblClassList.setStyleName("contacts-ListRow td");

		tblClubList.setWidth("950px");
		//tblClassList.addStyleName("contacts-ListContents");
		tblClubList.setPageSize(10);
	      
	      
		      
		      ClickableTextCell txtClubName = new ClickableTextCell();
			    Column<ClubNames, String> dayColumn = new Column<ClubNames, String>(txtClubName) {
			    	@Override
			    	  public void onBrowserEvent(Context context, Element elem, final ClubNames object,
			    		      NativeEvent event) {
			    		   	//Log.debug("Change status of " + object.getEvent());
			    		   	try {
			    		   		Log.debug("Responding to event: " + object.getClubName());
								listener.goToResults(object);
							} catch (Exception e) {
								//  Auto-generated catch block
								Log.debug("you got caught trying to go to a result");
								e.printStackTrace();
							}
			    		   	//eventBus.fireEvent(new StudentListEvent(object));
			    		  }
					@Override
					public String getValue(ClubNames object) {
						return object.getClubName();
					}
			      };
			      tblClubList.addColumn(dayColumn, "Club Name");
			      tblClubList.setColumnWidth(dayColumn, "200px");
		      
		      lblTitle = new Label("Clubs");
		      contentTableDecorator.add(lblTitle);
		      

		      
		      simplePager = new SimplePager();
		      simplePager.setDisplay(tblClubList);
		      contentTableDecorator.add(simplePager);
		tblClubList.setVisible(true);
		simplePager.setVisible(true);
		
		contentTableDecorator.add(tblClubList);
		
		contentTableDecorator.add(errorLabel);


		// Create the popup dialog box

		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);

		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");

		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Please Wait...</b>"));
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		//dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);
		Log.debug("Create AttendanceView DONE");
	}

	public SimplePager getSimplePager() {
		return simplePager;
	}

	public void setSimplePager(SimplePager simplePager) {
		this.simplePager = simplePager;
	}
	
	@Override
	public void setPresenter(ClubListActivity clubListActivity) {
		Log.debug("this should be listening to this view for events");
		listener = clubListActivity;
	}

	@Override
	public void setLblTitle(String string) {
		lblTitle.setText(string);
	}

	@Override
	public void setLoadtime(String loadtime) {

		
	}

	@Override
	public Button getRefreshButton() {
		return null;
	}

	@Override
	public CellTable<ClubNames> getTblClubList() {
		//  Auto-generated method stub
		return tblClubList;
	}

}
