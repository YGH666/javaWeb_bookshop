package yangguohao.servlet;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Blob;
import java.sql.Connection;
import java.util.List;

/**
 * @author Mr.Yang
 * @date 2020/03/03
 **/
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("上传成功");
/*//        System.out.println(request.getAttribute("username"));

        ServletInputStream inputStream = request.getInputStream();
        byte[] buffer = new byte[1024000];
        int read = inputStream.read(buffer);
        System.out.println(new String(buffer,0,read));*/

        //1.判断上传数据是否是多段上传，有文件上传的就是多段数据
        if (ServletFileUpload.isMultipartContent(request)){
            //创建工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建解析上床数据的工具类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

            Connection conn = JdbcUtils.getConnection();
            QueryRunner runner = new QueryRunner();
            String sql = "insert into customer(name,photo) values(?,?)";
            String name = null;
            InputStream is = null;

            //获取解析后的数据
            try {
                List<FileItem> list = servletFileUpload.parseRequest(request);

                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()){
                        //普通表单项
                        System.out.println("name="+fileItem.getFieldName());
                        System.out.println("value="+fileItem.getString("UTF-8"));

                        name=fileItem.getString("UTF-8");
                    }else {
                        //文件
                        System.out.println("name="+fileItem.getFieldName());
                        System.out.println("value="+fileItem.getName());

                        //下载到本地
//                        fileItem.write(new File("D:\\image\\"+fileItem.getName()));
                        //获取流数据，存到数据库
                        is = fileItem.getInputStream();
                    }
                }
                runner.update(conn,sql,name,is);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                is.close();
                JdbcUtils.close(conn);
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
