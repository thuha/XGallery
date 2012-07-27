@Application(defaultController = org.exoplatform.cross.demo.juzu.gallery.control.GalleryController.class)
@Bindings({
	@Binding(value = ChromatticManager.class,
	implementation = CrossMetaProvider.class),
	@Binding(value = ChromGalleryService.class,
	implementation = CrossMetaProvider.class)
})
@Assets(
scripts = {
		@Script(src="javascript/jquery.js", location = AssetLocation.SERVER),
		//bootstrap
		@Script(src="javascript/bootstrap/js/bootstrap-modal.js", location = AssetLocation.SERVER),
		@Script(src="javascript/bootstrap/js/bootstrap-tooltip.js", location = AssetLocation.SERVER),
		@Script(src="javascript/bootstrap/js/bootstrap-popover.js", location = AssetLocation.SERVER),
		//@Script(src="javascript/bootstrap/js/application.js", location = AssetLocation.SERVER),
		@Script(src="javascript/bootstrap/js/galleryView-bootstrap.js", location = AssetLocation.SERVER),
		//jquery-ui
		@Script(src="javascript/jquery-ui-1.8.22/js/jquery-ui-1.8.22.custom.min.js", location = AssetLocation.SERVER),
		@Script(src="javascript/jquery-ui-1.8.22/js/jquery.ui.sortable.js", location = AssetLocation.SERVER),
		@Script(src="javascript/jquery-ui-1.8.22/js/jquery.ui.widget.js", location = AssetLocation.SERVER),
		@Script(src="javascript/jquery-ui-1.8.22/js/jquery.ui.button.min.js", location = AssetLocation.SERVER),
		@Script(src="javascript/jquery-ui-1.8.22/js/galleryView-jQUI.js", location = AssetLocation.SERVER)
	},
stylesheets = {		
	//bootstrap
	@Stylesheet(src="javascript/bootstrap/css/bootstrap.css", location = AssetLocation.SERVER),
	//@Stylesheet(src="javascript/bootstrap/css/bootstrap-responsive.css", location = AssetLocation.SERVER),
	//jquery-ui
	@Stylesheet(src="javascript/jquery-ui-1.8.22/css/jquery-ui-1.8.21.custom.css", location = AssetLocation.SERVER)
	}
)
package org.exoplatform.cross.demo.juzu.gallery;



import org.juzu.Application;
import org.juzu.plugin.binding.Binding;
import org.juzu.plugin.binding.Bindings;
import org.exoplatform.commons.chromattic.ChromatticManager;
import org.exoplatform.cross.demo.chrom.gallery.service.ChromGalleryService;
import org.exoplatform.cross.demo.juzu.gallery.provider.CrossMetaProvider;
import org.juzu.impl.plugin.asset.AssetLocation;
import org.juzu.plugin.asset.Assets;
import org.juzu.plugin.asset.Script;
import org.juzu.plugin.asset.Stylesheet;
