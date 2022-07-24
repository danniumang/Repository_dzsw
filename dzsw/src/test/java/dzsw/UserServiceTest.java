package dzsw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.controller.SysRoleController;
import com.demo.controller.SysUserController;
import com.demo.entity.SysRole;
import com.demo.entity.SysUser;

public class UserServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		 SysUserController sc=(SysUserController)ctx.getBean("sysUserController");
		 SysUser user=new SysUser();
		 user.setPassword("1234");
		 user.setUname("liuyujie");
		 user.setUserid("990");
		 user.setUsex("男");
		// Model model=new Model();
		 sc.login(user, null);
		 SysRoleController src=(SysRoleController)ctx.getBean("sysRoleController");
		 SysRole sysr=new SysRole();
		 sysr.setDescribe("admin");
		 sysr.setRoleId(1);
		 sysr.setRoleName("ROLE_ADMIN");
		 src.select(sysr, null);
	}

}
