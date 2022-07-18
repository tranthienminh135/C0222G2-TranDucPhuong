// function isFibonacci(num: number): boolean {
//     let a: number = 0;
//     let b: number = 1;
//     let c: number = a + b;
//     for (let i = 0; i <= num; i++) {
//         if (num >= 0 && num <= 3) {
//             return true;
//         }
//         a = b;
//         b = c;
//         c = a + b;
//         if (c == num) {
//             return true;
//         } else if (c > num) {
//             return false;
//         }
//     }
// }
//
//
// let array: Array<number> = new Array<number>(100);
//
// for (let i = 0; i < array.length ; i++) {
//     array[i] = Math.floor(Math.random()*999);
// }
//
// for (let number of array) {
//     console.log(number)
//     if (isFibonacci(number)) {
//         console.log("Fibonacci: " + number)
//     }
// }



function isFibonacci(num: number) {
    let a: number = 0;
    let b: number = 1;
    let c: number = a + b;
    let sum:number = c;
    function loop(start: number, end: number, callBack: any): any {
        if (start < end) {
            callBack(start);
            return loop(start + 1, end, callBack);
        }
    }
    loop(0, num, function (index: number) {
        console.log(c)
        sum += c;
        a = b;
        b = c;
        c = a + b;
    })
    console.log("Sum: " + sum);
}
isFibonacci(15)