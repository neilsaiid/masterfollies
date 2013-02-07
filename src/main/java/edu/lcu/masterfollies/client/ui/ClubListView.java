package edu.lcu.masterfollies.client.ui;

<<<<<<< HEAD
import java.util.Map;

=======
>>>>>>> 8878c4e4ca54b13003c87e3e558b1088325d36d1
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Panel;
<<<<<<< HEAD
import com.google.gwt.view.client.HasData;
=======
>>>>>>> 8878c4e4ca54b13003c87e3e558b1088325d36d1

import edu.lcu.masterfollies.client.activity.ClubListActivity;
import edu.lcu.masterfollies.domain.ClubNames;
import edu.lcu.masterfollies.domain.Judges;

/**
 * View interface. Extends IsWidget so a view impl can easily provide
 * its container widget.
 *
 * @author drfibonacci
 */
public interface ClubListView extends IsWidget
{
	public void setEventBus(HandlerManager eventBus);
<<<<<<< HEAD
	public CellTable<Map<String, Object>> getTblClubList();
=======
	public CellTable<ClubNames> getTblClubList();
>>>>>>> 8878c4e4ca54b13003c87e3e558b1088325d36d1

	public interface Presenter
	{
		void goTo(Place place);

<<<<<<< HEAD
		void goToResults(String nameOfClub, Integer clubId);

		void updateRank(Integer rankId, Integer rank);
=======
		void goToResults(ClubNames clubNames);
>>>>>>> 8878c4e4ca54b13003c87e3e558b1088325d36d1
	}

	public void setPresenter(ClubListActivity clubListActivity);
	public void setLblTitle(String string);
	public void setLoadtime(String loadtime);
	public Button getRefreshButton();
	public Panel getPanel();
<<<<<<< HEAD
	public HasData<Map<String, Object>> getTblClubListGirls();
=======
>>>>>>> 8878c4e4ca54b13003c87e3e558b1088325d36d1
}