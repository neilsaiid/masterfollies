package edu.lcu.masterfollies.client.ui;

import java.util.List;
import java.util.Map;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TabBar;
import com.google.gwt.user.client.ui.Widget;

import edu.lcu.masterfollies.domain.Results;

public interface ResultsView extends IsWidget {
	public Widget asWidget();

	
	public void setListener(Presenter listener);
	
	public interface Presenter
	{
		public void batchInsert (final Integer judgeId, Integer clubNameId);
		public void updateLineScore(final Integer judgeId, Integer clubNameId, Integer questionId, Integer points);
		public void updateRankScore(final Integer judgeId, Integer clubNameId, Integer rank);
		public void updateNotes(final Integer questionId, String notes);
		
		void goTo(Place place);
		void updateResultsPoints(String radioButtonName);

		
	}
	public void setResults(List<Map<String,String>> results);
	void setTab();
	TabBar getTabBar();
	CellTable<Results> getTblResultsList();


	public void setLblTitle(String string);
}
