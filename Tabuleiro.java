import java.util.Scanner;

public class Tabuleiro{
    
    Scanner scanner = new Scanner(System.in);
    private boolean[][] matriz;
    private int jogador;
    private int navios;
    
    public Tabuleiro(int jogador, int navios){
        setJogador(jogador);
        setNaviosAtual(navios);
        setMatriz();
        setTabuleiro();
    }
    
    private void setJogador(int jogador){
        this.jogador = jogador;
    }
    
    public int getJogador(){
        return jogador;
    }
    
    private void setNaviosAtual(int navios){
        this.navios = navios;
    }
    
    public int getNaviosAtual(){
        return navios;
    }
    
    private void setMatriz(){
        this.matriz = new boolean[7][10];
    }
    
    private void setTabuleiro(){
        System.out.println("\nJogador " + getJogador() + ": Posicione seus Navios");
        for(int i=1; i<=navios; i++){
            System.out.println("\nNavio " + i + ":");
            System.out.print("Linha: ");
            int x = scanner.nextInt();
            System.out.print("Coluna: ");
            int y = scanner.nextInt();
            if(!matriz [x][y]){
                matriz [x][y] = true;
                System.out.println("Navio [" + x + "][" + y + "] Posicionado");
            }
            else{
                i--;
                System.out.print("\nNavio já posicionado, coloque outro Navio!\n");
            }
        }
    }
    
    public int deleteNavio(int x, int y){
        if(matriz[x][y]) {
            System.out.println("\nPosição [" + x + "][" + y + "] = BOOOM!!! Navio Abatido!\n");
            matriz [x][y] = false;
            return navios--;
        }
        else {
            System.out.println("\nPosição [" + x + "][" + y + "] = TIBUM!!! Tiro na (água)!\n");
            return navios;
        }
    }
}