import { Link } from 'react-router-dom'

const Navbar = () => {
    return ( 
        <nav className="navbar">
            <h1>
                <Link to="/">ToDo List</Link>
            </h1>
            <div className="links">                
                <Link to="/newtodo">Create new ToDo</Link>
            </div>
        </nav>
     );
}
 
export default Navbar;