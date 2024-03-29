package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TableDao;
import com.dao.TableDaoImpl;
import com.entity.Closed2D;

import common.CommonParameters;

public class ClosedNumberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null;
	TableDao tableDao;

	public ClosedNumberController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		tableDao = new TableDaoImpl(request);

		String closedNumberS = request.getParameter("closedNumber");
		String mode = request.getParameter("mode");
		int closedNumber = Integer.parseInt(closedNumberS);
		String msg = "";

		if (mode == "update" || mode.equals("update")) {

			if (tableDao.findNumberInClosedNumberTable(closedNumber)) {
				msg = "Number is already there!";
			} else {
				tableDao.addNumberInClosedNumberTable(closedNumber);
				msg = "Successfully added!";
			}
		} else if (mode == "delete" || mode.equals("delete")) {
			tableDao.deleteClosedNumberInClosedNumberTable(closedNumber);
			msg = "Your closed number is deleted!";
		}

		List<Closed2D> closed2DList = tableDao.getClosedNumberTable();

		request.setAttribute(CommonParameters.MESSAGE, msg);
		request.setAttribute(CommonParameters.CLOSED_2D_LIST, closed2DList);
		dispatcher = request.getRequestDispatcher("/closedNumbersPage");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
