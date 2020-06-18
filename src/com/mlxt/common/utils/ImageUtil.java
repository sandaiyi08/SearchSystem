package com.mlxt.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Filename: ImageUtil.java
 * 
 * ·面部识别工具类
 * 
 * @author Zhangqin
 * @version 1.0
 */
public class ImageUtil {
	
	/**
	 * ·读取本地图片获取输入流
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static FileInputStream readImage(String path) throws IOException {
		return new FileInputStream(new File(path));
	}

	/**
	 * ·读取表中图片获取输出流
	 * @param in
	 * @param targetPath
	 */
	public static void readBin2Image(InputStream in, String targetPath) {
		File file = new File(targetPath);
		String path = targetPath.substring(0, targetPath.lastIndexOf("/"));
		if (!file.exists()) {
			new File(path).mkdir();
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			int len = 0;
			byte[] buf = new byte[1024];
			while ((len = in.read(buf)) != -1) {
				fos.write(buf, 0, len);
			}
			fos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != fos) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
