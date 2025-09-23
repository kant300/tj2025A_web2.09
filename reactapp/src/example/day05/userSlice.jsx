import { createSlice } from "@reduxjs/toolkit";

// [1] 리덕스 설치 : reactApp 폴더 오른쪽 클랙 --> 터미널 열기
// [ 리액트 종료된 상태 ]
// npm i @reduxjs/toolkit
// npm i react-redux
// [ 리액트 재실행 ] npm run dev

// [2] 전역변수의 초기값 , '로그인여부'를 저장하는 상태 true(로그인됨), false(로그인안됨)
const initialState = { isAuthenticated : false };

// [3] 상태를 변경하는 리듀서 함수들을 정의
// createSlice({ name : 'slice이름', 초기값, reducers : { 액션함수명 : (state)=>{} } } );
const userSlice = createSlice({
    name : 'user' , // slice 이름, 저장소(store)에 저장되는 일부분의 값의 이름
    initialState , //[2] 정의한 객체로 초기값을 설정, 추후에 다양하게 저장 가능, 단 노출이 위험한 정보 제외
    reducers : { 
        login : ( state )=>{ state.isAuthenticated = true; }, // 로그인액션(로그인 함수가 실행되면 처리되는 코드)
        logout : ( state )=>{ state.isAuthenticated = false;} // 로그아웃 액션(로그아웃함수가 실해오디면 처리되는 코드)
    } ,  // slice(상태)가 변경되는 방법(함수) 정의
} );
// [4] 액션함수 내보내기
// [4-1] export default 내보내기는 파일내 1개만 가능 , store에 리듀서를 import 할수있게
export default userSlice.reducer
// [4-2] export 내보내기는 파일내 여러개 가능 , login액션, logout액션을 다른 컴포넌트에 
export const { login, logout } = userSlice.actions; // 

// [5] store(저장소) 만들기 : src 폴더에 store.js 만들기
// import { configureStore } from "@reduxjs/toolkit";
// import userReducer from "./example/day05/useSlice"; // [1]에서 만든 slice 파일 경로
// export default configureStore({ reducer : { user : userReducer } }); // reducer : { slice이름 : slice파일명 }//