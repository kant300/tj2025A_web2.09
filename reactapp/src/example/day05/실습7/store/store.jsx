/*
    스토어 :여러개의 상태를 보관하는 저장소, 1개 존재해야 한다
    congigureStore() : 스토어 생성 함수
*/

import { configureStore } from "@reduxjs/toolkit";
import userSlice from "./userSlice.jsx";
// [1] 스토어 만들기
const userStore = configureStore( { 
    reducer : {
        // [2] 내가 만든 슬라이스(상태)를 등록한다. 상태명 : 슬라이스명
        userSlice 
    }
} )
// [3] 다른 컴포넌트에서 스토어 호출할수있도록 export
export default Store;