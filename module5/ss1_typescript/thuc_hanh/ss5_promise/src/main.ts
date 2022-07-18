
let money = 10000;
const buyACar = (car: any) => {
    return new Promise(((resolve, reject) => {
        setTimeout(() => {
            if (money >= 1000) {
                resolve("can buy " + car);
            } else {
                reject("Do not enough money");
            }
        }, 1000);
    }))
}

money = 100;
const promise = buyACar("Vinfast")
    .then(value => {
        console.log(value)
}, error => {
        console.log(error)
})
