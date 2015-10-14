package com.bloc.threads;
import java.net.URL;
import java.io.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;

public class ImageGetter extends Thread {

	URL mURL;

	boolean openWhenCompleted;

	public ImageGetter(String url, boolean openWhenCompleted){
		try{
			mURL = new URL(url);
		}
		catch(Exception e){
			System.out.println("Invalid URL");
		}

	}
	/*
	 * ImageGetter
	 *
	 * Initialize the ImageGetter class.
	 *
	 * @param url The URL of the image this ImageGetter should
	 *		  download (String)
	 * @param openWhenCompleted if `true`, the image will be opened
	 *		  as soon it is downloaded, `false` otherwise
	 */
	/************************************************
 	 *	ASSIGNMENT:
 	 *	Implement this constructor for ImageGetter.
 	 *	The variables passed into it must impact the `run()` method's
 	 *	behavior as described above.
	/************************************************/

	@Override
	public void run() {
		try {
			File existingImage = new File("google_logo.png");
			if (existingImage.exists()) {
				existingImage.delete();
			}
			
			BufferedImage bufferedImage = ImageIO.read(mURL);
			File outputfile = new File("google_logo.png");
			ImageIO.write(bufferedImage, "png", outputfile);
			if ("/".equals(System.getProperties().getProperty("file.separator"))) {
				Runtime.getRuntime().exec("open google_logo.png");
			} else {
				Runtime.getRuntime().exec("google_logo.png");
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}