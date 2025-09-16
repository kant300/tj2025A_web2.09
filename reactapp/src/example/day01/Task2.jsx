  const products = [
    { title: "무선 키보드", price: 45000, inStock: true },
    { title: "게이밍 마우스", price: 32000, inStock: false },
    { title: "27인치 모니터", price: 280000, inStock: true }
  ]; 

  // [1] 해당 .jsx 파일내 대표(default) 컴포넌트 만들기
  export default function Task2( props ){
    // InfoCard함수의 매개변수로 아무거나속성명 사용
    return(<>
        <div>
            { /* 하위 컴포넌트 호출과 동시에 props 속성 자료 전달 */}
            <InfoCard 아무거나속성명 = { products[0] } />
            <InfoCard 아무거나속성명 = { products[1] } />
            <InfoCard 아무거나속성명 = { products[2] } /> 

        </div>
        </>)
  }

  // [2] 하위 컴포넌트 : 제품1개당 정보 구성하는 컴포넌트
  function InfoCard( props ){
    return (<>
            <ul>
                <li> { props.아무거나속성명.title }</li>
                <li> { props.아무거나속성명.price.toLocaleString() }</li>
                <li> { props.아무거나속성명.inStock == true ? '재고있음' : '재고없음' } </li>
            </ul>
        </>)
  }


