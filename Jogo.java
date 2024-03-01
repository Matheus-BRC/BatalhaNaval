import java.util.Scanner;

public class Jogo{
    
    Scanner scanner = new Scanner(System.in);
    private int naviosInicial;
    
    public Jogo(){
        setNaviosInicial();
        Tabuleiro tab1 = new Tabuleiro(1, getNaviosInicial());
        Tabuleiro tab2 = new Tabuleiro(2, getNaviosInicial());
        setJogo(tab1, tab2);
    }
    
    private void setNaviosInicial(){
        System.out.print("\nQuantidade de Navios: ");
        this.naviosInicial = scanner.nextInt();
    }
    
    public int getNaviosInicial(){
        return naviosInicial;
    }
    
    private void setJogo(Tabuleiro tab1, Tabuleiro tab2){
        System.out.println("\n JOGO \n");
        do{
            if(tab1.getNaviosAtual() > 0) {
                System.out.println("Jogador 1 acerte o Navio do Jogador 2:");
                setJogada(tab2);
            }
            if(tab2.getNaviosAtual() > 0) {
                System.out.println("Jogador 2 acerte o Navio do Jogador 1:");
                setJogada(tab1);
            }
        }
        while(tab1.getNaviosAtual() > 0 && tab2.getNaviosAtual() > 0);
        if(tab1.getNaviosAtual() == 0) System.out.print("JOGADOR 2 VENCEU!!!");
        else System.out.print("JOGADOR 1 VENCEU!!!");
    }
    
    private int setJogada(Tabuleiro alvo){
        System.out.print("Linha: ");
        int x = scanner.nextInt();
        System.out.print("Coluna: ");
        int y = scanner.nextInt();
        return alvo.deleteNavio(x,y);
    }
}