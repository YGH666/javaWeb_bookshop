package yangguohao.servlet;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * @author Mr.Yang
 * @date 2020/03/04
 **/
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取下载文件名
        String filename = "雪乃姐.jpg";
        //通过servletcontext对象获取下载文件内容
        ServletContext servletContext = getServletContext();
        //获取下载文件类型
        String mimeType = servletContext.getMimeType("/file/" + filename);
        System.out.println("mimeType = " + mimeType +" "+filename);
        //通过相应头告诉客户端数据类型
        response.setContentType(mimeType);
        //根据浏览器，设置响应头是否下载
        if (request.getHeader("User-Agent").contains("Firefox")){
            //火狐浏览器
            response.setHeader("Content-Disposition","attachment;filename==?UTF-8?B?"+new BASE64Encoder().encode(filename.getBytes("UTF-8")) +"?=");
        }else {
            //ie,chrome浏览器
            response.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(filename,"utf-8"));
        }


        //获取文件流和输出流
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + filename);
        OutputStream outputStream = response.getOutputStream();
        //调用工具包将文件流复制到输出流
        IOUtils.copy(resourceAsStream,outputStream);

    }
}
