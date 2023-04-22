package Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

public class UploadFile {

	public static List<String> uploadFile(String nameInput, HttpServletRequest request) {
		List<String> listPathImage = new ArrayList<String>();
		//lấy đường dẫn project
		File fileUpload = new File(request.getServletContext().getRealPath("/uploads"));
		if(!fileUpload.exists()) {
			//Tạo folder chưa file upload
			fileUpload.mkdirs();
		}
		
		
		try {
			List<Part> parts = (List<Part>) request.getParts();
			for (Part part : parts) {
				//kiểm tra part có đúng với name upload
				if (part.getName().equalsIgnoreCase(nameInput)) {
					//lấy tên file
					String fileName = part.getSubmittedFileName();
					
					//ghi file vào fileupload
					part.write(fileUpload.getAbsolutePath() + "/"  + fileName);
					
					listPathImage.add(fileUpload.getAbsolutePath() + "/"  + fileName);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return listPathImage;
	}

	private static String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	public static List<String> upCloudBinary(List<String> ListpathImage) {
		List<String> listPathCloudBinary = new ArrayList<>();
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "dqzsk2uls", "api_key",
				"451374263271413", "api_secret", "TCNze888wLpobby6lx9sYETJ5hw", "secure", true));

		for (String path : ListpathImage) {
			File file = new File(path);

			try {
				Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
				listPathCloudBinary.add(uploadResult.get("secure_url").toString());
				System.out.println(uploadResult);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		
		return listPathCloudBinary;
	}

}
