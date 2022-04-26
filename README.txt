Hello, I am Gabriel Nance and I have solved the Jr. Coding Challenge
number 21 to the best of my ability. I did so by first importing Maven
because of the recommendation in the problem description, I hadn't used
it before, but I found it very cool and extremely helpful. Before I break
down my thought process for the code, I will briefly describe its operation. 

On start you will see the JSON array from the input file along with a 2x2
matrix of options. It will first as for a payment, please input a number 
here because I took the liberty of assuming that since a vending 
machine can’t receive anything other than money and a button selection that 
my code should work similarly. Next it will prompt you to input a letter and
number based on the 2d array above the input. That selection will reduce 
the total inputted by the user until either the user cancels the transaction, 
or the total reaches $0. As for the design of the program itself like I mentioned I 
used Maven’s simple JSON and that name is fitting it made it quite simple. From line 
36 to 65 I am trying to transition the JSON objects/arrays to a regular 
object because I find those easier to manipulate. I wasn’t sure if I wanted to use
an iterator or a for loop so I kind of did both (To be honest I don’t know 
which your development team would prefer at Argono.) 68 to 116 I am assigning 
the letter number combination to the elements of a two-dimensional array. 
I thought it would be best to assign the label to an object directly rather 
than to its position in the array. Finally, 119 to 156 is the actual transaction. 
Mostly just looping through the array and comparing it to user input.

That’s it, I hope you find this solution satisfactory and thank you for considering me for this position!
 