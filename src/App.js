
import './App.css';
import Players from "./components/Players";
import Teams from "./components/Teams";
import Games from "./components/Games";

function App() {
  return (

      <div>
          <nav>
              <ul>
                  <li><a href="/teams">Teams</a></li>
                  <li><a href="/players">Players</a></li>
                  <li><a href="/games">Games</a></li>
              </ul>
          </nav>

          {/* Content based on URL */}
          {window.location.pathname === '/teams' && <Teams />}
          {window.location.pathname === '/players' && <Players />}
          {window.location.pathname === '/games' && <Games />}
      </div>








  );
}

export default App;
