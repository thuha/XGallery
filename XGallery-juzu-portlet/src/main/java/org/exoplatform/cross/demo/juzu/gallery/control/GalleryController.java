package org.exoplatform.cross.demo.juzu.gallery.control;



import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;

import org.exoplatform.cross.demo.chrom.gallery.model.Gallery;
import org.exoplatform.cross.demo.chrom.gallery.service.ChromGalleryService;

import org.juzu.portlet.JuzuPortlet;
import org.juzu.Action;
import org.juzu.Controller;
import org.juzu.Path;
import org.juzu.Response;
import org.juzu.View;

public class GalleryController extends Controller{
	
	
	@Inject
	@Path("galleryView.gtmpl")
	org.exoplatform.cross.demo.juzu.gallery.templates.galleryView displayView;
	
	@Inject
	@Path("galleryEditModeView.gtmpl")
	org.exoplatform.cross.demo.juzu.gallery.templates.galleryEditModeView editView;	
		
	@Inject
	PortletPreferences preferences;
	
	/*@Inject
	ChromatticManager chromManager;	
	*/
	
	@Inject
	ChromGalleryService gService;
	
/*	
	@Inject
	PortletConfig config;
*/
	//private int gIndex = 0;	
	
	//private ChromatticSession session;
		
	
	@View
	public void index(String message){		
		if (message == null) message = "";
		//EDIT MODE
		if (renderContext.getProperty(JuzuPortlet.PORTLET_MODE) == PortletMode.EDIT)
		{						
			try {
				//ChromGalleryService gService = new ChromGalleryService(chromManager);
				editView.with().galleries(gService.getAllGalleryNames()).message(message).render();
			} catch (Exception e) {
				editView.with().galleries(null).message(message).render();
			}												
		}
		//VIEW MODE
		else{					
			String gName = preferences.getValue("gallery-name","NONAME00");			
        	Gallery g = gService.getGallery(gName);
        	
        	if (g == null){
        		g = gService.addGallery(gName);        		
        	}
        	        	
			List<Photo> photos = new ArrayList(g.getPhotos().values());
			
			displayView.with().title(gName).photos(photos).message(message).render();			
		}
	}
	
	@Action
	public Response refresh(String galleryPath){
		return GalleryController_.index(null);
	}

	@Action
	public Response selectGallery(String galleryPath){		
		//Map<String, Gallery> albums = gs.getRoot().getAlbums();
		//galleries = new ArrayList<String>(albums.keySet());
		try {			
			preferences.setValue("gallery-name", galleryPath);
			preferences.store();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//gIndex = galleries.indexOf(galleryPath);		
		return GalleryController_.index(null).setProperty(JuzuPortlet.PORTLET_MODE, PortletMode.VIEW);							
	}
	
	@Action
	public Response addGallery(String galleryName) throws Exception{					
		//DB:
		//ChromGalleryService gService = new ChromGalleryService(chromManager);		
		try{			
			gService.addGallery(galleryName);
		}catch(Exception e){
			//e.printStackTrace();			
			return GalleryController_.index(e.toString());
		}		
		return GalleryController_.index(galleryName + " is created");		
	}
		
	
}
