/*
 * Copyright 2013 Hannes Janetzek
 *
 * This program is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.oscim.backend;


public class GLAdapter {

	public static boolean GDX_NO_LINUX_QUIRKS;

	public static GL20 g;

	public static boolean GDX_DESKTOP_QUIRKS;
	public static boolean GDX_WEBGL_QUIRKS;

	public static boolean NON_PREMUL_CANVAS;

	public static GL20 get(){
		return g;
	}
}
