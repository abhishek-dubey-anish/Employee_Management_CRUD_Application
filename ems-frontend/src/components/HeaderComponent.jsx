import React from 'react'
import { useNavigate } from 'react-router-dom'

const HeaderComponent = () => {

  const navigator = useNavigate();

  return (
    <div>
        <header>
            <nav className='navbar navbar-dark bg-dark'>
                <div className="container-md">
                    <a className="navbar-brand" onClick={()=>navigator("/employees")}>Employee Management System</a>
                </div>
            </nav>
        </header>
    </div>
  )
}

export default HeaderComponent