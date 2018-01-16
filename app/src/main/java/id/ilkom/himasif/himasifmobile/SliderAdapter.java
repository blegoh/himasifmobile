package id.ilkom.himasif.himasifmobile;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.brianr.himasifmobile.R;

/**
 * Created by Brian R on 04/01/2018.
 */

public class SliderAdapter extends PagerAdapter {
    //tes
/*    private int[] image_resources = {
            R.mipmap.eldi,
            R.mipmap.umroh,
            R.mipmap.eva,
            R.mipmap.ivan,
            R.mipmap.ricky,
            R.mipmap.zainul,
            R.mipmap.fahmi,
            R.mipmap.febrian,
            R.mipmap.lynna,
            R.mipmap.wildan,
            R.mipmap.loadhi,
            R.mipmap.aisyah,
            R.mipmap.arisqi,
            R.mipmap.ghalang,
            R.mipmap.gilang,
            R.mipmap.arief,
            R.mipmap.sarah,
            R.mipmap.shinta,
            R.mipmap.hadi,
            R.mipmap.ervian,
            R.mipmap.broto,
            R.mipmap.eka,
            R.mipmap.hamada,
            R.mipmap.yusuf,
            R.mipmap.cahyo,
            R.mipmap.ita,
            R.mipmap.arizha,
            R.mipmap.stan,
            R.mipmap.vigor,
            R.mipmap.brian,
            R.mipmap.tito,
            R.mipmap.wahib,
            R.mipmap.miqdad,
            R.mipmap.meyta


    };*/
    private String[] nama = {
            "M. Noor Dwi Eldianto",
            "Umroh Makhmudah",
            "Eva Wati Asri Mawaddah",
            "Ivan Daviq Yunanta",
            "Ricky Fredynansa Arya P",
            "Zainul Arifin",
            "Fahmi Amrullah",
            "Arif Febrian",
            "Lynna Ayu Mayangsari",
            "Wildan Zainul Faki",
            "Loadhi R Muhardi",
            "Ramadhany Aisyah Rakhim",
            "Arisqi Setyawan",
            "Ghalang Mega Juang",
            "Gilang Hidayatullah",
            "Arief Fujianto",
            "Sarah Tyas Pradipta",
            "Fourriska Mukti N S",
            "Muhammad Hadi Prayitno",
            "Ervian Akbarsyah Mahendra",
            "Bratasena Anggabayu B Y ",
            "Eka Putri Agustini Wulandari",
            "Hamada Ananta Burhanudin",
            "Muhammad Yusuf Auliya",
            "Cahyo Novaliyanto",
            "Ita Sugiharti",
            "Arizha Izzul Ilmi Nisa",
            "Stanislaus Jiwandana P",
            "Ranggi Rexa Vigor S ",
            "Brian Rizqi P D",
            "Anharits Pantito",
            "Wahib Irawan",
            "Miqdad Yanuar Farcha",
            "Tan Meyta Susanto",


    };
    private String[] jabatan = {
            "Ketua",
            "Sekretaris",
            "Bendahara",
            "Kadiv PSDM",
            "Kasubdiv Kaderisasi",
            "Anggota Kaderisasi",
            "Anggota Kaderisasi",
            "Anggota Kaderisasi",
            "Anggota Kaderisasi",
            "Kasubdiv IM",
            "Anggota IM",
            "Anggota IM",
            "Anggota IM",
            "Anggota IM",
            "Kadiv Humas",
            "Anggota Humas",
            "Anggota Humas",
            "Anggota Humas",
            "Anggota Humas",
            "Anggota Humas",
            "Kadiv Litbang",
            "Anggota Litbang",
            "Anggota Litbang",
            "Anggota Litbang",
            "Anggota Litbang",
            "Anggota Litbang",
            "Anggota Litbang",
            "Kadiv Mediatek",
            "Anggota Mediatek",
            "Anggota Mediatek",
            "Anggota Mediatek",
            "Anggota Mediatek",
            "Anggota Mediatek",
            "Anggota Mediatek",
    };
    private Context context;
    private LayoutInflater inflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

   /* @Override
    public int getCount() {
        return image_resources.length;
    }*/

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout) object);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slider, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.slider_image);
       // imageView.setImageResource(image_resources[position]);
        TextView name = (TextView) view.findViewById(R.id.nama);
        name.setText(nama[position]);
        TextView jabat = (TextView) view.findViewById(R.id.jabatan);
        jabat.setText(jabatan[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
