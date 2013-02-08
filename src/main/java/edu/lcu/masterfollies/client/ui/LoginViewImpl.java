package edu.lcu.masterfollies.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import edu.lcu.masterfollies.client.masterfollies;

public class LoginViewImpl extends DialogBox implements LoginView {
	
	  interface MyUiBinder extends UiBinder<Widget, LoginViewMobileImpl> {}
	  private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
	  
	private Button btnOK;
	private Button btnCancel;
	private TextBox txtUserName;
	private PasswordTextBox txtPassword;
	private Label lblErrorMessage;
	private FocusPanel focusPanel;

	public LoginViewImpl() {
		setText("");
		
		VerticalPanel verticalPanelRoot = new VerticalPanel();
		setWidget(verticalPanelRoot);
		verticalPanelRoot.setSize("369px", "242px");
		

		HorizontalPanel horizontalPanelTitle = new HorizontalPanel();
		verticalPanelRoot.add(horizontalPanelTitle);
		horizontalPanelTitle.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		Label lblTitle = new Label("Welcome to the  Master Follies Judging app.");
		lblTitle.setStyleName("loginTitle");
		horizontalPanelTitle.add(lblTitle);

		
		Label lblUsernameAndPassword = new Label("Username and Password are case sensitive");
		lblUsernameAndPassword.addStyleName("loginSubTitle");
		verticalPanelRoot.add(lblUsernameAndPassword);
		
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.addStyleName("round");
		verticalPanelRoot.add(verticalPanel);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setSize("366px", "28px");
		
		Label lblNewLabel_1 = new Label("Username");
		lblNewLabel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		lblNewLabel_1.addStyleName("gwt-Label-Username");
		horizontalPanel.add(lblNewLabel_1);
		lblNewLabel_1.setSize("76px", "23px");
		
		txtUserName = new TextBox();
		horizontalPanel.add(txtUserName);

		HorizontalPanel horizontalPanel1 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel1);
		horizontalPanel1.setWidth("364px");
		
		Label lblNewLabel = new Label("Password");
		lblNewLabel.addStyleName("gwt-Label-Username");
		lblNewLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		horizontalPanel1.add(lblNewLabel);
		lblNewLabel.setSize("76px", "23px");
		
		txtPassword = new PasswordTextBox();
		horizontalPanel1.add(txtPassword);
		
		HorizontalPanel horizontalPanel2 = new HorizontalPanel();
		verticalPanelRoot.add(horizontalPanel2);
		horizontalPanel2.setHorizontalAlignment(com.google.gwt.user.client.ui.HasHorizontalAlignment.ALIGN_CENTER);
		
		btnOK = new Button("New button");
		btnOK.setText("Log On");
		horizontalPanel2.add(btnOK);
		horizontalPanel2.addStyleName("loginButton");
		btnOK.setStyleName("blackglossyCSSButtonbutton");
		
		Label lblVersion = new Label("[ver. " + masterfollies.constants.version() + "]");
		horizontalPanel2.add(lblVersion);
		
		btnCancel = new Button("New button");
		btnCancel.setText("Cancel");
		//horizontalPanel.add(btnCancel);
		
		lblErrorMessage = new Label("");
		lblErrorMessage.setStyleName("gwt-Label-Error");
		HorizontalPanel horizontalPanel3 = new HorizontalPanel();
		verticalPanelRoot.add(horizontalPanel3);
		horizontalPanel3.add(lblErrorMessage);
	}

	@Override
	public Button getBtnCancel() {
		return btnCancel;
	}

	public Label getLblErrorMessage() {
		return lblErrorMessage;
	}

	public TextBox getTxtUserName() {
		return txtUserName;
	}

	public PasswordTextBox getTxtPassword() {
		return txtPassword;
	}

	@Override
	public DialogBox asDialog() {
		return this;
	}

	@Override
	public Button getOKButton() {
		return btnOK;
	}

}
