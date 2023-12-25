package com.opencart.utils;

import java.nio.file.Paths;
import com.microsoft.playwright.Page;
import com.opencart.factory.Browsers;

/**
 * Utility class to capture screenshots using Playwright.
 */
public class ScreenshotUtility extends Browsers {

	/**
	 * Captures a screenshot and saves it to a directory.
	 *
	 * @return The file path of the captured screenshot.
	 */
	public static String captureScreenshot() {
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		Browsers.getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		return path;
	}
}
