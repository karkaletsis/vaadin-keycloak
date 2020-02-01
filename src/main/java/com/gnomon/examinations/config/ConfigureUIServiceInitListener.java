package com.gnomon.examinations.config;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.internal.UIInternals;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinServiceInitListener;
import com.vaadin.flow.server.VaadinSession;
import org.keycloak.adapters.springsecurity.account.SimpleKeycloakAccount;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class ConfigureUIServiceInitListener implements VaadinServiceInitListener {

	@Override
	public void serviceInit(ServiceInitEvent event) {
		event.getSource().addUIInitListener(uiEvent -> {
			final UI ui = uiEvent.getUI();
			ui.addBeforeEnterListener(this::beforeEnter);
		});
	}

	/**
	 * Reroutes the user if (s)he is not authorized to access the view.
	 *
	 * @param event
	 *            before navigation event with event details
	 */
	private void beforeEnter(BeforeEnterEvent event) {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		SimpleKeycloakAccount account = (SimpleKeycloakAccount) authentication.getDetails();
//
//		AccessToken token = account.getKeycloakSecurityContext().getToken();
//		System.out.println("#### LOCALE: " + token.getLocale());
//		String[] locales = token.getLocale().split("_");
//		try {
//			VaadinSession.getCurrent().setLocale(new Locale(locales[0],locales[1]));
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
