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
var speed4 = 30; //글자가 찍히는 속도
var cnt4 = 0;
var timer4 = null;
function gogogo(){
text = "게시글 작성";	
    document.getElementById('title').innerHTML = text.substring(0, cnt) + "_";
    cnt++;
    timer = setTimeout('gogogo()', speed);
}

function gogogo1(){
text = "제목";	
    document.getElementById('boardTitle').innerHTML = text.substring(0, cnt1) + "_";
    cnt1++;
    timer1 = setTimeout('gogogo1()', speed1);
}

function gogogo2() {
 text = "첨부파일";	
 document.getElementById('boardFiles').innerHTML = text.substring(0, cnt2) + "_";
    cnt2++;
    timer2 = setTimeout('gogogo2()', speed2);
}

function gogogo3() {
 text = "등록";	
 document.getElementById('boardSubmit').innerHTML = text.substring(0, cnt3) + "_";
    cnt3++;
    timer3 = setTimeout('gogogo3()', speed3);
}

function gogogo4() {
 text = "돌아가기";	
 document.getElementById('boardBack').innerHTML = text.substring(0, cnt4) + "_";
    cnt4++;
    timer4 = setTimeout('gogogo4()', speed3);
}

function enterkeydown1() {

			if (window.event.keyCode == 13){ 
					title();
			}
			else if (window.event.keyCode == 39 || window.event.keyCode == 40){ 
					document.getElementById('boardFiles').focus();
			}
}

function enterkeydown2() {

        if (window.event.keyCode == 37 || window.event.keyCode == 38){ 
			document.getElementById('boardTitleInput').focus();
	}
		else if (window.event.keyCode == 39 || window.event.keyCode == 40){ 
			document.getElementById('boardContent').focus();
		}
}

function enterkeydown3() {
        if (window.event.keyCode == 13) {
 
             // 엔터키가 눌렸을 때 실행할 내용
             write();
        }
        
         else if (window.event.keyCode == 37 || window.event.keyCode == 38){ 
			document.getElementById('boardFiles').focus();
	}
		else if (window.event.keyCode == 39 || window.event.keyCode == 40){ 
			document.getElementById('boardSubmit').focus();
		}
}

function enterkeydown4() {
        if (window.event.keyCode == 13) {
 
             // 엔터키가 눌렸을 때 실행할 내용
             back();
        }
        
        else if (window.event.keyCode == 37 || window.event.keyCode == 38){ 
			document.getElementById('boardContent').focus();
	}
		else if (window.event.keyCode == 39 || window.event.keyCode == 40){ 
			document.getElementById('boardBack').focus();
		}
}

function write() {

	writeInfo.submit();

}

function back() {

location.href="board";

}

function focus(){

	document.getElementById('boardTitleInput').focus();

}

function title() {

	if(document.getElementById('boardTitleInput').value == ""){
		document.getElementById('boardContent').focus();
	}else{
		document.getElementById('boardContent').focus();
	}

}