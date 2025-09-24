/*
    슬라이스 : 상태(state), 리듀서(reducer), 액션(action) 를  정의하는 곳, 하나로 묶은 것
    createSlice
*/
import { createSlice } from "@reduxjs/toolkit";
// [1] 상태의 초기값 정의, 로그인여부 , 로그인 회원정보
const initialState = { isAuthenticated : false , usreInfo : null }
// [2] 슬라이스 정의
const userSlice = createSlice({
    name : "user" , // 슬라이스(상태) 이름
    initialState,
    reducers : { // 여러개의 상태 변경하는 함수정의한곳, { 함수명 : (state)=>{} , 함수명 : (state)=>{} }
        login : ( state , action )=> {
            state.isAuthenticated = true ; // 로그인 여부 true로 변경
            // action 할때 전달되는 매개변수들은 payload 안에 값이 들어있다.
            // 예] dispatch(login("안녕") ), payload = "안녕"
            state.userInfo= action.payload;

        },
        logout : ( state )=> { 
            state.isAuthenticated = false;  // 로그인 여부 false로 변경
            state.userInfo = null;  // 로그인 회원정보  null로 변경 
         }
    }
})
// [3] store에 저장할수있게 export 해주기
export default userSlice.reducer // 현재 정의한 리듀서(reducers)들을 store 등록예정
// [4] 다른 컴포넌트에서 액션이 가능하도록 login, logout 액션함수 export해주기
export const { login, logout } = userSlice.actions;