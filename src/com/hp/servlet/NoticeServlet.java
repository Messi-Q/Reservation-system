
package com.hp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.entity.Notice;
import com.hp.service.NoticeService;
import com.hp.service.impl.NoticeServiceImpl;

@WebServlet("/NoticeServlet")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeServlet() {
		super();

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 编码
		request.setCharacterEncoding("UTF-8");
		String opt = request.getParameter("opt");

		if (opt.equals("add")) {
			this.add(request, response);
		} else if (opt.equals("select")) {
			this.select(request, response);
		} else if (opt.equals("delete")) {
			this.delete(request, response);
		} else if (opt.equals("doUpdate")) {
			this.doUpdate(request, response);
		} else if (opt.equals("toUpdate")) {
			this.toUpdate(request, response);
		}else if (opt.equals("doSelectOne")) {
			this.doSelectOne(request, response);
		}
	}
		//选中一个公告后显示
		private void doSelectOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String id=request.getParameter("noticeId");
			NoticeService noticeService = new NoticeServiceImpl();
			ArrayList<Notice> noticeList = noticeService.findSelectOne(Integer.parseInt(id));
			request.setAttribute("noticeList", noticeList);
			request.getRequestDispatcher("notice.jsp").forward(request, response);			
		}


	// 添加
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("noticeTitle");
		String cont = request.getParameter("noticeCont");
		// 封装：将用用户输入的值封装成一个实体类对象
		Notice notice = new Notice(name, cont);
		// 调用业务层
		NoticeService noticeService = new NoticeServiceImpl();
		int i = noticeService.addNotice(notice);
		if (i > 0) {
			this.select(request, response);
		} else {
			request.getRequestDispatcher("addNotice.jsp").forward(request, response);
		}

	}

	// 删除
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("noticeId");
		// 封装：将用用户输入的值封装成一个实体类对象
		NoticeService noticeService = new NoticeServiceImpl();
		int i = noticeService.deleteNotice(Integer.parseInt(id));
		this.select(request, response);

	}

	// 查询
	private void toUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("noticeId");
		NoticeService proService = new NoticeServiceImpl();
		ArrayList<Notice> noticeList = proService.findOneRow(Integer.parseInt(id));
		request.setAttribute("noticeList", noticeList);
		request.getRequestDispatcher("updateNotice.jsp").forward(request, response);
	}

	// 修改
	private void doUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("noticeId");
		String title = request.getParameter("noticeTitle");
		String cont = request.getParameter("noticeCont");
		// 封装：将用用户输入的值封装成一个实体类对象
		Notice notice = new Notice(title, cont, Integer.parseInt(id));
		// 调用业务层
		NoticeService noticeService = new NoticeServiceImpl();
		int i = noticeService.updateNotice(notice);
		this.select(request, response);

	}

	// 查询
	private void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		NoticeService proService = new NoticeServiceImpl();
		ArrayList<Notice> noticeList = proService.findAll();
		request.setAttribute("noticeList", noticeList);
		request.getRequestDispatcher("noticeManage.jsp").forward(request, response);

	}
}
