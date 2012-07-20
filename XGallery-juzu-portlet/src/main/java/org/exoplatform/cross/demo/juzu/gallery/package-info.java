@Application(defaultController = org.exoplatform.cross.demo.juzu.gallery.control.GalleryController.class)
@Bindings({
	@Binding(value = ChromatticManager.class,
	implementation = CrossMetaProvider.class),
	@Binding(value = ChromGalleryService.class,
	implementation = CrossMetaProvider.class)
})
package org.exoplatform.cross.demo.juzu.gallery;



import org.juzu.Application;
import org.juzu.plugin.binding.Binding;
import org.juzu.plugin.binding.Bindings;
import org.exoplatform.commons.chromattic.ChromatticManager;
import org.exoplatform.cross.demo.chrom.gallery.service.ChromGalleryService;
import org.exoplatform.cross.demo.juzu.gallery.provider.CrossMetaProvider;

