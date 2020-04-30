$(function() {
	// 메모 추가 버튼 클릭 시 화면에 메모를 보여주기 : createBtn
	$("#createBtn").click(function() {
		new Memo().create();
	});
});
// 문서가 로딩된 다음 실행하려면 $()안에 function을 쓰자
function Memo() {
// create에서 만든 객체를 다른 함수에서도 사용해야되니까
	// $note가 메모화면 전체를 감싸고 있어
	var $note = null;
	
}
// create() 메모추가 버튼 누르면 메모 생성
Memo.prototype.create = function() {
	console.log("create");
	
	var $note = $(
			`<div class="memo-note">
			<div class="memo-bar">
				<span class="glyphicon glyphicon-chevron-up" aria-hidden="true"></span>
				<span class="glyphicon glyphicon-pushpin" aria-hidden="true"></span>
				<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
			</div>
			<div>
				<textarea class="memo-edit"></textarea>
			</div>
		</div>`
	);	
	
	$note.appendTo($(".memo-area"));
	
	this.$note = $note;
	this.drag();
	
	var that = this;
	
	$note.find(".glyphicon-chevron-up").click(function() {
		// console.dir(this);// 이벤트가 발생한 객체
		// console.dir(that);// 메모객체를 받은
		// 이 함수 내에서 this는 chevron-up객체를 의미
		// 그래서 변수를 생성해서 메모 객체를 받아와 사용
		
		console.log("disply");
		that.display();
	});
	$note.find(".glyphicon-pushpin").click(function() {
		console.log("fix");
		that.fix();
	});
	$note.find(".glyphicon-trash").click(function() {
		that.del();
	});
	
};
// display()
Memo.prototype.display = function() {
	this.$note.toggleClass("h20");
	this.$note.find(".glyphicon-chevron-up").toggleClass("up-down");
	// 있을 땐 제거 없을 땐 추가
};
// fix()
Memo.prototype.fix = function() {
	// note를 찾고 note안에 있는 클래스를 추가할 대상인 pushpin을 찾아서 눌렸을때 choice 실행
	this.$note.find(".glyphicon-pushpin").toggleClass("choice");
	if(this.$note.find(".glyphicon-pushpin").hasClass("choice")){
		this.$note.draggable("disable");
	}else{
		this.$note.draggable("enable");
	}
};
// del()
Memo.prototype.del = function() {
	this.$note.remove();
};
// drag()
Memo.prototype.drag = function() {
	this.$note.draggable();
};