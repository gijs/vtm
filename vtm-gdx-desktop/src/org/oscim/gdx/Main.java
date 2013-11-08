package org.oscim.gdx;

import org.oscim.awt.AwtGraphics;
import org.oscim.backend.CanvasAdapter;
import org.oscim.backend.GLAdapter;
import org.oscim.core.Tile;
import org.oscim.tilesource.TileSource;
import org.oscim.tilesource.oscimap4.OSciMap4TileSource;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.utils.SharedLibraryLoader;

public class Main {

	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "vtm-gdx";
		cfg.useGL20 = true;
		cfg.width = 1280;
		cfg.height = 800;
		cfg.stencil = 8;
		cfg.foregroundFPS = 20;
		// cfg.samples = 4;

		// set our globals
		CanvasAdapter.g = AwtGraphics.INSTANCE;
		GLAdapter.g = new GdxGLAdapter();
		
		// need to strip precision modifier from shaders.
		GLAdapter.GDX_DESKTOP_QUIRKS = true;
		
		// Windows and OSX seems to force a buffer flip on each 
		// input event which makes it not possible to use non-
		// continuous rendering. 
		// Use this is to prevent the annoying flickering
		GLAdapter.GDX_NO_LINUX_QUIRKS = true;
		
		Tile.SIZE = 360;

		new SharedLibraryLoader().load("vtm-jni");

		new LwjglApplication(new GdxMapDesktop(), cfg);
	}

	static class GdxMapDesktop extends GdxMap {

		public GdxMapDesktop() {
			super();
		}

		@Override
		public void create() {
			super.create();

			TileSource tileSource = new OSciMap4TileSource();
			tileSource.setOption("url", "http://city.informatik.uni-bremen.de/tiles/vtm");

			initDefaultMap(tileSource, false, true, true);
		}
	}
}
