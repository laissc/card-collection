package littleCards;

import java.util.Scanner;


public class Carta implements Ator {
    protected String tipo;
    protected String nome;
    protected String cor;
    protected Integer raridade;

    //construtor
    public Carta(String tipo, String nome, String cor, Integer raridade){
        this.tipo = tipo;
        this.nome = nome;
        this.cor = cor;
        this.raridade = raridade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getRaridade() {
        return raridade;
    }

    public void setRaridade(Integer raridade) {
        this.raridade = raridade;
    }

    @Override
    public String toString() {
        return "tipo: " + tipo + "\n" +
                "nome: " + nome + "\n" +
                "cor: " + cor + "\n" +
                "raridade: " + raridade + "\n";
    }


    public void atacar(int ataque, Scanner leitor){
        System.out.println("informe a força do ataque:\n");
        ataque = leitor.nextInt();
        leitor.nextLine();
        System.out.println("criatura " + this.getNome() + " atacando ataque deve tirar:" + ataque + " de vida\n");
    }

    public void defender(int defesa){
        System.out.println("a defesa tem um valor fixo: ");
        defesa = 100;
        System.out.println("criatura " +this.getNome() + " se defendendo\n" +
                "defesa bloqueando " + defesa + " unidades de ataque\n");
    }

    public void textoExplicativo(){
        System.out.println("explicando feitiço " + this.getNome() + "\n" +
                "este feitiço tem um valor fixo de aumento de ataque");
    }

    public void disparar(){
        System.out.println("disparando feitiço " + this.getNome() + "\n" +
                "ataque aumentando em X unidades");
    }

    @Override
    public void agir(Carta cartinha,Scanner leitor, int ataque, int defesa, int vida) {

        if (cartinha.getTipo().equals("criatura")){
            System.out.println("carta tipo -criatura- esta carta sempre ataca");

            atacar(ataque,leitor);
            defender(defesa);

        }
        if (cartinha.getTipo().equals("feitiço")){
            System.out.println("carta tipo -feitiço- esta carta sempre aumenta o ataque em 50");
            textoExplicativo();
            disparar();

        }

        if((!cartinha.getTipo().equals("feitiço")) || (!cartinha.getTipo().equals("criatura"))) {
            System.out.println("voce não é uma criatura e nem um feitiço,\n" +
                    "portanto não tem ações a realizar, só senta e assiste");
        }

    }
}
