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
import com.kitkatmachine.component.Chocolate;
import com.kitkatmachine.component.Cookie;
import com.kitkatmachine.provider.ChocolateProvider;
import com.kitkatmachine.provider.CookieProvider;

public class IngredientsModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Cookie.class).toProvider(CookieProvider.class);
		bind(Chocolate.class).toProvider(ChocolateProvider.class);
	}
	
}
