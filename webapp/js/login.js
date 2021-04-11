var speed = 70; //글자가 찍히는 속도
var cnt = 0;
var timer = null;
var speed1 = 70; //글자가 찍히는 속도
var cnt1 = 0;
var timer1 = null;

function gogogo(){
var text = " 아이디를 입력하세요";	
    document.getElementById('texts').innerHTML = text.substring(0, cnt) + "_";
    cnt++;
    timer = setTimeout('gogogo()', speed);
 
}
function enterkey() {
        if (window.event.keyCode == 13) {
 
             // 엔터키가 눌렸을 때 실행할 내용
             gogogo1();
             setTimeout(function() {document.getElementById('pw').focus();}, 1200);
             
        }
}
         

function gogogo1() {
 text = " 비밀번호를 입력하세요";	
 document.getElementById('texts1').innerHTML = text.substring(0, cnt1) + "_";
    cnt1++;
    timer1 = setTimeout('gogogo1()', speed1);
}


function focus(){

	document.getElementById('id').focus();

};