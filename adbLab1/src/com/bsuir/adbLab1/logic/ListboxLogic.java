package com.bsuir.adbLab1.logic;

import java.util.ArrayList;

import com.bsuir.adbLab1.dao.CitizenshipDAO;
import com.bsuir.adbLab1.dao.CityDAO;
import com.bsuir.adbLab1.dao.DaoException;
import com.bsuir.adbLab1.dao.DisabilityDAO;
import com.bsuir.adbLab1.dao.StatusDAO;
import com.bsuir.adbLab1.entity.Citizenship;
import com.bsuir.adbLab1.entity.City;
import com.bsuir.adbLab1.entity.Disability;
import com.bsuir.adbLab1.entity.MStatus;

public class ListboxLogic {

	public ListboxLogic() {	}
	
	public static ArrayList<City> getCity() throws LogicException {
		CityDAO cDao = new CityDAO();
		ArrayList<City> cList = new ArrayList<City>();
		try {
			cList = cDao.getCityList();
			return cList;
		} catch (DaoException e) {
			throw new LogicException("bla bla", e);
		}
	}
	
	public static ArrayList<Citizenship> getCtzn() throws LogicException {
		CitizenshipDAO cDao = new CitizenshipDAO();
		ArrayList<Citizenship> cList = new ArrayList<Citizenship>();
		try {
			cList = cDao.getCitizenshipList();
			return cList;
		} catch (DaoException e) {
			throw new LogicException("bla bla", e);
		}
	}

	public static ArrayList<MStatus> getStatus() throws LogicException {
		StatusDAO mDao = new StatusDAO();
		ArrayList<MStatus> mList = new ArrayList<MStatus>();
		try {
			mList = mDao.getStatusList();
			return mList;
		} catch (DaoException e) {
			throw new LogicException("bla bla", e);
		}
	}
	
	public static ArrayList<Disability> getDsblt() throws LogicException {
		DisabilityDAO mDao = new DisabilityDAO();
		ArrayList<Disability> dList = new ArrayList<Disability>();
		try {
			dList = mDao.getDisabilityList();
			return dList;
		} catch (DaoException e) {
			throw new LogicException("bla bla", e);
		}
	}
}
