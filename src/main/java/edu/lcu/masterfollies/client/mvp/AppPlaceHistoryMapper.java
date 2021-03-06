package edu.lcu.masterfollies.client.mvp;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

/**
 * PlaceHistoryMapper interface is used to attach all places which the
 * PlaceHistoryHandler should be aware of. This is done via the @WithTokenizers
 * annotation or by extending PlaceHistoryMapperWithFactory and creating a
 * separate TokenizerFactory.
 */
@WithTokenizers({edu.lcu.masterfollies.client.place.LoginPlace.Tokenizer.class,
	edu.lcu.masterfollies.client.place.ClubListPlace.Tokenizer.class,
	edu.lcu.masterfollies.client.place.ResultsPlace.Tokenizer.class,
	edu.lcu.masterfollies.client.place.SuperPlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
