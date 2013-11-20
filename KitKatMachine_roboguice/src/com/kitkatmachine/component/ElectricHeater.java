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

import javax.inject.Singleton;

@Singleton
public class ElectricHeater implements Heater {

	private boolean heating;

	@Override
	public String getComponentName() {
		return getClass().getSimpleName() + hashCode();
	}

	@Override
	public void on() {
		heating = true;
	}

	@Override
	public void off() {
		heating = false;
	}

	@Override
	public Chocolate melt(Chocolate chocolate) {
		if (heating){
			return new MeltChocolate(chocolate);
		}
		return chocolate;
	}

	private static class MeltChocolate implements Chocolate {

		private Chocolate original;

		MeltChocolate(Chocolate chocolate) {
			this.original = chocolate;
		}

		@Override
		public String getComponentName() {
			return original.getComponentName();
		}

		@Override
		public String getChocolate() {
			return "Melted " + original.getChocolate();
		}

	}

}
