package org.exoplatform.cross.demo.chrom.gallery.model;

/*
* Copyright (C) 2010 eXo Platform SAS.
*
* This is free software; you can redistribute it and/or modify it
* under the terms of the GNU Lesser General Public License as
* published by the Free Software Foundation; either version 2.1 of
* the License, or (at your option) any later version.
*
* This software is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this software; if not, write to the Free
* Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
* 02110-1301 USA, or see the FSF site: http://www.fsf.org.
*/

import org.chromattic.api.annotations.Create;
import org.chromattic.api.annotations.OneToMany;
import org.chromattic.api.annotations.PrimaryType;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;

/**
* Models an <code>nt:folder</code> node.
*
* @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a>
* @version $Revision$
*/
@PrimaryType(name = "xgallery:gallery")
public abstract class Gallery extends Base
{
   
   /**
* Factory method for directory object.
*
* @return a blank content
*/
   @Create
   protected abstract Gallery createGallery();

   
   @Create
   protected abstract Photo createPhoto(); 
 
  
   @OneToMany
   public abstract Map<String,Photo> getPhotos();
   
   
   @OneToMany
   public abstract Map<String,Gallery> getAlbums();
   
      
   public void savePhoto(String name, String mimeType, byte[] data)
   {
      savePhoto(name, mimeType, new ByteArrayInputStream(data));
   }

   
   public void savePhoto(String name, String mimeType, ByteArrayInputStream data)
   {
	   Photo photo = getPhotos().get(name);	   	
	   photo.update(mimeType, data);
   }

   
   public Photo addPhoto(String name, String mimeType, InputStream data)
   {
      Photo photo = createPhoto();      
      getPhotos().put(name,photo);
      photo.update(mimeType, data);
      return photo;
   }
   
   public Gallery addSubAlbum(String name){
	   Gallery g = createGallery();
	   getAlbums().put(name, g);
	   return g;
   }
   
   public void removeAlbum(String name){
	   Gallery g = getAlbums().get(name);
	   //TODO: empty g
	   getAlbums().remove(name);	   
   }
   
   
}