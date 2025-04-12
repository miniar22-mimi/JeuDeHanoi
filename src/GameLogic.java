public class GameLogic {
    private Tower[] towers;  // Les 3 tours du jeu
    private int numDisks;    // Nombre de disques
    private Player player;

    public GameLogic(int numDisks, Player player) {
        this.numDisks = numDisks;
        this.player = player;
        this.towers = new Tower[3];

        // Initialisation des 3 tours
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower();
        }
        // Placer les disques sur la première tour (tour 0)
        for (int i = numDisks; i > 0; i--) {
            towers[0].push(new Disk(i));
        }
    }

    // Méthode pour déplacer un disque d'une tour à une autre
    public boolean moveDisk(int from, int to) {
        if (from < 0 || from >= 3 || to < 0 || to >= 3 || from == to) {
            System.out.println("Mouvement invalide !");
            return false;
        }

        Tower source = towers[from];
        Tower destination = towers[to];

        if (source.isEmpty()) {
            System.out.println("La tour source est vide !");
            return false;
        }

        Disk diskToMove = source.pop();
        if (!destination.isEmpty() && destination.peek().getSize() < diskToMove.getSize()) {
            System.out.println("Impossible de déplacer un disque plus grand sur un plus petit !");
            source.push(diskToMove);  // Remet le disque sur la tour source
            return false;
        }

        destination.push(diskToMove);
        return true;
    }

    // Méthode pour vérifier si le jeu est terminé (tous les disques sont sur la dernière tour)
    public boolean isGameOver() {
        return towers[2].getDisks().size() == numDisks;
    }

    // Résoudre le jeu de Hanoï (en mode récursif)
    public void solve(int n, int from, int aux, int to) {
        if (n == 1) {
            moveDisk(from, to);
            return;
        }
        solve(n - 1, from, to, aux);
        moveDisk(from, to);
        solve(n - 1, aux, from, to);
    }

    // Affichage des tours (utile pour la visualisation de l'état)
    public void render() {
        for (int i = 0; i < 3; i++) {
            System.out.print("Tour " + (i + 1) + ": ");
            for (Disk disk : towers[i].getDisks()) {
                System.out.print(disk + " ");
            }
            System.out.println();
        }
    }
}

