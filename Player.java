
public class Player {
    private String name;
    private Symbol color;

    public Player(String name , Symbol color){
        this.name = name;
        this.color = color;
    }
    public String getName() {
        return this.name;
    }

    public String getSymbol() {
        return this.color.toString();
    }
}
