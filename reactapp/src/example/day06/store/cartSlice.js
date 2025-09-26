// [1] 카트 전역상태 어떻게 구상할지 초기값 선언, 테스트과정에서는 샘플데이터
// const cart = [
//      { id : 1 , name: "아메리카노" , price: 3000 , count : 3 },
//      { id : 3 , name: "카푸치노" , price : 4500 , count : 1 },
//]
// const 초기값 = { cart : [] }
const 초기값 = { cartList : [ { id : 1 , name: "아메리카노" , price: 3000 , count : 3 } ] }
// [2] 슬라이스 구성 : 상태와 상태변경 함수를 구성(객체)

const 카트슬라이스 = createSlice( {
 
} )