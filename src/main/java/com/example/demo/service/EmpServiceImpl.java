package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.example.demo.dao.EmpDaoImpl;
import com.example.demo.dao.EmpDao;
import com.example.demo.model.EmpModel;
import com.example.demo.model.LoginModel;
@Service
public class  EmpServiceImpl implements EmpService  {
	@Autowired
	EmpDao dao;
	
	@Transactional
	@Override
public void addEmp(EmpModel em) {
		
		dao.addEmp(em);	
	}

	@Override
	public EmpModel getEmpById(int id) {
		
		return dao.getEmpById(id);
	}
	
    @Transactional
	@Override
	public List<EmpModel> getEmps() {
		
		return dao.getEmps();
	}
    @Transactional
	@Override
	public void updateEmp(EmpModel em) {
		// TODO Auto-generated method stub
		 dao.updateEmp(em);
	}
    @Transactional
	@Override
	public void deleteEmpById(int id) {
		// TODO Auto-generated method stub
		dao.deleteEmpById(id);
	}
@Transactional
@Override
public List<EmpModel> doLogin(LoginModel lm){
	return dao.doLogin(lm);
}



}
