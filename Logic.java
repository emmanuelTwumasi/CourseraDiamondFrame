package mooc.vandy.java4android.diamonds.logic;

import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {
        // TODO -- add your code here
        int diamondHeight = (size*+2)+1;
        int diamondWidth = (size*2)+2;
        int count = -(size+1);

        for (int n=1;n<=diamondHeight;n++)//iterate for diamond height
        {
            count++;
            for (int i=1;i<=diamondWidth;i++)//iterate for diamond width
            {
                if (( n==1|| n==diamondHeight)&&(i==1||i==diamondWidth)){
                    mOut.print("+");
                }else if ((n==1||n==diamondHeight)&&!(i==1||i==diamondWidth)){
                    mOut.print("-");
                }else if (!(n==1||n==diamondHeight)&&(i==1||i==diamondWidth)){
                    mOut.print("|");
                }else {
                    diamondShape(size, n, i, count);
                }
            }mOut.print("\n");
        }
    }

    private void diamondShape(int size, int n, int i, int count) {
    int rowDiamond;
    if (count<=0){
        rowDiamond = n*2-2;
    }else {
        rowDiamond = (n-count*2)*2-2;
    }

    int midDiamond =  size + 1;
    int diamondLeftBound =  midDiamond - (rowDiamond/2-1);
    int diamondRightBound =  midDiamond+(rowDiamond/2);
    int topOfFrame = 1;
    int bottomOfFrame = size*2+1;

        if (i >= diamondLeftBound && i <= diamondRightBound) {
            if (i == diamondLeftBound|| i == diamondRightBound) {
                if (n< midDiamond && n > topOfFrame) {
                    if (i == diamondLeftBound) {
                        mOut.print("/");
                    } else {
                        mOut.print("\\");
                    }
                } else if (n == midDiamond) {
                    if (i == diamondLeftBound) {
                        mOut.print("<");
                    } else {
                        mOut.print(">");
                    }
                } else if (n > midDiamond && n < bottomOfFrame) {
                    if (i == diamondLeftBound) {
                        mOut.print("\\");
                    } else {
                        mOut.print("/");
                    }
                }
            } else {
                if (n % 2 == 0) {
                    mOut.print("=");
                } else {
                    mOut.print("-");
                }
            }
        } else {
            mOut.print(" ");
        }
    }

}


