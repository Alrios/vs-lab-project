import ToDoList from "./ToDoList";
import api from './api/todos'
import { useEffect, useState } from "react";

const Home = () => {
    const [todos, setTodos] = useState([]);

    useEffect(() => {
        const fetchTodos = async () => {
            try{
                const response = await api.get('/todos');                
                setTodos(response.data);
            } catch (err){
                if(err.response){
                    console.log(err.response.data.message);
                    console.log(err.response.status);
                    console.log(err.response.headers);
                } else{
                    console.log(`Error: $(err.message)`);
                }
            }
        }

        fetchTodos();
    }, [])

    const deleteHandle = async (id) => {                         
        try{
            await api.delete('/todos/' + id);
            const newTodos = todos.filter(todo => todo.todo !== id);
            setTodos(newTodos);
        } catch {
            console.log(`Error: $(err.message)`);
        }
    }

    return ( 
        <div className="home">
            { todos && <ToDoList todos={ todos } title="Today's ToDos" deleteHandle={ deleteHandle }/> }
        </div>
     );
}
 
export default Home;