import { useState } from "react";
import { useHistory } from "react-router-dom/cjs/react-router-dom.min";
import api from './api/todos'

const NewToDo = () => {
    const [text, setText]= useState('');
    const [prio, setPrio]= useState('1');

    const history = useHistory();

    const handleSubmit = async (e) => {
        e.preventDefault();
        const todo = { todo: text, priority: prio };
        try{
            await api.post('/todos', todo);
            history.push('/');
        } catch (err) {
            console.log(`Error: ${err.message}`);
        }
    }

    return ( 
        <div className="create">
            <h2>Add a new ToDo</h2>
            <form onSubmit={ handleSubmit }>
                <label>New ToDo:</label>
                <input
                    type="text"
                    required
                    value={text}
                    onChange={(e) => setText(e.target.value)}
                />
                <label>Priority:</label>
                <select
                    value={prio}
                    onChange={(e) => setPrio(e.target.value)}
                >
                    <option value="1">Top</option>
                    <option value="2">Middle</option>
                    <option value="3">Low</option>
                </select>
                <button>Add ToDo</button> 
            </form>
        </div>
     );
}
 
export default NewToDo;