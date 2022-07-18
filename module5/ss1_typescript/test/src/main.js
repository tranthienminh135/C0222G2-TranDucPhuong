function isPrime(num) {
    if (num < 2) {
        return false;
    }
    else {
        for (var i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
var array = new Array(1000);
for (var i = 0; i < array.length; i++) {
    array[i] = Math.floor(Math.random() * 999);
}
for (var i = 0; i < array.length; i++) {
    console.log(array[i]);
}
for (var _i = 0, array_1 = array; _i < array_1.length; _i++) {
    var number = array_1[_i];
    if (isPrime(number)) {
        console.log("Prime: " + number);
    }
}
