/* 
Enter your code here. 
Create all the necessary classes and methods as per the requirements. 
*/
// START of your code
import java.util.Scanner;

public class Solution{

	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String className = input.nextLine();
        
        // Checking the implementation of the Position class
        if(className.equals("Position")){
            Position p1 = new Position(input.nextInt(), input.nextInt());
            System.out.println(p1);
            p1.setX(5);
            System.out.println(p1.getX());
            
            Position p2 = new Position(5, 10);
            System.out.println(p1.equals(p2));            
        }
        
        // Checking the implementation of the Map class
        else if(className.equals("Map")){
            try{
                Map map = new Map(input);
                map.print();
                int size = map.getSize();
                System.out.println(size);		
                System.out.println(map.getValueAt(size/2, size/2)); 
            }
            catch(Exception e){}
        }
        
        // Checking the Player interface and the MyPlayer class
        else if(className.equals("Player")){
            Player player = new MyPlayer();
            System.out.println(Player.class.isInterface());  
            System.out.println(player instanceof Player);
            System.out.println(player instanceof MyPlayer);
        }
        
        // Checking the InvalidMapException class
        else if(className.equals("Exception")){
            try{
                throw new InvalidMapException("Some message");
            }
            catch(InvalidMapException e){
                System.out.println(e.getMessage());
            }
        }
        
        // Checking the Game class and all of its components
        else if(className.equals("Game")){
            
            // Initialize player, map, and the game
            Player player = new MyPlayer();
            Game game = null;

            try{
                game = new Game(new Map(input));
            }
            catch(InvalidMapException e){ // custom exception
                System.out.println(e.getMessage());
                System.exit(0);
            }

            game.addPlayer(player);

            // Make the player move based on the commands given in the input
            String moves = input.next();
            char move;
            for(int i=0; i<moves.length(); i++){
                move = moves.charAt(i);
                switch(move){
                    case 'R':
                        player.moveRight();
                        break;
                    case 'L':
                        player.moveLeft();
                        break;
                    case 'U':
                        player.moveUp();
                        break;
                    case 'D':
                        player.moveDown();
                        break;
                }
            }

            // Determine the final position of the player after completing all the moves above
            Position playerPosition = player.getPosition();
            System.out.println("Player final position");
            System.out.println("Row: " + playerPosition.getY());
            System.out.println("Col: " + playerPosition.getX());
        }
	}
}

class Position {
    private int x;
    private int y;
    
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public boolean equals(Position pos) {
        return (pos.x == this.x && pos.y == this. y);   
    }
    
    public String toString() {
        return "(" + getX() + "," + getY() + ")";
    }
}

interface Player {
    public void moveRight();
    public void moveLeft();
    public void moveUp();
    public void moveDown();
    public void setMap(Map map);
    public Position getPosition();
}

class MyPlayer implements Player {
    private Position position = new Position(0, 0);
    private Map map;
    
    public void setMap(Map map) {
        this.map = map;
        this.position = map.getPlayerPos();
    }
    public Position getPosition() {
        return this.position;
    }
    
    public void moveRight() {
        if (this.position.getX()+1 < this.map.getSize()) {
            if (this.map.getValueAt(this.position.getY(), this.position.getX()+1) != '1') {
                this.position.setX(this.position.getX() + 1);
            }
        }
    }
    public void moveLeft() {
        if (this.position.getX()-1 >= 0) {
            if (this.map.getValueAt(this.position.getY(), this.position.getX()-1) != '1') {
                this.position.setX(this.position.getX() - 1);
            }
        }
    }
    public void moveUp() {
        if (this.position.getY()-1 >= 0) {
            if (this.map.getValueAt(this.position.getY()-1, this.position.getX()) != '1') {
                this.position.setY(this.position.getY() - 1);
            }
        }
    }
    public void moveDown() {
        if (this.position.getY()+1 < this.map.getSize()) {
            if (this.map.getValueAt(this.position.getY()+1, this.position.getX()) != '1') {
                this.position.setY(this.position.getY() + 1);
            }
        }
    }
}

class Map {
    private int size = -1;
    private char[][] map;
    private Position playerPos = new Position(0, 0);
    
    public Map(Scanner input) throws InvalidMapException{
        size = input.nextInt();
        
        if (this.size <= 0) {
            throw new InvalidMapException("Map size can not be zero");
        }
        
        map = new char[this.size][this.size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++ ) {
                char mapChar = input.next().charAt(0);
                if (mapChar == '1' || mapChar == '0' || mapChar == 'P') {
                    map[i][j] = mapChar;
                    if (mapChar == 'P') {
                        this.playerPos.setX(j);
                        this.playerPos.setY(i);
                    }
                } else {
                    throw new InvalidMapException("Not enough map elements");
                }
            }
        }
    }
    
    public Position getPlayerPos() {
        return this.playerPos;
    }
    
    public int getSize() {
        return this.size;
    }
    
    public char getValueAt(int x, int y) {
        return this.map[x][y];
    }
    
    public void print() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                System.out.print(this.map[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Game {
    private Map map;
    private Player player;    
    
    public Game(Map map) {
        this.map = map;
    }
    
    public void setMap(Map map) {
        this.map = map;
    }
    
    public void addPlayer(Player player) {
        this.player = player;
        this.player.setMap(this.map);
    }
}

class InvalidMapException extends Exception {
    public InvalidMapException(String s) {
        super(s);
    }
}

// END of your code.

/*
DO NOT MODIFY THIS PART!!!
Input and Output has been done for you.
Various conditions are meant to check individual classes separately.
You still need to implement completely all the necessary classes with their corresponding methods,
but the correctness for each class is checked individually.
In other words, you already get some partial points for implementing some classes completely and correctly, 
even if other classes are complete but still may not work properly.
*/