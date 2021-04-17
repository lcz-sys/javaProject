package cn.gdcp.utils;


import org.springframework.util.ClassUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class UploadUtil {

	public static String upload(MultipartFile file) throws Exception{
		// 判断是否有上传文件
		if (Objects.isNull(file) || file.isEmpty() || Objects.isNull(file.getOriginalFilename())) {
			return null;
		}
		String savePath = "upload"; // 保存文件的相对目录
		String fileName = file.getOriginalFilename();

		// 文件存储路径
		String path = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
		String out = path.substring(0, path.lastIndexOf("out"))+"\\src\\main\\webapp\\"+savePath;

        // 获取当前系统时间字符串
		String time = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

		// 构建新文件名
		String newFileName = time+"_"+fileName;

		// 按指定路径重命名构建文件
		File savefile = new File(out,newFileName);

		// 若保存文件的文件夹不存在则创建
		if(!savefile.getParentFile().exists()){
			savefile.getParentFile().mkdirs();
		}
//		System.out.println("上传文件绝对路径: "+savefile.getPath());
		file.transferTo(savefile);
		return "/"+savePath+"/"+newFileName;
	}

}
