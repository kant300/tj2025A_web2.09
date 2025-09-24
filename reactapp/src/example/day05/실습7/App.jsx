import { BrowserRouter, Route, Routes } from "react-router-dom";
import HomePage from "./pages/HomePage";
import LoginPage from "./pages/LoginPage";
import ProfilePage from "./pages/ProfilePage";
import Heaeder from "./components/Header";  


// [1] 리액트 라우터 : SPA (Single Page Application) 구현
export default function App(props){
    return(<>
    <BrowserRouter>
        <h3> 루트 페이지 </h3>
        <Heaeder/>
        <Routes>
            <Route path="/" element={ <HomePage/> } />
            <Route path="/login" element={ <LoginPage/> } />
            <Route path="/profile" element={ <ProfilePage/> } />
        </Routes>
    </BrowserRouter>
    </>)
}