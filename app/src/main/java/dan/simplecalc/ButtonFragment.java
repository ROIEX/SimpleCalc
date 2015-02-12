package dan.simplecalc;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ButtonFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnButtonFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ButtonFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ButtonFragment newInstance(String param1, String param2) {
        ButtonFragment fragment = new ButtonFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ButtonFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_button, container, false);
        Button button0=(Button)view.findViewById(R.id.button0);
        button0.setOnClickListener(this);

        Button button1=(Button)view.findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2=(Button)view.findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3=(Button)view.findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4=(Button)view.findViewById(R.id.button4);
        button4.setOnClickListener(this);

        Button button5=(Button)view.findViewById(R.id.button5);
        button5.setOnClickListener(this);

        Button button6=(Button)view.findViewById(R.id.button6);
        button6.setOnClickListener(this);

        Button button7=(Button)view.findViewById(R.id.button7);
        button7.setOnClickListener(this);

        Button button8=(Button)view.findViewById(R.id.button8);
        button8.setOnClickListener(this);

        Button button9=(Button)view.findViewById(R.id.button9);
        button9.setOnClickListener(this);

        Button buttonDivide=(Button)view.findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(this);

        Button buttonMultiply=(Button)view.findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(this);

        Button buttonMinus=(Button)view.findViewById(R.id.buttonMinus);
        buttonMinus.setOnClickListener(this);

        Button buttonPlus=(Button)view.findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(this);

        Button buttonAssign=(Button)view.findViewById(R.id.buttonAssign);
        buttonAssign.setOnClickListener(this);

        Button buttonDot=(Button)view.findViewById(R.id.buttonDot);
        buttonDot.setOnClickListener(this);

        Button buttonClearEntry=(Button)view.findViewById(R.id.buttonClearEntry);
        buttonClearEntry.setOnClickListener(this);

        Button buttonClear=(Button)view.findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(this);

        Button buttonBackspace=(Button)view.findViewById(R.id.buttonBackspace);
        buttonBackspace.setOnClickListener(this);

        Button buttonPlusMinus=(Button)view.findViewById(R.id.buttonPlusMinus);
        buttonPlusMinus.setOnClickListener(this);

        Button buttonRoot=(Button)view.findViewById(R.id.buttonRoot);
        buttonRoot.setOnClickListener(this);

        Button buttonOneByX=(Button)view.findViewById(R.id.buttonOneByX);
        buttonOneByX.setOnClickListener(this);

        //memory buttons

        Button buttonMemoryClear=(Button)view.findViewById(R.id.buttonMemoryClear);
        buttonMemoryClear.setOnClickListener(this);

        Button buttonMemoryRead=(Button)view.findViewById(R.id.buttonMemoryRead);
        buttonMemoryRead.setOnClickListener(this);

        Button buttonMemorySave=(Button)view.findViewById(R.id.buttonMemorySave);
        buttonMemorySave.setOnClickListener(this);

        Button buttonMemoryPlus=(Button)view.findViewById(R.id.buttonMemoryPlus);
        buttonMemoryPlus.setOnClickListener(this);

        Button buttonMemoryMinus=(Button)view.findViewById(R.id.buttonMemoryMinus);
        buttonMemoryMinus.setOnClickListener(this);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(int button) {
        if (mListener != null) {
            mListener.onButtonFragmentInteraction(button);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnButtonFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        onButtonPressed(v.getId());
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

    public interface OnButtonFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onButtonFragmentInteraction(int button);
    }

}
