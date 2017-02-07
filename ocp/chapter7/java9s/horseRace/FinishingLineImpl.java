import java.util.Vector;

public class FinishingLineImpl implements FinishingLine {

    Vector<String> Ranking = new Vector<String>(10);

    public FinishingLineImpl(){}
    @Override
    public void arrive(Horse h) {
        // TODO Auto-generated method stub
        Ranking.add(h.getId());
    }

    public void print()
    {
        for (int i = 0; i < 10 ; i++)
        {
            System.out.println("Place " + (i + 1)+ " is : " + Ranking.get(i));
        }
    }
}