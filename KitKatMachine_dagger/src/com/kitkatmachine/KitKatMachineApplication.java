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

import com.kitkatmachine.module.AndroidModule;
import com.kitkatmachine.module.IngredientsModule;
import com.kitkatmachine.module.MachineModule;

import dagger.ObjectGraph;
import android.app.Application;

public class KitKatMachineApplication extends Application {

	private ObjectGraph graph;

	@Override
	public void onCreate() {
		super.onCreate();

		graph = ObjectGraph.create(getModules().toArray());
	}

	protected List<Object> getModules() {
		ArrayList<Object> modules = new ArrayList<Object>();

		modules.add(new AndroidModule(this));
		modules.add(new IngredientsModule());
		modules.add(new MachineModule());

		return modules;
	}

	public void inject(Object object) {
		graph.inject(object);
	}

	public ObjectGraph getApplicationGraph() {
		return graph;
	}

}
