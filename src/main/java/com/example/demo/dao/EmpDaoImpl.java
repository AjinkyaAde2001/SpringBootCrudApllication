package com.example.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.example.demo.model.EmpModel;
import com.example.demo.model.LoginModel;

import jakarta.persistence.EntityManager;
@Repository
public class EmpDaoImpl implements EmpDao {
	
	
	@Autowired
	private EntityManager entityManager;
	@Override
	public void addEmp(EmpModel em) {
		Session session = entityManager.unwrap(Session.class);
		session.save(em);
	}

	@Override
	public EmpModel getEmpById(int id) {
		Session session = entityManager.unwrap(Session.class);
		EmpModel em = (EmpModel) session.get(EmpModel.class, id);
		return em;
	}

	@Override
	public List<EmpModel> getEmps() {
		Session session = entityManager.unwrap(Session.class);
		return session.createQuery("from EmpModel").list();
	}

	@Override
	public void updateEmp(EmpModel em) {
		Session session = entityManager.unwrap(Session.class);
        session.update(em);
	}
    
	@Override
	public void deleteEmpById(int id) {
	    // TODO: Validate id and handle non-existent entities if needed
		Session session = entityManager.unwrap(Session.class);
		EmpModel em = (EmpModel) session.get(EmpModel.class, id);
		
	    // Check if the entity exists before attempting to delete
	   
	        session.delete(em);
	    }

	@Override
	public List<EmpModel> doLogin(LoginModel lm) {
		Session session = entityManager.unwrap(Session.class);
		List<EmpModel> emps = session.createQuery("from EmpModel E where E.email = '"+lm.getEmail()+"' and E.password='"+lm.getPassword()+"'").list();
		List<EmpModel> list = emps.size()>0?emps:null;
		return list;
	}
	
//	public List<EmpModel> doLogin(LoginModel lm) {
//	    Session session = entityManager.unwrap(Session.class);
//
//	    // Use parameterized query to avoid SQL injection
//	    Query<EmpModel> query = session.createQuery(
//	            "FROM EmpModel E WHERE E.email = :email AND E.password = :password", EmpModel.class);
//
//	    // Set parameters to the query
//	    query.setParameter("email", lm.getEmail());
//	    query.setParameter("password", lm.getPassword());
//
//	    // Execute the query
//	    List<EmpModel> emps = query.getResultList();
//
//	    // Return the result
//	    return emps.size() > 0 ? emps : null;
	//}

	}


