package id.ilkom.himasif.himasifmobile;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.app.Fragment;
import android.support.v7.content.res.AppCompatResources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.brianr.himasifmobile.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class OtherFragment extends Fragment {
    Button visimisi, tentang_kami, pengurus, aspirasi;

    public OtherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_other, container, false);

        visimisi = (Button)view.findViewById(R.id.visimisi);
        visimisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),VisiMisi.class);
                startActivity(i);
            }
        });
        tentang_kami = (Button)view.findViewById(R.id.tentang_kami);
        tentang_kami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),TentangKami.class);
                startActivity(i);
            }
        });
        pengurus = (Button)view.findViewById(R.id.pengurus);
        pengurus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),PengurusHimasif.class);
                startActivity(i);
            }
        });
        aspirasi = (Button)view.findViewById(R.id.aspirasi);
        aspirasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Aspirasi.class);
                startActivity(i);
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            Drawable drawVisiMisi = AppCompatResources
                    .getDrawable(getActivity(), R.drawable.ic_star_black_24dp);
            Drawable drawTentangKami = AppCompatResources
                    .getDrawable(getActivity(), R.drawable.ic_info_outline_black_24dp);
            Drawable drawPengurus = AppCompatResources
                    .getDrawable(getActivity(), R.drawable.ic_person_black_24dp);
            Drawable drawAspirasi = AppCompatResources
                    .getDrawable(getActivity(), R.drawable.ic_mode_edit_black_24dp);
            visimisi.setCompoundDrawablesWithIntrinsicBounds(null, drawVisiMisi, null, null);
            tentang_kami.setCompoundDrawablesWithIntrinsicBounds(null, drawTentangKami, null, null);
            pengurus.setCompoundDrawablesWithIntrinsicBounds(null, drawPengurus, null, null);
            aspirasi.setCompoundDrawablesWithIntrinsicBounds(null, drawAspirasi, null, null);

        }
        else
        {
            //Safely create our VectorDrawable on pre-L android versions.
            Drawable drawVisiMisi = VectorDrawableCompat
                    .create(getActivity().getResources(), R.drawable.ic_star_black_24dp, null);
            Drawable drawTentangKami = VectorDrawableCompat
                    .create(getActivity().getResources(), R.drawable.ic_info_outline_black_24dp, null);
            Drawable drawPengurus = VectorDrawableCompat
                    .create(getActivity().getResources(), R.drawable.ic_person_black_24dp, null);
            Drawable drawAspirasi = VectorDrawableCompat
                    .create(getActivity().getResources(), R.drawable.ic_mode_edit_black_24dp, null);

            visimisi.setCompoundDrawablesWithIntrinsicBounds(null, drawVisiMisi, null, null);
            tentang_kami.setCompoundDrawablesWithIntrinsicBounds(null, drawTentangKami, null, null);
            pengurus.setCompoundDrawablesWithIntrinsicBounds(null, drawPengurus, null, null);
            aspirasi.setCompoundDrawablesWithIntrinsicBounds(null, drawAspirasi, null, null);
        }
        return view;
    }

}
