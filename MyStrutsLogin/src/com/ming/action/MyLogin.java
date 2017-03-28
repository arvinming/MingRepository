package com.ming.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class MyLogin implements Action{
	
	private String username;
	
	private String password;

	
	
	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String execute() throws Exception {
		if("arvin".equals(this.getUsername()) && "123".equals(this.getPassword())){
			ActionContext.getContext().getSession().put("username_key", this.getUsername());
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
}
