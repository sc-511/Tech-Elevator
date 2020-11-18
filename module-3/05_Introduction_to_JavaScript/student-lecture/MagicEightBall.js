let userName = 'Shane';

console.log("Welcome to the Magic Eight Ball!");
console.log("Let the Magic Eight ball choose your destiny");

let magicBallValue = 5;
let questionToAsk = "Magic Eight Ball what will my future look like?...";
switch(Math.random() * magicBallValue){
    case 0:
        console.log("It is uncertain....");
        break;
    case 1:
        console.log("You will be very rich..");
        break;
    case 2:
        console.log("You will live a life of unfortuante events..");
        break;
    case 3:
        console.log("You will live a life of happiness...");
        break;
    case 4:
        console.log("A special person will be visiting soon with great news..");
        break;
    case 5:
        console.log("You will be finding yourself with a great amount of success...");
        break;
}
console.log("Thank you for playing!");