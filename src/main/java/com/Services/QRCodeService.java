package com.Services;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.google.zxing.WriterException;

@Service
public interface QRCodeService {

	void generateQRCodeImage(String text, int width, int height, String filePath) throws Exception;
	
}
