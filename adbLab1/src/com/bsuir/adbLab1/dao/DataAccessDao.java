package com.bsuir.adbLab1.dao;

import java.util.ArrayList;

import com.bsuir.adbLab1.entity.Citizenship;
import com.bsuir.adbLab1.entity.City;
import com.bsuir.adbLab1.entity.Disability;
import com.bsuir.adbLab1.entity.MStatus;
import com.bsuir.adbLab1.entity.User;

public interface DataAccessDao {
	User showUser(int id) throws DaoException;
	ArrayList<User> getUserList() throws DaoException;
	boolean changeUser(User user) throws DaoException;
	boolean addUser(User user) throws DaoException;
	ArrayList<City> getCityList() throws DaoException;
	ArrayList<MStatus> getStatusList() throws DaoException;
	ArrayList<Citizenship> getCitizenshipList() throws DaoException;
	ArrayList<Disability> getDisabilityList() throws DaoException;
	
}
