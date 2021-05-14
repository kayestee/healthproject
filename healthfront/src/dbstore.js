import { useState, useEffect} from "react";
import {Spinner} from "react-bootstrap";

export function GetDBSTore() {
    const [error, setError] = useState(null);
    const  [isLoaded, setIsLoaded] = useState(false);
    const [items, setItems] = useState([]);

    const reqOptions = {
        method: 'GET',
        headers : {'Content-Type': 'application/json'}
    };

    useEffect(() => {
        fetch("http://localhost:8080/healthcheck?format=", reqOptions)
            .then(response => response.json)
            .then((result) => {
                setIsLoaded(true);
                console.log(result)
                setItems(result);
            },
            (error) => {
                setIsLoaded(true);
                setError(error);
            }
            )
    }, [])

    if (error) {
        console.log('items')
        return (<div>Error: {error.message}</div>);
    } else if (!isLoaded) {
        return 'Loading';
    } else {
        console.log('items')
        return items;
    }
}