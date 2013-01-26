package edu.lcu.masterfollies.client.ui;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.TextBox;
/**
 * This is the place that tells the viewimpl what to show the client
 * @author Neil
 *
 */
public interface ReportsListView {
	HasClickHandlers getOKButton();
	public TextBox getTxtUserName();
	public TextBox getTxtPassword();
	public HasText getLblErrorMessage();
	public DialogBox asDialog();
	Button getBtnCancel();

	
	public interface Presenter
	{
		void goTo(Place place);
	}
}
