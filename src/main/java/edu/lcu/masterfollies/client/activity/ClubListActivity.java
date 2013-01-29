package edu.lcu.masterfollies.client.activity;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;

import edu.lcu.masterfollies.client.ClientFactory;
import edu.lcu.masterfollies.client.GreetingServiceAsync;
import edu.lcu.masterfollies.client.place.ClubListPlace;
import edu.lcu.masterfollies.client.ui.ClubListView;
import edu.lcu.masterfollies.domain.ClubNames;
import edu.lcu.masterfollies.domain.Judges;
import edu.lcu.masterfollies.domain.ListCount;
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
		final AsyncDataProvider<ClubNames> provider = new AsyncDataProvider<ClubNames>() {
				@Override
				protected void onRangeChanged(HasData<ClubNames> display) {
					getClubList(display, this);
				}
			};
		
		try {
			Log.debug("***I am AFTER the bind method call***");

			final ClubListActivity x = this;
			
			
			provider.addDataDisplay(clientFactory.getClubListView()
					.getTblClubList());
			Log.debug("***I am AFTER the provider.addDataDisplay***");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		ClickHandler handler = new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Log.debug("RUN clubname FIRE");
				HasData<ClubNames> hasData = (HasData<ClubNames>)clubListView.getTblClubList();
				getClubList(hasData, provider);
			}
		};
		
		clubListView = clientFactory.getClubListView();
		
		Button refresh = clubListView.getRefreshButton();
		if (refresh != null)  {
			addHandler(refresh.addClickHandler(handler));
		}
	}

	private void getClubList(HasData<ClubNames> display,
			final AsyncDataProvider<ClubNames> dp) {
		
		Log.debug("CLIENT getClassList");
		this.judge = ((ClubListPlace) clientFactory.getPlaceController().getWhere()).getJudge();
		final int start = display.getVisibleRange().getStart();
		final int length = display.getVisibleRange().getLength();
		AsyncCallback<ListCount<ClubNames>> callback = new AsyncCallback<ListCount<ClubNames>>() {
			@Override
			public void onFailure(Throwable caught) {
				Log.debug("FAIL Range " + caught.getMessage());
				Window.alert(caught.getMessage());
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(ListCount<ClubNames> result) {
				Log.debug("result start = " + start);Log.debug("result length = " + length);
				Log.debug("result count = " + result.getCount());
				Log.debug("result data");
				if (result.getData() != null) {
					for (ClubNames s: result.getData()) {
						Log.debug("course = " + s);
					}
				}
				dp.updateRowCount(result.getCount(), /* exact(not estimate) = */
						true);
				
				dp.updateRowData(start, result.getData());
								
				if (result.getEnv() != null ) {
					String message = (String) result.getEnv().get("message");
					if (message != null)
						Window.alert(message);
				}
				
				Log.debug("SUCCESS DONE");
			}
		};
		rpcService.getClubList(callback);
	}

	/**
	 * Invoked by the ActivityManager to start a new Activity
	 */
	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		Log.debug("Start Activity");
		
		
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

//	@Override
//	public void goToStudent(Course course) {
//		StudentPlace place = new StudentPlace(course.toTag());
//		place.setParent(clientFactory.getPlaceController().getWhere());
//		goTo(place);
//	}

	/**
	 * Navigate to a new Place in the browser
	 */
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}

//	@Override
//	public void goToResults(ClubNames clubNames) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void goToResults(ClubNames clubNames, Judges judge) {
		// TODO Auto-generated method stub
		
	}
}
