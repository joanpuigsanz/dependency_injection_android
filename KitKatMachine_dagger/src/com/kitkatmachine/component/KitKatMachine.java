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

import dagger.Lazy;

public class KitKatMachine implements Machine{

	private Mold mold;
	
	// We don't want to load the heater until we really need it
	private Lazy<Heater> heater;
	
	@Inject
	public KitKatMachine(Mold mold, Lazy<Heater> heater) {
		this.mold = mold;
		this.heater = heater;
	}

	@Override
	public String makeKitKat(Chocolate chocolate, Cookie cookie){
		StringBuilder sb = new StringBuilder(); 
		chocolate.getChocolate();
		sb.append("Turning on heater" + "\n");
		heater.get().on();
		sb.append("Melting chocolate" + "\n");
		chocolate = heater.get().melt(chocolate);
		sb.append("Puting the cookie and the chocolate in to the mold" + "\n");
		mold.putToghether(cookie, chocolate);
		sb.append("Your KitKat is ready!" + "\n");
		
		return sb.toString();
	}
	
}
