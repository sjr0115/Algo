/**
 * MyMap 생성자로 사용될 함수를 구현
 */
MyMap = function(){
	this.map = new Object();
}
MyMap.prototype = {
		put : function(key, value){
			this.map[key] = value;
		},
		get : function(key){
			return this.map[key];
		},
		size : function(){
			var cnt = 0;
			for(var prop in this.map){
				cnt++;
			}
			return cnt;
		},
		clear : function(){
			this.map = new Array();
		},
		remove : function(key) {
			delete this.map[key];
		}
};