import { useState } from "react";

export default function Task4( props ){
    // 입력값을 관리할 state
    const [ name, setName ] = useState('');
    const [ phone, setPhone ] = useState('');
    const [ age, setAge ] = useState('');
    
    // 연락처 목록을 저장할 state( 초기값 3명 )
    const [ contacts, setContacts ] = useState( [
        { id : 1, name : "신동엽" , phone : "010-7894-7894" , age : 50 },
        { id : 2, name : "강호동" , phone : "010-4321-4321" , age : 40 },
        { id : 3, name : "유재석" , phone : "010-1234-1234" , age : 30 },
    ] );
    
    // 등록함수
    const createAdd =()=> {
        if( !name || !phone || !age ) {
            alert( "모든 항목을 입력해주세요!" );
            return;
        }

        const newContact ={
            id : Date.now(), // 고유 id
            name,
            phone,
            age : parseInt(age, 10),
        };

        // 새로운 데이터 추가
        setContacts( [...contacts, newContact] );

        // 입력칸 초기화
        setName('');
        setPhone('');
        setAge('');
        };

        // 삭제함수
        const Delete = ( id ) => {
            setContacts( contacts.filter( ( c ) => c.id !== id ) );
        };

        return(
            <div
                style={ {
                    border: "1px solid lightgrey",
                    borderRadius: "10px",
                    padding: "20px",
                    width: "600px",
                } } 
            >
      <h3>전화번호부</h3>

      {/* 입력창 + 등록 버튼 */}
      <input
        placeholder="성명"
        value={name}
        onChange={(e) => setName(e.target.value)}
        style={{ marginRight: "5px", padding: "5px", border: "1px solid lightgrey",
                    borderRadius: "5px" }}
      />
      <input
        placeholder="연락처 (예: 010-1234-5678)"
        value={phone}
        onChange={(e) => setPhone(e.target.value)}
        style={{ marginRight: "5px" , padding: "5px", border: "1px solid lightgrey",
                    borderRadius: "5px" }}
      />
      <input
        placeholder="나이"
        value={age}
        onChange={(e) => setAge(e.target.value)}
        style={{ marginRight: "5px", padding: "5px", border: "1px solid lightgrey",
                    borderRadius: "5px" }}
      />
      <button onClick={createAdd}>등록</button>

      {/* 리스트 출력 (map 사용) */}
      <div style={{ marginTop: "20px" }}>
        {contacts.map((c) => (
          <div
            key={c.id}
            style={{
              marginBottom: "10px",
              padding: "5px 0",
              borderBottom: "1px solid #eee",
            }}
          >
            <b>성명:</b> {c.name}{" "}
            <b>연락처:</b> {c.phone}{" "}
            <b>나이:</b> {c.age}
            <button
              style={{
                color: "red",
                marginLeft: "10px",
                border: "1px solid red",
                borderRadius: "5px",
                padding: "2px 8px",
                cursor: "pointer",
              }}
              onClick={() => Delete(c.id)}
            >
              삭제
            </button>
          </div>
        ))}
      </div>

      {/* 총 인원 수 */}
      <div style={{ marginTop: "10px" }}>총 {contacts.length}명</div>
    </div>
  );
}


    
    
