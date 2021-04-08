var speed = 70; //글자가 찍히는 속도
var cnt = 0;
var timer1 = null;
var text = " 아이디를 입력하세요.";	
function gogogo(){

    document.getElementById('texts').innerHTML = text.substring(0, cnt) + "_";
    cnt++;
    timer1 = setTimeout('gogogo()', speed);
 
}
function enterkey() {
        if (window.event.keyCode == 13) {
 
             // 엔터키가 눌렸을 때 실행할 내용
             login();
        }
}
function login() {

location.href="loginPw";

}