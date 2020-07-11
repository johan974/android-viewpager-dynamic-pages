package nl.deholtmans.viewpagerdemo;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class EditorFragment extends Fragment {
    private static final String KEY_POSITION = "position";
    private long pageNumber = -1;

    public enum PAGE_ACTION {CURRENT_PAGE, PREVIOUS_PAGE, NEXT_PAGE}

    static EditorFragment newInstance(int position, long pageNumber) {
        EditorFragment frag = new EditorFragment();
        frag.pageNumber = pageNumber;
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, position);
        frag.setArguments(args);
        return (frag);
    }

    static String getTitle(Context ctxt, long pageNumber) {
        return (String.format(ctxt.getString(R.string.hint), pageNumber));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.editor, container, false);
        EditText editor = (EditText) result.findViewById(R.id.editor);
        //int position = getArguments().getInt(KEY_POSITION, -1);
        editor.setHint(getTitle(getActivity(), pageNumber));
        return (result);
    }
}