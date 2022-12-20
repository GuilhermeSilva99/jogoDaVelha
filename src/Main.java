import java.util.Scanner;

public class Main {
    /**
     * Script para se basear durante o desenvolvimento:
     *
     * Repetir até o jogo acabar
     *      imprimir o jogo - ok -
     *      saber qual jogador da vez - ok -
     *      ler jogada
     *      validar a jogada
     *          Se está vazio
     *          Se a posição existe
     *      ver se o jogo acabou
     *          Se alguem ganhou
     *              verificar linhas
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
            System.out.println("Digite a linha:");
            linha = scanner.nextInt();
            System.out.println("Digite a coluna:");
            coluna = scanner.nextInt();
        }




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