package yangguohao.servlet;

import yangguohao.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Mr.Yang
 * @date 2020/03/02
 **/
public class SearchStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("");

        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int t = i + 1;
            students.add(new Student(t,"student"+t,t+18,"phone"+t));
        }

        request.setAttribute("stuList",students);
        request.getRequestDispatcher("/test/showStudent.jsp").forward(request,response);
    }
}
