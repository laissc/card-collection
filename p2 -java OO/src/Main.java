import littleCards.*;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void simular(ArrayList<Carta> maoGaroto, ArrayList<Carta> maoOponente,Scanner leitor, int ataque, int defesa, int vida){


        for (int i = 0; i < maoGaroto.size(); i++ ){
            System.out.println("--carta "+ (i+1) + "do garoto--");
            maoGaroto.get(i).agir(maoGaroto.get(i), leitor, ataque, defesa, vida);
        }
        for (int i = 0; i < maoGaroto.size(); i++ ){
            System.out.println("--carta "+ (i+1) + "do oponente--");
            maoOponente.get(i).agir(maoOponente.get(i), leitor, ataque, defesa, vida);
        }
    }

    public static void comparar(ArrayList<Carta> colecao, ArrayList<Carta> repetidos){
        int repeticoes = 0;
        for (int i = 0; i < colecao.size(); i++) {
            for (int j = 0; j < colecao.size(); j++){
                if (colecao.get(i).getRaridade()==(colecao.get(j).getRaridade()) && colecao.get(i).getTipo()==(colecao.get(j).getTipo())){
                    if (i!=j){
                        repetidos.add(colecao.get(i));
                        repeticoes++;
                    }
                }
            }
        }
        System.out.println("Há " + repeticoes + " repetições de carta na sua coleção\n" +
                "considerando tipo e raridade.\n" +
                "As cartas repetidas são as seguintes:\n");
        imprimirArrayList(repetidos);
        repetidos.clear();


    }

    public static void buscaTipo(ArrayList<Carta> colecao, ArrayList<Carta> pesquisados, String chave, int indice,Scanner leitor, int ataque, int defesa, int vida ){
        for (int i = 0; i < colecao.size(); i++) {
            if (colecao.get(i).getTipo().equals(chave)){
                pesquisados.add(colecao.get(i));
            }
        }
        for (int i = 0; i < pesquisados.size();i++) {
            System.out.println("indice " + (i+1));
            System.out.println(pesquisados.get(i).toString());
        }

        System.out.println("Insira índice da carta que deseja que aja:\n");
        indice = leitor.nextInt();
        leitor.nextLine();

        for (int i = 0; i < pesquisados.size();i++) {
            if ((i + 1) == indice){
                pesquisados.get(i).agir(pesquisados.get(i),leitor, ataque, defesa, vida);
            }
        }
        pesquisados.clear();
    }

    public static void buscaNome(ArrayList<Carta> colecao, ArrayList<Carta> pesquisados, String chave, int indice,Scanner leitor, int ataque, int defesa, int vida ){
        for (int i = 0; i < colecao.size(); i++) {
            if (colecao.get(i).getNome().equals(chave)){
                pesquisados.add(colecao.get(i));
            }
        }
        for (int i = 0; i < pesquisados.size();i++) {
            System.out.println("indice " + (i+1));
            System.out.println(pesquisados.get(i).toString());
        }
        System.out.println("Insira índice da carta que deseja que aja:\n");
        indice = leitor.nextInt();
        leitor.nextLine();

        for (int i = 0; i < pesquisados.size();i++) {
            if ((i + 1) == indice){
                pesquisados.get(i).agir(pesquisados.get(i), leitor, ataque, defesa, vida);
            }
        }
        pesquisados.clear();
    }

    public static void buscaCor(ArrayList<Carta> colecao, ArrayList<Carta> pesquisados, String chave, int indice,Scanner leitor, int ataque, int defesa, int vida  ){
        for (int i = 0; i < colecao.size(); i++) {
            if (colecao.get(i).getCor().equals(chave)){
                pesquisados.add(colecao.get(i));
            }
        }
        for (int i = 0; i < pesquisados.size();i++) {
            System.out.println("indice " + (i+1));
            System.out.println(pesquisados.get(i).toString());
        }
        System.out.println("Insira índice da carta que deseja que aja:\n");
        indice = leitor.nextInt();
        leitor.nextLine();
        for (int i = 0; i < pesquisados.size();i++) {
            if ((i + 1) == indice){
                pesquisados.get(i).agir(pesquisados.get(i), leitor, ataque, defesa, vida);
            }
        }
        pesquisados.clear();
    }

    public static void buscaRaridade(ArrayList<Carta> colecao, ArrayList<Carta> pesquisados, int chave, int indice, Scanner leitor, int ataque, int defesa, int vida  ){
        for (int i = 0; i < colecao.size(); i++) {
            if (colecao.get(i).getRaridade().equals(chave)){
                pesquisados.add(colecao.get(i));
            }
        }

        for (int i = 0; i < pesquisados.size();i++) {
            System.out.println("indice " + (i+1));
            System.out.println(pesquisados.get(i).toString());
        }

        System.out.println("Insira índice da carta que deseja que aja:\n");
        indice = leitor.nextInt();
        leitor.nextLine();

        for (int i = 0; i < pesquisados.size();i++) {
            if ((i + 1) == indice){
                pesquisados.get(i).agir(pesquisados.get(i), leitor, ataque, defesa, vida);
            }
        }

        pesquisados.clear();
    }

    public static void imprimirArrayList(ArrayList<Carta> vetor) {
        for (int i = 0; i < vetor.size(); i++){
            System.out.println("--carta numero " + (i+1) + "--");
            System.out.println(vetor.get(i).toString());
        }

        /*
        for (Carta carta : vetor) {
            System.out.println(carta.toString());
        }
         */
    }

    public static void imprimirMenu(ArrayList<Carta> colecao) {
        if (colecao.size() <= 1){
            System.out.println("Insira o número da operação que deseja realizar: \n" +
                    "1: cadastrar nova carta\n" +
                    "(você terá acesso a mais opções quando tiver\n" +
                    "ao menos duas cadastradas.");

        }else if (colecao.size() >=2 && colecao.size() < 6){
            System.out.println("Insira o número da operação que deseja realizar: \n" +
                    "1: cadastrar nova carta\n" +
                    "2: consultar carta por atributo\n" +
                    "3: verificar repetições\n" +
                    "4: menu de trocas\n" +
                    "0: Sair\n" +
                    "!!! A OPÇÃO TESTAR ESTRATEGIAS SÓ SERÁ\n" +
                    "LIBERADA COM AO MENOS 6 CARTAS NA COLEÇÃO !!!");


        }else{
            System.out.println("Insira o número da operação que deseja realizar: \n" +
                    "1: cadastrar nova carta\n" +
                    "2: consultar carta por atributo\n" +
                    "3: verificar repetições\n" +
                    "4: menu de trocas\n" +
                    "5: teste de estratégias\n" +
                    "0: Sair\n");
        }
    }


    public static void main(String []args){

        Scanner leitor = new Scanner(System.in);

        ArrayList<Carta> colecao = new ArrayList<>();
        ArrayList<Carta> pesquisados = new ArrayList<>();
        ArrayList<Carta> repetidos = new ArrayList<>();
        ArrayList<Carta> maoGaroto = new ArrayList<>();
        ArrayList<Carta> maoOponente = new ArrayList<>();

        String tipo, nome, cor;
        int raridade;
        String chave;
        int chaveInt;
        int indice = 0;
        int ataque = 0, defesa = 0, vida = 0;
        int cartaX, cartaY;



        String opcao;

        do {
            imprimirMenu(colecao);

            opcao = leitor.nextLine();

            switch (Integer.parseInt(opcao)) {

                case 1://cadastrar carta
                    System.out.println("informe qual tipo de carta deseja cadastrar:");
                    System.out.println("1: criatura");
                    System.out.println("2: encantamento");
                    System.out.println("3: feitiço");
                    System.out.println("4: novo tipo");


                    opcao = leitor.nextLine();
                    switch (Integer.parseInt(opcao)) {
                        case 1://cadastrar criatura
                            /////////////////LENDO CARTA///////////////////

                            System.out.println("nome: ");
                            nome = leitor.nextLine();
                            System.out.println("cor: ");
                            cor = leitor.nextLine();
                            System.out.println("raridade: ");
                            raridade = leitor.nextInt();
                            leitor.nextLine();

                            /////////////////LENDO CARTA///////////////////

                            Carta criatura = new Carta("criatura", nome, cor, raridade);

                            colecao.add(criatura);

                            System.out.println("VETOR COLEÇÃO: ");
                            imprimirArrayList(colecao);


                            break;
                        case 2://cadastrar encantamento
                            /////////////////LENDO CARTA///////////////////

                            System.out.println("nome: ");
                            nome = leitor.nextLine();
                            System.out.println("cor: ");
                            cor = leitor.nextLine();
                            System.out.println("raridade: ");
                            raridade = leitor.nextInt();
                            leitor.nextLine();

                            /////////////////LENDO CARTA///////////////////

                            Carta encantamento = new Carta("encantamento", nome, cor, raridade);

                            colecao.add(encantamento);

                            System.out.println("VETOR COLEÇÃO: ");
                            imprimirArrayList(colecao);

                            break;
                        case 3://cadastrar feitico
                            /////////////////LENDO CARTA///////////////////
                            System.out.println("nome: ");
                            nome = leitor.nextLine();
                            System.out.println("cor: ");
                            cor = leitor.nextLine();
                            System.out.println("raridade: ");
                            raridade = leitor.nextInt();
                            leitor.nextLine();

                            /////////////////LENDO CARTA///////////////////

                            Carta feitico = new Carta("feitiço", nome, cor, raridade);

                            colecao.add(feitico);

                            System.out.println("VETOR COLEÇÃO: ");
                            imprimirArrayList(colecao);

                            break;
                        case 4://cadastrar novo tipo de carta
                            /////////////////LENDO CARTA///////////////////
                            System.out.println("tipo: ");
                            tipo = leitor.nextLine();
                            System.out.println("nome: ");
                            nome = leitor.nextLine();
                            System.out.println("cor: ");
                            cor = leitor.nextLine();
                            System.out.println("raridade: ");
                            raridade = leitor.nextInt();
                            leitor.nextLine();
                            /////////////////LENDO CARTA//////////////////

                            Carta nova = new Carta (tipo, nome, cor, raridade);

                            colecao.add(nova);

                            System.out.println("VETOR COLEÇÃO: ");
                            imprimirArrayList(colecao);

                            break;
                        case 0: //voltar
                            break;
                        default:
                            System.out.println("Opção invalida. Tente novamente\n");

                    }
                    break;

                case 2://consultar por atributo

                    if (colecao.size() == 0){
                        System.out.println("você ainda nao tem cartas\n" +
                                "cadastre uma carta para depois fazer consultas\n");
                    }else {
                        System.out.println("Qual atributo gostaria de buscar: \n" +
                                "1.tipo \t\t 2.nome \t\t 3.cor \t\t 4.raridade");

                        opcao = leitor.nextLine();
                        switch (Integer.parseInt(opcao)) {
                            case 1://busca por tipo
                                System.out.println("insira chave de tipo:");

                                chave = leitor.nextLine();

                                buscaTipo(colecao, pesquisados, chave, indice, leitor, ataque, defesa, vida);

                                break;
                            case 2://busca por nome
                                System.out.println("insira chave de nome:");

                                chave = leitor.nextLine();
                                buscaNome(colecao, pesquisados, chave, indice, leitor, ataque, defesa, vida );

                                break;
                            case 3://busca por cor
                                System.out.println("insira chave de cor:");

                                chave = leitor.nextLine();
                                buscaCor(colecao, pesquisados, chave, indice, leitor, ataque, defesa, vida);

                                break;
                            case 4://busca por raridade
                                System.out.println("insira chave de raridade:");

                                chaveInt = leitor.nextInt();
                                leitor.nextLine();
                                buscaRaridade(colecao, pesquisados, chaveInt, indice, leitor, ataque, defesa, vida);
                                break;
                            default:
                                System.out.println("opção inválida - tente novamente");
                                break;

                        }
                    }
                    break;
                case 3://verificar repetição de cartas
                    comparar(colecao, repetidos);
                    break;
                case 4://menu de trocas

                    do {
                        System.out.println("VETOR COLECAO");
                        imprimirArrayList(colecao);
                        System.out.println("A carta X deve equivaler a duas cartas Y\n");
                        System.out.println("informe a carta X inserindo o número dela\n");
                        cartaX = leitor.nextInt();
                        leitor.nextLine();

                        System.out.println("informe a carta Y inserindo o número dela\n");
                        cartaY = leitor.nextInt();
                        leitor.nextLine();

                        for (int i = 0; i < colecao.size(); i++) {
                            if ((i + 1) == cartaX) {
                                System.out.println("A carta X:\n");
                                System.out.println(colecao.get((i)).toString());
                            }
                        }

                        for (int i = 0; i < colecao.size(); i++) {
                            if ((i + 1) == cartaY) {
                                System.out.println("Equivale a duas vezes a carta Y:\n");
                                System.out.println(colecao.get((i)).toString());
                            }
                        }
                        if (cartaX == cartaY){
                            System.out.println("voce informou a mesma carta para X e Y\n" +
                                    "tente novamente\n");
                        }
                    }while (cartaX == cartaY);

                    break;

                case 5://teste de estratégias
                    System.out.println("VETOR COLEÇÃO: ");
                    imprimirArrayList(colecao);
                    System.out.println("selecionar mão do jogador 1 (garoto)\n" +
                            "informando os números das cartas na colecao");

                    int carta1, carta2, carta3;

                    ///////////////SELECIONANDO PRIMEIRA MÃO///////////////

                    System.out.println("primeira carta: \n");
                    carta1 = leitor.nextInt();
                    leitor.nextLine();
                    for (int i = 0; i < colecao.size(); i++){
                        if (i == (carta1-1)) {
                            maoGaroto.add(colecao.get(i));
                            colecao.remove(colecao.get(i));
                        }
                    }
                    System.out.println("VETOR COLEÇÃO: ");
                    imprimirArrayList(colecao);
                    System.out.println("fique atento, após a retirada da carta anterior\n" +
                            "as remanescentes se reposicionaram");
                    System.out.println("segunda carta:\n");
                    carta2 = leitor.nextInt();
                    leitor.nextLine();
                    for (int i = 0; i < colecao.size(); i++){
                        if (i == (carta2-1)) {
                            maoGaroto.add(colecao.get(i));
                            colecao.remove(colecao.get(i));
                        }
                    }
                    System.out.println("VETOR COLEÇÃO: ");
                    imprimirArrayList(colecao);
                    System.out.println("fique atento, após a retirada da carta anterior\n" +
                            "as remanescentes se reposicionaram");
                    System.out.println("terceira carta:\n");
                    carta3 = leitor.nextInt();
                    leitor.nextLine();
                    for (int i = 0; i < colecao.size(); i++){
                        if (i == (carta3-1)) {
                            maoGaroto.add(colecao.get(i));
                            colecao.remove(colecao.get(i));
                        }
                    }

                    System.out.println("estas são as cartas selecionadas\n" +
                            "para o jogador 1 (garoto)\n");
                    imprimirArrayList(maoGaroto);

                    ///////////////SELECIONANDO SEGUNDA MÃO///////////////
                    System.out.println("VETOR COLEÇÃO: ");
                    imprimirArrayList(colecao);
                    System.out.println("selecionar mão do jogador 2 (oponente)\n" +
                            "informando os números das cartas na colecao");

                    System.out.println("primeira carta:\n");
                    carta1 = leitor.nextInt();
                    leitor.nextLine();
                    for (int i = 0; i < colecao.size(); i++){
                        if (i == (carta1-1)) {
                            maoOponente.add(colecao.get(i));
                            colecao.remove(colecao.get(i));
                        }
                    }
                    System.out.println("VETOR COLEÇÃO: ");
                    imprimirArrayList(colecao);

                    System.out.println("fique atento, após a retirada da carta anterior\n" +
                            "as remanescentes se reposicionaram");
                    System.out.println("segunda carta:\n");
                    carta2 = leitor.nextInt();
                    leitor.nextLine();
                    for (int i = 0; i < colecao.size(); i++){
                        if (i == (carta2-1)) {
                            maoOponente.add(colecao.get(i));
                            colecao.remove(colecao.get(i));
                        }
                    }
                    System.out.println("VETOR COLEÇÃO: ");
                    imprimirArrayList(colecao);

                    System.out.println("fique atento, após a retirada da carta anterior\n" +
                            "as remanescentes se reposicionaram");
                    System.out.println("terceira carta:\n");
                    carta3 = leitor.nextInt();
                    leitor.nextLine();
                    for (int i = 0; i < colecao.size(); i++){
                        if (i == (carta3-1)) {
                            maoOponente.add(colecao.get(i));
                            colecao.remove(colecao.get(i));
                        }
                    }

                    System.out.println("estas são as cartas selecionadas\n" +
                            "para o jogador 2 (oponente)\n");
                    imprimirArrayList(maoOponente);

                    simular(maoGaroto, maoOponente,leitor,ataque,defesa,vida);



                    break;
                case 0://sair
                    break;
                default:
                    System.out.println("Opção invalida. Tente novamente");
            }
        }while (!opcao.equals("0"));
    }
}
