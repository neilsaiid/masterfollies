package edu.lcu.masterfollies.client.ui;


import java.util.Map;

import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.ClickableTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.ProvidesKey;

import edu.lcu.masterfollies.client.AppConstants;
import edu.lcu.masterfollies.client.activity.ClubListActivity;
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
	private CellTable<Map<String, Object>> tblClubList;
	DateTimeFormat x = DateTimeFormat.getFormat("hh:mm a");
	private Label lblTitle;
	private VerticalPanel contentTableDecorator;
	private VerticalPanel verticalPanel_Boys;
	private VerticalPanel verticalPanel_Girls;
	private CellTable<Map<String, Object>> tblClubListGirls;
	private TextColumn<Map<String, Object>> ClubNameGirls;
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

	//FieldUpdater<column_Rank1, Boolean> fieldUpdater = new FieldUpdater<column_Rank1, Boolean>()


	public ClubListViewImpl() {
		Log.debug("Create ClubListView");
		contentTableDecorator = new VerticalPanel();
		initWidget(contentTableDecorator);
		contentTableDecorator.setWidth("100%");
		contentTableDecorator.setWidth("50em");


	    ProvidesKey<Map<String, Object>> keyProvider = new ProvidesKey<Map<String, Object>>() {
	        public Object getKey(Map<String, Object> item) {
	          // Always do a null check.
	          return (item == null) ? null : (Integer) item.get("rank_id");
	        }
	      };
	    
	      
		      
		      ClickableTextCell txtClubName = new ClickableTextCell();
		      
		      lblTitle = new Label("Clubs");
		      contentTableDecorator.add(lblTitle);
		      lblTitle.addStyleName("gwt-Label-Judge-Title");
		      
		      verticalPanel_Boys = new VerticalPanel();
		      contentTableDecorator.add(verticalPanel_Boys);
		      tblClubList = new CellTable<Map<String, Object>>(keyProvider);
		      tblClubList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.BOUND_TO_SELECTION);
		      
		      verticalPanel_Boys.add(tblClubList);
		      tblClubList.setSize("750px", "400px");
//		      tblClubList
		      tblClubList.addStyleName("tblClubList-large-font");
		      tblClubList.setPageSize(10);
		      Column<Map<String, Object>, String> ClubNameBoys = new Column<Map<String, Object>, String>(txtClubName) {
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
		      	
//		      	@Override
//		      	 public void onBrowserEvent(Context context, Element elem, final Map<String, Object> object,
//                         NativeEvent event) {
//		      		Log.debug("HERE  " + object);
//		      		
//		      	}
		      	
		      };
            column_Rank1.setFieldUpdater(new FieldUpdater<Map<String, Object>, Boolean>() {

                      @Override
                      public void update(int index, Map<String, Object> object, Boolean value) {
                    	  if (value) {
                    		  object.put("rank", 1);
                              listener.updateRank((Integer) object.get("rank_id"), 1);
                              tblClubList.redraw();
                    	  }
                    	  else {
                    		  object.put("rank", 0);
                    		  listener.updateRank((Integer) object.get("rank_id"), 0);
                    	  }
          
                    	  
                      }
           
            });
		    		  
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
	            column_Rank2.setFieldUpdater(new FieldUpdater<Map<String, Object>, Boolean>() {

                    @Override
                    public void update(int index, Map<String, Object> object, Boolean value) {
                  	  if (value) {
                  		  object.put("rank", 2);
                            listener.updateRank((Integer) object.get("rank_id"), 2);
                            tblClubList.redraw();
                  	  }
                  	  else {
                		  object.put("rank", 0);
                		  listener.updateRank((Integer) object.get("rank_id"), 0);
                  	  }
                  	 
                  	  
                    }
         
          });
		      
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
	            column_Rank3.setFieldUpdater(new FieldUpdater<Map<String, Object>, Boolean>() {

                    @Override
                    public void update(int index, Map<String, Object> object, Boolean value) {
                  	  if (value) {
                  		  object.put("rank", 3);
                            listener.updateRank((Integer) object.get("rank_id"), 3);
                            tblClubList.redraw();
                  	  }
                  	  else {
                		  object.put("rank", 0);
                		  listener.updateRank((Integer) object.get("rank_id"), 0);
                  	  }
                  	
                  	  
                    }
         
          });
		      tblClubList.setVisible(true);
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
		
		column_Rank1Girls.setFieldUpdater(new FieldUpdater<Map<String, Object>, Boolean>() {

            @Override
            public void update(int index, Map<String, Object> object, Boolean value) {
          	  if (value) {
          		  object.put("rank", 1);
                    listener.updateRank((Integer) object.get("rank_id"), 1);
                    tblClubListGirls.redraw();
          	  }
          	  else {
          		  object.put("rank", 0);
          		  listener.updateRank((Integer) object.get("rank_id"), 0);
          	  }

          	  
            }
 
  });
  		
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
		column_Rank2Girls.setFieldUpdater(new FieldUpdater<Map<String, Object>, Boolean>() {

            @Override
            public void update(int index, Map<String, Object> object, Boolean value) {
          	  if (value) {
          		  object.put("rank", 2);
                    listener.updateRank((Integer) object.get("rank_id"), 2);
                    tblClubListGirls.redraw();
          	  }
          	  else {
          		  object.put("rank", 0);
          		  listener.updateRank((Integer) object.get("rank_id"), 0);
          	  }

          	  
            }
 
  });
  		
		
		
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
		column_Rank3Girls.setFieldUpdater(new FieldUpdater<Map<String, Object>, Boolean>() {

            @Override
            public void update(int index, Map<String, Object> object, Boolean value) {
          	  if (value) {
          		  object.put("rank", 3);
                    listener.updateRank((Integer) object.get("rank_id"), 3);
                    tblClubListGirls.redraw();
          	  }
          	  else {
          		  object.put("rank", 0);
          		  listener.updateRank((Integer) object.get("rank_id"), 0);
          	  }

          	  
            }
 
  });
		
		contentTableDecorator.add(errorLabel);

	}


	
	@Override
	public void setPresenter(ClubListActivity clubListActivity) {
		Log.debug("ClubListViewImpl line 411");
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

	public CellTable<Map<String, Object>> getTblClubList() {
		return tblClubList;
	}


	@Override
	public HasData<Map<String, Object>> getTblClubListGirls() {
		return tblClubListGirls;
	}

}
