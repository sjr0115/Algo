// 편의성을 위해 객체 배열 선언
var foods = [
  { ename: "cake", kname: "케이크" },
  { ename: "burger", kname: "햄버거" },
  { ename: "steak", kname: "스테이크" },
  { ename: "sandwich", kname: "샌드위치" }
];

// $(function() {});   문서로딩시 함수안의 내용을 자동 실행하라는 뜻
$(function() {
  var $imgThumb = $(".img-thumb");

  // foods 배열의 크기만큼 자동 반복돌면서 각 요소들을 반환
  $.each(foods, function(index, food) {
    $imgThumb.append(
      `<img src="./images/${food.ename}.jpg" data-index="${index}">`
    );
  });

  // 처음 로딩시 케이크 이미지 적용
  choiceImg(0);

  // 랜덤 선택 버튼 클릭 시 이벤트 처리
  $("#addBtn").click(function() {
    choiceImg(parseInt(Math.random() * 4));
  });

  // 하단 썸네일 이미지 클릭 시 이벤트 처리
  $(".img-thumb > img").click(function() {
    choiceImg($(this).attr("data-index"));
    // choiceImg($(this).data("index")); // "data-이름" 형태의 속성 설정인 경우 data 함수도 가능
  });
});

// 인덱스 위치의 이미지를 선택 모양을 만들고 화면 중앙 이미지로 설정
function choiceImg(index) {
  $(".img-view > img").attr("src", `./images/${foods[index].ename}.jpg`);
  $("#foodName").text(foods[index].kname);

  $(".img-thumb > img").removeClass("choice");
  $(`.img-thumb > img:eq(${index})`).addClass("choice");
}
