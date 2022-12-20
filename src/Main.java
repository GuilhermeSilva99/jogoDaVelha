public class Main {
    /**
     * Script para se basear durante o desenvolvimento:
     *
     * Repetir até o jogo acabar
     *      imprimir o jogo - ok -
     *      saber qual jogador da vez
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
        Character jogador1 = 'O';
        Character jogador2 = 'X';

        Character[][] jogo = new Character[3][3];

        imprimir(jogo);

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