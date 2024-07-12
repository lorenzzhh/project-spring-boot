import '../App.css';
import {useEffect, useState} from "react";

function Games() {
    const [games, setGames] = useState([]);


    useEffect(() => {

        const url = 'http://localhost:8080/api/games';

        fetch(url)
            .then((response) => {
                if (!response.ok) {
                    throw new Error('Netzwerkantwort war nicht ok');
                }
                return response.json();
            })
            .then((data) => {
                setGames(data);
            })
            .catch((error) => {
                throw new Error("fehler beim laden")
            });
    }, []);


    return (

        <>
            <h1>Games</h1>


            {games.map(game=>

                <div>{game.name}</div>
            )}

        </>


    );
}

export default Games;