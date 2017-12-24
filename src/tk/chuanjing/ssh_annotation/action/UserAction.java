package tk.chuanjing.ssh_annotation.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tk.chuanjing.ssh_annotation.domain.User;
import tk.chuanjing.ssh_annotation.service.IUserService;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author ChuanJing
 * @date 2017年7月25日 下午3:09:11
 * @version 1.0
 */

@Controller("userAction")
@Scope("prototype")
@Namespace("/")						// <package namespace="">
@ParentPackage("struts-default")	// <package extends="">
public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User();
	public User getModel() {
		return user;
	}
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;

	// <action name="user_add"><result name="success">/success.jsp</result>
	@Action(value="user_add", results = { @Result(name="success", location="/success.jsp") } )
	public String add() {
		userService.add(user);
		
		return SUCCESS;
	}
	
	@Action(value="user_findById")
	public void findById() {
		// 通过service来调用根据id查询操作
		User _user = userService.findById(user.getId());
		
		// 将_user转换成json数据响应到浏览器
		String json = JSONObject.toJSONString(_user);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
