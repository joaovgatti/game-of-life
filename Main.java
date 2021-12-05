public class Main {

    public static void main(String[] args) throws InterruptedException {

        final int MAX_ITERATIONS = 500;

        var game = new Game();

        System.out.println("Bem vindo ao jogo da vida.");

        game.SetGridSize();

        game.SetBoard();

        var gameMode = game.SetStartMode();
        if (gameMode == 1) //userInput
        {
            var numberOfInputs = game.GetNumeroDeCasasASelecionar();
            game.SetInitialPoints(numberOfInputs);
            System.out.println("A tabela de inicio definida pelo usuario eh:");
            game.PrintBoard();
        }
        else
        {
            game.PopulateBoardRandom();
            System.out.println("A tabela de inicio iniciada de forma randomico eh:");
            game.PrintBoard();

        }

        System.out.println("Iniciando jogo");

        for(int i =0; i < MAX_ITERATIONS; i++)
        {
            game.play();
            game.PrintBoard();
            Thread.sleep(1000);
        }
    }
}
