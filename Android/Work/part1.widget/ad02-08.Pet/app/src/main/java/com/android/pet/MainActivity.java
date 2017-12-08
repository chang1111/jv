package com.android.pet;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBox = null;
    private TextView textView1 = null;
    private RadioGroup rgpPet = null;
    private RadioButton radioPuppy = null;
    private RadioButton radioCat = null;
    private RadioButton radioRabbit = null;
    private Button button = null;
    private ImageView imageView = null;
    private ToggleButton toggle = null;
    private TextView textView2 = null;
    private RadioGroup ver = null;
    private RadioButton ver1 = null;
    private RadioButton ver2 = null;
    private RadioButton ver3 = null;
    private ImageView imageView2 = null;
    private LinearLayout button2 = null;
    private Button reset = null;
    private Button exit = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = findViewById(R.id.checkBox);
        textView1 = findViewById(R.id.textView1);
        rgpPet = findViewById(R.id.rgpPet);
        radioPuppy = findViewById(R.id.radioPuppy);
        radioCat = findViewById(R.id.radioCat);
        radioRabbit = findViewById(R.id.radioRabbit);
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
        toggle = findViewById(R.id.toggle);
        textView2 = findViewById(R.id.textView2);
        ver = findViewById(R.id.ver);
        ver1 = findViewById(R.id.ver1);
        ver2 = findViewById(R.id.ver2);
        ver3 = findViewById(R.id.ver3);
        imageView2 = findViewById(R.id.imageView2);
        button2 = findViewById(R.id.button2);
        reset = findViewById(R.id.reset);
        exit = findViewById(R.id.exit);

        textView1.setVisibility(View.GONE);
        rgpPet.setVisibility(View.GONE);
        button.setVisibility(View.GONE);
        imageView.setVisibility(View.GONE);
        toggle.setVisibility(View.GONE);
        textView2.setVisibility(View.GONE);
        ver.setVisibility(View.GONE);
        imageView2.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    textView1.setVisibility(View.VISIBLE);
                    rgpPet.setVisibility(View.VISIBLE);
                    button.setVisibility(View.VISIBLE);
                }
                else {
                    textView1.setVisibility(View.GONE);
                    rgpPet.setVisibility(View.GONE);
                    button.setVisibility(View.GONE);
                    imageView.setVisibility(View.GONE);
                }
            }
        });
        rgpPet.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioPuppy:
                        imageView.setVisibility(View.VISIBLE);
                        imageView.setImageDrawable( getResources().getDrawable(R.drawable.dog, null ) );
                        break;
                    case R.id.radioCat:
                        imageView.setVisibility(View.VISIBLE);
                        imageView.setImageDrawable( getResources().getDrawable(R.drawable.cat, null ) );
                        break;
                    case R.id.radioRabbit:
                        imageView.setVisibility(View.VISIBLE);
                        imageView.setImageDrawable( getResources().getDrawable(R.drawable.rabbit, null ) );
                        break;
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioPuppy.isChecked()||radioCat.isChecked()||radioRabbit.isChecked()) {
                    checkBox.setChecked(false);
                    radioPuppy.setChecked(false);
                    radioCat.setChecked(false);
                    radioRabbit.setChecked(false);
                    checkBox.setVisibility(View.GONE);
                    textView1.setVisibility(View.GONE);
                    rgpPet.setVisibility(View.GONE);
                    button.setVisibility(View.GONE);
                    imageView.setVisibility(View.GONE);
                    toggle.setVisibility(View.VISIBLE);
                }

            }
        });
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    textView2.setVisibility(View.VISIBLE);
                    ver.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);
                }
                else {
                    textView2.setVisibility(View.GONE);
                    ver.setVisibility(View.GONE);
                    imageView2.setVisibility(View.GONE);
                    button2.setVisibility(View.GONE);
                }
            }
        });

        ver.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.ver1:
                        imageView2.setVisibility(View.VISIBLE);
                        imageView2.setImageDrawable( getResources().getDrawable(R.drawable.marshmallow, null ) );
                        break;
                    case R.id.ver2:
                        imageView2.setVisibility(View.VISIBLE);
                        imageView2.setImageDrawable( getResources().getDrawable(R.drawable.nougat, null ) );
                        break;
                    case R.id.ver3:
                        imageView2.setVisibility(View.VISIBLE);
                        imageView2.setImageDrawable( getResources().getDrawable(R.drawable.lollipop, null ) );
                        break;
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle.setChecked(false);
                ver1.setChecked(false);
                ver2.setChecked(false);
                ver3.setChecked(false);
                toggle.setVisibility(View.GONE);
                textView2.setVisibility(View.GONE);
                ver.setVisibility(View.GONE);
                imageView2.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
                checkBox.setVisibility(View.VISIBLE);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
