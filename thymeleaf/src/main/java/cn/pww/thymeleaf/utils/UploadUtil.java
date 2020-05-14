package cn.pww.thymeleaf.utils;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

public class UploadUtil {
	public final static Logger logger = LoggerFactory.getLogger(UploadUtil.class);

//	public static final String file_dir = "/home/site/wwwroot/webapps/files";
	public static final String file_dir =System.getProperty("catalina.home")+"\\webapps\\files";

	public static Map<String, String> upload(HttpServletRequest request) {
		return upload(request, null);
	}

	/**
	 * 
	 * @param request
	 * @param fieldName
	 * @return key 生成的文件名 value 原文件名
	 */
	public static Map<String, String> upload(HttpServletRequest request, String fieldName) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			if (ServletFileUpload.isMultipartContent(request)) {
				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
				Iterator<String> paramNames = multipartRequest.getFileNames();
				while (paramNames.hasNext()) {
					String paramName = (String) paramNames.next();
					if (fieldName == null || (fieldName != null && paramName.equals(fieldName))) {
						List<MultipartFile> files = multipartRequest.getFiles(paramName);
						if (files != null && files.size() > 0)
							for (int i = 0; i < files.size(); i++) {
								MultipartFile file = files.get(i);
								if (file.getSize() == 0)
									continue;
								String fileName = UUID.randomUUID().toString();
								if (!StringUtils.isEmpty(file.getOriginalFilename())
										&& file.getOriginalFilename().indexOf(".") > 0) {
									String fileType = file.getOriginalFilename().substring(
											file.getOriginalFilename().lastIndexOf("."),
											file.getOriginalFilename().length());
									if (!StringUtils.isEmpty(fileType))
										fileName = fileName + fileType;

								}
								fileName = saveFile(fileName, file);
								map.put(fileName, file.getOriginalFilename());
							}
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return map;
	}


	private static String saveFile(String fileName, MultipartFile file) throws Exception {

//        File dir = new File( ResourceUtils.getURL("classpath:").getPath()+"/static");
        File dir = new File(file_dir);
		if (!dir.exists())
			dir.mkdir();
		File destFile = new File(dir.getAbsolutePath() + "\\" + fileName);
		file.transferTo(destFile);
		return fileName;
	}

	/*public static void deleteFile(String fileName)  {
		File dir = new File(file_dir);
		if (!dir.exists())
			dir.mkdir();
		File destFile = new File(dir.getAbsolutePath() + "/" + fileName);
		if (destFile.exists())
			destFile.delete();
	}*/
}
