import java.util.Random;

public class HorseImpl implements Horse,Runnable {

    int _distance;
    String _id;
    FinishingLine _f;

    public HorseImpl(String id, FinishingLine f)
    {
        _id = id;
        _distance = 0;
        _f = f;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        Random rand = new Random();

        int n = rand.nextInt(10) + 1;

        while (_distance < 100)
        {
            try
            {
                Thread.sleep(n);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            _distance += 1;
        }

            _f.arrive(this);
    }

    @Override
    public String getId() {
        // TODO Auto-generated method stud
        return _id;
    }
}

