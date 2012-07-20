package org.exoplatform.cross.demo.juzu.addition;

import javax.inject.Inject;

import org.juzu.Action;
import org.juzu.Path;
import org.juzu.Response;
import org.juzu.View;



public class Addition {
	
	static String operation = "";
	static int result = 0;
	
	@Inject
	@Path("index.gtmpl")
	org.exoplatform.cross.demo.juzu.addition.templates.index index;

	@Inject
	@Path("additionView.gtmpl")
	org.exoplatform.cross.demo.juzu.addition.templates.additionView view;
	
	
	@View
	public void index(){
		index.render();
	}	
	
	@View
	public void additionDisplay(){
		view.with().operation(operation).result(result).render();
	}
	
	
	@Action
	public Response add(String n){
		try{
			result += Integer.parseInt(n);
			operation += " + " + n;
		}catch(Exception e){
			
		}
		
		return Addition_.additionDisplay();
	}
	
	@Action
	public Response restart(){
		operation = "";
		result = 0;
		return Addition_.index();
	}
}

