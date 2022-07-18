var money = 10000;
var buyACar = function (car) {
    return new Promise((function (resolve, reject) {
        setTimeout(function () {
            if (money >= 1000) {
                resolve("can buy " + car);
            }
            else {
                reject("Do not enough money");
            }
        }, 1000);
    }));
};
money = 1000000;
var promise = buyACar("Vinfast")
    .then(function (value) {
    console.log(value);
}, function (error) {
    console.log(error);
});
