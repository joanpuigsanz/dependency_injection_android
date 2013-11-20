package com.kitkatmachine.provider;

import javax.inject.Provider;

import com.kitkatmachine.component.Chocolate;
import com.kitkatmachine.component.ChocolateWithMilk;

public class ChocolateProvider implements Provider<Chocolate>{

	@Override
	public Chocolate get() {
		return new ChocolateWithMilk();
	}

}
