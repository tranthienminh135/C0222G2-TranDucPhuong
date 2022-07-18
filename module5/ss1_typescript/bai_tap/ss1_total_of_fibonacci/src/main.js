function isFibonacci(num) {
    var a = 0;
    var b = 1;
    var c = a + b;
    for (var i = 0; i < num; i++) {
        a = b;
        b = c;
        c = a + b;
        if (c == num) {
            return true;
        }
        else if (c > num) {
            return false;
        }
    }
}
console.log(isFibonacci(4181));
