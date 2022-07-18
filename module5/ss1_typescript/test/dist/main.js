function isPrime(num) {
    if (num < 2) {
        return false;
    }
    else {
        for (let i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
let arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20];
let array = new Array(100);
for (let i = 0; i < array.length; i++) {
    array[i] = Math.floor(Math.random() * 999);
}
for (let i = 0; i < array.length; i++) {
    console.log(array[i]);
}
for (let number of arr) {
    if (isPrime(number)) {
        console.log(number);
    }
}
//# sourceMappingURL=main.js.map