package com.example42041.pdf_download_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView pdfListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pdfListView = (ListView) findViewById(R.id.myPDFList);
        setTitle("CONTENTS");

        pdfListView.setAdapter(new ArrayAdapter<String>(this, 17367043,
                new String[]{ "Chapters 1 इतिहास",
                "Chapters 2 भूगोल", "Chapters 3 भारतीय राजव्यवस्था",
                "Chapters 4 अर्थव्यवस्था", "Chapters 5 सामान्य ज्ञान", "Chapters 6 करेण्ट अफेयर्स"}) {
            public View getView(int i, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i, view, viewGroup);
                TextView textView = (TextView) view2.findViewById(R.id.cardtext);
                return view2;
            }
        });
        pdfListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                String obj = MainActivity.this.pdfListView.getItemAtPosition(i).toString();
                Intent intent = new Intent(MainActivity.this.getApplicationContext(), PDFOpener.class);
                intent.putExtra("pdfFileName", obj);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}