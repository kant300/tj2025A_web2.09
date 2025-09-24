
export default function LoginPage(props){
    const { isAuthenticated } = useSelector( (state)=> state.user );
    console.log( isAuthenticated )

    // const dispatch = useDispatch();

    
    
    return(<>
        <h3> 로그인 페이지 </h3>    
    </>)
}