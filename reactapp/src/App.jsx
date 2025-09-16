import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'

// 함수 == 컴포넌트 == 새로운 마크업 만들기
function App() { // js code start
  const [count, setCount] = useState(0)
  // js code end
  return (
    <>
      <h1> 여기가 최초 렌더링 합니다. </h1>
    </>
  )
}
// 다른 js 파일에서 함수를 import 할수 있도록 export
export default App
