var speed = 50; //글자가 찍히는 속도
var cnt = 0;
var timer = null;

var speed1 = 50; //글자가 찍히는 속도
var cnt1 = 0;
var timer1 = null;

var speed2 = 50; //글자가 찍히는 속도
var cnt2 = 0;
var timer2 = null;

var speed3 = 50; //글자가 찍히는 속도
var cnt3 = 0;
var timer3 = null;

var speed4 = 50; //글자가 찍히는 속도
var cnt4 = 0;
var timer4 = null;

var speed5 = 50; //글자가 찍히는 속도
var cnt5 = 0;
var timer5 = null;

var speed6 = 50; //글자가 찍히는 속도
var cnt6 = 0;
var timer6 = null;

var speed7 = 50; //글자가 찍히는 속도
var cnt7 = 0;
var timer7 = null;

var speed8 = 50; //글자가 찍히는 속도
var cnt8 = 0;
var timer8 = null;

var speed9 = 50; //글자가 찍히는 속도
var cnt9 = 0;
var timer9 = null;

var speed10 = 50; //글자가 찍히는 속도
var cnt10 = 0;
var timer10 = null;

function handleOnInputId(e)  {
  e.value = e.value.replace(/[^A-Za-z1-9]/ig, '')
}

function handleOnInputPassword(e)  {
  e.value = e.value.replace(/[^A-Za-z123456789!@#$%^&*()_+]/ig, '')
}

function focus(){

	document.getElementById('id').focus();

};

function enterkey() {
        if (window.event.keyCode == 13) {
 
        next();
       }
}

function enterkey1() {
        if (window.event.keyCode == 13) {
 
             next1();
             
        }
}
function enterkey2() {
        if (window.event.keyCode == 13) {
 
            next2();
             
        }
}

function enterkey3() {

        if (window.event.keyCode == 13) {
        	

             	next3();
             	}
             	
}

function enterkey4() {
        if (window.event.keyCode == 13) {
         
 			x=document.joinInfo
        	txt=x.gender.value
        		if(txt>=1 && txt<=2) {
					next4();
             
             } else {
				txt=1; 
             }       
        }
}

function enterkey5() {
        if (window.event.keyCode == 13) {
 
 			next5();
             
        }
}

function gogogo() {
	var text = "원하는 아이디를 입력하세요(영문+숫자 조합)";	
    document.getElementById('texts').innerHTML = text.substring(0, cnt)+ "_";
    cnt++;
    timer = setTimeout('gogogo()', speed);
 
}

function gogogo1() {
 text = "원하는 비밀번호를 입력하세요(영문+숫자 조합)";	
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
 text = "성별을 입력하세요(남자는 '1' 여자는 '2')";	
 document.getElementById('texts4').innerHTML = text.substring(0, cnt4) + "_";
    cnt4++;
    timer4 = setTimeout('gogogo4()', speed4);
}

function gogogo7() {
 text = "이메일을 입력하세요";	
 document.getElementById('texts5').innerHTML = text.substring(0, cnt7) + "_";
    cnt7++;
    timer7 = setTimeout('gogogo7()', speed7);
}

function gogogo8() {
 text = "입력하신 정보로 가입하시겠습니까?";	
 document.getElementById('texts6').innerHTML = text.substring(0, cnt8) + "_";
    cnt8++;
    timer8 = setTimeout('gogogo8()', speed8);
}

function gogogo9() {
 text = "네";	
 document.getElementById('button1').innerHTML = text.substring(0, cnt9) + "_";
    cnt9++;
    timer9 = setTimeout('gogogo9()', speed9);
}

function gogogo10() {
 text = "아니오";	
 document.getElementById('button2').innerHTML = text.substring(0, cnt10) + "_";
    cnt10++;
    timer10 = setTimeout('gogogo10()', speed10);
}

function pressYes() {
 if (window.event.keyCode == 13) {
	joinInfo.submit();
	}
	else if (window.event.keyCode == 39 || window.event.keyCode == 40){ 
			document.getElementById('button2').focus();
			}
}

function pressNo() {
 if (window.event.keyCode == 13) {
	location.reload();
	}
	 else if (window.event.keyCode == 37 || window.event.keyCode == 38){ 
			document.getElementById('button1').focus();
			}
}

function next() {
 if (document.getElementById('id').value == "") {
	 gogogo();
	}
	else {
	gogogo1();
		document.getElementById('pw').removeAttribute("disabled");
     setTimeout(function() {document.getElementById('pw').focus();}, 500);
		
	}
}

function next1() {
 if (document.getElementById('pw').value == "") {
	 gogogo1();
	}
	else {
	document.getElementById('pwchk').removeAttribute("disabled");
	gogogo2();
             setTimeout(function() {document.getElementById('pwchk').focus();}, 500);
		
	}
}

function next2() {
 if (document.getElementById('pwchk').value == "") {
	 gogogo2();
	}
	else if(document.getElementById('pwchk').value != document.getElementById('pw').value){
		gogogo2();
	}
	else {
	document.getElementById('name').removeAttribute("disabled");
	gogogo3();
     setTimeout(function() {document.getElementById('name').focus();}, 500);
		
	}
}

function next3() {
 if (document.getElementById('name').value == "") {
	 gogogo3();
	}
	else {
	document.getElementById('gender').removeAttribute("disabled");
     	gogogo4();
        setTimeout(function() {document.getElementById('gender').focus();}, 500);    
		
	}
}

function next4() {
 if (document.getElementById('gender').value == "") {
	 gogogo4();
	}
	else {
	document.getElementById('email').removeAttribute("disabled");
	gogogo7();
     setTimeout(function() {document.getElementById('email').focus();}, 500);
		
	}
}

function next5() {
 if (document.getElementById('email').value == "") {
	 gogogo7();
	}
	else {
	document.getElementById('button1').removeAttribute("disabled");
	document.getElementById('button2').removeAttribute("disabled");
	 gogogo8();
    setTimeout(function() {gogogo9();}, 500);
    setTimeout(function() {gogogo10();}, 1200);
    setTimeout(function() {document.getElementById('button1').focus();}, 1700);
		
	}
}

function onlyKorean(name) {
var str=document.getElementById(name).value;
for (i = 0; i < str.length; i++) {
if (!((str.charCodeAt(i) > 0x3130 && str.charCodeAt(i) < 0x318F) || (str.charCodeAt(i) >= 0xAC00 && str.charCodeAt(i) <= 0xD7A3))) {
document.getElementById(name).value=''; 
} 
} 
}
