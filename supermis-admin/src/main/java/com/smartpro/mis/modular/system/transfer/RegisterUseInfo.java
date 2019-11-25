package com.smartpro.mis.modular.system.transfer;

import com.smartpro.mis.modular.system.model.Doctoruser;
import com.smartpro.mis.modular.system.model.User;
import com.smartpro.mis.modular.system.model.Doctoruser;
import com.smartpro.mis.modular.system.model.Patientuser;
import com.smartpro.mis.modular.system.model.User;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 用户传输bean
 * 
 * @author smartpro
 * @Date 2017/5/5 22:40
 */
public class RegisterUseInfo {

//	private Integer id;
//	private String account;
//	private String password;
//	private String salt;
//	private String name;
//
////	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	private Date birthday;
//	private Integer sex;
//	private String email;
//
//	@NotNull
//	private String phone;
//	private String roleid;
//	private Integer deptid;
//	private Integer status;
//	private Date createtime;
//	private Integer version;
//	private String avatar;
//	/**
//	 * 身份证号
//	 */
//	private String cardNo;
//	private Integer age;
	private User user;
	private Patientuser patientuser;
	private Doctoruser doctoruser;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Patientuser getPatientuser() {
		return patientuser;
	}

	public void setPatientuser(Patientuser patientuser) {
		this.patientuser = patientuser;
	}

	public Doctoruser getDoctoruser() {
		return doctoruser;
	}

	public void setDoctoruser(Doctoruser doctoruser) {
		this.doctoruser = doctoruser;
	}

}
