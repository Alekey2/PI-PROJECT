import axios from "axios";

const tocaRaulBackEnd = axios.create({
    baseURL: "https://localhost:1010", 
});

export { tocaRaulBackEnd };
