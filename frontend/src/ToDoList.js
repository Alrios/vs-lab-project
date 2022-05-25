import { Link } from "react-router-dom/cjs/react-router-dom.min";

const ToDoList = ({ todos, title, deleteHandle }) => {

    const sortedTodos = todos.sort((a, b) => a.priority - b.priority)

    const getColor = (prio) => {
        let color = '';
        if(prio === 1) {
            color = '#e84040';
        } else if (prio === 2) {
            color = 'orange';
        } else if (prio === 3) {
            color = 'lightblue';
        }
        return color;
    }

    return ( 
        <div className="todo-list">
            <h2>{title}</h2>
            {sortedTodos.map((todo) => (
                <div className="todo-preview" key={todo.todo} style={{backgroundColor: getColor(todo.priority)}}>
                    <Link to={`/todos/${todo.todo}`}>
                        <h2>- { todo.todo }</h2>
                        <button className="delBtn" onClick={(e) => deleteHandle(todo.todo, e)}>DONE</button>
                    </Link>
                </div>
            ))}
        </div>
     );
}
 
export default ToDoList;