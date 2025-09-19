import axios from "axios"
import { useEffect, useState } from "react"

export default function Task5(){
    // useState
    const [ name, setName ]= useState('');
    const [ phone, setPhone ]= useState('');
    const [ age, setAge ]= useState('');
    const [ members, setMembers ]= useState( [] );
    
    // 전체출력
    const memberPrint = async()=>{
    const response = await axios.get("http://localhost:8080/member");
    setMembers( response.data );
    }; 
    useEffect( ()=>{ memberPrint(); }, [] )

    // 등록버튼 axios 이용하여 스프링 서버에게 등록요청
    const memberWrite=async()=>{
        const obj = { name, phone, age }
        const response = await axios.post("http://localhost:8080/member", obj );

        setName('');
        setPhone('');
        setAge('');

        memberPrint();
    };
    
    // 삭제버튼
    async function memberDelete( deleteNo ) {
        const response = await axios.delete("http://localhost:8080/member?no="+deleteNo);
        const newMembers= members.filter( (member)=>{ return member.no !=deleteNo} )
        setMembers( [...newMembers] );
    };
    
    return(<>
        <h3> 전화번호부 </h3>
        <input placeholder="성명" value={ name } onChange={ (e)=>{ setName(e.target.value) } }/>
        <input placeholder="연락처(예:010-1234-5678" value={ phone } onChange={ (e)=>{ setPhone(e.target.value)} }/>
        <input placeholder="나이" value={ age } onChange={ (e)=>{ setAge(e.target.value) } }/>
        <button onClick={ memberWrite}> 등록 </button>
        {
            members.map( (member)=>{
                return <div>
                    { member.no}{member.name}{member.phone}{member.age}
                        <button onClick={ ()=> { memberDelete(member.no)}}> 삭제 </button>
                    
                </div>
            })
        }
        <div> 총 { members.length } 명 </div>
    </>)
}