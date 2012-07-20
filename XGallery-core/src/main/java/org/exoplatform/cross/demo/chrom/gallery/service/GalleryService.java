package org.exoplatform.cross.demo.chrom.gallery.service;

import java.util.ArrayList;
import java.util.List;

import org.chromattic.api.ChromatticSession;
import org.exoplatform.cross.demo.chrom.gallery.model.Gallery;


public class GalleryService {
	
	private ChromatticConnection conn;
	
	public GalleryService(ChromatticConnection conn){
		this.conn = conn;
	}
		
	public Gallery createGallery(String name) throws Exception{
		ChromatticSession session = conn.getCurrentSession();
		
		try{			
			if (session.findByPath(Gallery.class, name) == null){
				Gallery g = session.insert(Gallery.class, name);
				session.save();
				return g;
			}else{
				throw new Exception("Please take other name. Gallery '"+name+"' already exists");
			}
		}finally{
			session.close();
		}
	}
	
	
	public void deleteGallery(Gallery g){		
		ChromatticSession session = conn.getCurrentSession();
		try{
			session.remove(g);
			session.save();
		}finally{
			session.close();			
		}		
	}
	
	public Gallery getRoot(){
		ChromatticSession session = conn.getCurrentSession();
		Gallery root;
		try{
			root = session.findByPath(Gallery.class, conn.getRoot());
			if (root == null){
				root = session.insert(Gallery.class, conn.getRoot());
			}			
		}catch(Exception e){
			return null;
		}		
		
		return root;
	}
	
	
	public List<String> getAllGalleriesValide(List<String> test){
		List<String> db = new ArrayList<String>();
		ChromatticSession session = conn.getCurrentSession();
		for (String name : test){
			Gallery g = session.findByPath(Gallery.class, name);
			if (g != null){
				db.add(g.getName());
			}
		}
		
		return db;
	}
	
	
}
