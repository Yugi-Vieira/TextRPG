public class Player extends Character {
    
    // guardar o numero de upgrades em cada skill
        public int numAtkUpgrades, numDefUpgrades;
        
        //status adicionais do jogador
        int gold, restsLeft, pots;
        
        public String[] atkUpgrades = {"Atack Dmg", "Atack Spd", "Critical", "Armor Penetration"};
        public String[] defUpgrades = {"Armadura", "Resistencia Magica", "HP"};
        
        public Player(String name){
            super(name, 100, 0);
            // Setando upgrades pra 0
            this.numAtkUpgrades = 0;
            this.numDefUpgrades = 0;
            //Setando status adicionais
            this.gold = 5;
            this.restsLeft = 1;
            this.pots = 0;
            //deixa o jogador escolher 1 upgrade assim que criar o personagem
            chooseTrait();
        }
    
        @Override
        public int atack() {
            return (int) (Math.random() * (xp/4 + numAtkUpgrades * 3 + 3 ) + xp / 10 + numAtkUpgrades * 2 + numDefUpgrades + 1);
        }
    
        @Override
        public int defend() {
            return (int) (Math.random() * (xp / 4 + numDefUpgrades * 4 + 5) + xp / 8 + numDefUpgrades * 3 + numAtkUpgrades + 2);
        }
        
        public void chooseTrait(){
            GameLogic.clearConsole();
            GameLogic.printHeading ("Choose a trait: "); 
            System.out.println("(1) "  + atkUpgrades [numAtkUpgrades]);
            System.out.println("(2) " + defUpgrades [numDefUpgrades]);
            //le a escolha
            int input = GameLogic.readInt("->", 2);
            
            GameLogic.clearConsole();
            //lidar com as duas classes
            if(input==1){
                GameLogic.printHeading("Voce escolheu: " + atkUpgrades[numAtkUpgrades] + "!" );
                numAtkUpgrades++;
            }else{
                GameLogic.printHeading("Voce escolheu: " + defUpgrades[numDefUpgrades] + "!" );
                numDefUpgrades++;
            }
            GameLogic.anythingToContinue();
        }
    
        
    }
    