package org.exoplatform.cross.demo.chrom.gallery.model;

import java.util.Date;

import org.chromattic.api.annotations.Id;
import org.chromattic.api.annotations.Name;
import org.chromattic.api.annotations.Path;
import org.chromattic.api.annotations.PrimaryType;
import org.chromattic.api.annotations.Property;


@PrimaryType(name = "nt:hierarchyNode")
public abstract class Base{
	/**
	* Returns the file id.
	*
	* @return the file id
	*/
	   @Id
	   public abstract String getId();

	   /**
	* Returns the file path.
	*
	* @return the file path
	*/
	   @Path
	   public abstract String getPath();

	   /**
	* Returns the file name.
	*
	* @return the file name
	*/
	   @Name
	   public abstract String getName();

   /**
	* Returns the creation date of this file.
	*
	* @return the creation date
	*/

	   @Property(name = "jcr:created")
	   public abstract Date getCreated();
}
