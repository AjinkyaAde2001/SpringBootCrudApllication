package com.example.demo.service;

import java.util.List;

import com.example.demo.model.EmpModel;
import com.example.demo.model.LoginModel;


public interface EmpService {
	public void addEmp(EmpModel em);
	public EmpModel getEmpById(int id); 
	public List<EmpModel> getEmps();
	public void updateEmp(EmpModel em);
	public void deleteEmpById(int id);
	public List<EmpModel> doLogin(LoginModel lm);
	
}
	
	
