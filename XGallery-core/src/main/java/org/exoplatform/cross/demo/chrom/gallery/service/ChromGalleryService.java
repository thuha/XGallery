package org.exoplatform.cross.demo.chrom.gallery.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.chromattic.api.Chromattic;
import org.chromattic.api.ChromatticSession;
import org.exoplatform.commons.chromattic.ChromatticLifeCycle;
import org.exoplatform.commons.chromattic.ChromatticManager;
import org.exoplatform.cross.demo.chrom.gallery.model.Gallery;

public class ChromGalleryService {

	private Chromattic chrom;
	private static final String _ROOT_PATH = "XGALLERY";
	
	
	public ChromGalleryService(ChromatticManager chromManager) throws Exception{		
		if (chromManager == null)
			throw new Exception("ChromatticManager NULL");
		ChromatticLifeCycle chromLifecycle = chromManager.getLifeCycle("xgallery");
		if (chromLifecycle == null)
			throw new Exception("Lifecycle xgallery null");
					
		this.chrom = chromManager.getLifeCycle("xgallery").getChromattic();			
	}
	
	public Gallery getRoot(){
		ChromatticSession session = chrom.openSession();
		Gallery root = session.findByPath(Gallery.class, _ROOT_PATH);		
		if (root == null){
			root = session.insert(Gallery.class, _ROOT_PATH);	
			session.save();
		}		
		return root;
	}
	
	public Gallery getGallery(String name){
		ChromatticSession session = chrom.openSession();
		Gallery root = session.findByPath(Gallery.class, _ROOT_PATH);
		Gallery g = null;
		if (root != null){
			Map<String,Gallery> albums = root.getAlbums();
			g = albums.get(name);
		}		
		return g; 
	}
	
	public Gallery addGallery(String name){
		Gallery root = getRoot();
		
		Gallery g = root.addSubAlbum(name);
		
		return g;
	}
		
	public List<String> getAllGalleryNames(){
		return new ArrayList<String>(getRoot().getAlbums().keySet());
	}
	
	
}
