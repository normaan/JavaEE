package com.jdm.jdmshop.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("TraversePicture3")
public class no_TraversePicture3 {

	public List<String> fileList(HttpServletRequest request){
		List<String> list = new ArrayList<String>();
		String path = request.getSession().getServletContext().getRealPath("/");//项目的绝对路径
		File file = new File(path+"/file/img");//文件夹路径
		File[] files = file.listFiles();//遍历该文件夹
		if(null!=files){
			for (int i = 0; i < files.length; i++){
				File file1 = files[i];
				String name = file1.getName();//获取图片名称
				list.add(name);
			}
			return list;
		}else{
			return null;
		}


	}
	
}



