package com.mlxt.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Filename: ImageUtil.java
 * 
 * ���沿ʶ�𹤾���
 * 
 * @author Zhangqin
 * @version 1.0
 */
public class ImageUtil {
	
	/**
	 * ����ȡ����ͼƬ��ȡ������
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static FileInputStream readImage(String path) throws IOException {
		return new FileInputStream(new File(path));
	}

	/**
	 * ����ȡ����ͼƬ��ȡ�����
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
