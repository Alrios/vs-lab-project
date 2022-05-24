import Home from './Home';
import Navbar from './Navbar';
import { BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import NewTodo from './NewToDo';
import NotFound from './NotFound';
import ToDoDetails from './ToDoDetails';

function App() {

  return (
    <Router>
    <div className="App">
      <Navbar />
      <div className="content">
        <Switch>
            <Route exact path="/">
              <Home />
            </Route>
            <Route path="/newtodo">
              <NewTodo />
            </Route>
            <Route path="/todos/:id">
              <ToDoDetails />
            </Route>
            <Route path="*">
              <NotFound />
            </Route>
        </Switch>
      </div>
    </div>
    </Router>
  );
}

export default App;
