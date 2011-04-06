/*
Version.java
Copyright (C) 2010  Belledonne Communications, Grenoble, France

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
*/
package org.linphone.core;

import android.os.Build;

/**
 * Centralize version access and allow simulation of lower versions.
 * @author Guillaume Beraudo
 */
public class Version {

	private static final int buildVersion = Integer.parseInt(Build.VERSION.SDK);
//		7; // 2.1

	public static final boolean sdkAboveOrEqual(int value) {
		return buildVersion >= value;
	}

	public static final boolean sdkStrictlyBelow(int value) {
		return buildVersion < value;
	}

	public static int sdk() {
		return buildVersion;
	}

	public static boolean isArmv7() {
		try {
			return sdkAboveOrEqual(4)
			&& Build.class.getField("CPU_ABI").get(null).toString().startsWith("armeabi-v7");
		} catch (Throwable e) {}
		return false;
	}


}