package classes;

public class Bardo extends Combatente {
    public Bardo(String nome, int nivel) {
super(nome, nivel, 80); 
    }
    @Override
    public String atacar(Combatente alvo) {
  int danoSonoro = nivel * 4;
   int curaAliada = nivel * 5;     alvo.defenderEReceberDano(danoSonoro);
  this.setVida(this.getVida() + curaAliada); 
 return nome + " (Bardo) tocou uma canção: causou " + danoSonoro + 
     " de dano e curou " + curaAliada + " PV de si mesmo!";
    }
    @Override
    public void defenderEReceberDano(int danoBruto) {  
 this.vida -= danoBruto;
    }
}