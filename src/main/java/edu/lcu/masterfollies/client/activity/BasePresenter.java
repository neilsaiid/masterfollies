package edu.lcu.masterfollies.client.activity;

import java.util.LinkedList;
import java.util.List;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.HandlerRegistration;

public abstract class BasePresenter extends AbstractActivity {

    private List<HandlerRegistration> registrations = new LinkedList<HandlerRegistration>();

    public void bind() {}

    public void unbind() {
        for(HandlerRegistration registration : registrations) {
            registration.removeHandler();
        }
        registrations.clear();
    }

    protected void addHandler(HandlerRegistration registration) {
        registrations.add(registration);
    }

	@Override
	public void onStop() {
		unbind();
	}
}
