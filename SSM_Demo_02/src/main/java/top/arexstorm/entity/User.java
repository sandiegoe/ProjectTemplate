package top.arexstorm.entity;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class User implements Serializable {

	private Long id;
	private String username;
	private Integer age;
	private String interests;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
