package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UploadServlet")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try
//        {
//            RequestDispatcher rd;
//
//            String UPLOAD_DIRECTORY = "C:\\Users\\HP\\workspace\\E-Techform\\WebContent\\images";
//            response.setContentType("text/html;charset=UTF-8");
//            if(ServletFileUpload.isMultipartContent(request)){
//
//                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
//
//                for(FileItem item : multiparts){
//                    if(!item.isFormField()){
//                        name = new File(item.getName()).getName();
//                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
//                        String fp1=UPLOAD_DIRECTORY.replace("\\", "/");
//                        fp1=fp1+"/"+name;
//                        rd=request.getRequestDispatcher("/Register.jsp");
//                        request.setAttribute("msg", fp1);
//                        rd.forward(request, response);
//
//                    }
//                }
//            }
//
//        } catch (Exception ex) {
//            request.setAttribute("message", "File Upload Failed due to " + ex);
//
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
