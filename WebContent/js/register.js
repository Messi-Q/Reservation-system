/**
 * 
 */
// 验证确认密码
function validateLoginpass() {
	var UserPwd = document.getElementById("UserPwd").value;
	var IsPwd = document.getElementById("IsPwd").value;
	if (UserPwd.length < 5 || UserPwd.length > 16) {
		window.alert("密码长度必须在5~16之间！");
		form.UserPwd.focus();
		return false;
	} else if (UserPwd != IsPwd) {
		window.alert("您输入的密码与确认密码不一致!");
		form.IsPwd.focus();
		return false;
	} else {
		return true;
	}
}

// 校验用户名密码
function validateLoginname() {
	if (form.UserName.value == "") {
		alert("用户名不能为空！");
		return false;
	} else if (form.UserPwd.value == "") {
		alert("密码不能为空！");
		return false;
	} else if (form.IsPwd.value == "") {
		alert("确认密码输入不能为空！");
		return false;
	} else if (form.RealName.value == "") {
		alert("真实姓名不能为空！");
		return false;
	} else if (form.Age.value == "") {
		alert("年龄不能为空！");
		return false;
	} else if (form.CardId.value == "") {
		alert("身份证不能为空！");
		return false;
	} else if (form.UserAddress.value == "") {
		alert("地址不能为空！");
		return false;
	} else if (form.UserTel.value == "") {
		alert("电话不能为空！");
		return false;
	} else if (form.Email.value == "") {
		alert("邮箱不能为空！");
		return false;
	} else if (form.Ems.value == "") {
		alert("邮编不能为空！");
		return false;
	} else {
		return true;
	}
}

// 校验email
function validateEmail() {
	var Email = document.getElementById("Email");
	var email = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
	if (!email.test(Email.value)) {
		window.alert("错误的Email格式！");
		form.Email.focus();
		return false;
	} else {
		return true;
	}
}

// 校验手机号码
function validatemobile() {
	var Tel = document.getElementById("UserTel").value;
	var tel = /^1[3|4|5|7|8][0-9]{9}$/;
	if (Tel.length != 11) {
		window.alert("请输入有效的手机号码!");
		form.Tel.focus();
		return false;
	} else if (!tel.test(Tel)) {
		window.alert("请输入有效的手机号码!");
		form.Tel.focus();
		return false;
	} else {
		return true;
	}
}

// 校验邮政编码
function validateEms() {
	var ems = document.getElementById("Ems").value;
	if (ems.length != 6) {
		window.alert("请输入有效的邮政编码!");
		form.ems.focus();
		return false;
	} else {
		return true;
	}
}

function checkAll() {
	if (validateLoginpass() && validateLoginname() && validateEmail()
			&& validatemobile() && validateEms()) {
//		alert("ok");
		return true;
	} else {
//		alert("error");
		return false;
	}
}
