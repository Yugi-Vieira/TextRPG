public class Enemy extends Character {

    //variavel para guardar o xp do player
    int playerXp;
    
    //contrutor especifico do inimigo
    public Enemy(String name, int playerXp) {
        super(name, (int) (Math.random()*playerXp + playerXp/3 + 5), (int)(Math.random()*(playerXp/4 + 2) + 1));
        this.playerXp = playerXp;
    }

    
    //calculo especifico de ataque e defesa
    @Override
    public int atack() {
        return (int) (Math.random() * (playerXp / 4 + 2) + xp / 4 + 4);
    }

    @Override
    public int defend() {
        return (int) (Math.random() * (playerXp / 4 + 2) + xp / 4 + 4);
    }
    
}
