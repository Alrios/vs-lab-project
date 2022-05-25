import { useHistory, useParams } from "react-router-dom/cjs/react-router-dom.min";
import api from './api/todos';
import { useState } from "react";

const ToDoDetails = () => {
    const { id } = useParams();
    const history = useHistory();
    const [prio, setPrio]= useState('1');
        
    const handleChange = async (e) => {
        const newTodo = { todo: id, priority: prio };
        e.preventDefault();
        try{
            await api.put('/todos', newTodo);
            history.push('/');
        } catch (err) {
            console.log(`Error: ${err.message}`);
        }    
    }

        return ( 
            <div className="change">
                <h2>Changing priority of "{ id }" </h2>
                <form onSubmit={ handleChange }>
                    <label>Priority:</label>
                    <select
                        value={prio}
                        onChange={(e) => setPrio(e.target.value)}
                    >
                        <option value="1">Top</option>
                        <option value="2">Middle</option>
                        <option value="3">Low</option>
                    </select>
                    <button>Change priority</button> 
                </form>
            </div>
        );
}
 
export default ToDoDetails;