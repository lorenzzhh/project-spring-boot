import '../App.css';
import {useEffect, useState} from "react";

function Teams() {
    const [teams, setTeams] = useState([]);
    const [team, setTeam] = useState({})
    const [showDetails, setShowDetails] = useState(false)

    useEffect(() => {
        loadTeams()
    }, []);


    function loadTeams() {
        const url = 'http://localhost:8080/api/teams';
        fetch(url)
            .then((response) => {
                if (!response.ok) {
                    throw new Error('Netzwerkantwort war nicht ok');
                }
                return response.json();
            })
            .then((data) => {
                setTeams(data);
            })
            .catch((error) => {
                throw new Error("fehler beim laden")
            });
    }

    function loadOneTeam(id) {
        const url = 'http://localhost:8080/api/teams/' + id;
        fetch(url)
            .then((response) => {
                if (!response.ok) {
                    throw new Error('Netzwerkantwort war nicht ok');
                }
                return response.json();
            })
            .then((data) => {
                setTeam(data)
                setShowDetails(true);
            })
            .catch((error) => {
                throw new Error("fehler beim laden")
            });
    }

    function postTeam() {

    }

    function deleteTeam(id) {
        const url = 'http://localhost:8080/api/teams/' + id;

        fetch(url, {
            method: 'DELETE',
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error('Netzwerkantwort war nicht ok (vielleicht hat es noch spieler im team, welche zuerst gelöscht werden müssen)');
                }
                return response.json();
            })
            .then(() => {
                alert(`Item mit ID ${id} erfolgreich gelöscht.`);
                loadTeams()
            })
            .catch((error) => {
                alert(`Fehler: ${error.message}`);
            });
    }

    function editTeam(id) {

    }


    return (

        <>
            <h1>Teams</h1>


            {showDetails
                ?

                <>
                    <button onClick={() => setShowDetails(false)}>Schliessen</button>
                    <h1>{team.name}</h1>
                    <h2>Spieler</h2>
                    <ul>
                        {team.people.map(player =>
                            <li>{player.name}</li>
                        )}
                    </ul>

                </>
                :
                <table>
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Aktionen</th>
                    </tr>
                    </thead>
                    <tbody>
                    {teams.map((team) => (
                        <tr key={team.id}>
                            <td>{team.name}</td>
                            <td>
                                <button onClick={() => loadOneTeam(team.id)}>Mehr erfahren</button>
                                <button onClick={() => editTeam(team.id)}>Edit</button>
                                <button onClick={() => deleteTeam(team.id)}>Delete</button>
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </table>

            }


        </>


    );
}

export default Teams;