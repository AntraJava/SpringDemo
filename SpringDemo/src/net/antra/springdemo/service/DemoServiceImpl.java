package net.antra.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import net.antra.springdemo.dao.DemoDAO;

@Service("aService")
public class DemoServiceImpl implements DemoService{
	
	@Autowired
	DemoDAO aDAO;
	
	@Override
	public void doSomeThing() {
		aDAO.doSomething();
	}
//	@Autowired
//	public DemoServiceImpl(DemoDAO d){
//		aDAO = d;
//	}
	public DemoDAO getaDAO() {
		return aDAO;
	}
	
	//@Autowired
	public void setaDAO(DemoDAO aDAO) {
		this.aDAO = aDAO;
	}
}
