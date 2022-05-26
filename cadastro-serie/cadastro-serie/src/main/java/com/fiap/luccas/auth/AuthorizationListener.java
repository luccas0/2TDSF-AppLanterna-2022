package com.fiap.luccas.auth;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import com.fiap.luccas.model.User;

public class AuthorizationListener implements PhaseListener {
	
	@Override
	public void afterPhase(PhaseEvent arg0) {
		String page = FacesContext.getCurrentInstance().getViewRoot().getViewId();
		
		if(page.equals("/login.xhtml") || page.equals("/register.xhtml")) {
			return;
		}
		
		//early return
		
		//se usuario não esta logado va para login
		User user = (User)  FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("user");
		
		if (user != null) return;
		
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler()
		.handleNavigation(FacesContext.getCurrentInstance(), null, "login.xhtml");
				
	}
	
	@Override
	public void beforePhase(PhaseEvent arg0) {
		
	}
	
	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
