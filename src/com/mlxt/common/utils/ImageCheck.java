package com.mlxt.common.utils;

import java.util.Arrays;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

/**
 * Filename: ImageCheck.java
 * 
 * ·面部识别检测类
 * 
 * @author Zhangqin
 * @version 1.0
 */
public class ImageCheck {

	/**
	 * ·初始化人脸探测器
	 */
	static CascadeClassifier faceDetector;

	/**
	 * ·初始化人脸探测器
	 */
	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		faceDetector = new CascadeClassifier("F:\\face-detact\\src\\com\\company\\haarcascade_frontalface_alt.xml");
	}

	/**
	 * ·将图片插入数据库
	 */
	public static void readImage2DB() {
//		String path = "E:/5.jpg";
//		Connection conn = null;
//		PreparedStatement ps = null;
//		FileInputStream in = null;
//		try {
//			in = ImageUtil.readImage(path);
//			conn = DBUtil.getConn();
//			String sql = "insert into photo (id,name,photo)values(?,?,?)";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, 5);
//			ps.setString(2, "Tom");
//			ps.setBinaryStream(3, in, in.available());
//			int count = ps.executeUpdate();
//			if (count > 0) {
//				System.out.println("插入成功！");
//			} else {
//				System.out.println("插入失败！");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBUtil.closeConn(conn);
//			if (null != ps) {
//				try {
//					ps.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
	}

	/**
	 * ·读取数据库中图片
	 * @param id
	 * @return
	 */
	public static String readDB2Image(int id) {
		String targetPath = "D:/image/";
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			conn = DBUtil.getConn();
//			String sql = "select * from photo where id =?";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, id);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				int ids = rs.getInt("id");
//				// System.out.println(id);
//				InputStream in = rs.getBinaryStream("photo");
//				targetPath = targetPath + ids + ".png";
//				ImageUtil.readBin2Image(in, targetPath);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBUtil.closeConn(conn);
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (ps != null) {
//				try {
//					ps.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
		return targetPath;
	}

	/**
	 * ·面部对比
	 * @param img_1
	 * @param img_2
	 * @return
	 */
	public static double compare_image(String img_1, String img_2) {
		Mat mat_1 = conv_Mat(img_1);
		Mat mat_2 = conv_Mat(img_2);

		Mat hist_1 = new Mat();
		Mat hist_2 = new Mat();

		// 颜色范围
		MatOfFloat ranges = new MatOfFloat(0f, 256f);
		// 直方图大小， 越大匹配越精确 (越慢)
		MatOfInt histSize = new MatOfInt(1000);

		Imgproc.calcHist(Arrays.asList(mat_1), new MatOfInt(0), new Mat(), hist_1, histSize, ranges);
		Imgproc.calcHist(Arrays.asList(mat_2), new MatOfInt(0), new Mat(), hist_2, histSize, ranges);

		// CORREL 相关系数
		double res = Imgproc.compareHist(hist_1, hist_2, Imgproc.CV_COMP_CORREL);
		return res;
	}

	/**
	 * ·图像处理
	 * @param img_1
	 * @return
	 */
	private static Mat conv_Mat(String img_1) {
		Mat image0 = Imgcodecs.imread(img_1);

		Mat image = new Mat();
		// 灰度转换
		Imgproc.cvtColor(image0, image, Imgproc.COLOR_BGR2GRAY);

		MatOfRect faceDetections = new MatOfRect();
		// 探测人脸
		faceDetector.detectMultiScale(image, faceDetections);

		// rect中是人脸图片的范围
		for (Rect rect : faceDetections.toArray()) {
			// 切割rect人脸
			Mat mat = new Mat(image, rect);
			return mat;
		}
		return null;
	}

}
