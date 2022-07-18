function isPrime(num: number): boolean {
    if (num < 2) {
        return false;
    } else {
        for (let i = 2; i < num; i++) {
            if (num % i == 0) {
                return false
            }
        }
        return true;
    }
}

let array: Array<number> = new Array<number>(1000);

for (let i = 0; i < array.length; i++) {
    array[i] = Math.floor(Math.random() * 999);
}
for (let i = 0; i < array.length ; i++) {
    console.log(array[i])
}

for (let number of array) {
    if (isPrime(number)) {
        console.log("Prime: " + number);
    }
}
