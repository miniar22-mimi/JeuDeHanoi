public class Main {
    public static void main(String[] args) {
        GameView view = new GameView();

        // Demander le nom du joueur et le nombre de disques
        String playerName = view.askForPlayerName();
        int numDisks = view.askForNumberOfDisks();
        Player player = new Player(playerName);

        // Créer la logique du jeu
        GameLogic game = new GameLogic(numDisks, player);

        // Lancer le jeu
        while (!game.isGameOver()) {
            game.render();
            int from = view.askForMove();  // Demander un mouvement
            int to = view.askForMove();
            game.moveDisk(from - 1, to - 1);  // -1 car les indices des tours sont 0-based
        }

        // Afficher le message de victoire
        view.displayGameOver();
    }
}
