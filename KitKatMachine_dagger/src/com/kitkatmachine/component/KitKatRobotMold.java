/*
 * Copyright (C) 2013 Joan Puig Sanz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kitkatmachine.component;

import javax.inject.Inject;
import javax.inject.Singleton;

import android.util.Log;

@Singleton
public class KitKatRobotMold implements Mold{
	
	private Cookie cookie;
	private Chocolate meltedChocolate;

	@Inject
	public KitKatRobotMold(){
		Log.i(getClass().getSimpleName(), "new mold created");
	}
	
	@Override
	public String getComponentName() {
		return getClass().getSimpleName();
	}
	
	public void putToghether(Cookie cookie, Chocolate meltedChocolate){
		this.cookie = cookie;
		this.meltedChocolate = meltedChocolate;
		
		this.cookie.getCookie();
		this.meltedChocolate.getChocolate();
		
		Log.i(getClass().getSimpleName(), "Putting the cookie and the chocolate together");
	}

}
