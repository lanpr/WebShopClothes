package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import DAO.UserDAO;
import Utils.CookieUtils;
import model.User;

@MultipartConfig
@WebServlet({ "/account/sign-in", "/account/sign-up", "/account/sign-out" })
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("sign-up")) {
			signUp(req, resp);

		} else if (uri.contains("sign-in")) {
			signIn(req, resp);
		} else if (uri.contains("sign-out")) {
			signOut(req, resp);
		}

	}

	protected void signIn(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getMethod();
		response.setContentType("text/html;charset=UTF-8");

		try {
			if (method.equals("POST")) {
				String username = request.getParameter("email");
				String password = request.getParameter("matkhau");
				String remember = request.getParameter("remember");
				User user = UserDAO.findUserById(username);
				PrintWriter out = response.getWriter();
				if (user == null || !password.equalsIgnoreCase(user.getMatkhau())) {
//					request.setAttribute("message", "Tài khoản hoặc mật khẩu không đúng !");
					out.print("<h6 class='text-danger'>Tài khoản hoặc mật khẩu không đúng</h6>");
				} else {
					if (remember != null) {
						int hours = 2 * 24 * 60 * 60;
						CookieUtils.add("username", user.getEmail(), hours, response);
						CookieUtils.add("password", user.getMatkhau(), hours, response);
					}
//					request.setAttribute("views", "/VIEWS/home.jsp");
					request.getSession().setAttribute("user", user);
					out.print(true);
				}
			} else {
				request.setAttribute("views", "/VIEWS/dangnhap.jsp");
				request.setAttribute("email", CookieUtils.get("username", request));
				request.setAttribute("password", CookieUtils.get("password", request));
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	protected void signUp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getMethod();

		try {
			if (method.equals("POST")) {
				response.setContentType("text/html;charset=UTF-8");
				User user = new User();
				DateTimeConverter dtConverter = new DateConverter();
				dtConverter.setPattern("yyyy-MM-dd");

				ConvertUtilsBean convertUtilsBean = new ConvertUtilsBean();
				convertUtilsBean.register(dtConverter, Date.class);

				BeanUtilsBean bean = new BeanUtilsBean(convertUtilsBean);
				bean.populate(user, request.getParameterMap());
				user.setVaitro(false);
				user.setDiachi(null);

				User checkUser = UserDAO.findUserById(user.getEmail());
				PrintWriter out = response.getWriter();
				if (checkUser != null) {
					out.print("<h6 class='text-danger'>Email đã tồn tại !</h6>");
				} else {
					UserDAO.createUser(user);
					out.print(true);
				}
			} else {
				request.setAttribute("views", "/VIEWS/dangky.jsp");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	protected void signOut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getMethod();
		response.setContentType("text/html;charset=UTF-8");
		try {
			request.getSession().removeAttribute("user");
			
			request.setAttribute("views", "/VIEWS/dangnhap.jsp");
			request.getRequestDispatcher("/index.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
