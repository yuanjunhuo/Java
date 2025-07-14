package org.example.mybatis;

import org.example.mybatis.Mapper.UserMapper;
import org.example.mybatis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MyBatisApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	void delete(){
		int a = userMapper.delete(1);
		System.out.println("删除成功！！！");
		System.out.println(a);
	}

	@Test
	void insert(){
		User user = new User("hjy65566",321,12,"17834322345");
		int a = userMapper.insert(user);
		System.out.println(a);
	}

	@Test
	void update(){
		User user = new User("h",1,12,"17834322345");
		int a = userMapper.update(user);
		System.out.println(a);
	}

	@Test
	void SelectbyID(){
		//User user = new User("h",1,12,"17834322345");
		User a = userMapper.findById(2);
		System.out.println(a);
	}


	@Test
	void contextLoads() {
		System.out.println("hjy!!!!!!");
		List<User> users = userMapper.findAll();
		for (User user : users) {
			System.out.println(user);
		}
	}
}
