import java.util.Scanner;

public class Main {
    /**
     * Script para se basear durante o desenvolvimento:
     *
     * Repetir até o jogo acabar
     *      imprimir o jogo - ok -
     *      saber qual jogador da vez - ok -
     *      ler jogada - ok -
     *      validar a jogada - ok -
     *          Se está vazio - ok -
     *          Se a posição existe - ok -
     *      ver se o jogo acabou
     *          Se alguem ganhou
     *              verificar linhas - ok -
     *              verificar colunas
     *              verificar diagonais
     *          Se deu velha
     *      Se não acabou
     *          trocar de jogador
     *          
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Character jogador1 = 'O';
        Character jogador2 = 'X';

        Character[][] jogo = new Character[3][3];

        Character jogadorAtual = jogador1;
        int linha = 0;
        int coluna = 0;

        boolean jogoContinua = true;

        while (jogoContinua){
            imprimir(jogo);
            System.out.println("Jogador da vez: "+jogadorAtual);
            System.out.println("Digite a linha:");
            linha = scanner.nextInt();
            System.out.println("Digite a coluna:");
            coluna = scanner.nextInt();

            if (verificarJogada(jogo,linha,coluna)){
                jogo[linha][coluna] = jogadorAtual;
                if(verificarLinhasCompleta(jogo)){
                    System.out.println("O jogador "+jogadorAtual+" ganhou o jogo!");
                    imprimir(jogo);
                    jogoContinua = false;
                }else {
                    //trocar jogador
                    if(jogadorAtual == jogador1){
                        jogadorAtual = jogador2;
                    }else {
                        jogadorAtual = jogador1;
                    }
                }

            }else {
                System.out.println("Jogada inválida! Jogue novamente!");
            }
        }




    }

    public static boolean verificarLinhasCompleta(Character[][] matriz){
        boolean linhaCompleta = true;
        for (int i = 0; i < matriz.length; i++) {
            linhaCompleta = true;
            for (int j = 1; j < matriz[i].length; j++) {
                //System.out.println("matriz["+i+"][0] != matriz["+i+"]["+j+"]  "+matriz[i][j]);
                if(matriz[i][0] != matriz[i][j] || matriz[i][0] == null){
                    linhaCompleta = false;
                }
            }
            if(linhaCompleta){
                break;
            }
        }
        return linhaCompleta;
    }
    public static boolean verificarJogada(Character[][] matriz, int linha, int coluna){
        if(linha >= 0 && linha <= 2 && coluna >= 0 && coluna <= 2){
            if(matriz[linha][coluna] == null){
                return true;
            }
        }
        return  false;
    }
    public static void imprimir(Character[][] matriz){
        System.out.println("#|0|1|2");
        for (int i = 0; i <matriz.length; i++) {
            System.out.print(i+" ");
            for (int j = 0; j < matriz[i].length; j++) {
                if(matriz[i][j] == null){
                    System.out.print("_");
                }else {
                    System.out.print(matriz[i][j]);
                }
                if(j != matriz[i].length -1){
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }
}