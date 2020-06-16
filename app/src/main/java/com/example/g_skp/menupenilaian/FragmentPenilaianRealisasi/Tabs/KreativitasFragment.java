package com.example.g_skp.menupenilaian.FragmentPenilaianRealisasi.Tabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.g_skp.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link KreativitasFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link KreativitasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KreativitasFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kreativitas, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event

}
