/*
	 * Copyright 2008 Google Inc.
	 *
	 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
	 * use this file except in compliance with the License. You may obtain a copy of
	 * the License at
	 *
	 * http://www.apache.org/licenses/LICENSE-2.0
	 *
	 * Unless required by applicable law or agreed to in writing, software
	 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
	 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
	 * License for the specific language governing permissions and limitations under
	 * the License.
	 */
package edu.lcu.masterfollies.client;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;
import com.google.gwt.resources.client.ImageResource;
	
	
	/**
	 * The images and styles used throughout the Showcase.
	 */
	public interface MasterfolliesResources extends ClientBundle {
		public static final MasterfolliesResources INSTANCE =  GWT.create(MasterfolliesResources.class);

		
		@NotStrict
		  @Source("masterfollies.css")
		  public CssResource css();
		
		@NotStrict
		  @Source("masterfolliesIpad.css")
		  public CssResource cssIpad();


		ImageResource blueNext();
		
		@Source("BallRed.png")
	  ImageResource red();
		@Source("BallYellow.png")
	  ImageResource yellow();
		@Source("BallGreen.png")
	  ImageResource green();
		
		@Source("speech_balloon.png")
		  ImageResource speechBalloon();
	  
	  ImageResource btnRed30();
	  ImageResource btnYellow30();
	  ImageResource btnGreen30();

	}

