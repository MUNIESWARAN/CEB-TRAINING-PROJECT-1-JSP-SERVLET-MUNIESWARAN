package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CompetancyDao;
import com.dao.CompetancyDaoImp;
import com.dao.SkillUpdateDao;
import com.dao.SkillsUpdateDaoImp;
import com.model.Competency;
import com.model.SkillsModel;

/**
 * Servlet implementation class UpdateSkillController
 */
@WebServlet("/UpdateSkillController")
public class UpdateSkillController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateSkillController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		PrintWriter out = response.getWriter();
		try {
			int employeeId = Integer.parseInt(request.getSession().getAttribute("employeeid").toString());
			
			String userType = request.getSession().getAttribute("userType").toString();
			SkillUpdateDao skillUpdateDAO = new SkillsUpdateDaoImp();
			ArrayList<SkillsModel> skillList = new ArrayList<SkillsModel>();
			skillList = skillUpdateDAO.getListOfSkillsByUserType(userType);
			int count = skillList.size();
			int skillId = 0;

			ArrayList<Competency> competencyList = new ArrayList<Competency>();

			for (int i = 1, j = 0; i <= count; i++, j++) {
				skillId = skillList.get(j).getSkillId();
				System.out.println(request.getParameter("skillLevel" + 1));
				competencyList.add(new Competency(employeeId, skillId, request.getParameter("skillLevel" + i)));
				System.out.println("Updating Competency->" + employeeId + " " + skillId + " "
						+ request.getParameter("skillLevel" + 1));
			}

			CompetancyDao competancyDao = new CompetancyDaoImp();
			
			if(competancyDao.checkCompetencyUpdated(employeeId)) {
				System.out.println("Updating Competency Details...");
				competancyDao.updateCompetencyDetails(competencyList);
			}else {
				System.out.println("Adding Competency Details...");
			competancyDao.addCompetencyDetails(competencyList);
			}
		} catch (Exception e) {
			System.out.println("Error UpdateskillController : " + e);

		}
		out.println("Testing");
	}

}
