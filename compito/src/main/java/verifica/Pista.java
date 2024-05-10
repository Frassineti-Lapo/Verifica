public class Pista 
{
    private int amici = 8;
    private int ingresso = 2;
    private int kart = 4;
    private int giri = 5;
    Pilota pilota;

    public Pista(int amici, int ingresso, int kart, int giri, Pilota pilota)
    {
        this.amici = amici;
        this.ingresso = ingresso;
        this.kart = kart;
        this.giri = giri;
        this.pilota = pilota;
    }

    public synchronized void entra(String nome) throws InterruptedException
    {      
        while(ingresso != 0)
        {
            System.out.println("Lo spogliatoio e' libero, il pilota: " + nome + "entra");
            ingresso--;
            if(kart != 0)
            {
                System.out.println("La pista e' libera, il kart entra");
                ingresso++;
                kart--;
                giri--;
            }
            else
            {
                System.out.println("La pista e' piena, il kart aspetta");
                wait();
            }
            kart++;
        }      
    }

    public synchronized void esci(String nome)
    {
        if(giri == 0)
        {
            System.out.println("Il pilota: " + nome + "ha completato i giri, esce");
            giri++;
            notify();
        }
    }

}
