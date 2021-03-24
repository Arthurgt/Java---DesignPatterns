package singleton;

public enum GameEngineEnum { //reflection security
    INSTANCE("Player");

    private int hp = 100;
    private String characterName = "";

    private GameEngineEnum(String name) {
        this.characterName = name;
    }

    public void gameLoop() {
        while(true) {

        }
    }
}
