package com.kitkatmachine.provider;

import javax.inject.Provider;

import com.kitkatmachine.component.Cookie;
import com.kitkatmachine.component.TastyCookie;

public class CookieProvider implements Provider<Cookie>{

	@Override
	public Cookie get() {
		return new TastyCookie();
	}

}
