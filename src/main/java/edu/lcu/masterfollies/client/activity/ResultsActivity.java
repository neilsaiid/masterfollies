package edu.lcu.masterfollies.client.activity;

import java.util.Date;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;

import edu.lcu.masterfollies.client.ClientFactory;
import edu.lcu.masterfollies.client.GreetingServiceAsync;
import edu.lcu.masterfollies.client.place.ResultsPlace;
import edu.lcu.masterfollies.client.ui.ResultsView;
import edu.lcu.masterfollies.domain.ClubNames;
import edu.lcu.masterfollies.domain.Judges;
import edu.lcu.masterfollies.domain.Results;
import edu.lcu.masterfollies.shared.Log;

public class ResultsActivity extends BasePresenter implements ResultsView.Presenter {
	
	public enum ButtonCodes {
		PRESENT, ABSENT, TARDY
	}

	private ClientFactory clientFactory;
	private ResultsView display;
	
	private final GreetingServiceAsync rpcService;
	private final EventBus eventBus;

	Date today = new Date();
	DateTimeFormat dateFormat = DateTimeFormat.getFormat("yyyy-MM-dd"); 
	private boolean unsetOnly = false;
	final private AsyncDataProvider<Results> provider;
	
	Results results;
	private Judges judge;
	private ClubNames clubName;
	

	
	public ResultsActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;	
		this.display = clientFactory.getResultsView();
		this.eventBus = clientFactory.getEventBus();
		this.rpcService = clientFactory.getRpcService();
		unsetOnly = false;
		
		
		provider = new AsyncDataProvider<Results>() {
			@Override
			protected void onRangeChanged(HasData<Results> display) {
				getResultsList(display, this);
				
			}


		};
		
		
		bind();
	}

	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		ResultsPlace resultsPlace = ((ResultsPlace)clientFactory.getPlaceController().getWhere());
		judge = resultsPlace.getJudge();
		clubName = resultsPlace.getClubName();
		Log.debug("Judge: " + judge);
		display.setLblTitle(
				"Results for "  + clubName.getClubName() + " By: " + judge.getFirstName() + " " + judge.getLastName());
	
		
		Log.debug("START");
		panel.setWidget(display.asWidget());
		display.setListener(this);
	}
	
	public void bind() {
		Log.debug("Start bind");

	}

		
		
		

	
	@Override
	public void batchInsert(Integer judgeId, Integer clubNameId) {
		// TODO define these in the service
		
	}


	@Override
	public void updateLineScore(Integer judgeId, Integer clubNameId,
			Integer questionId, Integer points) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateRankScore(Integer judgeId, Integer clubNameId,
			Integer rank) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateNotes(Integer questionId, String notes) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public
	void getResultsList(HasData<Results> display,
			AsyncDataProvider<Results> asyncDataProvider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void goTo(Place place) {
		// TODO Auto-generated method stub
		
	}

}
