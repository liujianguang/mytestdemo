
package com;

import java.io.File;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @ClassName: FileDoUtil
 * @Description: 文件操作辅助类
 * @author Jeckey.Liu
 * @date 2014年7月29日 下午12:02:26
 * 
 */
public class FileDoUtil {
	private static final Log logger = LogFactory.getLog(FileDoUtil.class);

	/**
	 * 创建目录和创建文件
	 * @param file
	 */
	public static void mkDirs(File file) {
		if (file == null) {
			return;
		} else if (file.exists()) {
			return;
		} else {
			String path = file.getAbsolutePath();
			int index = path.lastIndexOf(File.separator);
			String dirsPath = new String(path.substring(0, index));
			File filedirs = new File(dirsPath);
			if (!filedirs.exists()) {
				filedirs.mkdirs();
			}
			try {
				file.createNewFile();
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}
	}

}
