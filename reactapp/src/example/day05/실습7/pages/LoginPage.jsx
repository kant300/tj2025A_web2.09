
export default function LoginPage(props){
    // 1. 로그인 처리 함수 정의 : axios 생략
    const onLogin = asyne()=>{
        alert('[로그인 성공]');
    const { isAuthenticated } = useSelector( (state)=> state.user );
    console.log( isAuthenticated )

    // const dispatch = useDispatch();

    
    
    return(<>
        <h3> 로그인 페이지 </h3>    
    </>)
}