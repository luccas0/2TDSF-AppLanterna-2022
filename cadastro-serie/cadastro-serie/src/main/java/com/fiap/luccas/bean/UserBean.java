package com.fiap.luccas.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.fiap.luccas.dao.UserDao;
import com.fiap.luccas.model.User;

@Named
@RequestScoped
public class UserBean {
	
	private User user = new User();
	
	private UserDao userDao = new UserDao();
	
	public void save() {
		
		userDao.create(getUser());
		
		FacesContext
		    .getCurrentInstance().addMessage(null, new FacesMessage("Usuario cadastrado com sucesso"));
	}
	
	public List<User> getList() {
		return userDao.listAll();
	}
	
	public String login() {
		if(userDao.exist(user)) {
			//salavar usuario logado na secao
		
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("User", user);
		
		return "series";
		}
	
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login invalido"));
		
		return "login?faces-redirect=true";
}
	
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("user");
		return "login";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	

}
