// ==== 여러개의 slice를 하나의 스토어에서 관리하는 코드 ====
import { configureStore } from "@reduxjs/toolkit";
import userReducer from './userSlice.jsx'   // 내가 만든 슬라이스를 가져오기
// [1] 스토어 생성하기 : 모든 컴포넌트에서 store 참조하여  store에 저장된 슬라이스를 사용한다.
// configureStore({ reducer : {  상태명1 : 슬라이스명 , 상태명2 : 슬라이스명 } } );
const store = configureStore( { 
    reducer : { 
        // [2] 내가 만든 슬라이스 등록, user 상태에 개발자(사용자저의)가 만든 슬라이스를 대입
        user : userReducer , // 상태명 : 내가만든슬라이스 
        //theme : themeReducer,
    } 
} );
// [3] 스토어를 다른 컴포넌트가 사용할 수있게 export default
export default store;
