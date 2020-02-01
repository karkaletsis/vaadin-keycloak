package com.gnomon.examinations.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.VaadinSession;
import org.keycloak.adapters.springsecurity.account.SimpleKeycloakAccount;
import org.keycloak.representations.AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.Serializable;

@Route(value = "") //can also navigate to this view with {base url}/ent
@Secured("ROLE_USER")
public class HomeView extends VerticalLayout implements Serializable {

    private TextField filter1;
    private static final Logger log = LoggerFactory.getLogger(HomeView.class);

    public HomeView(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		SimpleKeycloakAccount account = (SimpleKeycloakAccount) authentication.getDetails();

		AccessToken token = account.getKeycloakSecurityContext().getToken();
		System.out.println("#### IS EXPIRED: " + token.isExpired());

        H2 h2 = new H2();
        h2.setText("test");
        add(h2);

        Button button = new Button("notify");
        button.addClickListener(e-> {
            Notification.show(token.isExpired()+"");
        });

        add(button);

    }



}
