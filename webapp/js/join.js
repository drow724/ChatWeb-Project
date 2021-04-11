var speed = 70; //글자가 찍히는 속도
var cnt = 0;
var timer = null;

var speed1 = 70; //글자가 찍히는 속도
var cnt1 = 0;
var timer1 = null;

var speed2 = 70; //글자가 찍히는 속도
var cnt2 = 0;
var timer2 = null;

var speed3 = 70; //글자가 찍히는 속도
var cnt3 = 0;
var timer3 = null;

var speed4 = 70; //글자가 찍히는 속도
var cnt4 = 0;
var timer4 = null;

var speed5 = 70; //글자가 찍히는 속도
var cnt5 = 0;
var timer5 = null;

var speed6 = 70; //글자가 찍히는 속도
var cnt6 = 0;
var timer6 = null;

var speed7 = 70; //글자가 찍히는 속도
var cnt7 = 0;
var timer7 = null;

function focus(){

	document.getElementById('id').focus();

};

function enterkey() {
        if (window.event.keyCode == 13) {
 
             // 엔터키가 눌렸을 때 실행할 내용
             gogogo1();
             setTimeout(function() {document.getElementById('pw').focus();}, 1200);
             
        }
}

function enterkey1() {
        if (window.event.keyCode == 13) {
 
             // 엔터키가 눌렸을 때 실행할 내용
             gogogo2();
             setTimeout(function() {document.getElementById('pwchk').focus();}, 1100);
             
        }
}
function enterkey2() {
        if (window.event.keyCode == 13) {
 
             // 엔터키가 눌렸을 때 실행할 내용
             gogogo3();
             setTimeout(function() {document.getElementById('name').focus();}, 500);
             
        }
}

function enterkey3() {
        if (window.event.keyCode == 13) {
 
             // 엔터키가 눌렸을 때 실행할 내용
             gogogo4();
             setTimeout(function() {document.getElementById('sex').focus();}, 500);
             
        }
}

function enterkey4() {
        if (window.event.keyCode == 13) {
 
             // 엔터키가 눌렸을 때 실행할 내용
             gogogo5();
             setTimeout(function() {document.getElementById('birth').focus();}, 500);
             
        }
}

function enterkey5() {
        if (window.event.keyCode == 13) {
 
             // 엔터키가 눌렸을 때 실행할 내용
             gogogo6();
             setTimeout(function() {document.getElementById('phone').focus();}, 500);
             
        }
}

function enterkey6() {
        if (window.event.keyCode == 13) {
 
             // 엔터키가 눌렸을 때 실행할 내용
			gogogo7();
             setTimeout(function() {document.getElementById('email').focus();}, 500);
             
        }
}

function enterkey7() {
        if (window.event.keyCode == 13) {
 
             // 엔터키가 눌렸을 때 실행할 내용
           
             
        }
}


function gogogo(){
var text = "원하는 아이디를 입력하세요";	
    document.getElementById('texts').innerHTML = text.substring(0, cnt)+ "_";
    cnt++;
    timer = setTimeout('gogogo()', speed);
 
}

function gogogo1() {
 text = "원하는 비밀번호를 입력하세요";	
 document.getElementById('texts1').innerHTML = text.substring(0, cnt1) + "_";
    cnt1++;
    timer1 = setTimeout('gogogo1()', speed1);
}

function gogogo2() {
 text = "비밀번호 확인";	
 document.getElementById('texts2').innerHTML = text.substring(0, cnt2) + "_";
    cnt2++;
    timer2 = setTimeout('gogogo2()', speed2);
}

function gogogo3() {
 text = "이름을 입력하세요";	
 document.getElementById('texts3').innerHTML = text.substring(0, cnt3) + "_";
    cnt3++;
    timer3 = setTimeout('gogogo3()', speed3);
}

function gogogo4() {
 text = "성별을 입력하세요";	
 document.getElementById('texts4').innerHTML = text.substring(0, cnt4) + "_";
    cnt4++;
    timer4 = setTimeout('gogogo4()', speed4);
}

function gogogo5() {
 text = "생년월일을 입력하세요";	
 document.getElementById('texts5').innerHTML = text.substring(0, cnt5) + "_";
    cnt5++;
    timer5 = setTimeout('gogogo5()', speed5);
}

function gogogo6() {
 text = "핸드폰번호를 입력하세요";	
 document.getElementById('texts6').innerHTML = text.substring(0, cnt6) + "_";
    cnt6++;
    timer6 = setTimeout('gogogo6()', speed6);
}

function gogogo7() {
 text = "이메일을 입력하세요";	
 document.getElementById('texts7').innerHTML = text.substring(0, cnt7) + "_";
    cnt7++;
    timer7 = setTimeout('gogogo7()', speed7);
}
