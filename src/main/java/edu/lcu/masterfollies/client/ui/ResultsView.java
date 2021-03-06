package edu.lcu.masterfollies.client.ui;

import java.util.List;
import java.util.Map;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.HTMLPanel;
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
		public void updateNotes(final Integer resultId, String notes);
		
		void goTo(Place place);
		void updateResultsPoints(String radioButtonName, Integer value);
	}
	void setTab();
	TabBar getTabBar();
	CellTable<Results> getTblResultsList();
	public void setLblTitle(String string);
	void setResults(List<Map<String, Object>> results);
	Button getBtnNewButton();
	Button getBtnNextShow();
	HTMLPanel getPanel();
	public FocusWidget getbtnBack();


}
