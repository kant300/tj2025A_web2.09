  const products = [
    { title: "무선 키보드", price: 45000, inStock: true },
    { title: "게이밍 마우스", price: 32000, inStock: false },
    { title: "27인치 모니터", price: 280000, inStock: true }
  ]; 

  // [1] 해당 .jsx 파일내 대표(default) 컴포넌트 만들기
  export default function Task2( props ){
    return(<>
        <div>
            <ul>
                <li> { products[0].title }</li>
                <li> { products[0].price }</li>
                <li> { products[0].inStock == true ? '재고있음' : '재고없음' } </li>
            </ul>
            <ul>
                <li> { products[1].title }</li>
                <li> { products[1].price }</li>
                <li> { products[1].inStock == true ? '재고있음' : '재고없음' } </li>
            </ul>
            <ul>
                <li> { products[2].title }</li>
                <li> { products[2].price }</li>
                <li> { products[2].inStock == true ? '재고있음' : '재고없음' } </li>
            </ul>
        </div>
        </>)
  }

