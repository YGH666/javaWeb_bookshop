package yangguohao.web;

import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;
import yangguohao.pojo.User;
import yangguohao.service.UserService;
import yangguohao.service.impl.UserServiceImpl;
import yangguohao.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author Mr.Yang
 * @date 2020/03/04
 **/
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username");
//        System.out.println("username = " + username);
        String password = request.getParameter("password");
//        System.out.println("password = " + password);
        User loginUser = userService.login(new User(null, username, password, null));
        System.out.println(loginUser);
        if (loginUser == null){
            System.out.println("登陆失败！");
            request.setAttribute("msg","用户名或密码错误!");
            request.setAttribute("username",username);
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }else {
            System.out.println("登陆成功！");
            request.getSession().setAttribute("user",loginUser);
            if ("admin".equals(loginUser.getUsername())){
                request.getSession().setAttribute("isRoot","yes");
            }else {
                request.getSession().setAttribute("isRoot","no");
            }

//            request.getRequestDispatcher("/index.jsp").forward(request,response);
            response.sendRedirect(request.getContextPath());
        }
    }

    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        User user = WebUtils.copyParamToBean(request.getParameterMap(),new User());

        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        if (token == null ){
            request.setAttribute("msg","请不要重复提交表单！");
        }else if (token.equalsIgnoreCase(code)){
            if (userService.existUsername(username)){
                System.out.println("用户名["+username+"]已存在");

                request.setAttribute("msg","用户名["+username+"]已存在");
                request.setAttribute("username",username);
                request.setAttribute("email",email);

                request.getRequestDispatcher("/regist.jsp").forward(request,response);
            }else {
                userService.registUser(user);
                request.getRequestDispatcher("/login.jsp").forward(request,response);
                System.out.println("注册成功");
            }
        }else {
            request.setAttribute("msg","验证码错误！");
            request.setAttribute("username",username);
            request.setAttribute("email",email);

            System.out.println("验证码错误!");
            request.getRequestDispatcher("/regist.jsp").forward(request,response);
        }
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }

    protected void ajaxExistUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        boolean existUsername = userService.existUsername(username);

        Map<String,Object> map = new HashMap<>();
        map.put("existUsername",existUsername);

        Gson gson = new Gson();
        String json = gson.toJson(map);

        resp.getWriter().write(json);
    }
}

