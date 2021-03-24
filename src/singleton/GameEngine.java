package singleton;

public class GameEngine {

    private int hp = 100;
    private String characterName = "";
    private static GameEngine instance;

    private GameEngine(int hp, String characterName){
        this.hp = hp;
        this.characterName = characterName;
    }

    public static GameEngine getInstance() {
        if(instance == null) {
            synchronized (GameEngine.class) { //multithreading security
                if(instance == null) {
                    instance = new GameEngine(100, "Player");
                }
            }
        }
        return instance;
    }

    public void gameLoop() {
        while(true) {

        }
    }

    protected Object readResolve() { //deserialization security
        return getInstance();
    }
}
