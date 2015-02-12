package dan.simplecalc;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import java.util.Vector;


public class HistoryFragment extends Fragment implements ListView.OnItemClickListener {

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        digitEdit.setText(String.valueOf(calculate(historyEntries.get(position))));
        isResultShown=true;
    }

    enum Expression{PLUS, MINUS, DIVIDE, MULTIPLY};

    // TODO: Rename and change types of parameters

    boolean isResultShown = false;
    double memory=0.0;

    EditText digitEdit;
    EditText operatingEdit;
    ListView historyList;

    private Vector<String> historyEntries;
    private ArrayAdapter<String> historyListAdapter;

    // TODO: Rename and change types and number of parameters
    public static HistoryFragment newInstance(String param1, String param2) {
        HistoryFragment fragment = new HistoryFragment();
        return fragment;
    }

    public HistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        digitEdit=(EditText)view.findViewById(R.id.digitEdit);
        operatingEdit=(EditText)view.findViewById(R.id.operatingEdit);
        historyList=(ListView)view.findViewById(R.id.historyList);
        historyEntries=new Vector<String>();
        historyListAdapter=new ArrayAdapter<String>(getActivity(),R.layout.historyrow,historyEntries);
        historyList.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    //functions for external use from the main activity
    public void backSpace(){
        if(!digitEdit.getText().toString().matches("")) {
            String digitString = digitEdit.getText().toString();
            digitString = digitString.substring(0, digitString.length() - 1);
            digitEdit.setText(digitString);
        }
    }

    public void enterDigit(int digit){
        if(isResultShown){
            isResultShown=false;
            digitEdit.setText("");
        }
        digitEdit.append(String.valueOf(digit));
    }

    public void enterDot(){
        digitEdit.append(".");
    }

    public void plus(){
        if(!digitEdit.getText().toString().matches("")){
            operatingEdit.append(digitEdit.getText()+" + ");
            if(!operatingEdit.getText().toString().matches(""))
            {
                digitEdit.setText(String.valueOf(calculate(operatingEdit.getText().toString())));
            }
            isResultShown=true;
        }
    }

    public void minus(){
        if(!digitEdit.getText().toString().matches("")){
            operatingEdit.append(digitEdit.getText()+" - ");
            if(!operatingEdit.getText().toString().matches(""))
            {
                digitEdit.setText(String.valueOf(calculate(operatingEdit.getText().toString())));
            }
            isResultShown=true;
        }
    }

    public void divide(){
        if(!digitEdit.getText().toString().matches("")){
            operatingEdit.append(digitEdit.getText()+" / ");
            if(!operatingEdit.getText().toString().matches(""))
            {
                digitEdit.setText(String.valueOf(calculate(operatingEdit.getText().toString())));
            }
            isResultShown=true;
        }
    }

    public void multiply(){
        if(!digitEdit.getText().toString().matches("")){
            operatingEdit.append(digitEdit.getText()+" * ");
            if(!operatingEdit.getText().toString().matches(""))
            {
                digitEdit.setText(String.valueOf(calculate(operatingEdit.getText().toString())));
            }
            isResultShown=true;
        }
    }

    public void assign(){
        if(!digitEdit.getText().toString().matches("")){
            operatingEdit.append(digitEdit.getText());
            historyListAdapter.add(operatingEdit.getText().toString());
            historyList.setAdapter(historyListAdapter);
            digitEdit.setText(String.valueOf(calculate(operatingEdit.getText().toString())));
            operatingEdit.setText("");
            isResultShown=true;
        }
    }

    public void clear(){
        operatingEdit.setText("");
        digitEdit.setText("");
    }

    public void clearEntry(){
        digitEdit.setText("");
    }

    public void plusMinus(){
        if(!digitEdit.getText().toString().matches("")){
            double value = Double.parseDouble(digitEdit.getText().toString());
            value *= -1;
            digitEdit.setText(String.valueOf(value));
        }
    }

    public void root(){
        double value;
        if(!digitEdit.getText().toString().matches("")){
            value=Double.parseDouble(digitEdit.getText().toString());
            value=Math.sqrt(value);
            digitEdit.setText(String.valueOf(value));
        }
    }

    public void divideOneByX()
    {
        double value;
        if(!digitEdit.getText().toString().matches("")){
            value=Double.parseDouble(digitEdit.getText().toString());
            value=1.0/value;
            digitEdit.setText(String.valueOf(value));
        }
    }

    private double calculate(String expression){
        Expression operation=Expression.PLUS;
        String[] parts=expression.split(" ");
        double result=0.0;
        for(String s : parts){
            if(s.equals("+")){
                operation=Expression.PLUS;
            }else if(s.equals("-")){
                operation=Expression.MINUS;
            }else if(s.equals("/")){
                operation=Expression.DIVIDE;
            }else if(s.equals("*")){
                operation=Expression.MULTIPLY;
            }else{
                if(operation==Expression.PLUS){
                    result+=Double.parseDouble(s);
                }else if(operation==Expression.MINUS){
                    result-=Double.parseDouble(s);
                }else if(operation==Expression.DIVIDE){
                    result/=Double.parseDouble(s);
                }else if(operation==Expression.MULTIPLY){
                    result*=Double.parseDouble(s);
                }
            }
        }

        return result;
    }

    public void memoryClear(){
        memory=0.0;
    }

    public void memoryRead(){
        digitEdit.setText(String.valueOf(memory));
    }

    public void memorySave(){
        if(!digitEdit.getText().toString().matches("")){
            memory=Double.parseDouble(digitEdit.getText().toString());
        }
    }

    public void memoryPlus(){
        if(!digitEdit.getText().toString().matches("")){
            memory+=Double.parseDouble(digitEdit.getText().toString());
        }
    }

    public void memoryMinus(){
        if(!digitEdit.getText().toString().matches("")){
            memory-=Double.parseDouble(digitEdit.getText().toString());
        }
    }

}
