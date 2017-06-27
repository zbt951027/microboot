package cn.mldn.microboot.vo;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

@SuppressWarnings("serial")
public class Member implements Serializable {
	@Email(message="请输入正确的Email格式")
	private String mid;
	@Pattern(regexp="\\S", message="姓名不能为空!")
	private String name;
	@NotNull
	private Integer age;
	@Past
	@NotNull
	private Date birthday;
	@Digits(integer=20, fraction=2, message="请输入正确的工资")
	private Double sal;

	public String getMid() { 
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Member [mid=" + mid + ", name=" + name + ", age=" + age + ", birthday=" + birthday + ", sal=" + sal
				+ "]";
	}
}
