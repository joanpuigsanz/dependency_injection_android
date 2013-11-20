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
package com.kitkatmachine.ui;

import javax.inject.Inject;
import javax.inject.Provider;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.kitkatmachine.R;
import com.kitkatmachine.component.Chocolate;
import com.kitkatmachine.component.Component;
import com.kitkatmachine.component.Cookie;
import com.kitkatmachine.component.Heater;
import com.kitkatmachine.component.Machine;

import dagger.Lazy;

public class HomeFragment extends BaseFragment implements OnClickListener {

	private TextView componentsTextView;
	private Button makeKitKatButton;
	
	@Inject ActivityTitleController titleControler;

	@Inject Provider<Chocolate> chocolate;
	@Inject Provider<Cookie> cookie;

	@Inject Lazy<Heater> heater; // The heater is taken only when it is needed
	@Inject Machine machine;

	public static Fragment newInstance() {
		return new HomeFragment();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_main, null);

		componentsTextView = (TextView) view.findViewById(R.id.componentsTextView);
		makeKitKatButton = (Button) view.findViewById(R.id.makeKitKatButton);

		makeKitKatButton.setOnClickListener(this);
		
		return view;
	}

	@Override
	public void onResume() {
		super.onResume();

		// Lets print the ingredients that we have
		componentsTextView.setText("");
		showIngredient(chocolate.get());
		showIngredient(cookie.get());
	}

	private void showIngredient(Component component) {
		componentsTextView.append(component.getComponentName() + "\n");
	}

	@Override
	public void onClick(View v) {
		if (v == makeKitKatButton) {
			String result = machine.makeKitKat(chocolate.get(), cookie.get());
			componentsTextView.setText(result);
		}
	}

}
