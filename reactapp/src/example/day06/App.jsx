import { BrowserRouter } from "react-router-dom";
import Header from "./components/Header";

export default function App( props ){
    return(<>
        <BrowserRouter>    
        <h3> 루트페이지 </h3>
        <Header />
        <Routes>
            
        </Routes>

        </BrowserRouter>
    </>)
}