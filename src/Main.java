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
     *          Se alguem ganhou - ok -
     *              verificar linhas - ok -
     *              verificar colunas - ok -
     *              verificar diagonais - ok -
     *          Se deu velha - ok -
     *      Se não acabou - ok -
     *          trocar de jogador - ok -
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
        boolean isLinhaInvalida  = true;
        boolean isColunaInvalida  = true;
        String enter = "";

        while (jogoContinua){
            imprimir(jogo);
            System.out.println("Jogador da vez: "+jogadorAtual);
            while(isLinhaInvalida){
                try {
                    System.out.println("Digite a linha:");
                    linha = scanner.nextInt();
                    isLinhaInvalida = false;
                }catch (Exception e){
                    enter = scanner.nextLine();
                    System.out.println("Digite apenas um número");
                }
            }
            isLinhaInvalida = true;

            while (isColunaInvalida) {
                try {
                    System.out.println("Digite a coluna:");
                    coluna = scanner.nextInt();
                    isColunaInvalida = false;
                }catch (Exception e){
                    enter = scanner.nextLine();
                    System.out.println("Digite apenas um número");
                }
            }
            isColunaInvalida = true;
            if (verificarJogada(jogo,linha,coluna)){
                jogo[linha][coluna] = jogadorAtual;
                if(verificarLinhasCompleta(jogo) || verificarColunasCompleta(jogo) || verificarDiagonaisCompleta(jogo)){
                    System.out.println("O jogador "+jogadorAtual+" ganhou o jogo!");
                    imprimir(jogo);
                    jogoContinua = false;
                }else if(verificarDeuVelha(jogo)){
                    imprimir(jogo);
                    System.out.println("O jogo deu velha!");
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

    public static boolean verificarDeuVelha(Character[][] matriz){
        boolean deuVelha = true;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if(matriz[i][j] == null){
                    deuVelha = false;
                }
            }
        }
        return deuVelha;
    }
    public static boolean verificarDiagonaisCompleta(Character[][] matriz){
        boolean diagonalCompleta = true;
        for (int i = 1; i < matriz.length; i++) {
            for (int j = 1; j < matriz.length; j++) {
                if(i == j){
                    if(matriz[0][0] != matriz[i][j] || matriz[0][0] == null){
                        diagonalCompleta = false;
                    }
                }
            }
        }
        if(diagonalCompleta){
            return diagonalCompleta;
        }
        diagonalCompleta = true;
        int contador= 1;
        for (int i = matriz.length-2; i >= 0; i--) {
            for (int j = 1; j < matriz.length; j++) {
                if(contador==j){
                    if(matriz[matriz.length-1][0] != matriz[i][j] || matriz[matriz.length-1][0] == null){
                        diagonalCompleta = false;
                    }
                }
            }
            contador++;
        }
        return diagonalCompleta;
    }



    public static boolean verificarColunasCompleta(Character[][] matriz){
        boolean colunaCompleta = true;
        for (int i = 0; i < matriz.length; i++) {
            colunaCompleta = true;
            for (int j = 1; j < matriz[i].length; j++) {
                //System.out.println("matriz[0]["+i+"] "+matriz[0][i]+" != matriz["+j+"]["+i+"]  " + matriz[j][i]);
                if(matriz[0][i] != matriz[j][i] || matriz[0][i] == null){
                    colunaCompleta = false;
                }
            }
            if(colunaCompleta){
                break;
            }
        }
        return colunaCompleta;
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