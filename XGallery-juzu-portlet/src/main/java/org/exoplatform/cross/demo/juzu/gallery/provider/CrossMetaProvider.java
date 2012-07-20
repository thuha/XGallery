/*
 * Copyright (C) 2003-2012 eXo Platform SAS.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.exoplatform.cross.demo.juzu.gallery.provider;

import java.lang.reflect.Method;

import javax.inject.Provider;

import org.exoplatform.commons.chromattic.ChromatticManager;


/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Mar 13, 2012  
 * @param <T>
 * @param <T>
 */
public class CrossMetaProvider implements org.juzu.impl.inject.MetaProvider{
	
	private final String containerName = "portal";
	
	//@Override
		public <T> Provider<? extends T> getProvider(final Class<T> implementationType) {
			 return new Provider<T>() {
			      
			      @Override
			      public T get() {
			    	  
					try
				      {
				         ClassLoader cl = Thread.currentThread().getContextClassLoader();
				         
				         // Get top container
				         Class<?> eXoContainerContextClass = cl.loadClass("org.exoplatform.container.ExoContainerContext");
				         Method getTopContainerMethod = eXoContainerContextClass.getMethod("getTopContainer");
				         Object topContainer = getTopContainerMethod.invoke(null);
		
				         //
				         if (topContainer == null)
				         {
				            throw new Exception("Could not locate the top container");
				         }
		
				         //
				         Method getPortalContainerMethod = topContainer.getClass().getMethod("getPortalContainer", String.class);
				         Object container = getPortalContainerMethod.invoke(topContainer, containerName);
				         System.out.println("---->ChMan: "+topContainer.getClass().getClassLoader());
				         //
				         if (container == null)
				         {
				            throw new Exception("Could not obtain the " + containerName + " portal container");
				         }
		
				         //
				         Method getComponentInstanceOfTypeMethod = container.getClass().getMethod("getComponentInstanceOfType", Class.class);
				         //Class<?> serviceClass = Thread.currentThread().getContextClassLoader().loadClass(implementationType.getName());
				         Object service = getComponentInstanceOfTypeMethod.invoke(container, implementationType);
		
				         //
				         if (service == null)
				         {
				            throw new Exception("Could not obtain the chrom service");
				         }
						         
				         return (T) service;
				      }
				      catch (Exception e)
				      {
				    	 e.printStackTrace();
				         throw null;
				      }
				}
			 };
		}
}
