/**
 *  MyMap 생성자 함수를 구현합니다.
 *
 *  put - 데이터 입력
 *  get - 데이터 반환
 *  size - 관리하는 데이터의 개수 반환
 *  remove - 키에 해당하는 데이터 삭제
 *  clear - 관리하는 데이터 모두 삭제
 */
function MyMap() {
  this.data = {};
  this.count = 0;
}
MyMap.prototype = {
  put(key, value) {
    this.data[key] = value;
    this.count++;
  },
  size() {
    return this.count;
  },
  get(key) {
    return this.data[key];
  },
  remove(key) {
    delete this.data[key];
    this.count--;
  },
  clear() {
    this.data = {};
    this.count = 0;
  }
};
