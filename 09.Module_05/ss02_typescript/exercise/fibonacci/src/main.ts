function fibonacci(n: number): number {
    if (n <= 0) {
        return 0;
    } else if (n == 1 || n == 2) {
        return 1;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
}

let sum = 0;
let n: number = 12;
for (let i = 0; i < n; i++) {
    let value: number = fibonacci(i);
    console.log("fibonacci(" + i + ")=" + value);
    sum += value;
}

console.log("Tong cua " + n + " so fibonacci la: " + sum);
