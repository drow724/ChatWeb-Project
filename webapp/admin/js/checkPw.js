var speed = 60; //글자가 찍히는 속도
var cnt = 0;
var timer = null;
var speed1 = 30; //글자가 찍히는 속도
var cnt1 = 0;
var timer1 = null;
var speed2 = 30; //글자가 찍히는 속도
var cnt2 = 0;
var timer2 = null;

function gogogo(){
text = "현재 비밀번호를 입력해 주세요!";	
    document.getElementById('art').innerHTML = text.substring(0, cnt) + "_";
    cnt++;
    timer = setTimeout('gogogo()', speed);
}

function adminLogin() {

           if (window.event.keyCode == 13) {
 
             // 엔터키가 눌렸을 때 실행할 내용
             login();
        }
       
}


function login() {

	location.href="checkPw?password=" + document.getElementById('adminPw').value;

}

function gogogo2() {
 text = "회원가입";	
 document.getElementById('texts2').innerHTML = text.substring(0, cnt2) + "_";
    cnt2++;
    timer2 = setTimeout('gogogo2()', speed2);
}

function focus(){

	document.getElementById('adminPw').focus();

}
