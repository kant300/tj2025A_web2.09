import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './web2/App.jsx'
create.render( <App /> );

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <App />
  </StrictMode>,
)
