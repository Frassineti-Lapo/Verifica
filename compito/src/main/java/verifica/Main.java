package verifica;

public class Main 
{
    public static void main(String[] args) 
    {
        Pista pista = new Pista();
        for(int i=1; i<=8; i++)
        {
            Pilota p = new Pilota(i, pista);
            p.start();
        }
    }
}