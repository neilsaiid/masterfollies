package edu.lcu.masterfollies.client.activity;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.ListBox;

import edu.lcu.masterfollies.client.ClientFactory;
import edu.lcu.masterfollies.client.GreetingServiceAsync;
import edu.lcu.masterfollies.client.place.SuperPlace;
import edu.lcu.masterfollies.client.ui.SuperView;
import edu.lcu.masterfollies.domain.ClubNames;
import edu.lcu.masterfollies.shared.Log;

public class SuperActivity extends BasePresenter implements
	SuperView.Presenter{

	private ClientFactory clientFactory;
	private final GreetingServiceAsync rpcService;
	private final EventBus eventBus;
	
	private SuperView display;
	
	
	public SuperActivity(SuperPlace place, ClientFactory clientFactory) {
		Log.debug("SuperActivity Method in SuperActivity");
		this.clientFactory = clientFactory;
		this.rpcService = clientFactory.getRpcService();
		
		this.eventBus = clientFactory.getEventBus();
		Log.debug("SuperActivity before bind()");
		bind();
	}
	public void reorderList(final Boolean up){
		final int place = display.getListBox_2().getSelectedIndex();
		if (place < 0){
			Window.alert("Please select a Club from the list");
			return;
		}
		
		String clubName = display.getListBox_2().getItemText(place);
		
		rpcService.changeClubOrder(clubName, up, new AsyncCallback<List<ClubNames>>(){

			@Override
			public void onFailure(Throwable caught) {
				Log.debug("SuperActivity Failed in getClubOrderList");
			}

			@Override
			public void onSuccess(List<ClubNames> result) {
				int row = 0;
				ListBox x = display.getListBox_2();
				x.clear();
		          for (ClubNames clubName: result) {
		        	   x.addItem(clubName.getClubName());
		          }
		          if (up){
		        	  x.setSelectedIndex(place - 1);
		          }
		          else
		        	  x.setSelectedIndex(place + 1);
		        FlexTable f = display.getFlexTable(); {
		        	for (ClubNames m: result){
						String clubName = (String) m.getClubName();
		        		
					    f.setText(row, 0, clubName);
					    row += 1;
		        	}
			     
		        }
		          
			}
			
		});
	}
	
	public void bind() {
		Log.debug("SuperActivity start of bind()");
		Log.debug("****DEBUG IS:  " + clientFactory);
		this.display = clientFactory.getSuperView();
		Log.debug("****DEBUG IS:  " + display);
//		final AsyncDataProvider<ClubNames> provider = new AsyncDataProvider<ClubNames>() {
//			@Override
//			protected void onRangeChanged(HasData<ClubNames> display) {
//				getClubOrderList(display, this);
//			}
//		};
//		provider.addDataDisplay(clientFactory.getSuperView().displayOrder(results));
//	}
//	protected void getClubOrderList(HasData<ClubNames> display,
//			final AsyncDataProvider<ClubNames> dp) {
//		Log.debug("SuperActivity 1");
//		final int start = display.getVisibleRange().getStart();
//		AsyncCallback<List<ClubNames>> callback = new AsyncCallback<List<ClubNames>>(){
//
//			@Override
//			public void onFailure(Throwable caught) {
//				Log.debug("getClubOrderList in SuperActivity FAIL Range " + caught.getMessage());
//				Window.alert(caught.getMessage());
//				caught.printStackTrace();
//			}
//			@Override
//			public void onSuccess(List<ClubNames> result) {
//				dp.updateRowData(start, result);
//				Log.debug("getClubOrderList in SuperActivity Success DONE");
//			}
//		};
//		rpcService.getClubOrderList(callback);
		addHandler(this.display.getUpArrow().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				reorderList(true); 
				
			}
		}));
		addHandler(this.display.getDownArrow().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				reorderList(false);
				
			}
		}));
	}
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		try {
			Log.debug("StartMethod in SuperActivity");
			display.setPresenter(this);
			getClubOrderList();
			panel.setWidget(display.asWidget());
		} catch (Exception e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getClubOrderList() {
		rpcService.getClubOrderList(new AsyncCallback<List<ClubNames>>(){

			@Override
			public void onFailure(Throwable caught) {
				Log.debug("SuperActivity Failed in getClubOrderList");
			}

			@Override
			public void onSuccess(List<ClubNames> result) {
				int row = 0;
				ListBox x = display.getListBox_2();
		          for (ClubNames clubName: result) {
		        	   x.addItem(clubName.getClubName());      
			}
		
	}
		});
	}

	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}
}