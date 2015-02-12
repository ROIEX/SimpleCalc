package dan.simplecalc;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends FragmentActivity implements ButtonFragment.OnButtonFragmentInteractionListener{
    LinearLayout mainLayout;
    HistoryFragment historyFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLayout=(LinearLayout)findViewById(R.id.layout_main);
        historyFragment=(HistoryFragment)getSupportFragmentManager().findFragmentById(R.id.history_fragment);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            mainLayout.setOrientation(LinearLayout.HORIZONTAL);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            mainLayout.setOrientation(LinearLayout.VERTICAL);
        }
    }

    public void onButtonFragmentInteraction(int button){
        switch (button){
            case R.id.button0:
                historyFragment.enterDigit(0);
                break;
            case R.id.button1:
                historyFragment.enterDigit(1);
                break;
            case R.id.button2:
                historyFragment.enterDigit(2);
                break;
            case R.id.button3:
                historyFragment.enterDigit(3);
                break;
            case R.id.button4:
                historyFragment.enterDigit(4);
                break;
            case R.id.button5:
                historyFragment.enterDigit(5);
                break;
            case R.id.button6:
                historyFragment.enterDigit(6);
                break;
            case R.id.button7:
                historyFragment.enterDigit(7);
                break;
            case R.id.button8:
                historyFragment.enterDigit(8);
                break;
            case R.id.button9:
                historyFragment.enterDigit(9);
                break;
            case R.id.buttonDot:
                historyFragment.enterDot();
                break;
            case R.id.buttonPlus:
                historyFragment.plus();
                break;
            case R.id.buttonMinus:
                historyFragment.minus();
                break;
            case R.id.buttonDivide:
                historyFragment.divide();
                break;
            case R.id.buttonMultiply:
                historyFragment.multiply();
                break;
            case R.id.buttonAssign:
                historyFragment.assign();
                break;
            case R.id.buttonClear:
                historyFragment.clear();
                break;
            case R.id.buttonClearEntry:
                historyFragment.clearEntry();
                break;
            case R.id.buttonRoot:
                historyFragment.root();
                break;
            case R.id.buttonOneByX:
                historyFragment.divideOneByX();
                break;
            case R.id.buttonPlusMinus:
                historyFragment.plusMinus();
                break;
            case R.id.buttonBackspace:
                historyFragment.backSpace();
                break;
            case R.id.buttonMemoryClear:
                historyFragment.memoryClear();
                break;
            case R.id.buttonMemoryRead:
                historyFragment.memoryRead();
                break;
            case R.id.buttonMemorySave:
                historyFragment.memorySave();
                break;
            case R.id.buttonMemoryPlus:
                historyFragment.memoryPlus();
                break;
            case R.id.buttonMemoryMinus:
                historyFragment.memoryMinus();
                break;
            default:
        }
    }
}
