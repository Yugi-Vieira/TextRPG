import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);
    
    static Player player;
    
    public static boolean isRuning;
    
    //Batalhas aleatorias
    public static String[] encounters = {"Battle", "Battle", "Battle", "Rest", "Rest"};
    
    //Nome dos mobs
    public static String[] enemies = {"Besouro", "Besouro", "Sapo"};
    
    //Lugares da historia
    public static int place = 0, act = 1;
    public static String[] places = {"Portal dos envocadores", "Covil dos Lobos", "Campo das Acoaminas", "Aura Vermelha", "Ninho do Dragao", "Covil do Baron"};
    
    //metodod para ler user imput do console
    public static int readInt(String prompt, int userChoices){
        int input;
        do{
            System.out.println(prompt);
            try{
                input = Integer.parseInt(scanner.next());    
            }catch(Exception e){
                input = -1;
                System.out.println("Insira um valor inteiro!");
            }         
        }while(input < 1 || input > userChoices);
        return input;
    }
    
    // Metodo para limpar tela
    public static void clearConsole(){
        for(int i = 0; i < 80 ; i++)
            System.out.println();
    }
    
    // Metodo para printar um separador com tamanho N
    public static void printSeparator(int n){
        for(int i = 0; i < n ; i ++)
            System.out.print("-");
        System.out.println();
    }
    
    //Metodo para printar um cabecalho
    public static void printHeading(String title){
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }
    
    //metodo para parar o jogo ate o player digitar algo
    public static void anythingToContinue(){
        System.out.println("\n Aperte qualquer botao para continuar...");
        scanner.next();
    }
    
    //Iniciar o jogo
    public static void startGame(){
        boolean nameSet = false;
        String name;
        //print pagina de titulo
        clearConsole();
        printSeparator(30);
        printSeparator(40);
        System.out.println("Bem vindo a Sumoners Rift \n um rpg baseado em texto by Yugi Santos");
        printSeparator(30);
        printSeparator(40);
        anythingToContinue();
        
        //Escolher o nome do player
        do{
            clearConsole();
            printHeading("Qual seu nome?");
            name = scanner.next();
            //pegunta se quer consertar
            clearConsole();
            printHeading("Seu nome e: "+name+". \n Certo?");
            System.out.println("(1) Sim! \n (2) Nao, quero trocar meu nome.");
            int input = readInt("->" , 2);
            if (input == 1)
                nameSet = true;
        }while(!nameSet);
        
        //Printa o comeco da historia
        Story.PrintIntro();
        
        player = new Player(name);
        
        //printa a primeira parte da historia
        Story.PrintFristActIntro();
        
        //is runing passa pra true, pro loop do jogo poder continuar
        isRuning = true;
        
        //comecar loop de novo jogo
        gameLoop();
    }
    
    //metodo que muda os valores do jogo baseado no xp do jogador
    public static void checkAct(){
        //muda o lugar baseado no xp
        if(player.xp >= 10 && act == 1){
            // muda o act e o lugar do jogador
            act = 2;
            place = 1;
            //Lvl Up do jogador
            player.chooseTrait();
            //historia
            Story.PrintWolves();
            //Define os inimigos dessa parte
            enemies[0] = "Lobo Pequeno";
            enemies[1] = "Lobo Pequeno";
            enemies[2] = "Lobo Grande";
            //muda as chances de batalha
            encounters[4] = "Shop";
            //completa a vida
            player.hp = player.maxHp;
        }else if(player.xp >= 50 && act == 2){
            // muda o act e o lugar do jogador
            act = 3;
            place = 2;
            //Lvl Up do jogador
            player.chooseTrait();
            //historia
            Story.PrintRaptors();
             //Define os inimigos dessa parte
            enemies[0] = "Raptor filhote";
            enemies[1] = "Raptor filhote";
            enemies[2] = "raptor Mae";
            player.hp = player.maxHp;
        }else if(player.xp >= 100 && act == 3){
            act = 4;
            place = 3;
            player.chooseTrait();
            Story.PrintRedBuff();
             //Define os inimigos dessa parte
            enemies[0] = "Besouro vermelho";
            enemies[1] = "Besouro Vermelho";
            enemies[2] = "Brumbleback";
            player.hp = player.maxHp;
        }else if(player.xp >= 200 && act == 4){
              act = 5;
            place = 4;
            player.chooseTrait();
            Story.PrintDragon();
             //Define os inimigos dessa parte
            enemies[0] = "Scutle Crab";
            enemies[1] = "Scutle Crab";
            enemies[2] = "Dragao Anciao";
            player.hp = player.maxHp;
        }else if(player.xp >= 350 && act == 5){
             act = 6;
            place = 5;
            player.chooseTrait();
            Story.PrintHerald();
             //Define os inimigos dessa parte
            enemies[0] = "Vastilarva";
            enemies[1] = "Vastilarva";
            enemies[2] = "Arauto do vale";
            player.hp = player.maxHp;
        }else if(player.xp >= 600 && act == 6){
            act = 7;
            place = 6;
            player.chooseTrait();
            Story.PrintBaronNashor();
            player.hp = player.maxHp;
            //chamando a ultima batalha
            finalBattle();
        }
            
    }
    
    // metodo para calcular uma batalha aleatoria
    public static void randomEncounter(){
        // numero aleatorio entre 0 e o tamanho da array de inimigos
        int encounter = (int) (Math.random()* encounters.length);
        //chamando o metodo respectivo
        if (encounters[encounter].equals("Battle")){
            randomBattle();
        }else if(encounters[encounter].equals("Rest")){
            takeRest();
        }else{
            Shop();
        }
    }
    
    //Metodo continuar historio
    public static void continueJourney(){
        //checa se o pornto da historia avancou
        checkAct();
        //checa se a historia nao esta no final
        if(act != 7)
            randomEncounter();
    }
    
    public static void characterInfo(){
        clearConsole();
        printHeading("CHARACTER INFO");
        System.out.println(player.name + "\tHP: "+ player.hp + "/" + player.maxHp);
        printSeparator(20);
        System.out.println("XP: "+ player.xp+ "\tGold: "+player.gold);
        printSeparator(20);
        //numero de pots
        System.out.println("# de pocoes: "+player.pots);
        printSeparator(20);
        
        //printa as skill scolhidas
        if(player.numAtkUpgrades > 0){
            System.out.println("Status ofensivos: " + player.atkUpgrades[player.numAtkUpgrades]);
            printSeparator(20);
        }
        if(player.numDefUpgrades > 0){
            System.out.println("Status defensivos: " + player.defUpgrades[player.numDefUpgrades]);
            printSeparator(20);
        }    
        anythingToContinue();
    }
    
    //Shop / encontrar vendedor
    public static void Shop(){
        clearConsole();
        System.out.println("Voce encontrou um estranho vendedor. \n Ele te oferece algo:");
        int price = (int) (Math.random()* (10 + player.pots*3) + 10 + player.pots);
        System.out.println("- Pocao de Vida: "+price+" ouro.");
        printSeparator(20);
        //pergunta se quer comprar
        System.out.println("Voce quer comprar uma?\n(1) Sim\n(2) Nao, obrigado");
        int input = readInt("-> ", 2);
        //verifica se ele quis comprar
        if(input == 1){
            clearConsole();
            //verifica se player tem gold pra comprar
            if(player.gold >= price){
                player.pots++;
                player.gold -= price;
                System.out.println("Voce comprou uma Pocao de vida por "+price+" de ouro \nTotal de pocoes ["+player.pots+"]");
            }else{
                System.out.println("Voce nao tem ouro suficiente para comprar essa Pocao.");
                anythingToContinue();
            }
        }
    }
    
    //Player descansar e recuperar vida
    public static void takeRest(){
        clearConsole();
        if(player.restsLeft >= 1){
            printHeading("Voce deseja descanar? (" +player.restsLeft+ " Descanso(s) disponiveis)");
            System.out.println("(1) Sim\n(2) Nao agora");
            int input = readInt("-> ",2);
            if(input == 1){//Jogador descansa
                clearConsole();
                if(player.hp < player.maxHp){
                    int HpRestored = (int) (Math.random() * (player.xp/4 + 1) + 10);
                    player.hp += HpRestored;
                    if(player.hp > player.maxHp)
                        player.hp = player.maxHp;
                    System.out.println("Voce descansou, "+HpRestored+" pontos de vida foram restaurados.");
                    System.out.println("Voce esta agora com "+player.hp+"/"+player.maxHp+" de vida");
                    player.restsLeft--;
                }else{
                    System.out.println("Voce esta com a vida cheia e nao precisa descansar agora.");
                    anythingToContinue();
                }
            }
        }else{
            System.out.println("Voce nao tem descansos para usar...");
        }
    }
    
    //Cria uma batalha aleatoria
    public static void randomBattle(){
        clearConsole();
        printHeading("Voce encontrou uma criatura na floresta, voce tera que enfrenta-la");
        anythingToContinue();
        //criar novo inimigo com nome aleatorio
        battle(new Enemy(enemies[(int)(Math.random()*enemies.length)], player.xp));
    }
    
    //o metodo de batalha principal
    public static void battle(Enemy enemy) {
    // Loop da batalha principal
    while (true) {
        clearConsole();
        printHeading(enemy.name + "\nHP: " + enemy.hp + "/" + enemy.maxHp);
        printHeading(player.name + "\nHP: " + player.hp + "/" + player.maxHp);
        System.out.println("Escolha uma acao: ");
        printSeparator(20);
        System.out.println("(1) Lutar\n(2) Usar pocao\n(3) Fugir");
        int input = readInt("-> ", 3);

        // Reagir de acordo com o input
        if (input == 1) { // LUTAR
            // Calcular dano causado e recebido
            int dmg = player.atack() - enemy.defend();
            int dmgTook = enemy.atack() - player.defend();

            // Verificar se o dano nao é negativo
            if (dmgTook < 0) {
                dmg -= dmgTook / 2;
                dmgTook = 0;
            }
            if (dmg < 0) dmg = 0;

            // Aplicar danos
            player.hp -= dmgTook;
            enemy.hp -= dmg;

            // Mostrar as informações desse round
            clearConsole();
            printHeading("Batalha");
            System.out.println("Voce causou " + dmg + " de dano no " + enemy.name + ".");
            printSeparator(15);
            System.out.println("Voce recebeu " + dmgTook + " de dano.");
            anythingToContinue();

            // Verificar se o jogador está vivo
            if (player.hp <= 0) {
                playerDied();
                break;
            } else if (enemy.hp <= 0) {
                // Avisar o player que ele ganhou
                clearConsole();
                System.out.println("Voce derrotou " + enemy.name + "!");
                // Aumenta o XP do player
                player.xp += enemy.xp;
                System.out.println("Voce ganhou " + enemy.xp + " XP!");
                // Drops Aleatorios
                boolean addRest = (Math.random() * 5 + 1 <= 2.25);
                int goldEarned = (int) (Math.random() * enemy.xp);
                if (addRest) {
                    player.restsLeft++;
                    System.out.println("Voce ganhou um descanso!");
                }
                if (goldEarned > 0) {
                    player.gold += goldEarned;
                    System.out.println("Voce recebeu " + goldEarned + " de ouro de " + enemy.name + "!");
                }
                anythingToContinue();
                break;
            }
        } else if (input == 2) { // USAR POC
            clearConsole();
            if (player.pots > 0 && player.hp < player.maxHp) { // Player pode tomar pot
                // Tem certeza?
                printHeading("Voce deseja tomar uma pot de vida? (" + player.pots + " pocoes restantes)");
                System.out.println("(1) Sim\n(2) Nao, talvez depois");
                input = readInt("-> ", 2);
                if (input == 1) { // Player enche a vida tomando a pot
                    player.hp = player.maxHp;
                    player.pots--;
                    clearConsole();
                    System.out.println("Voce tomou uma Pocao de vida. Sua vida foi restaurada para: " + player.maxHp);
                    anythingToContinue();
                }
            } else { // Player nao pode tomar pot
                System.out.println("Voce nao tem pocoes ou esta com a vida cheia.");
                anythingToContinue();
            }
        } else if (input == 3) { // FUGIR
            clearConsole();
            // Verificar se o player está na batalha final
            if (act != 7) {
                // Chance de 40%
                if (Math.random() * 10 + 1 <= 4) {
                    System.out.println("Voce escapou do " + enemy.name);
                    anythingToContinue();
                    break;
                } else {
                    System.out.println("Voce nao conseguiu escapar...");
                    // Calcular o dano que o jogador recebe
                    int dmgTook = enemy.atack() - player.defend();
                    if (dmgTook < 0) dmgTook = 0;
                    player.hp -= dmgTook;
                    System.out.println("Tentando fugir, voce recebeu " + dmgTook + " de dano!");
                    anythingToContinue();
                    // Verifica se o player morreu
                    if (player.hp <= 0) {
                        playerDied();
                        break;
                    }
                }
            } else { // Está na batalha final, não pode fugir
                System.out.println("Nao ha como escapar do Baron de Nashor");
                int dmgTook = enemy.atack() - player.defend();
                if (dmgTook < 0) dmgTook = 0;
                player.hp -= dmgTook;
                System.out.println("Tentando fugir, voce recebeu " + dmgTook + " de dano!");
                anythingToContinue();
                if (player.hp <= 0) {
                    playerDied();
                    break;
                }
            }
        }
    }
}//fim battle1

    //printa o menu 
    public static void printMenu(){
        clearConsole();
        printHeading(places[place]);
        System.out.println("Escolha uma acao: ");
        printSeparator(20);
        System.out.println("(1) Continuar historia");
        System.out.println("(2) Informacoes do personagem");
        System.out.println("(3) Sair do jogo");
    }
    
    //Batalha final (ultima) de todo o jogo
    public static void finalBattle(){
        //criar o boss final com muito XP
        battle(new Enemy("BARAO DE NASHOR", 900));
        //mostra o texto de final
        Story.PrintEnd(player);
        isRuning = false;
    }
    
    //metodo chamado quando o player morre
    public static void playerDied(){
        clearConsole();
        System.out.println("Voce Morreu...");
        System.out.println("Voce acumulou "+player.xp+" XP dessa vez, tente escalar a montanha denovo e juntar mais.");
        System.out.println("Obrigado por jogar meu jogo, espero que tenha gostado :)");
    }
    
    public static void gameLoop(){
        while(isRuning){
            printMenu();
            int input = readInt("->", 3);
            if(input == 1)
                continueJourney();
            else if(input == 2)
                characterInfo();
            else
                isRuning = false;
        }
    }
}
