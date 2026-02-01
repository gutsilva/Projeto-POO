package classes;

public class Necromante extends Combatente {
    public Necromante(String nome, int nivel) {
        super(nome, nivel, 75); 
    }
    @Override
    public String atacar(Combatente alvo) {
        int danoNecrotico = nivel * 12;
        int dreno = danoNecrotico / 2;
        
        alvo.defenderEReceberDano(danoNecrotico);
        this.setVida(this.getVida() + dreno);
        
        return nome + " (Necro) lançou dreno espiritual em " + alvo.getNome() + 
               ": drenou " + dreno + " de vida!";
    }

    @Override
    public void defenderEReceberDano(int danoBruto) {
        
        if (random.nextInt(100) < 10) { 
             System.out.println(nome + " se transformou em névoa e evitou o dano!");
        } else {
            this.vida -= danoBruto;
        }
    }
}