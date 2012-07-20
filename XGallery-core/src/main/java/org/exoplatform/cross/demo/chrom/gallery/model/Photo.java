package org.exoplatform.cross.demo.chrom.gallery.model;

import java.io.InputStream;

import org.chromattic.api.annotations.Create;
import org.chromattic.api.annotations.MappedBy;
import org.chromattic.api.annotations.Name;
import org.chromattic.api.annotations.OneToOne;
import org.chromattic.api.annotations.Owner;
import org.chromattic.api.annotations.Path;
import org.chromattic.api.annotations.PrimaryType;

@PrimaryType(name = "nt:file")
public abstract class Photo extends Base{
	
	@Name
	public abstract String getName();
	
	@Path
	public abstract String getPath();
	
	 /**
	    * Returns the document's content or null if no content is associated with this document.
	    *
	    * @return the document content
	    */
	   @OneToOne
	   @Owner
	   @MappedBy("jcr:content")
	   protected abstract Content getContent();

	   /**
	    * Set the document content.
	    *
	    * @param content the document content
	    */
	   protected abstract void setContent(Content content);

	   /**
	    * Factory method for content object.
	    *
	    * @return a blank content
	    */
	   @Create
	   protected abstract Content createContent();
	   
	   
	   public void update(String mimeType, InputStream data){
		   Content content = getContent();
		   if (content == null){
			   content = createContent();
			   setContent(content);
		   }
		   getContent().update(mimeType, data);
	   }

}
