package kr.re.etri.advcloud.common.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class FileUtil {
	
	public static boolean createDir(String dirPath) {
		try {
			return new File(dirPath).mkdirs();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public static File createFile(InputStream stream, String filePath) throws Exception {
		BufferedOutputStream bos = null;

		try {
			File saveFile = new File(filePath);

			if (saveFile.isDirectory()) {
				throw new Exception("파일 경로가 올바르지 않습니다.");
			}

			if (!saveFile.getParentFile().exists()) {
				saveFile.getParentFile().mkdirs();
			}

			if (saveFile.exists()) {
				saveFile.delete();
			}

			bos = new BufferedOutputStream(new FileOutputStream(saveFile));

			int read = 0;
			byte[] buffer = new byte[8192];
			while ((read = stream.read(buffer)) != -1) {
				bos.write(buffer, 0, read);
			}

			bos.flush();

			return saveFile;
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (stream != null)
				stream.close();
			if (bos != null)
				bos.close();
		}
	}

	public static boolean loadFile(String filePath, OutputStream outputStream) {
		FileInputStream inputStrean = null;
		try {
			File file = new File(filePath);
            inputStrean = new FileInputStream(file);
			
			byte[] outByte = new byte[8192];
			while (inputStrean.read(outByte, 0, 8192) != -1) {
				outputStream.write(outByte, 0, 8192);
			}
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			try {
				inputStrean.close();
			} catch (IOException e) {
			}
		}
	}
	
	public static boolean exist(String filePath) {
		try {
			return new File(filePath).exists();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public static void copy(String src, String dest) throws IOException {
		FileUtils.copyFile(new File(src), new File(dest));
	}

	public static void move(String src, String dest) throws IOException {
		if (exist(dest)) {
			delete(dest);
		}
		FileUtils.moveFile(new File(src), new File(dest));
	}

	public static void delete(String filePath) throws IOException {
		FileUtils.forceDelete(new File(filePath));
	}
	
	public static String fileName(String filePath) {
		return StringUtils.substring(filePath, filePath.lastIndexOf(File.separator) + 1);
	}

	public static String fileNameWithoutExt(String filePath) {
		String fileName = fileName(filePath);
		return StringUtils.left(fileName, fileName.lastIndexOf("."));
	}

	public static String fileExt(String filePath) {
		return StringUtils.substring(filePath, filePath.lastIndexOf(".") + 1);
	}

	public static long fileSize(String filePath) {
		try {
			File file = new File(filePath);

			if (file.exists()) {
				if (file.isDirectory()) {
					return 0;
				} else {
					return file.length();
				}
			} else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	// 파일복사
	public static Map<String, Object> copyToFile(String basePath, String dirPath, String filePath, String fileName) throws Exception {
		Map<String, Object> result = null;
		try{
			File oldFile = new File(basePath + dirPath + filePath, fileName);
			String newPath = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
			String nowYMDHMS = new SimpleDateFormat("yyyyMMddHmsS").format(new Date());
			String newFileName = nowYMDHMS + fileName;
			File newFile = new File(basePath + dirPath + newPath, newFileName);

			if(oldFile.exists()){
				FileUtils.copyFile(oldFile, newFile);
				result = new HashMap<String, Object>();
				result.put("newPath", newPath);
				result.put("newFileName", newFileName);
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return result;
	}
	
	public static List<String> getFileList(String dirPath) {
		List<String> fileList = new ArrayList<String>();
		for (File file : new File(dirPath).listFiles()) {
			if (file.isDirectory() || file.isHidden()) {
				continue;
			}
			fileList.add(file.getName());
		}

		return fileList;
	}
	
}
