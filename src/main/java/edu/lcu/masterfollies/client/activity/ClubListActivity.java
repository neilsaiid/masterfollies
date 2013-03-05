package edu.lcu.masterfollies.client.activity;


import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;

import edu.lcu.masterfollies.client.ClientFactory;
import edu.lcu.masterfollies.client.GreetingServiceAsync;
import edu.lcu.masterfollies.client.place.ClubListPlace;
import edu.lcu.masterfollies.client.place.ResultsPlace;
import edu.lcu.masterfollies.client.ui.ClubListView;
import edu.lcu.masterfollies.domain.Judges;
import edu.lcu.masterfollies.shared.Log;

public class ClubListActivity extends BasePresenter implements
		ClubListView.Presenter {

	private ClientFactory clientFactory;
	private final GreetingServiceAsync rpcService;
	private final EventBus eventBus;
	private ClubListView clubListView;
	
	DateTimeFormat dateFormat = DateTimeFormat.getFormat("MMM dd, yyyy 'at' hh:mm a");
	private Judges judge; 

	public ClubListActivity(ClubListPlace place, ClientFactory clientFactory) {
		Log.debug("***I am here in the ClubListActivity***");
		//this.instructor = place.getInstructor();
		this.clientFactory = clientFactory;
		this.rpcService = clientFactory.getRpcService();
		this.eventBus = clientFactory.getEventBus();

		Log.debug("***I am before the bind method call***");

		bind();
	}
	
	public void bind() {

		final AsyncDataProvider<Map<String, Object>> provider = new AsyncDataProvider<Map<String, Object>>() {
				@Override
				protected void onRangeChanged(HasData<Map<String, Object>> display) {
					getClubListBoys(display, this);

				}
			};
		
		try {
			provider.addDataDisplay(clientFactory.getClubListView()
					.getTblClubList());
			Log.debug("***I am AFTER the provider.addDataDisplay***");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	final AsyncDataProvider<Map<String, Object>> providerGirls = new AsyncDataProvider<Map<String, Object>>() {
			@Override
			protected void onRangeChanged(HasData<Map<String, Object>> display) {
				getClubListGirls(display, this);
			}
		};
	
	try {
		providerGirls.addDataDisplay(clientFactory.getClubListView()
				.getTblClubListGirls());
		Log.debug("***I am AFTER the provider.addDataDisplay***");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		try {
			Log.debug("I'm ready for the click handler");
			ClickHandler handler = new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					Log.debug("RUN clubname FIRE");

					HasData<Map<String, Object>> hasData = (HasData<Map<String, Object>>)clubListView.getTblClubList();
					getClubListGirls(hasData, provider);

				}
			};
			
			clubListView = clientFactory.getClubListView();
			
			Button refresh = clubListView.getRefreshButton();
			if (refresh != null)  {
				addHandler(refresh.addClickHandler(handler));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void getClubListGirls(HasData<Map<String, Object>> hasData,
			final AsyncDataProvider<Map<String, Object>> gdp) {
		Log.debug("CLIENT getClassList");
		this.judge = ((ClubListPlace) clientFactory.getPlaceController().getWhere()).getJudge();
		final int start = hasData.getVisibleRange().getStart();
		final int length = hasData.getVisibleRange().getLength();
		AsyncCallback<List<Map<String, Object>>> callback = new AsyncCallback<List<Map<String, Object>>>() {
			@Override
			public void onFailure(Throwable caught) {
				Log.debug("FAIL Range " + caught.getMessage());
				Window.alert(caught.getMessage());
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(List<Map<String, Object>> result) {
				
				gdp.updateRowCount(result.size(), /* exact(not estimate) = */
						true);
				
				gdp.updateRowData(start, result);
											
				Log.debug("SUCCESS DONE");
			}
		};
		rpcService.getClubListGirls(judge.getId(), new Date(),callback);

	}
		

	private void getClubListBoys(HasData<Map<String, Object>> display,
			final AsyncDataProvider<Map<String, Object>> dp) {

		
		Log.debug("CLIENT getClassList");
		this.judge = ((ClubListPlace) clientFactory.getPlaceController().getWhere()).getJudge();
		final int start = display.getVisibleRange().getStart();
		final int length = display.getVisibleRange().getLength();

		AsyncCallback<List<Map<String,Object>>> callback = new AsyncCallback<List<Map<String,Object>>>() {

			@Override
			public void onFailure(Throwable caught) {
				Log.debug("FAIL Range " + caught.getMessage());
				Window.alert(caught.getMessage());
				caught.printStackTrace();
			}


			@Override
			public void onSuccess(List<Map<String, Object>> result) {
				
				dp.updateRowCount(result.size(), /* exact(not estimate) = */
						true);
				
				dp.updateRowData(start, result);
												
				Log.debug("SUCCESS DONE");
			}
		};
		rpcService.getClubListBoys(judge.getId(),new Date(), callback);

	}

	/**
	 * Invoked by the ActivityManager to start a new Activity
	 */
	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		Log.debug("Start Method in ClubListAcivity");
		
		
		try {
			judge = ((ClubListPlace) clientFactory.getPlaceController()
					.getWhere()).getJudge();
			Log.debug("Judge: " + judge);
			clubListView.setLblTitle(
					"Ratings for Judge " + judge.getFirstName() + " " + judge.getLastName());
			
			
			clubListView.setPresenter(this);
			containerWidget.setWidget(clubListView.asWidget());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.debug("End of start Activity***");
	}

	/**
	 * Ask user before stopping this activity
	 */
	@Override
	public String mayStop() {
		//return "Please hold on. This activity is stopping.";
		return null;
	}

	/**
	 * Navigate to a new Place in the browser
	 */
	public void goTo(Place place) {
		History.fireCurrentHistoryState();
		clientFactory.getPlaceController().goTo(place);
	}



	@Override

	public void goToResults(String nameOfClub, Integer clubId) {
		
		ResultsPlace resultsPlace = new ResultsPlace("results", judge, clubId, nameOfClub);
		clientFactory.getPlaceController().goTo(resultsPlace);
	}
	@Override
	public void updateRank(Integer rankId, Integer rank){
		AsyncCallback<Void> callback = new AsyncCallback<Void>() {
			@Override
			public void onFailure(Throwable caught) {
				Log.debug("FAIL Range " + caught.getMessage());
				Window.alert(caught.getMessage());
				caught.printStackTrace();
			}



			@Override
			public void onSuccess(Void result) {
				
				Log.debug("SUCCESS DONE");
			}
		};
		rpcService.updateRankPoints(rankId, rank, new Date(), callback);
	}

}
