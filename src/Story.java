public class Story {
    
    public static void PrintIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("Historia");
        GameLogic.printSeparator(30);
        System.out.println("Existiam lendas sobre oque havia no topo daquela montanha...");
        System.out.println("Parece que voce foi forte o suficiente para chegar até o topo, mas e apenas o comeco");
        System.out.println("Voce nao tem tempo para pensar no passado, tome cuidado com oque ha pela frente, e nao se perca na floresta");
        GameLogic.anythingToContinue();
    }
    
    public static void PrintFristActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("Parte I - Introducao");
        GameLogic.printSeparator(30);
        System.out.println("No topo dessa montanha voce avista uma floresta, como um labirinto de pedra cheio de vegetacao");
        System.out.println("Voce decide seguir em frente e descobrir oque há a seguir");
        System.out.println("é hora de descobrir o quao verdadeira sao as lendas sobre essa montanha...");
        GameLogic.anythingToContinue();
    }
    
    public static void PrintWolves() {
    GameLogic.clearConsole();
    GameLogic.printSeparator(30);
    System.out.println("Encontro com Lobos");
    GameLogic.printSeparator(30);
    System.out.println("Você avança pela floresta densa e de repente ouve uivos ao longe.");
    System.out.println("Um grupo de lobos aparece em seu caminho, suas presas brilhando à luz da lua.");
    System.out.println("Você precisa estar preparado para enfrentar esses ferozes caçadores da selva.");
    GameLogic.anythingToContinue();
    }
    
    public static void PrintRaptors() {
    GameLogic.clearConsole();
    GameLogic.printSeparator(30);
    System.out.println("Encontro com Acoaminas");
    GameLogic.printSeparator(30);
    System.out.println("Enquanto atravessa um campo aberto, você é cercado por um bando de acoaminas.");
    System.out.println("A principio parecem como galinhas mutantes, mas voce esta prestes a descobrir do que sao capazes");
    System.out.println("Essas criaturas são rápidas e atacam em grupo. Você precisa ser ágil para sobreviver.");
    GameLogic.anythingToContinue();
    }
    
    public static void PrintRedBuff() {
    GameLogic.clearConsole();
    GameLogic.printSeparator(30);
    System.out.println("Encontro com Brumbleback");
    GameLogic.printSeparator(30);
    System.out.println("Você sente o calor antes mesmo de ver a criatura.");
    System.out.println("O Brumbleback, guardião do Red Buff, surge entre as árvores, seu corpo irradiando fogo.");
    System.out.println("Prepare-se para uma batalha ardente que pode fortalecer suas habilidades.");
    GameLogic.anythingToContinue();
    }

    public static void PrintHerald() {
    GameLogic.clearConsole();
    GameLogic.printSeparator(30);
    System.out.println("Encontro com Arauto do Vale");
    GameLogic.printSeparator(30);
    System.out.println("A terra treme sob seus pés enquanto você se aproxima do covil do Arauto do Vale.");
    System.out.println("Esta criatura colossal se ergue diante de você, suas escamas refletindo a luz do sol poente.");
    System.out.println("Uma batalha épica está prestes a começar, e sua vitória poderá mudar o curso da guerra.");
    GameLogic.anythingToContinue();
    }
    
    public static void PrintDragon() {
    GameLogic.clearConsole();
    GameLogic.printSeparator(30);
    System.out.println("Encontro com Dragão");
    GameLogic.printSeparator(30);
    System.out.println("Ao atravessar uma ponte antiga, você sente o ar ficar mais denso e quente.");
    System.out.println("Um rugido ensurdecedor ecoa pelo vale enquanto um dragão colossal aparece.");
    System.out.println("Derrotar essa fera mítica pode conceder-lhe poderes inimagináveis.");
    GameLogic.anythingToContinue();
    }
    
    public static void PrintBaronNashor() {
    GameLogic.clearConsole();
    GameLogic.printSeparator(30);
    System.out.println("Encontro com Baron Nashor");
    GameLogic.printSeparator(30);
    System.out.println("Finalmente, você chega ao covil do Baron Nashor, a criatura mais temida de toda a selva.");
    GameLogic.printSeparator(30);
    System.out.println("Seu corpo gigantesco e tentáculos poderosos representam um desafio mortal.");
    System.out.println("A batalha final está prestes a começar, e a vitória determinará o destino da guerra.");
    GameLogic.anythingToContinue();
    }
    
    public static void PrintEnd(Player player){
    GameLogic.clearConsole();
    GameLogic.printSeparator(30);
    System.out.println("Parabens, "+ player.name +"! Voce derrotou o Baron Nashor e se tornou o mais forte ao pé das nuvens...");
    GameLogic.printSeparator(30);
        System.out.println("Esse jogo foi desenvolvido por Yugi Santos");
        System.out.println("Espero que tenha gostado :)");
    }
    
}
