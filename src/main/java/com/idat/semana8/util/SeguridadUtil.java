package com.idat.semana8.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class SeguridadUtil {
	
	public static String getCurrentUser() {

		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		String userSession = null;
		if (authentication != null && authentication.isAuthenticated())
			userSession = authentication.getName();
		return userSession;
	}
}
