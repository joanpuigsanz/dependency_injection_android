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

import javax.inject.Singleton;

import android.content.Context;

import com.kitkatmachine.KitKatMachineApplication;
import com.kitkatmachine.annotation.ForApplication;

import dagger.Module;
import dagger.Provides;

@Module( library = true )
public class AndroidModule {

	private final KitKatMachineApplication mApplication;

	public AndroidModule(KitKatMachineApplication application) {
		mApplication = application;
	}

	/**
	 * Allow the application context to be injected but require that it be
	 * annotated with {@link ForApplication @Annotation} to explicitly
	 * differentiate it from an activity context.
	 */
	@Provides @Singleton @ForApplication Context provideApplicationContext() {
		return mApplication;
	}
}
