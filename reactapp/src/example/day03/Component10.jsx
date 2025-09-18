import { useState } from "react"
import axios from "axios" // 자동완성안되면 작성

// =========== 스프링 서버내 day07(boardservice13) ============
export default function Component10( props ){
    // [1] 입력받은 데이터들을 관리하는 useState
    const [ bcontent, setBcontent ] = useState('')
    const [ bwriter, setBwriter ] = useState("")
    
    // [2] axios 이용하여 스프링 서버에게 등록요청
    const boardWrite = async()=>{
        const obj = { bcontent, bwriter }   // 2-1 : 입력받은 데이터들을 객체화
        const response = await axios.post("http://localhost:8080/board" , obj ) // 2-2 : axios 요청
        console.log(response.data);
        boardPrint();   // 2-3
    }

    // [3] 출력할 데이터들을 관리하는 useState
    const [ boards, setBoards ]= useState( [ { bno : 1, bcontent : 'test', bwriter : 'test' } ] );
    // [4] 출력할 데이터들을 axios 이용하여 스프링에게 요청, -> 2-3에서 실행
    const boardPrint = async()=>{
        // 4-1. axios 요청
        const response = await axios.get("http://localhost:8080/board"); // 스프링과 리액트 서버가 달라서 상대주소 작성해야 함
        // 4-2. axios 요청값을 setState 이용한 재렌더링
        setBoards( response.data );
    }

   


    return(<>
        <h3> 스프링 서버의 boardservice13(day07) 통신 </h3>
        <input value={ bcontent } onChange={ (e)=> { setBcontent(e.target.value) } } />
        <input value={ bwriter } onChange={ (e)=> { setBwriter(e.target.value) } } />
        <button onClick={ boardWrite }> 등록 </button>
        {
            boards.map( (board)=>{
                return <div> { board.bno } { board.bcontent } {board.bwriter } </div>
            })
        }

    </>)
}