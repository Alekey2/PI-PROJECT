import { tocaRaulBackEnd } from "./axios.config";

export class StockService {

    create(newStock) {
        return new Promise((resolve, reject) => {
            console.log(newStock);
            tocaRaulBackEnd.post("/stock", newStock).then(() => resolve()).catch(error => reject(error));
        })
    }

}