var speed3 = 30; //글자가 찍히는 속도
var cnt3 = 0;
var timer3 = null;

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

function back() {

location.href="index";

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
