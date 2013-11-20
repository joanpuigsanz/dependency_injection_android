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
package com.kitkatmachine.module;

import com.google.inject.AbstractModule;
import com.kitkatmachine.component.ElectricHeater;
import com.kitkatmachine.component.Heater;
import com.kitkatmachine.component.KitKatMachine;
import com.kitkatmachine.component.KitKatRobotMold;
import com.kitkatmachine.component.Machine;
import com.kitkatmachine.component.Mold;

public class MachineModule extends AbstractModule {

	
	@Override
	protected void configure() {
		bind(Heater.class).to(ElectricHeater.class).asEagerSingleton();
		
		bind(Mold.class).to(KitKatRobotMold.class);
		bind(Machine.class).to(KitKatMachine.class);
		
	}

}
