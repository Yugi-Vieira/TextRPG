# Sumoners Rift Text-Based RPG

## Descrição

Sumoners Rift é um jogo de RPG baseado em texto desenvolvido por Yugi Santos. O jogo leva os jogadores em uma jornada épica através de diversos atos e locais, enfrentando inimigos, comprando itens, descansando para recuperar saúde e ganhando experiência para subir de nível.

## Funcionalidades Principais

- **História Interativa:** Avance através de diferentes atos e locais, cada um com sua própria narrativa e inimigos únicos.
- **Batalhas Aleatórias:** Enfrente inimigos em batalhas aleatórias, use poções para recuperar saúde ou tente fugir.
- **Sistema de Progressão:** Ganhe XP para subir de nível, escolha traços para melhorar seu personagem e avance na história.
- **Lojas e Descanso:** Encontre vendedores para comprar poções e descanse para recuperar saúde entre as batalhas.
- **Batalha Final:** Enfrente o temível Barão de Nashor na batalha final para completar o jogo.

## Instruções de Execução

1. **Clone o repositório:**
   ```sh
   git clone https://github.com/seu-usuario/sumoners-rift-rpg.git
   cd sumoners-rift-rpg
2. **Compile o Jogo:**
    ```sh
    javac GameLogic.java

3. **Execute o Jogo**
    ```sh
    java GameLogic

## Detalhes do Código

A classe principal do jogo é `GameLogic`, que gerencia a maior parte da lógica do jogo. Aqui estão alguns dos métodos principais:

### Métodos de Inicialização e Interface

- **startGame:** Inicializa o jogo, permitindo ao jogador escolher um nome e iniciando a narrativa.
- **gameLoop:** Loop principal do jogo que exibe o menu e reage às escolhas do jogador.
- **printMenu:** Exibe o menu principal com opções para continuar a história, ver informações do personagem ou sair do jogo.

### Encontros e Batalhas

- **randomEncounter:** Determina encontros aleatórios que podem ser batalhas, descanso ou uma visita à loja.
- **battle:** Gerencia as batalhas entre o jogador e os inimigos.
- **finalBattle:** Enfrenta o boss final do jogo, o Barão de Nashor.
- **randomBattle:** Cria uma batalha aleatória contra inimigos variados.

### Progresso e Acontecimentos

- **checkAct:** Verifica o progresso do jogador e atualiza a história e os inimigos conforme o XP do jogador aumenta.
- **continueJourney:** Continua a jornada do jogador, verificando o progresso e determinando novos encontros.

### Utilitários

- **readInt:** Lê a entrada do usuário e garante que seja um número inteiro válido.
- **clearConsole:** Limpa o console para uma melhor visualização.
- **printSeparator:** Imprime um separador de tamanho especificado.
- **printHeading:** Imprime um cabeçalho formatado.
- **anythingToContinue:** Pausa o jogo até que o jogador pressione uma tecla.
- **characterInfo:** Exibe informações detalhadas sobre o personagem do jogador.

### Mecânicas do Jogo

- **Shop:** Permite ao jogador comprar poções de vida de um vendedor.
- **takeRest:** Permite ao jogador descansar para recuperar vida.

### Tratamento de Eventos

- **playerDied:** Método chamado quando o jogador morre, exibindo uma mensagem de fim de jogo.

## Possíveis Melhorias

- **Adicionar mais atos e inimigos:** Expanda a narrativa e a variedade de inimigos para enriquecer a experiência do jogador.
- **Implementar sistema de habilidades:** Permita que os jogadores escolham e usem habilidades especiais durante as batalhas.
- **Melhorar o sistema de inventário:** Adicione mais itens e equipamentos que os jogadores possam coletar e usar.
- **Adicionar elementos gráficos:** Implementar uma interface gráfica para tornar o jogo mais visualmente atraente.

## Contribuição

Sinta-se à vontade para abrir issues e enviar pull requests para melhorias e correções de bugs.

## Licença

Este projeto é licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

Obrigado por jogar Sumoners Rift! Espero que você tenha uma experiência épica.