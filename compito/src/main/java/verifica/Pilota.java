public class Pilota extends Thread
{
    private String nome;
    private Pista pista;

    public Pilota(String nome, Pista pista)
    {
        this.nome = nome;
        this.pista = pista;
    }

    @Override
    public void run()
    {
        try
        {
            Pilota p = pista.entra(); 
            while(ingresso != 0)
            {
                System.out.println("Lo spogliatoio e' libero, il pilota: " + nome + "entra");
                if(kart != 0)
                {
                    System.out.println("La pista e' libera, il kart entra");
                }
                else
                {
                    System.out.println("La pista e' piena, il kart aspetta");
                    sleep(2000);
                }
            }

            Pilota p = pista.esci();

        } catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        
    }

}

