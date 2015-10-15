package com.bsuir.adbLab1.command;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.bsuir.adbLab1.entity.User;
import com.bsuir.adbLab1.logic.AddLogic;
import com.bsuir.adbLab1.logic.LogicException;
import com.bsuir.adbLab1.logic.ShowLogic;
import com.bsuir.adbLab1.resource.ConfigurationManager;


public class AddCommand implements ICommand {

	private static final Logger LOG = Logger.getLogger(AddCommand.class);
	public AddCommand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute(HttpServletRequest request) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		String surname = request.getParameter("surname");
		String name = request.getParameter("name");
		String secondName = request.getParameter("secondName");
		Date dateOfBirth = null;
		Date dateOfIssue = null;
		try {
			dateOfBirth = dateFormat.parse(request.getParameter("dateOfBirth"));
			dateOfIssue = dateFormat.parse(request.getParameter("dateOfIssue"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String passportSeries = request.getParameter("passportSeries");
		String passportNumber = request.getParameter("passportNumber");
		String authority = request.getParameter("authority");
		String birthPlace = request.getParameter("birthPlace");
		int cityID = Integer.parseInt(request.getParameter("cityID"));
		String address = request.getParameter("address");
		String homeTelephone = request.getParameter("homeTelephone");
		String mobileTelephone = request.getParameter("mobileTelephone");
		String email = request.getParameter("email");
		String placeOfWork = request.getParameter("placeOfWork");
		String wPosition = request.getParameter("wPosition");
		String registrationAddress = request.getParameter("registrationAddress");
		int maritalStatusID = Integer.parseInt(request.getParameter("maritalStatusID"));
		int citizenshipID = Integer.parseInt(request.getParameter("citizenshipID"));
		int disabilityID = Integer.parseInt(request.getParameter("disabilityID"));
		String isPensioner = request.getParameter("isPensioner");
		String monthlyIncome = request.getParameter("monthlyIncome");
		String identification_number = request.getParameter("identification_number");
		
		String page = null;
		try {
			LOG.debug("WE ADD user");
			User user = AddLogic.create(surname, name, secondName, dateOfBirth, 
					passportSeries, passportNumber, authority, dateOfIssue,
					birthPlace, cityID, address, homeTelephone, mobileTelephone, 
					email, placeOfWork, wPosition, registrationAddress, maritalStatusID, 
					citizenshipID, disabilityID, isPensioner, monthlyIncome, identification_number);
			AddLogic.add(user);
			request.setAttribute("users", ShowLogic.Show());
			LOG.debug("WE SHOW YOU users");
			page = ConfigurationManager.getProperty("path.page.main");

		} catch (LogicException ex) {
			LOG.error("something wrong in add", ex);
		}
		return page;
	}

}
