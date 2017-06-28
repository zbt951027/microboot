package cn.mldn.microboot.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.ProtoCommon;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.mldn.microboot.controller.util.AbstractBaseController;

@Controller
public class UploadController extends AbstractBaseController {
	@RequestMapping(value="/uploadPre", method=RequestMethod.GET)
	public String uploadPre() {
		return "upload/upload_page";
	}
	 
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	@ResponseBody
	public String upload(String name, HttpServletRequest request) throws Exception { 
		if(request instanceof MultipartHttpServletRequest) {
			MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest)request;
			List<MultipartFile> files = mrequest.getFiles("pic");
			Iterator<MultipartFile> iter = files.iterator();
			while(iter.hasNext()) {
				MultipartFile photo = iter.next();
				if(photo != null) {
					// 得到文件的扩展名称
					String extName = photo.getContentType().substring(photo.getContentType().lastIndexOf("/") + 1);
					// 取得要使用的配置文件
					ClassPathResource classPathResource = new ClassPathResource("fastdfs_client.properties");
					// 进行客户端访问的整体配置，需要知道配置文件的完整路径
					ClientGlobal.init(classPathResource.getClassLoader().getResource("fastdfs_client.properties").getPath());
					// 定义tracker客户端
					TrackerClient trackerClient = new TrackerClient();
					// 定义TrackerServer的配置信息
					TrackerServer trackerServer = trackerClient.getConnection();
					// 在整个FastDFS之中真正负责干活的就是Storage
					StorageServer storageServer = null;
					StorageClient1 storageClient = new StorageClient1(trackerServer, storageServer);
					
					// 定义上传文件的元数据
					NameValuePair[] metaList = new NameValuePair[3];
					metaList[0] = new NameValuePair("fileName", photo.getOriginalFilename());
					metaList[1] = new NameValuePair("fileExtName", extName);
					metaList[2] = new NameValuePair("fileLength", String.valueOf(photo.getSize()));
					// 如果要上传则使用trackerClient对象完成
					String upload_file1 = storageClient.upload_file1(photo.getBytes(), extName, metaList);
					System.out.println(upload_file1);  
//					storageClient.delete_file("group1", "M00/00/00/wKhtqFk7xE6ACpYGAABAnTpordQ064.png");
					trackerServer.close();
				}
			}
		}
		return "upload_file";
	}
	
	@RequestMapping(value="/show", method=RequestMethod.GET)
	public String show(String groupFile, Model model) throws Exception {
		ClassPathResource classPathResource = new ClassPathResource("fastdfs_client.properties");
		// 进行客户端访问的整体配置，需要知道配置文件的完整路径
		ClientGlobal.init(classPathResource.getClassLoader().getResource("fastdfs_client.properties").getPath());
		// 定义tracker客户端
		TrackerClient trackerClient = new TrackerClient();
		// 定义TrackerServer的配置信息
		TrackerServer trackerServer = trackerClient.getConnection();
		// group1/M00/00/00/wKhtqFlTrayAEzR_AAArVq8ZsB8509.png
		int ts = (int) (System.currentTimeMillis() / 1000);// 时间参考
		StringBuffer fileUrl = new StringBuffer();
		fileUrl.append("http://");
		fileUrl.append(trackerServer.getInetSocketAddress().getHostString());
		fileUrl.append("/").append(groupFile);
		fileUrl.append("?token=").append(ProtoCommon.getToken(groupFile.substring(groupFile.indexOf("/") + 1), ts, ClientGlobal.g_secret_key));
		fileUrl.append("&ts=").append(ts);
		trackerServer.close(); 
		model.addAttribute("image", fileUrl.toString());
		return "upload/upload_show"; 
	}
}
