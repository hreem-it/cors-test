import logo from './logo.svg';
import './App.css';
import {useState} from "react";

function App() {
    const [response, setResponse] = useState("")

    async function handleCall() {
        let resp = await fetch("http://localhost:8080/hello", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({mock: 'data'}) // Converts JavaScript values to a JSON string
        })
        let respText = await resp.text()
        console.log(respText)
        setResponse(respText)
    }

    return (
        <div className="App">
            <header className="App-header">
                <img src={logo} className="App-logo" alt="logo"/>
                <p>
                    Edit <code>src/App.js</code> and save to reload.
                </p>
                <a
                    className="App-link"
                    onClick={handleCall}
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    Push me
                </a>
                {response}
            </header>
        </div>
    );
}

export default App;
