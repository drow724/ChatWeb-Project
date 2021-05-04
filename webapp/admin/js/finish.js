var speed3 = 30; //글자가 찍히는 속도
var cnt3 = 0;
var timer3 = null;

function enterkeydown() {
        if (window.event.keyCode == 13) {
             clickBack();
        }
}

function clickBack() {
location.href="main";
}

function gogogo3() {
 text = "돌아가기";	
 document.getElementById('texts3').innerHTML = text.substring(0, cnt3) + "_";
    cnt3++;
    timer3 = setTimeout('gogogo3()', speed3);
}

function focus(){
	document.getElementById('texts3').focus();
}
