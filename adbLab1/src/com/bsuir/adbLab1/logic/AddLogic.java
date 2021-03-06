package com.bsuir.adbLab1.logic;

import java.util.Date;

import com.bsuir.adbLab1.dao.CitizenshipDAO;
import com.bsuir.adbLab1.dao.CityDAO;
import com.bsuir.adbLab1.dao.DaoException;
import com.bsuir.adbLab1.dao.DisabilityDAO;
import com.bsuir.adbLab1.dao.StatusDAO;
import com.bsuir.adbLab1.dao.UserDAO;
import com.bsuir.adbLab1.entity.User;

public class AddLogic {

	public AddLogic() {}
	
	public static boolean add(User user) throws LogicException {
		UserDAO userDao = new UserDAO();
		try {
			return userDao.addUser(user);
		} catch (DaoException e) {
			throw new LogicException("cant add user!", e);
		}
	}
	public static User create(String surname, String name, String secondName, 
			Date dateOfBirth, String passportSeries,String passportNumber, String authority, 
			Date dateOfIssue, String birthPlace, int cityID, String address, 
			String homeTelephone, String mobileTelephone, String email, String placeOfWork, 
			String wPosition, String registrationAddress, int maritalStatusID, 
			int citizenshipID, int disabilityID, String isPensioner, 
			String monthlyIncome, String identification_number) throws LogicException {

		CityDAO cityd = new CityDAO();
		CitizenshipDAO citizenshipd = new CitizenshipDAO();
		DisabilityDAO disabilityd = new DisabilityDAO();
		StatusDAO statusd = new StatusDAO();
		User user = new User();
		try {
			user.setCity(cityd.getCityById(cityID));
			user.setSurname(surname);
			user.setName(name);
			user.setSecondName(secondName);
			user.setDateOfBirth(dateOfBirth);
			user.setAddress(address);
			user.setDateOfIssue(dateOfIssue);
			user.setBirthPlace(birthPlace);
			user.setPassportSeries(passportSeries);
			user.setPassportNumber(passportNumber);
			user.setAuthority(authority);
			user.setHomeTelephone(homeTelephone);
			user.setMobileTelephone(mobileTelephone);
			user.setEmail(email);
			user.setPlaceOfWork(placeOfWork);
			user.setwPosition(wPosition);
			user.setRegistrationAddress(registrationAddress);
			user.setMaritalStatus(statusd.getStatusById(maritalStatusID));
			user.setCitizenship(citizenshipd.getCitizenshipById(citizenshipID));
			user.setDisability(disabilityd.getDisabilityById(disabilityID));
			user.setIsPensioner(isPensioner);
			user.setMonthlyIncome(monthlyIncome);
			user.setIdentification_number(identification_number);
		} catch (DaoException e) {
			throw new LogicException("cant create new bran user", e);
		}
		return user;
	}
}
