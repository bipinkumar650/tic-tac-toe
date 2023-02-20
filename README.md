#Problem Statement 
problem statement source: [workat@tech](https://workat.tech/machine-coding/practice/design-tic-tac-toe-smyfi9x064ry)  
Let's look at the game of Tic Tac Toe. Tic Tac Toe is a two-player strategy game played on a 3*3 grid. There are 9 empty cells and 9 pieces - 5 pieces of 'X' and 4 pieces of 'O'

The game starts with an empty grid.

##Rules of the game
* The game is played between two players. One player owns the X pieces and can put it on any of the empty cells in the grid. The other player owns the O pieces and can in any of the empty cells.
* The player with X makes the first turn. Each player plays alternately after that.
* The first player to form a horizontal/vertical/diagonal sequence wins.
##Requirements
Create a command-line application for tic tac toe with the following requirements:  

* Ask the user for the names of the two players and piece assigned(eg: Bipin X)
* Print the grid after initializing  
  * Allow the user to make moves on behalf of both the players.  
  * The user will make a move by entering the cell position.  
  * You need to determine the piece (X/O) and make the move if it is valid.  
  * Valid move:  
    * The piece is controlled by the player having the current turn  
    * The cell is empty  
  * If the move is invalid  
    * print 'Invalid Move'  
    * the same player plays again  
  * If the move is valid:  
    * put the piece on the cell  
    * print the board after the move  
* Determine if a player has won or if there are no valid moves left. Ignore all moves mentioned after that.  
A position in the cell is represented by two values: row number (1-3) and column number (1-3).

##Examples  
3 1 represents the cell at the extreme bottom-left (3rd row, 1st column)  
1 3 represents the cell at the extreme top-right (1st row, 3rd column)  
##Input/Output Format  
The code should strictly follow the input/output format and will be tested with provided test cases.  

####Input Format  
Multiple lines with each line containing the Cell Position. The row and column numbers will be separated by a space.  
Stop taking the input when you encounter the word exit.  

####Output Format  
Print the initial grid. This would be followed by the grid after each move. In case of an invalid move, do not print the grid and instead print:  

####Invalid Move  
The board needs to be printed in the following format based on the respective position:  
```
X X O   
- - X  
O O - 
```
 
Here,  
X and O represent the different pieces. An empty cell is represented by a hyphen (-).  
The initial position of the board would be  
```
- - -
- - -
- - -
```
If the player wins after a move, print: 'Player_Name won the game'  
If there are no valid moves left for any player, print 'Game Over'  
#### Simulation
```
Provide the board size
3
Provide number of players
2
Provide detail for player1
Bipin X
Provide detail for player2
Titu O
- - - 
- - - 
- - - 
Bipin's turn
3 2
- - - 
- - - 
- X - 
Titu's turn
1 2
- O - 
- - - 
- X - 
Bipin's turn
3 1
- O - 
- - - 
X X - 
Titu's turn
3 3
- O - 
- - - 
X X O 
Bipin's turn
1 1
X O - 
- - - 
X X O 
Titu's turn
2 1
X O - 
O - - 
X X O 
Bipin's turn
2 3
X O - 
O - X 
X X O 
Titu's turn
1 3
X O O 
O - X 
X X O 
Game over
X O O 
O - X 
X X O 
```
