function fibonacci(n) {
    if (n <= 0) {
        return 0;
    }
    else if (n == 1 || n == 2) {
        return 1;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
}
var sum = 0;
var n = 12;
for (var i = 0; i < n; i++) {
    var value = fibonacci(i);
    console.log("fibonacci(" + i + ")=" + value);
    sum += value;
}
console.log("Tong cua " + n + " so fibonacci la: " + sum);
