package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.TableDao;
import com.dao.TableDaoImpl;
import com.entity.Closed2D;
import com.entity.History2D;
import com.entity.Number2D;
import com.entity.User2D;

import common.CommonConstants;
import common.CommonParameters;

public class MultiInputController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null;
	List<Number2D> twoDList = new ArrayList<Number2D>();
	List<User2D> userList = new ArrayList<User2D>();
	History2D h2D = null;
	int total;
	int userTotal;
	int pageTotal;
	int realID;
	String shortMsg;
	TableDao tableDao;

	public MultiInputController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		tableDao = new TableDaoImpl(request);

		String idAlertColor = CommonConstants.ID_DEFAULT_COLOR;

		HttpSession session = request.getSession();
		String defaultTable = (String) session.getAttribute(CommonParameters.SESSION_NAME);
		String userName = (String) session.getAttribute(CommonParameters.SESSION_USER);

		if (defaultTable == null || defaultTable.isEmpty() || defaultTable.equals("details")) {
			if (userName == null || userName.isEmpty() || userName.equals(null)) {
				twoDList = tableDao.getTable();
			} else {
				twoDList = tableDao.getTableByUser(userName);
			}

			total = tableDao.getTotalMoney();
			userTotal = tableDao.getUserTotalMoney(userName);
			userList = tableDao.getUsers();
			realID = tableDao.getIdCount();

			if (realID > CommonConstants.ID_COUNT_LIMIT) {
				idAlertColor = CommonConstants.ID_ALERT_COLOR;
			}

			for (int i = 0; i < userList.size(); i++) {
				String checked = "red";
				if (tableDao.checkNameInTempTable(userList.get(i).getUser()) == true) {
					checked = "green";
				}
				userList.get(i).setChecked(checked);
			}

			request.setAttribute(CommonParameters.TOTAL_MONEY, total);
			request.setAttribute(CommonParameters.USER_TOTAL_MONEY, userTotal);
			request.setAttribute(CommonParameters.TAB_BAR_HOME_COLOR, CommonConstants.HOVER_COLOR_CODE);
			request.setAttribute(CommonParameters.REAL_ID, realID);
			request.setAttribute(CommonParameters.ID_ALERT_COLOR, idAlertColor);
			request.setAttribute(CommonParameters.DELETE_COLUMN_DISPLAY, "table-cell");
			request.setAttribute(CommonParameters.USER_LIST, userList);
			request.setAttribute(CommonParameters.TWO_D_LIST, twoDList);
			dispatcher = request.getRequestDispatcher("/home");
			dispatcher.forward(request, response);
		} else if (defaultTable.equals("history")) {
			dispatcher = request.getRequestDispatcher("History");
			dispatcher.forward(request, response);
		} else if (defaultTable.equals("normal")) {
			response.sendRedirect("SortByUser?m=money");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		tableDao = new TableDaoImpl(request);

		h2D = new History2D();
		String alertMsg = "";
		String msg = "";
		int pageNo = 1;

		HttpSession session = request.getSession();
		String name = (String) session.getAttribute(CommonParameters.SESSION_USER);

		String reverse = request.getParameter("reverse");
		String numberS1 = request.getParameter("number1");
		String numberS2 = request.getParameter("number2");
		String numberS3 = request.getParameter("number3");
		String numberS4 = request.getParameter("number4");
		String numberS5 = request.getParameter("number5");
		String numberS6 = request.getParameter("number6");
		String numberS7 = request.getParameter("number7");
		String numberS8 = request.getParameter("number8");
		String numberS9 = request.getParameter("number9");
		String numberS0 = request.getParameter("number0");
		String moneyS = request.getParameter("money");
		int money = Integer.parseInt(moneyS);

		if (reverse.equals("yes") || reverse == "yes") {
			int rCount = 0;
			if (!(numberS1.isEmpty())) {
				int number1 = Integer.parseInt(numberS1);
				Integer rNumber1 = getReverse(number1);
				tableDao.add2DwithR(number1, rNumber1, money, name, pageNo);
				rCount = rCount + 1;
				if (checkClosedNumberOrNot(number1, request)) {
					alertMsg = alertMsg + " " + numberS1;
				}
				if (checkClosedNumberOrNot(rNumber1, request)) {
					if (rNumber1 < 10) {
						alertMsg = alertMsg + " " + "0" + rNumber1.toString();
					} else {
						alertMsg = alertMsg + " " + rNumber1.toString();
					}
				}
				shortMsg = numberS1;
			}
			if (!(numberS2.isEmpty())) {
				int number2 = Integer.parseInt(numberS2);
				Integer rNumber2 = getReverse(number2);
				tableDao.add2DwithR(number2, rNumber2, money, name, pageNo);
				rCount = rCount + 1;
				if (checkClosedNumberOrNot(number2, request)) {
					alertMsg = alertMsg + " " + numberS2;
				}
				if (checkClosedNumberOrNot(rNumber2, request)) {
					if (rNumber2 < 10) {
						alertMsg = alertMsg + " " + "0" + rNumber2.toString();
					} else {
						alertMsg = alertMsg + " " + rNumber2.toString();
					}
				}
				shortMsg = shortMsg + " / " + numberS2;
			}
			if (!(numberS3.isEmpty())) {
				int number3 = Integer.parseInt(numberS3);
				Integer rNumber3 = getReverse(number3);
				tableDao.add2DwithR(number3, rNumber3, money, name, pageNo);
				rCount = rCount + 1;
				if (checkClosedNumberOrNot(number3, request)) {
					alertMsg = alertMsg + " " + numberS3;
				}
				if (checkClosedNumberOrNot(rNumber3, request)) {
					if (rNumber3 < 10) {
						alertMsg = alertMsg + " " + "0" + rNumber3.toString();
					} else {
						alertMsg = alertMsg + " " + rNumber3.toString();
					}
				}
				shortMsg = shortMsg + " / " + numberS3;
			}
			if (!(numberS4.isEmpty())) {
				int number4 = Integer.parseInt(numberS4);
				Integer rNumber4 = getReverse(number4);
				tableDao.add2DwithR(number4, rNumber4, money, name, pageNo);
				rCount = rCount + 1;
				if (checkClosedNumberOrNot(number4, request)) {
					alertMsg = alertMsg + " " + numberS4;
				}
				if (checkClosedNumberOrNot(rNumber4, request)) {
					if (rNumber4 < 10) {
						alertMsg = alertMsg + " " + "0" + rNumber4.toString();
					} else {
						alertMsg = alertMsg + " " + rNumber4.toString();
					}
				}
				shortMsg = shortMsg + " / " + numberS4;
			}
			if (!(numberS5.isEmpty())) {
				int number5 = Integer.parseInt(numberS5);
				Integer rNumber5 = getReverse(number5);
				tableDao.add2DwithR(number5, rNumber5, money, name, pageNo);
				rCount = rCount + 1;
				if (checkClosedNumberOrNot(number5, request)) {
					alertMsg = alertMsg + " " + numberS5;
				}
				if (checkClosedNumberOrNot(rNumber5, request)) {
					if (rNumber5 < 10) {
						alertMsg = alertMsg + " " + "0" + rNumber5.toString();
					} else {
						alertMsg = alertMsg + " " + rNumber5.toString();
					}
				}
				shortMsg = shortMsg + " / " + numberS5;
			}
			if (!(numberS6.isEmpty())) {
				int number6 = Integer.parseInt(numberS6);
				Integer rNumber6 = getReverse(number6);
				tableDao.add2DwithR(number6, rNumber6, money, name, pageNo);
				rCount = rCount + 1;
				if (checkClosedNumberOrNot(number6, request)) {
					alertMsg = alertMsg + " " + numberS6;
				}
				if (checkClosedNumberOrNot(rNumber6, request)) {
					if (rNumber6 < 10) {
						alertMsg = alertMsg + " " + "0" + rNumber6.toString();
					} else {
						alertMsg = alertMsg + " " + rNumber6.toString();
					}
				}
				shortMsg = shortMsg + " / " + numberS6;
			}
			if (!(numberS7.isEmpty())) {
				int number7 = Integer.parseInt(numberS7);
				Integer rNumber7 = getReverse(number7);
				tableDao.add2DwithR(number7, rNumber7, money, name, pageNo);
				rCount = rCount + 1;
				if (checkClosedNumberOrNot(number7, request)) {
					alertMsg = alertMsg + " " + numberS7;
				}
				if (checkClosedNumberOrNot(rNumber7, request)) {
					if (rNumber7 < 10) {
						alertMsg = alertMsg + " " + "0" + rNumber7.toString();
					} else {
						alertMsg = alertMsg + " " + rNumber7.toString();
					}
				}
				shortMsg = shortMsg + " / " + numberS7;
			}
			if (!(numberS8.isEmpty())) {
				int number8 = Integer.parseInt(numberS8);
				Integer rNumber8 = getReverse(number8);
				tableDao.add2DwithR(number8, rNumber8, money, name, pageNo);
				rCount = rCount + 1;
				if (checkClosedNumberOrNot(number8, request)) {
					alertMsg = alertMsg + " " + numberS8;
				}
				if (checkClosedNumberOrNot(rNumber8, request)) {
					if (rNumber8 < 10) {
						alertMsg = alertMsg + " " + "0" + rNumber8.toString();
					} else {
						alertMsg = alertMsg + " " + rNumber8.toString();
					}
				}
				shortMsg = shortMsg + " / " + numberS8;
			}
			if (!(numberS9.isEmpty())) {
				int number9 = Integer.parseInt(numberS9);
				Integer rNumber9 = getReverse(number9);
				tableDao.add2DwithR(number9, rNumber9, money, name, pageNo);
				rCount = rCount + 1;
				if (checkClosedNumberOrNot(number9, request)) {
					alertMsg = alertMsg + " " + numberS9;
				}
				if (checkClosedNumberOrNot(rNumber9, request)) {
					if (rNumber9 < 10) {
						alertMsg = alertMsg + " " + "0" + rNumber9.toString();
					} else {
						alertMsg = alertMsg + " " + rNumber9.toString();
					}
				}
				shortMsg = shortMsg + " / " + numberS9;
			}
			if (!(numberS0.isEmpty())) {
				int number0 = Integer.parseInt(numberS0);
				Integer rNumber0 = getReverse(number0);
				tableDao.add2DwithR(number0, rNumber0, money, name, pageNo);
				rCount = rCount + 1;
				if (checkClosedNumberOrNot(number0, request)) {
					alertMsg = alertMsg + " " + numberS0;
				}
				if (checkClosedNumberOrNot(rNumber0, request)) {
					if (rNumber0 < 10) {
						alertMsg = alertMsg + " " + "0" + rNumber0.toString();
					} else {
						alertMsg = alertMsg + " " + rNumber0.toString();
					}
				}
				shortMsg = shortMsg + " / " + numberS0;
			}

			msg = shortMsg + " R " + moneyS + " ks added.";

			h2D.setR("R");
			h2D.setTotal(2 * rCount * money);
			pageTotal = tableDao.getPageTotal(name, pageNo);
			pageTotal = pageTotal + (2 * rCount * money);
			h2D.setPageTotal(pageTotal);

		} else {
			int count = 0;
			if (!(numberS1.isEmpty())) {
				int number1 = Integer.parseInt(numberS1);
				tableDao.add2D(number1, money, name, pageNo);
				count = count + 1;
				if (checkClosedNumberOrNot(number1, request)) {
					alertMsg = alertMsg + " " + numberS1;
				}
				shortMsg = numberS1;
			}
			if (!(numberS2.isEmpty())) {
				int number2 = Integer.parseInt(numberS2);
				tableDao.add2D(number2, money, name, pageNo);
				count = count + 1;
				if (checkClosedNumberOrNot(number2, request)) {
					alertMsg = numberS1;
				}
				shortMsg = shortMsg + " / " + numberS2;
			}
			if (!(numberS3.isEmpty())) {
				int number3 = Integer.parseInt(numberS3);
				tableDao.add2D(number3, money, name, pageNo);
				count = count + 1;
				if (checkClosedNumberOrNot(number3, request)) {
					alertMsg = numberS1;
				}
				shortMsg = shortMsg + " / " + numberS3;
			}
			if (!(numberS4.isEmpty())) {
				int number4 = Integer.parseInt(numberS4);
				tableDao.add2D(number4, money, name, pageNo);
				count = count + 1;
				if (checkClosedNumberOrNot(number4, request)) {
					alertMsg = numberS1;
				}
				shortMsg = shortMsg + " / " + numberS4;
			}
			if (!(numberS5.isEmpty())) {
				int number5 = Integer.parseInt(numberS5);
				tableDao.add2D(number5, money, name, pageNo);
				count = count + 1;
				if (checkClosedNumberOrNot(number5, request)) {
					alertMsg = numberS1;
				}
				shortMsg = shortMsg + " / " + numberS5;
			}
			if (!(numberS6.isEmpty())) {
				int number6 = Integer.parseInt(numberS6);
				tableDao.add2D(number6, money, name, pageNo);
				count = count + 1;
				if (checkClosedNumberOrNot(number6, request)) {
					alertMsg = numberS1;
				}
				shortMsg = shortMsg + " / " + numberS6;
			}
			if (!(numberS7.isEmpty())) {
				int number7 = Integer.parseInt(numberS7);
				tableDao.add2D(number7, money, name, pageNo);
				count = count + 1;
				if (checkClosedNumberOrNot(number7, request)) {
					alertMsg = numberS1;
				}
				shortMsg = shortMsg + " / " + numberS7;
			}
			if (!(numberS8.isEmpty())) {
				int number8 = Integer.parseInt(numberS8);
				tableDao.add2D(number8, money, name, pageNo);
				count = count + 1;
				if (checkClosedNumberOrNot(number8, request)) {
					alertMsg = numberS1;
				}
				shortMsg = shortMsg + " / " + numberS8;
			}
			if (!(numberS9.isEmpty())) {
				int number9 = Integer.parseInt(numberS9);
				tableDao.add2D(number9, money, name, pageNo);
				count = count + 1;
				if (checkClosedNumberOrNot(number9, request)) {
					alertMsg = numberS1;
				}
				shortMsg = shortMsg + " / " + numberS9;
			}
			if (!(numberS0.isEmpty())) {
				int number0 = Integer.parseInt(numberS0);
				tableDao.add2D(number0, money, name, pageNo);
				count = count + 1;
				if (checkClosedNumberOrNot(number0, request)) {
					alertMsg = numberS1;
				}
				shortMsg = shortMsg + " / " + numberS0;
			}
			msg = shortMsg + " - " + moneyS + " ks added.";
			h2D.setR("-");
			h2D.setTotal(count * money);
			pageTotal = tableDao.getPageTotal(name, pageNo);
			pageTotal = pageTotal + (count * money);
			h2D.setPageTotal(pageTotal);
		}

		h2D.setNote(shortMsg);
		h2D.setMoney(money);
		h2D.setName(name);
		h2D.setPageNo(pageNo);
		tableDao.add2DtoHistory(h2D);

		if (!alertMsg.equals("")) {
			alertMsg = "The number (" + alertMsg + ") are closed numbers.";
		}

		request.setAttribute(CommonParameters.MESSAGE, msg);
		request.setAttribute(CommonParameters.ALERT_MESSAGE, alertMsg);
		doGet(request, response);
	}

	protected int getReverse(int number) {
		int reverse = 0;
		if (number < 10) {
			reverse = number * 10;
		} else {
			while (number != 0) {
				int remainder = number % 10;
				reverse = reverse * 10 + remainder;
				number = number / 10;
			}
		}

		return reverse;
	}

	protected boolean checkClosedNumberOrNot(int number, HttpServletRequest request) {

		tableDao = new TableDaoImpl(request);

		boolean flag = false;
		List<Closed2D> closed2DList = new ArrayList<Closed2D>();
		closed2DList = tableDao.getClosedNumberTable();
		for (int i = 0; i < closed2DList.size(); i++) {
			if (number == closed2DList.get(i).getNumber()) {
				flag = true;
			}
		}
		return flag;
	}

}
