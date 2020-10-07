var formatter = new Intl.NumberFormat();
console.log(formatter.format(NUMBER));
if (NUMBER > 0) {
    document.write(formatter.format(NUMBER))
}
NUMBER = ""