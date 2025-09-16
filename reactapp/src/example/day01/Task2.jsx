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
            <InfoCard product = { products[0] } />
            <InfoCard product = { products[1] } />
            <InfoCard product = { products[2] } /> 

        </div>
        </>)
  }

  // [2] 하위 컴포넌트 : 제품1개당 정보 구성하는 컴포넌트
  function InfoCard( props ){
    // 구문분해, props 현재상태 : { product : { title, price, inStock } }
    const { title, price, inStock } = props.product
    return (<>
            <ul>
                <li> { title }</li>
                <li> { price.toLocaleString() }</li>
                <li> { inStock == true ? '재고있음' : '재고없음' } </li>
            </ul>
        </>)
  }


