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

	document.getElementById('email').focus();

}

function gogogo(){
var text = "가입하신 이메일을 입력하세요";	
    document.getElementById('texts').innerHTML = text.substring(0, cnt) + "_";
    cnt++;
    timer = setTimeout('gogogo()', speed);
 
}

function gogogo1() {
 text = "가입하신 이름을 입력하세요";	
 document.getElementById('texts1').innerHTML = text.substring(0, cnt1) + "_";
    cnt1++;
    timer1 = setTimeout('gogogo1()', speed1);
}

function gogogo2() {
 text = "입력하신 정보로 찾으시겠습니까?";	
 document.getElementById('texts2').innerHTML = text.substring(0, cnt2) + "_";
    cnt2++;
    timer2 = setTimeout('gogogo2()', speed2);
}

function enterkey() {
        if (window.event.keyCode == 13) {
 
            next();
             
        }
}
 
 function next() {
 if (document.getElementById('email').value == "") {
	 gogogo();
	}
	else {
	gogogo1();
	document.getElementById('name').removeAttribute("disabled");
    setTimeout(function() {document.getElementById('name').focus();}, 500);
		
	}
}

function enterkey1() {
        if (window.event.keyCode == 13) {
             next1();
        }
}

function next1() {
 if (document.getElementById('name').value == "") {
	 gogogo1();
	}
	else {
	gogogo2();
	document.getElementById('texts2').removeAttribute("disabled");
    setTimeout(function() {document.getElementById('texts2').focus();}, 500);
		
	}
}

function pressSubmit() {
        if (window.event.keyCode == 13) {
			findInfo.submit();
             
        }
}