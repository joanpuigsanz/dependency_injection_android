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
package com.kitkatmachine;

import java.util.ArrayList;
import java.util.List;

import roboguice.RoboGuice;
import android.app.Application;

import com.google.inject.Module;
import com.google.inject.Stage;
import com.kitkatmachine.module.IngredientsModule;
import com.kitkatmachine.module.MachineModule;

public class KitKatMachineApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		try {
			RoboGuice.setBaseApplicationInjector(this, Stage.PRODUCTION, getModules());
		} catch (Throwable t) {
			throw new RuntimeException("FATAL!! Could not instantiate application modules", t);
		}
	}

	protected Module[] getModules() {
		List<Module> modules = new ArrayList<Module>();
		modules.add(RoboGuice.newDefaultRoboModule(this));
		modules.add(new IngredientsModule());
		modules.add(new MachineModule());
		
		return (Module[]) modules.toArray(new Module[modules.size()]);
	}
}
