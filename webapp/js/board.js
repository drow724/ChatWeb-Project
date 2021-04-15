var speed = 50; //글자가 찍히는 속도
var cnt = 0;
var timer = null;
var speed1 = 50; //글자가 찍히는 속도
var cnt1 = 0;
var timer1 = null;
var speed2 = 50; //글자가 찍히는 속도
var cnt2 = 0;
var timer2 = null;

function focus(){

	document.getElementById('id').focus();

}

function gogogo(){
var text = "게시판";	
    document.getElementById('title').innerHTML = text.substring(0, cnt) + "_";
    cnt++;
    timer = setTimeout('gogogo()', speed);
 
}

function gogogo1() {
 text = "비밀번호를 입력하세요";	
 document.getElementById('texts1').innerHTML = text.substring(0, cnt1) + "_";
    cnt1++;
    timer1 = setTimeout('gogogo1()', speed1);
}

function gogogo2() {
 text = "로그인 하시겠습니까?";	
 document.getElementById('texts2').innerHTML = text.substring(0, cnt2) + "_";
    cnt2++;
    timer2 = setTimeout('gogogo2()', speed2);
}

function enterkey() {
        if (window.event.keyCode == 13) {
 
             // 엔터키가 눌렸을 때 실행할 내용
             gogogo1();
             setTimeout(function() {document.getElementById('pw').focus();}, 500);
             
        }
}
 
function enterkey1() {
        if (window.event.keyCode == 13) {
 
             // 엔터키가 눌렸을 때 실행할 내용
             gogogo2();
             setTimeout(function() {document.getElementById('texts2').focus();}, 600);
             
        }
}

function pressSubmit() {
        if (window.event.keyCode == 13) {
			loginInfo.submit();
             
        }
}