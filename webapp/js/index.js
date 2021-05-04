var speed = 60; //글자가 찍히는 속도
var cnt = 0;
var timer = null;
var speed1 = 30; //글자가 찍히는 속도
var cnt1 = 0;
var timer1 = null;
var speed2 = 30; //글자가 찍히는 속도
var cnt2 = 0;
var timer2 = null;
var speed3 = 30; //글자가 찍히는 속도
var cnt3 = 0;
var timer3 = null;

function gogogo(){
text = "Let's Chat!";	
    document.getElementById('art').innerHTML = text.substring(0, cnt) + "_";
    cnt++;
    timer = setTimeout('gogogo()', speed);
}

function gogogo1(){
text = " 로그인";	
    document.getElementById('texts1').innerHTML = text.substring(0, cnt1) + "_";
    cnt1++;
    timer1 = setTimeout('gogogo1()', speed1);
}

function clickLogin() {
	location.href="login";
}

function clickJoin() {
	location.href="join";
}

function enterkeyup() {
        if (window.event.keyCode == 13) {
 
             // 엔터키가 눌렸을 때 실행할 내용
             login();
        }
        
         else if (window.event.keyCode == 39 || window.event.keyCode == 40){ 
			document.getElementById('texts2').focus();
	}
}

function enterkeydown() {
        if (window.event.keyCode == 13) {
 
             // 엔터키가 눌렸을 때 실행할 내용
             join();
        }
        
         else if (window.event.keyCode == 37 || window.event.keyCode == 38){ 
			document.getElementById('texts1').focus();
		}
		else if (window.event.keyCode == 39 || window.event.keyCode == 40){ 
			document.getElementById('texts3').focus();
		}
}

function enterkeydown2() {
        if (window.event.keyCode == 13) {
 
             // 엔터키가 눌렸을 때 실행할 내용
             find();
        }
        
         else if (window.event.keyCode == 37 || window.event.keyCode == 38){ 
			document.getElementById('texts2').focus();
	}
}

function login() {

location.href="login";

}

function join() {

location.href="join";

}

function find() {

location.href="find";

}

function gogogo2() {
 text = "회원가입";	
 document.getElementById('texts2').innerHTML = text.substring(0, cnt2) + "_";
    cnt2++;
    timer2 = setTimeout('gogogo2()', speed2);
}

function gogogo3() {
 text = "아이디/비밀번호 찾기";	
 document.getElementById('texts3').innerHTML = text.substring(0, cnt3) + "_";
    cnt3++;
    timer3 = setTimeout('gogogo3()', speed3);
}

function focus(){

	document.getElementById('texts1').focus();

}
