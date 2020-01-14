package com.example.babauactivity.fragment;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.babauactivity.activity.CamnangActivity;
import com.example.babauactivity.activity.CannangActivity;
import com.example.babauactivity.activity.CookingActivity;
import com.example.babauactivity.activity.HoatDongActivity;
import com.example.babauactivity.activity.MainActivity;
import com.example.babauactivity.activity.QuatationActivity;
import com.example.babauactivity.activity.ShopActivity;
import com.example.babauactivity.activity.StoryActivity;
import com.example.babauactivity.activity.ThucphamActivity;
import com.example.babauactivity.model.DataPopcorm;
import com.example.babauactivity.R;
import com.example.babauactivity.adapter.PopcormAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentPopcorm extends Fragment implements PopcormAdapter.ItemClick {
    LinearLayout appplus_CHplay,appplus_chrome,appplus_trinhduyet,comunityFB,comunityTD;
    boolean clickFirstCH = true;
    boolean clickFirstChrome = true;
    boolean clickFirstCHTrinhduyet = true;

    boolean clickFirstcomunityfb = true;
    boolean clickFirstcomunitytd = true;
    Button btnAppplus_always, btnAppplus_one,btnComuAlwayl,btnComuOne;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pop_corm, container, false);



        RecyclerView recyclerViewPopcorm = view.findViewById(R.id.recycler_popcorm);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerViewPopcorm.setLayoutManager(gridLayoutManager);

        ArrayList<DataPopcorm> dataPopcorm = new ArrayList<>();
        dataPopcorm.add(new DataPopcorm(R.drawable.ic_babyweight, "Kể truyện cho bé"));
        dataPopcorm.add(new DataPopcorm(R.drawable.ic_babyweight, "Danh ngôn mẹ"));
        dataPopcorm.add(new DataPopcorm(R.drawable.ic_babyweight, "Fanpage bà bâu"));
        dataPopcorm.add(new DataPopcorm(R.drawable.ic_babyweight, "Cộng đồng bà bâu"));
        dataPopcorm.add(new DataPopcorm(R.drawable.ic_babyweight, "Đánh giá ứng dụng"));
        dataPopcorm.add(new DataPopcorm(R.drawable.ic_babyweight, "Chia sẻ ứng dụng"));
        dataPopcorm.add(new DataPopcorm(R.drawable.ic_babyweight, "Ứng dụng khác"));

        PopcormAdapter popcormAdapter = new PopcormAdapter(dataPopcorm, getContext());
        recyclerViewPopcorm.setAdapter(popcormAdapter);

        popcormAdapter.setClickPopcorm(this);


        return view;
    }


    @Override
    public void ClickPopcorm(int position) {
//        Toast.makeText(getContext(), "popcorm " + position, Toast.LENGTH_SHORT).show();

        switch (position){
            case 0:
                Intent story = new Intent(getContext(), StoryActivity.class);
                startActivity(story);
                break;
            case 1:
                Intent quatation = new Intent(getContext(), QuatationActivity.class);
                startActivity(quatation);
                break;
            case 2:
                FanPage();
                break;
            case 3:
                community();
                break;
            case 4:
                Intent evaluate = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=vnshine.com.sotiemchung&hl=en"));
                startActivity(evaluate);
                break;
            case 5:
                ShareApp();
                break;
            case 6:
                AppPlus();
                break;
        }
    }

    private void community() {
        Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_comunity);

        comunityFB = dialog.findViewById(R.id.comunityFB);
        comunityTD = dialog.findViewById(R.id.comunityTD);
        btnComuAlwayl = dialog.findViewById(R.id.btnComuAlwayl);
        btnComuOne = dialog.findViewById(R.id.btnComuOne);

        comunityFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickFirstcomunitytd = true;
                if (clickFirstcomunityfb == true){
                    comunityFB.setBackgroundColor(getResources().getColor(R.color.xanhdialog));
                    comunityTD.setBackgroundColor(getResources().getColor(R.color.xanhbgdialog));

                    btnComuAlwayl.setTextColor(Color.WHITE);
                    btnComuOne.setTextColor(Color.WHITE);

                    btnComuAlwayl.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent comunity = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/vnshinejsc/"));
                            startActivity(comunity);
                        }
                    });
                    btnComuOne.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent comunity = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/vnshinejsc/"));
                            startActivity(comunity);
                        }
                    });

                    clickFirstcomunityfb = false;
                } else {
                    Intent comunity = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/vnshinejsc/"));
                    startActivity(comunity);
                    clickFirstcomunityfb = true;
                }
            }
        });
        comunityTD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickFirstcomunityfb = true;
                if (clickFirstcomunitytd == true){
                    comunityTD.setBackgroundColor(getResources().getColor(R.color.xanhdialog));
                    comunityFB.setBackgroundColor(getResources().getColor(R.color.xanhbgdialog));

                    btnComuAlwayl.setTextColor(Color.WHITE);
                    btnComuOne.setTextColor(Color.WHITE);

                    btnComuAlwayl.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent comunity = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=vnshine&oq=vnshine&aqs=chrome.0.69i59j0j69i61j69i60l2.3435j0j4&sourceid=chrome&ie=UTF-8"));
                            startActivity(comunity);
                        }
                    });
                    btnComuOne.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent comunity = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=vnshine&oq=vnshine&aqs=chrome.0.69i59j0j69i61j69i60l2.3435j0j4&sourceid=chrome&ie=UTF-8"));
                            startActivity(comunity);
                        }
                    });

                    clickFirstcomunitytd = false;
                } else {
                    Intent comunity = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=vnshine&oq=vnshine&aqs=chrome.0.69i59j0j69i61j69i60l2.3435j0j4&sourceid=chrome&ie=UTF-8"));
                    startActivity(comunity);
                    clickFirstcomunitytd = true;
                }
            }
        });

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(lp);
//        dialog.show();

        Uri webpage = Uri.parse("https://www.facebook.com/vnshinejsc/");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        }


    }

    private void AppPlus() {
        Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_appplus);

        appplus_CHplay = dialog.findViewById(R.id.appplus_CHplay);
        appplus_chrome = dialog.findViewById(R.id.appplus_chrome);
        appplus_trinhduyet = dialog.findViewById(R.id.appplus_trinhduyet);
        btnAppplus_always = dialog.findViewById(R.id.btnAppplus_always);
        btnAppplus_one = dialog.findViewById(R.id.btnAppplus_one);


        appplus_CHplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickFirstChrome = true;
                clickFirstCHTrinhduyet = true;

                if (clickFirstCH == true){
                    appplus_CHplay.setBackgroundColor(getResources().getColor(R.color.xanhdialog));
                    appplus_chrome.setBackgroundColor(getResources().getColor(R.color.xanhbgdialog));
                    appplus_trinhduyet.setBackgroundColor(getResources().getColor(R.color.xanhbgdialog));

                    btnAppplus_always.setTextColor(Color.WHITE);
                    btnAppplus_one.setTextColor(Color.WHITE);

                    btnAppplus_always.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent CHplay = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/search?q=Mama%20Care&c=apps&hl=en"));
                            startActivity(CHplay);
                        }
                    });
                    btnAppplus_one.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent CHplay = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/search?q=Mama%20Care&c=apps&hl=en"));
                            startActivity(CHplay);
                        }
                    });

                    clickFirstCH = false;
                } else {
                    Toast.makeText(getContext(), "second click", Toast.LENGTH_SHORT).show();

                    Intent CHplay = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/search?q=Mama%20Care&c=apps&hl=en"));
                    startActivity(CHplay);

                    clickFirstCH = true;

                }

            }
        });
        appplus_chrome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickFirstCH = true;
                clickFirstCHTrinhduyet = true;

                if (clickFirstChrome == true){
                    appplus_chrome.setBackgroundColor(getResources().getColor(R.color.xanhdialog));
                    appplus_CHplay.setBackgroundColor(getResources().getColor(R.color.xanhbgdialog));
                    appplus_trinhduyet.setBackgroundColor(getResources().getColor(R.color.xanhbgdialog));

                    btnAppplus_always.setTextColor(Color.WHITE);
                    btnAppplus_one.setTextColor(Color.WHITE);

                    btnAppplus_always.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent chrome = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/dev?id=7261021571514228233&hl=en"));
                            startActivity(chrome);
                        }
                    });
                    btnAppplus_one.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent chrome = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/dev?id=7261021571514228233&hl=en"));
                            startActivity(chrome);
                        }
                    });


                    clickFirstChrome = false;
                } else{
                    Intent chrome = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/dev?id=7261021571514228233&hl=en"));
                    startActivity(chrome);

                    clickFirstChrome = true;

                }

            }
        });
        appplus_trinhduyet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickFirstChrome = true;
                clickFirstCH = true;
                if (clickFirstCHTrinhduyet == true){
                    appplus_trinhduyet.setBackgroundColor(getResources().getColor(R.color.xanhdialog));
                    appplus_chrome.setBackgroundColor(getResources().getColor(R.color.xanhbgdialog));
                    appplus_CHplay.setBackgroundColor(getResources().getColor(R.color.xanhbgdialog));

                    btnAppplus_always.setTextColor(Color.WHITE);
                    btnAppplus_one.setTextColor(Color.WHITE);

                    btnAppplus_always.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent chrome = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=vnshine&oq=vn&aqs=chrome.0.69i59j69i57j69i60l2j69i65l3j69i60.1167j0j4&sourceid=chrome&ie=UTF-8"));
                            startActivity(chrome);
                        }
                    });
                    btnAppplus_one.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent chrome = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=vnshine&oq=vn&aqs=chrome.0.69i59j69i57j69i60l2j69i65l3j69i60.1167j0j4&sourceid=chrome&ie=UTF-8"));
                            startActivity(chrome);
                        }
                    });

                    clickFirstCHTrinhduyet = false;
                } else{
                    Intent chrome = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=vnshine&oq=vn&aqs=chrome.0.69i59j69i57j69i60l2j69i65l3j69i60.1167j0j4&sourceid=chrome&ie=UTF-8"));
                    startActivity(chrome);

                    clickFirstCHTrinhduyet = true;

                }

            }
        });

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(lp);
//        dialog.show();


        Uri webpage = Uri.parse("https://play.google.com/store/search?q=Mama%20Care&c=apps&hl=en");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, webpage);
        PackageManager packageManager = getActivity().getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
        boolean isIntentSafe = activities.size() > 0;

        if (isIntentSafe) {
            startActivity(mapIntent);
        }

    }

    private void ShareApp() {
        Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_share);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(lp);
//        dialog.show();

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, "Your Subject");
        i.putExtra(Intent.EXTRA_EMAIL, new String[] {"mamacarestudio@gmail.com"});
        String send = "https://play.google.com/store/apps/details?id="+getContext().getPackageName();
        i.putExtra(Intent.EXTRA_TEXT, send);
        startActivity(Intent.createChooser(i, "choose one"));
    }

    private void FanPage() {
//        Dialog dialog = new Dialog(getContext());
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.dialog_fanpage);
//
//        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
//        lp.copyFrom(dialog.getWindow().getAttributes());
//        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
//        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
//
//        dialog.getWindow().setAttributes(lp);
//
//        dialog.show();
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/vnshinejsc/"));
        startActivity(browserIntent);

    }



}
