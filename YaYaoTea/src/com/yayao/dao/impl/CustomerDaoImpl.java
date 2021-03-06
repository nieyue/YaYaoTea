package com.yayao.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.yayao.bean.Customer;
import com.yayao.dao.CustomerDao;
/**
 * 客户管理接口实现
 * @author yy
 *
 */
@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {
	/*@Resource(name="sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	protected SqlSession getSession(){
		sqlSession = sqlSessionFactory.openSession();
	return sqlSession;
	}*/
	@Resource(name="sqlSession")
	 private SqlSession sqlSession;
	/**
	 * 查询单个客户
	 */
	public Customer selectCustomerByID(Integer id) {
		//CustomerDao customerDao = getSession().getMapper(CustomerDao.class);
		Customer customer = sqlSession.selectOne("com.yayao.dao.CustomerDao.selectCustomerByID", id);
		//Customer customer = customerDao.selectCustomerByID(id);
		return customer;
		
	}
	/**
	 * 用户提交需求
	 */
	public void addCustomerContent(Customer customer) {
		sqlSession.insert("com.yayao.dao.CustomerDao.addCustomerContent",customer);
	}
	/**
	 * 查询10个客户
	 */
	public List<Customer> showCustomer(Map<String,Object> map) {
		
		List<Customer> list = sqlSession.selectList("com.yayao.dao.CustomerDao.showCustomer", map);
		
		return list;
	}
	/**
	 * 修改订单状态
	 */
	public void updateCustomerIndex(Customer customer) {
		sqlSession.update("com.yayao.dao.CustomerDao.updateCustomerIndex", customer);
	}

}
