package edu.lcu.masterfollies.client.ui;

<<<<<<< HEAD
import java.util.List;
import java.util.Map;

import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.ClickableTextCell;
import com.google.gwt.cell.client.FieldUpdater;
=======
import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.cell.client.ClickableTextCell;
>>>>>>> 8878c4e4ca54b13003c87e3e558b1088325d36d1
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
<<<<<<< HEAD
import com.google.gwt.user.cellview.client.TextColumn;
=======
import com.google.gwt.user.cellview.client.SimplePager;
>>>>>>> 8878c4e4ca54b13003c87e3e558b1088325d36d1
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
<<<<<<< HEAD
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.HasData;
=======
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
>>>>>>> 8878c4e4ca54b13003c87e3e558b1088325d36d1
import com.google.gwt.view.client.ProvidesKey;

import edu.lcu.masterfollies.client.AppConstants;
import edu.lcu.masterfollies.client.activity.ClubListActivity;
<<<<<<< HEAD
=======
import edu.lcu.masterfollies.domain.ClubNames;
>>>>>>> 8878c4e4ca54b13003c87e3e558b1088325d36d1
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
<<<<<<< HEAD
	private CellTable<Map<String, Object>> tblClubList;
	DateTimeFormat x = DateTimeFormat.getFormat("hh:mm a");
	private Label lblTitle;
	private VerticalPanel contentTableDecorator;
	private VerticalPanel verticalPanel_Boys;
	private VerticalPanel verticalPanel_Girls;
	private CellTable<Map<String, Object>> tblClubListGirls;
	private TextColumn<Map<String, Object>> ClubNameGirls;
	private HorizontalPanel horizontalPanel;
	private Label lblFirstPlace;
	private ListBox listBoxFirstPlace;
	private Label lblSecondPlace;
	private ListBox listBoxSecondPlace;
	private Label lblThirdPlace;
	private ListBox listBoxThirdPlace;
	private HorizontalPanel horizontalPanel_1;
	private Label label;
	private ListBox listBox;
	private Label label_1;
	private ListBox listBox_1;
	private Label label_2;
	private ListBox listBox_2;
	private Column<Map<String, Object>, Boolean> column_Rank3;
	private Column<Map<String, Object>, Boolean> column_Rank2;
	private Column<Map<String, Object>, Boolean> column_Rank1;
	private Column<Map<String, Object>, Boolean> column_Rank1Girls;
	private Column<Map<String, Object>, Boolean> column_Rank2Girls;
	private Column<Map<String, Object>, Boolean> column_Rank3Girls;
	
	CheckboxCell[][] cba;
	
	public CellTable<Map<String, Object>> getTblClassList() {
		return tblClubList;
	}

	public void setTblClassList(CellTable<Map<String, Object>> tblCourseList) {
=======
	private SimplePager simplePager;
	private CellTable<ClubNames> tblClubList;
	DateTimeFormat x = DateTimeFormat.getFormat("hh:mm a");
	private Label lblTitle;
	private VerticalPanel contentTableDecorator;
	

	public CellTable<ClubNames> getTblClassList() {
		return tblClubList;
	}

	public void setTblClassList(CellTable<ClubNames> tblCourseList) {
>>>>>>> 8878c4e4ca54b13003c87e3e558b1088325d36d1
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
<<<<<<< HEAD
	FieldUpdater<column_Rank1, Boolean> fieldUpdater = new FieldUpdater<column_Rank1, Boolean>()
=======
>>>>>>> 8878c4e4ca54b13003c87e3e558b1088325d36d1

	public ClubListViewImpl() {
		Log.debug("Create ClubListView");
		contentTableDecorator = new VerticalPanel();
		initWidget(contentTableDecorator);
		contentTableDecorator.setWidth("100%");
		contentTableDecorator.setWidth("50em");

<<<<<<< HEAD
	    ProvidesKey<Map<String, Object>> keyProvider = new ProvidesKey<Map<String, Object>>() {
	        public Object getKey(Map<String, Object> item) {
	          // Always do a null check.
	          return (item == null) ? null : (Integer) item.get("rank_id");
	        }
	      };
	    
	      
		      
		      ClickableTextCell txtClubName = new ClickableTextCell();
		      
		      lblTitle = new Label("Clubs");
		      contentTableDecorator.add(lblTitle);
		      
		      verticalPanel_Boys = new VerticalPanel();
		      contentTableDecorator.add(verticalPanel_Boys);
		      tblClubList = new CellTable<Map<String, Object>>(keyProvider);
		      verticalPanel_Boys.add(tblClubList);
		      tblClubList.setSize("750px", "400px");
		      tblClubList.addStyleName("contacts-ListContents");
		      tblClubList.setPageSize(10);
		      Column<Map<String, Object>, String> ClubNameBoys = new Column<Map<String, Object>, String>(txtClubName) {
		      	@Override
		      	  public void onBrowserEvent(Context context, Element elem, final Map<String, Object> object,
		      		      NativeEvent event) {
		      		   	//Log.debug("Change status of " + object.getEvent());
		      		   	try {
		      		   		Log.debug("Responding to event: " + (String) object.get("club_name"));
		      		   		listener.goToResults((String)object.get("club_name"),(Integer)object.get("club_names_id"));
=======
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
>>>>>>> 8878c4e4ca54b13003c87e3e558b1088325d36d1
							} catch (Exception e) {
								//  Auto-generated catch block
								Log.debug("you got caught trying to go to a result");
								e.printStackTrace();
							}
<<<<<<< HEAD
		      		   	//eventBus.fireEvent(new StudentListEvent(object));
		      		  }
					@Override
					public String getValue(Map<String, Object> object) {
						return (String)object.get("club_name");
					}
		        };
		      tblClubList.addColumn(ClubNameBoys, "Boy Clubs");
		      
		  //    Column ClubRankBoys = new Column();
		      
		      
		      tblClubList.setColumnWidth(ClubNameBoys, "200px");
		      
		      column_Rank1 = new Column<Map<String, Object>, Boolean>(new CheckboxCell() ) {
		      	@Override
		      	public Boolean getValue(Map<String, Object> object) {
		      		Integer rankValue = (Integer) object.get("rank");
		      		if(rankValue != null && rankValue == 1)
		      			return (Boolean) true;
		      		return false;
		      	}
		      };
		      tblClubList.addColumn(column_Rank1, "Rank 1");
		      
		      column_Rank2 = new Column<Map<String, Object>, Boolean>(new CheckboxCell()) {
		      	@Override
		      	public Boolean getValue(Map<String, Object> object) {
		      		Integer rankValue = (Integer) object.get("rank");
		      		if(rankValue != null && rankValue == 2)
		      			return (Boolean) true;
		      		return false;
		      
		      	}
		      };
		      tblClubList.addColumn(column_Rank2, "Rank 2");
		      
		      column_Rank3 = new Column<Map<String, Object>, Boolean>(new CheckboxCell()) {
		      	@Override
		      	public Boolean getValue(Map<String, Object> object) {
		      		Integer rankValue = (Integer) object.get("rank");
		      		if(rankValue != null && rankValue == 3)
		      			return (Boolean) true;
		      		return false;
		      	
		      	}
		      };
		      tblClubList.addColumn(column_Rank3, "Rank 3");
		      tblClubList.setVisible(true);
		
		horizontalPanel = new HorizontalPanel();
		contentTableDecorator.add(horizontalPanel);
		horizontalPanel.setWidth("711px");
		
		lblFirstPlace = new Label("First Place:");
		horizontalPanel.add(lblFirstPlace);
		
		listBoxFirstPlace = new ListBox();
		horizontalPanel.add(listBoxFirstPlace);
		listBoxFirstPlace.setVisibleItemCount(4);
		
		lblSecondPlace = new Label("Second Place:");
		horizontalPanel.add(lblSecondPlace);
		
		listBoxSecondPlace = new ListBox();
		horizontalPanel.add(listBoxSecondPlace);
		listBoxSecondPlace.setVisibleItemCount(4);
		
		lblThirdPlace = new Label("Third Place:");
		horizontalPanel.add(lblThirdPlace);
		
		listBoxThirdPlace = new ListBox();
		listBoxThirdPlace.setVisibleItemCount(4);
		horizontalPanel.add(listBoxThirdPlace);
	//	/******* START OF GIRLS PANELS ******************/
		verticalPanel_Girls = new VerticalPanel();
		contentTableDecorator.add(verticalPanel_Girls);
		
		tblClubListGirls = new CellTable<Map<String, Object>>(keyProvider);
		tblClubListGirls.setPageSize(10);
		verticalPanel_Girls.add(tblClubListGirls);
		tblClubListGirls.setSize("750px", "400px");
		
//		ClubNameGirls = new TextColumn<Map<String, Object>>() {
//			@Override
//			public String getValue(Map<String, Object> object) {
//				return object.toString();
//			}
//		};
		Column<Map<String, Object>, String> ClubNameGirls = new Column<Map<String, Object>, String>(txtClubName) {
	      	@Override
	      	  public void onBrowserEvent(Context context, Element elem, final Map<String, Object> object,
	      		      NativeEvent event) {
	      		   	//Log.debug("Change status of " + object.getEvent());
	      		   	try {
	      		   		Log.debug("Responding to event: " + (String) object.get("club_name"));
							listener.goToResults((String)object.get("club_name"),(Integer)object.get("club_names_id"));
						} catch (Exception e) {
							//  Auto-generated catch block
							Log.debug("you got caught trying to go to a result");
							e.printStackTrace();
						}
	      		   	//eventBus.fireEvent(new StudentListEvent(object));
	      		  }
				@Override
				public String getValue(Map<String, Object> object) {
					return (String) object.get("club_name");
				}
	        };
		tblClubListGirls.addColumn(ClubNameGirls, "Girl Clubs");
		tblClubListGirls.setColumnWidth(ClubNameGirls, "200px");
		
		column_Rank1Girls = new Column<Map<String, Object>, Boolean>(new CheckboxCell()) {
	      	@Override
	      	public Boolean getValue(Map<String, Object> object) {
	      		Integer rankValue = (Integer) object.get("rank");
	      		if(rankValue != null && rankValue == 1)
	      			return (Boolean) true;
	      		return false;
	      	
	      	}
	      	
		};
		tblClubListGirls.addColumn(column_Rank1Girls, "Rank 1");
		
		column_Rank2Girls = new Column<Map<String, Object>, Boolean>(new CheckboxCell()) {
	      	@Override
	      	public Boolean getValue(Map<String, Object> object) {
	      		Integer rankValue = (Integer) object.get("rank");
	      		if(rankValue != null && rankValue == 2)
	      			return (Boolean) true;
	      		return false;
	      	}
		};
		tblClubListGirls.addColumn(column_Rank2Girls, "Rank 2");
		
		column_Rank3Girls = new Column<Map<String, Object>, Boolean>(new CheckboxCell()) {
	      	@Override
	      	public Boolean getValue(Map<String, Object> object) {
	      		Integer rankValue = (Integer) object.get("rank");
	      		if(rankValue != null && rankValue == 3)
	      			return (Boolean) true;
	      		return false;
	      	}
	      	
		};
		
		tblClubListGirls.addColumn(column_Rank3Girls, "Rank 3");
		
		horizontalPanel_1 = new HorizontalPanel();
		contentTableDecorator.add(horizontalPanel_1);
		horizontalPanel_1.setWidth("709px");
		
		label = new Label("First Place:");
		horizontalPanel_1.add(label);
		
		listBox = new ListBox();
		listBox.setVisibleItemCount(4);
		horizontalPanel_1.add(listBox);
		
		label_1 = new Label("Second Place:");
		horizontalPanel_1.add(label_1);
		
		listBox_1 = new ListBox();
		listBox_1.setVisibleItemCount(4);
		horizontalPanel_1.add(listBox_1);
		
		label_2 = new Label("Third Place:");
		horizontalPanel_1.add(label_2);
		
		listBox_2 = new ListBox();
		listBox_2.setVisibleItemCount(4);
		horizontalPanel_1.add(listBox_2);
		
		contentTableDecorator.add(errorLabel);

	}

=======
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
>>>>>>> 8878c4e4ca54b13003c87e3e558b1088325d36d1
	
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
<<<<<<< HEAD
	public CellTable<Map<String, Object>> getTblClubList() {
=======
	public CellTable<ClubNames> getTblClubList() {
>>>>>>> 8878c4e4ca54b13003c87e3e558b1088325d36d1
		//  Auto-generated method stub
		return tblClubList;
	}

<<<<<<< HEAD
	@Override
	public HasData<Map<String, Object>> getTblClubListGirls() {
		// TODO Auto-generated method stub
		return tblClubListGirls;
	}

=======
>>>>>>> 8878c4e4ca54b13003c87e3e558b1088325d36d1
}
