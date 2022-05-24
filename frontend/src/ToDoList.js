import { Link } from "react-router-dom/cjs/react-router-dom.min";

const ToDoList = ({ todos, title, deleteHandle }) => {

    const sortedTodos = todos.sort((a, b) => a.priority - b.priority)

    return ( 
        <div className="todo-list">
            <h2>{title}</h2>
            {sortedTodos.map((todo) => (
                <div className="todo-preview" key={todo.todo}>
                    <Link to={`/todos/${todo.todo}`}>
                        <h2>&gt; { todo.todo }</h2>
                        <h2>Priority: { todo.priority }</h2>
                        <button className="delBtn" onClick={() => deleteHandle(todo.todo)}>DONE</button>
                    </Link>
                </div>
            ))}
        </div>
     );
}
 
export default ToDoList;