package classes;

public class GuardiaoDeFerro extends Combatente {
    private int vigor = 70;
    public GuardiaoDeFerro(String nome, int nivel) { super(nome, nivel, 150); }
    @Override
    public String atacar(Combatente alvo) {
  int dano = nivel * 9;
        alvo.defenderEReceberDano(dano);
 return nome + " atacou com escudo.";
    } 
    @Override
    public void defenderEReceberDano(int danoBruto) {
        if (vigor >= 10 && random.nextInt(100) < 30) {
    vigor -= 10;
    System.out.println(nome + " bloqueou o ataque!");
      } else {
            this.vida -= danoBruto;   }
 }
}