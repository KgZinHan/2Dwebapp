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
import com.entity.History2D;
import com.entity.Number2D;
import com.entity.User2D;

import common.CommonConstants;
import common.CommonParameters;

public class CustomInputController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null;
	List<Number2D> twoDList = new ArrayList<Number2D>();
	List<User2D> userList = new ArrayList<User2D>();
	History2D h2D1 = null;
	History2D h2D2 = null;
	int total;
	int userTotal;
	int pageTotal;
	int realID;
	String shortMsg;
	String shortMsgR;
	TableDao tableDao = new TableDaoImpl();

	public CustomInputController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String defaultTable = (String) session.getAttribute(CommonParameters.SESSION_NAME);
		String userName = (String) session.getAttribute(CommonParameters.SESSION_USER);
		List<Integer> dNumberList = new ArrayList<Integer>();
		String dNumbers = "0";
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

			dNumberList = tableDao.getDangerousNumber();
			if (!(dNumberList.size() <= 0)) {
				dNumbers = dNumberList.get(0).toString();
				for (int i = 1; i < dNumberList.size(); i++) {
					if(dNumberList.get(i) < 10) {
						dNumbers = dNumbers + " - " + "0"+ dNumberList.get(i).toString();
					}
					else {
						dNumbers = dNumbers + " - " + dNumberList.get(i).toString();
					}		
				}
			}

			request.setAttribute(CommonParameters.TOTAL_MONEY, total);
			request.setAttribute(CommonParameters.USER_TOTAL_MONEY, userTotal);
			request.setAttribute(CommonParameters.DANGEROUS_NUMBERS, dNumbers);
			request.setAttribute(CommonParameters.TAB_BAR_HOME_COLOR, CommonConstants.HOVER_COLOR_CODE);
			request.setAttribute(CommonParameters.REAL_ID, realID);
			request.setAttribute(CommonParameters.DELETE_COLUMN_DISPLAY, "table-cell");
			request.setAttribute(CommonParameters.USER_LIST, userList);
			request.setAttribute(CommonParameters.TWO_D_LIST, twoDList);
			dispatcher = request.getRequestDispatcher("/home");
			dispatcher.forward(request, response);
			dispatcher.forward(request, response);
		} else if (defaultTable.equals("history")) {
			dispatcher = request.getRequestDispatcher("History");
			dispatcher.forward(request, response);
		} else if (defaultTable.equals("normal")) {
			response.sendRedirect("SortByUser?m=money");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		h2D1 = new History2D();
		h2D2 = new History2D();
		String msg = new String();
		String moneyS = request.getParameter("money");
		String rMoneyS = request.getParameter("rMoney");
		int money = Integer.parseInt(moneyS);
		int rMoney = Integer.parseInt(rMoneyS);
		int pageNo = 1;
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute(CommonParameters.SESSION_USER);
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
		int rCount = 0;
		if (!(numberS1.isEmpty())) {
			int number1 = Integer.parseInt(numberS1);
			Integer rNumber1 = getReverse(number1);
			tableDao.add2D(number1, money, name, pageNo);
			tableDao.add2D(rNumber1, rMoney, name, pageNo);
			rCount = rCount + 1;
			shortMsg = numberS1;
			shortMsgR = rNumber1.toString();
		}
		if (!(numberS2.isEmpty())) {
			int number2 = Integer.parseInt(numberS2);
			Integer rNumber2 = getReverse(number2);
			tableDao.add2D(number2, money, name, pageNo);
			tableDao.add2D(rNumber2, rMoney, name, pageNo);
			rCount = rCount + 1;
			shortMsg = shortMsg + " / " + numberS2;
			shortMsgR = shortMsgR + " / " + rNumber2.toString();
		}
		if (!(numberS3.isEmpty())) {
			int number3 = Integer.parseInt(numberS3);
			Integer rNumber3 = getReverse(number3);
			tableDao.add2D(number3, money, name, pageNo);
			tableDao.add2D(rNumber3, rMoney, name, pageNo);
			rCount = rCount + 1;
			shortMsg = shortMsg + " / " + numberS3;
			shortMsgR = shortMsgR + " / " + rNumber3.toString();
		}
		if (!(numberS4.isEmpty())) {
			int number4 = Integer.parseInt(numberS4);
			Integer rNumber4 = getReverse(number4);
			tableDao.add2D(number4, money, name, pageNo);
			tableDao.add2D(rNumber4, rMoney, name, pageNo);
			rCount = rCount + 1;
			shortMsg = shortMsg + " / " + numberS4;
			shortMsgR = shortMsgR + " / " + rNumber4.toString();
		}
		if (!(numberS5.isEmpty())) {
			int number5 = Integer.parseInt(numberS5);
			Integer rNumber5 = getReverse(number5);
			tableDao.add2D(number5, money, name, pageNo);
			tableDao.add2D(rNumber5, rMoney, name, pageNo);
			rCount = rCount + 1;
			shortMsg = shortMsg + " / " + numberS5;
			shortMsgR = shortMsgR + " / " + rNumber5.toString();
		}
		if (!(numberS6.isEmpty())) {
			int number6 = Integer.parseInt(numberS6);
			Integer rNumber6 = getReverse(number6);
			tableDao.add2D(number6, money, name, pageNo);
			tableDao.add2D(rNumber6, rMoney, name, pageNo);
			rCount = rCount + 1;
			shortMsg = shortMsg + " / " + numberS6;
			shortMsgR = shortMsgR + " / " + rNumber6.toString();
		}
		if (!(numberS7.isEmpty())) {
			int number7 = Integer.parseInt(numberS7);
			Integer rNumber7 = getReverse(number7);
			tableDao.add2D(number7, money, name, pageNo);
			tableDao.add2D(rNumber7, rMoney, name, pageNo);
			rCount = rCount + 1;
			shortMsg = shortMsg + " / " + numberS7;
			shortMsgR = shortMsgR + " / " + rNumber7.toString();
		}
		if (!(numberS8.isEmpty())) {
			int number8 = Integer.parseInt(numberS8);
			Integer rNumber8 = getReverse(number8);
			tableDao.add2D(number8, money, name, pageNo);
			tableDao.add2D(rNumber8, rMoney, name, pageNo);
			rCount = rCount + 1;
			shortMsg = shortMsg + " / " + numberS8;
			shortMsgR = shortMsgR + " / " + rNumber8.toString();
		}
		if (!(numberS9.isEmpty())) {
			int number9 = Integer.parseInt(numberS9);
			Integer rNumber9 = getReverse(number9);
			tableDao.add2D(number9, money, name, pageNo);
			tableDao.add2D(rNumber9, rMoney, name, pageNo);
			rCount = rCount + 1;
			shortMsg = shortMsg + " / " + numberS9;
			shortMsgR = shortMsgR + " / " + rNumber9.toString();
		}
		if (!(numberS0.isEmpty())) {
			int number0 = Integer.parseInt(numberS0);
			Integer rNumber0 = getReverse(number0);
			tableDao.add2D(number0, money, name, pageNo);
			tableDao.add2D(rNumber0, rMoney, name, pageNo);
			rCount = rCount + 1;
			shortMsg = shortMsg + " / " + numberS0;
			shortMsgR = shortMsgR + " / " + rNumber0.toString();
		}
		msg = shortMsg + " - " + moneyS + " R " + rMoneyS + " ks added.";
		h2D1.setNote(shortMsg);
		h2D1.setR("-");
		h2D1.setTotal(rCount * money);
		h2D1.setMoney(money);
		h2D1.setName(name);
		h2D1.setPageNo(pageNo);
		pageTotal = tableDao.getPageTotal(name, pageNo);
		pageTotal = pageTotal + (rCount * money);
		h2D1.setPageTotal(pageTotal);
		tableDao.add2DtoHistory(h2D1);
		h2D2.setNote(shortMsgR);
		h2D2.setR("-");
		h2D2.setTotal(rCount * rMoney);
		h2D2.setMoney(rMoney);
		h2D2.setName(name);
		h2D2.setPageNo(pageNo);
		pageTotal = tableDao.getPageTotal(name, pageNo);
		pageTotal = pageTotal + (rCount * rMoney);
		h2D2.setPageTotal(pageTotal);
		tableDao.add2DtoHistory(h2D2);
		request.setAttribute(CommonParameters.MESSAGE, msg);
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

}
