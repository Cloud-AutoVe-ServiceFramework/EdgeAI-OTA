package kr.re.etri.advcloud.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.re.etri.advcloud.common.constant.FtpClientConstant;

public class FtpClientUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(FtpClientUtils.class);
	
	private static FTPClient ftpClient = null;
	
	private static FtpClientConstant ftpClientConstant;
	
	public static void open(FtpClientConstant ftpClientConstant) {
		FtpClientUtils.ftpClientConstant = ftpClientConstant;
		ftpClient = new FTPClient();
	}
	
//	public static void close() {
//		if (ftpClient != null) {
//			try {
//				ftpClient.logout();
//				ftpClient.disconnect();
//			} catch (Exception e) {
//				log.error(e.getMessage(), e);
//			}
//		}
//	}

	private static void connect() {
		try {
			logger.debug(">>> ftpClientConstant.getHost(): {}", ftpClientConstant.getADVMHost());
			
			ftpClient.connect(ftpClientConstant.getADVMHost(), ftpClientConstant.getADVMPort());
			ftpClient.login(ftpClientConstant.getADVMUsername(), ftpClientConstant.getADVMPassword());
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			ftpClient.enterLocalPassiveMode();
			//ftpClient.setControlKeepAliveTimeout(config.getKeepAliveTimeout());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	private static void disconnect() {
		try {
			ftpClient.logout();
			ftpClient.disconnect();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	// 
	@SuppressWarnings("hiding")
	public static boolean saveFile(File file, String workingDirectory, String fileName) {
		InputStream targetStream = null;
		try {
			targetStream = new FileInputStream(file);
			return saveFile(targetStream, workingDirectory, fileName);
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage(), e);
			return false;
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			return false;
		} finally {
			try {
				targetStream.close();
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}
	}
	
	public static boolean saveFile(InputStream inputStream, String workingDirectory, String fileName) {
		try {
			connect();
			
			String currentDirectory = ftpClient.printWorkingDirectory();
			if (currentDirectory.indexOf(workingDirectory) == -1) {
				boolean isChange = ftpClient.changeWorkingDirectory(workingDirectory);
				if (!isChange) {
					ftpClient.makeDirectory(workingDirectory);
					logger.info(ftpClient.getReplyString());
					ftpClient.changeWorkingDirectory(workingDirectory);
					logger.info(ftpClient.getReplyString());
				}
			}
			boolean result = ftpClient.storeFile(fileName, inputStream);
			logger.info(ftpClient.getReplyString());
			return result;
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			return false;
		} finally {
			disconnect();
		}
	}

	public static boolean loadFile(String remotePath, OutputStream outputStream) {
		try {
			connect();
			return ftpClient.retrieveFile(remotePath, outputStream);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			return false;
		} finally {
			disconnect();
		}
	}

	public static boolean deleteFile(String filePath) {
		try {
			connect();
			
			boolean result = ftpClient.deleteFile(filePath);
			logger.info(ftpClient.getReplyString());
			
			return result;
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			return false;
		} finally {
			disconnect();
		}
	}
	
}
