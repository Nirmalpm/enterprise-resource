package com.nirmal.pachakari.utils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;

@Component
public class ImageUtil {
	/**
	 * 
	 * @param inputImagePath
	 * @param outputImagePath
	 * @param scaleWidth
	 * @param scaleHeight
	 * @throws IOException
	 */
	public File resize(String inputImagePath, String outputImagePath, int scaleWidth, int scaleHeight)
			throws IOException {
		// read input image
		File inputFile = new File(inputImagePath);
		BufferedImage inputImage = ImageIO.read(inputFile);

		// create output image
		BufferedImage outputImage = new BufferedImage(scaleWidth, scaleHeight, inputImage.getType());

		// scale input image to output image
		Graphics2D g2d = outputImage.createGraphics();
		g2d.drawImage(inputImage, 0, 0, scaleWidth, scaleHeight, null);
		g2d.dispose();

		// extract the extension of output file
		String formatName = outputImagePath.substring(outputImagePath.lastIndexOf(".") + 1);

		// writes to output file
		File outputFile = new File(outputImagePath);
		ImageIO.write(outputImage, formatName, outputFile);
		return outputFile;

	}
	
	/**
	 * 
	 * @param inputImagePath
	 * @param outputImagePath
	 * @param percent
	 * @throws IOException
	 */
	public File resize(String inputImagePath, String outputImagePath, double percent) throws IOException {
		// read input image
		File inputFile = new File(inputImagePath);
		BufferedImage inputImage = ImageIO.read(inputFile);
		int scaleWidth = (int) (inputImage.getWidth() * percent);
		int scaleHeight = (int) (inputImage.getHeight() * percent);
		return resize(inputImagePath, outputImagePath, scaleWidth, scaleHeight);
	}
}
