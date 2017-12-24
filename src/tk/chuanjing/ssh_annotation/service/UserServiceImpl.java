package tk.chuanjing.ssh_annotation.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tk.chuanjing.ssh_annotation.dao.IUserDAO;
import tk.chuanjing.ssh_annotation.domain.User;

/**
 * @author ChuanJing
 * @date 2017年7月24日 下午8:26:03
 * @version 1.0
 */

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	@Qualifier("userDao")
	private IUserDAO userDao;
	
	public void add(User user) {
		userDao.add(user);
	}

	public void update(User user) {
		userDao.update(user);
	}

	public void del(User user) {
		userDao.del(user);
	}

//	@Transactional(readOnly=true)
	public User findById(int id) {
		return userDao.findById(id);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public List<User> findAllByCriteria(DetachedCriteria dc) {
		return userDao.findAllByCriteria(dc);
	}

	public List<User> findByNameQuery() {
		return userDao.findByNameQuery();
	}

}
