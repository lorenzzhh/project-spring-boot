import '../App.css';
import {useEffect, useState} from "react";

function Players() {
    const [players, setPlayers] = useState([]);


    useEffect(() => {

        const url = 'http://localhost:8080/api/people';

        fetch(url)
            .then((response) => {
                if (!response.ok) {
                    throw new Error('Netzwerkantwort war nicht ok');
                }
                return response.json();
            })
            .then((data) => {
                setPlayers(data);
            })
            .catch((error) => {
                throw new Error("fehler beim laden")
            });
    }, []);



    function deleteEntry(id) {
        const url = 'http://localhost:8080/api/people/' + id;

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
            })
            .catch((error) => {
                alert(`Fehler: ${error.message}`);
            });
    }





    return (

        <>
            <h1>Players</h1>


            {players.map(player=>


                <div>
                    <div>{player.name}</div>
                    <button onClick={() => deleteEntry(player.id)}>Delete</button>
                </div>
            )}

        </>


    );
}

export default Players;