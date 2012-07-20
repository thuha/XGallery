package org.exoplatform.cross.demo.chrom.gallery.service;


import org.chromattic.api.Chromattic;
import org.chromattic.api.ChromatticBuilder;
import org.chromattic.api.ChromatticSession;
import org.exoplatform.cross.demo.chrom.gallery.model.Base;
import org.exoplatform.cross.demo.chrom.gallery.model.Gallery;
import org.exoplatform.cross.demo.chrom.gallery.model.Photo;


public class ChromatticConnection {
	
	private Chromattic manager;
	private String root;
	private String ws;
	
	
	public void setRoot(String ws, String root, boolean createRoot){
		this.root = root;
		this.ws = ws;	
	}
	
		
	public ChromatticConnection(){
		ChromatticBuilder builder = ChromatticBuilder.create();
		
		builder.add(Base.class);
		builder.add(Photo.class);
		builder.add(Gallery.class);
		
		//builder.setOptionValue(ChromatticBuilder.SESSION_LIFECYCLE_CLASSNAME, CurrentRepositoryLifeCycle.class.getName());
		//builder.setOptionValue(ChromatticBuilder.CREATE_ROOT_NODE, createRoot);
		//builder.setOptionValue(ChromatticBuilder.ROOT_NODE_PATH, "/"+root);
		 
		this.manager = builder.build();
			
	}
	
	
	public ChromatticSession getCurrentSession(){		
		//return manager.openSession(ws);
		return null;
	}	
	
	public String getRoot(){		
		return root;
	}
	
}
	
