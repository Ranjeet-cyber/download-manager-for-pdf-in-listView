package com.example42041.pdf_download_listview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

public class PDFOpener extends AppCompatActivity {
    private String MY_PDF;
    public int STORAGE_PERMISSION_CODE = 1;
    public final String TAG = PDFOpener.class.getSimpleName();
    private String getItem;
    private LinearLayout BannerAds;
    private PDFView pdfView;
    public SeekBar seekBar;
    public TextView txtView;
    public String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfopener);
                if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                    requestStoragePermission();
                }
                BannerAds = findViewById(R.id.fb_banner);


                String stringExtra = getIntent().getStringExtra("pdfFileName");
                this.getItem = stringExtra;


                // gk vigyan siuru
                if (this.getItem.equals("Chapters 1 भौतिक विज्ञान")) {
                    this.url = "https://firebasestorage.googleapis.com/v0/b/class-fa602.appspot.com/o/cdsPathfinder%2F36_unlocked.pdf?alt=media&token=120178ee-38dc-479d-a07f-db27e14cf5af";
                    this.pdfView = (PDFView) findViewById(R.id.pdfView);
                    this.txtView = (TextView) findViewById(R.id.textView);
                    this.MY_PDF = "rs8ch1";
                    initSeekBar();
                    downloadPdf(this.MY_PDF);
                }
                if (this.getItem.equals("Chapters 2 रसायन विज्ञान")) {
                    this.url = "https://firebasestorage.googleapis.com/v0/b/class-fa602.appspot.com/o/cdsPathfinder%2F37_unlocked.pdf?alt=media&token=016608b7-4265-49ba-82ae-8426ab3bb4c3";
                    this.pdfView = (PDFView) findViewById(R.id.pdfView);
                    this.txtView = (TextView) findViewById(R.id.textView);
                    this.MY_PDF = "rs8ch2";
                    initSeekBar();
                    downloadPdf(this.MY_PDF);
                }
                if (this.getItem.equals("Chapters 3 जीव विज्ञान")) {
                    this.url = "https://firebasestorage.googleapis.com/v0/b/class-fa602.appspot.com/o/cdsPathfinder%2F38_unlocked.pdf?alt=media&token=f9ba32cf-e306-4eb7-adeb-f1c42c223421";
                    this.pdfView = (PDFView) findViewById(R.id.pdfView);
                    this.txtView = (TextView) findViewById(R.id.textView);
                    this.MY_PDF = "rs8ch3";
                    initSeekBar();
                    downloadPdf(this.MY_PDF);
                }
                if (this.getItem.equals("Chapters 1 इतिहास")) {
                    this.url = "https://firebasestorage.googleapis.com/v0/b/class-fa602.appspot.com/o/cdsPathfinder%2F39_unlocked.pdf?alt=media&token=509c8889-85d9-45ed-a3bb-c7bf01bbdbd1";
                    this.pdfView = (PDFView) findViewById(R.id.pdfView);
                    this.txtView = (TextView) findViewById(R.id.textView);
                    this.MY_PDF = "rs8ch4";
                    initSeekBar();
                    downloadPdf(this.MY_PDF);
                }
                if (this.getItem.equals("Chapters 2 भूगोल")) {
                    this.url = "https://firebasestorage.googleapis.com/v0/b/class-fa602.appspot.com/o/cdsPathfinder%2F40_unlocked.pdf?alt=media&token=2c9cc33b-8f1f-4769-b427-5b9d25a4563f";
                    this.pdfView = (PDFView) findViewById(R.id.pdfView);
                    this.txtView = (TextView) findViewById(R.id.textView);
                    this.MY_PDF = "rs8ch5";
                    initSeekBar();
                    downloadPdf(this.MY_PDF);
                }
                if (this.getItem.equals("Chapters 3 भारतीय राजव्यवस्था")) {
                    this.url = "https://firebasestorage.googleapis.com/v0/b/class-fa602.appspot.com/o/cdsPathfinder%2F41_unlocked.pdf?alt=media&token=e0c1f25f-8be4-47a3-8abc-dca8695e0b06";
                    this.pdfView = (PDFView) findViewById(R.id.pdfView);
                    this.txtView = (TextView) findViewById(R.id.textView);
                    this.MY_PDF = "rs8ch6";
                    initSeekBar();
                    downloadPdf(this.MY_PDF);
                }
                if (this.getItem.equals("Chapters 4 अर्थव्यवस्था")) {
                    this.url = "https://firebasestorage.googleapis.com/v0/b/class-fa602.appspot.com/o/cdsPathfinder%2F42_unlocked.pdf?alt=media&token=c90acdd3-f9c4-453e-90a3-25097ffaa389";
                    this.pdfView = (PDFView) findViewById(R.id.pdfView);
                    this.txtView = (TextView) findViewById(R.id.textView);
                    this.MY_PDF = "rs8ch7";
                    initSeekBar();
                    downloadPdf(this.MY_PDF);
                }
                if (this.getItem.equals("Chapters 5 सामान्य ज्ञान")) {
                    this.url = "https://firebasestorage.googleapis.com/v0/b/class-fa602.appspot.com/o/cdsPathfinder%2F43_unlocked.pdf?alt=media&token=0e7d3533-e8be-46df-8cf2-6d22034fda80";
                    this.pdfView = (PDFView) findViewById(R.id.pdfView);
                    this.txtView = (TextView) findViewById(R.id.textView);
                    this.MY_PDF = "rs8ch8";
                    initSeekBar();
                    downloadPdf(this.MY_PDF);
                }
                if (this.getItem.equals("Chapters 6 करेण्ट अफेयर्स")) {
                    this.url = "https://firebasestorage.googleapis.com/v0/b/class-fa602.appspot.com/o/cdsPathfinder%2F44_unlocked.pdf?alt=media&token=22fa296d-24f1-4181-92ee-2f39faeff071";
                    this.pdfView = (PDFView) findViewById(R.id.pdfView);
                    this.txtView = (TextView) findViewById(R.id.textView);
                    this.MY_PDF = "rs8ch9";
                    initSeekBar();
                    downloadPdf(this.MY_PDF);
                }


            }

            private void initSeekBar() {
                SeekBar seekBar2 = (SeekBar) findViewById(R.id.seekBar);
                this.seekBar = seekBar2;
                seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }

                    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                        int width = ((seekBar.getWidth() - (seekBar.getThumbOffset() * 3)) * i) / seekBar.getMax();
                        TextView access$200 = PDFOpener.this.txtView;
                        access$200.setText("" + i);
                        PDFOpener.this.txtView.setX(seekBar.getX() + ((float) width) + ((float) (seekBar.getThumbOffset() / 2)));
                        PDFOpener.this.getSupportActionBar().setTitle((CharSequence) "Downloading PDF 👍");
                    }
                });
            }

            private void downloadPdf(final String str) {
                new AsyncTask<Void, Integer, Boolean>() {

                    public Boolean doInBackground(Void... voidArr) {
                        return downloadPdf();
                    }

                    @SuppressLint("StaticFieldLeak")
                    private Boolean downloadPdf() {
                        try {
                            if (PDFOpener.this.getFileStreamPath(str).exists()) {
                                return true;
                            }
                            try {
                                if (!PDFOpener.this.isConnected(PDFOpener.this)) {
                                    PDFOpener.this.buildDialog(PDFOpener.this).show();
                                }
                                PDFOpener.this.requestStoragePermission();
                                FileOutputStream openFileOutput = PDFOpener.this.openFileOutput(str, 0);
                                URL url = new URL(PDFOpener.this.url);
                                int contentLength = url.openConnection().getContentLength();
                                BufferedInputStream bufferedInputStream = new BufferedInputStream(url.openStream());
                                byte[] bArr = new byte[contentLength];
                                long j = 0;
                                while (true) {
                                    int read = bufferedInputStream.read(bArr);
                                    if (read != -1) {
                                        j += (long) read;
                                        publishProgress(new Integer[]{Integer.valueOf((int) ((100 * j) / ((long) contentLength)))});
                                        openFileOutput.write(bArr, 0, read);
                                    } else {
                                        openFileOutput.flush();
                                        openFileOutput.close();
                                        bufferedInputStream.close();
                                        return true;
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                return false;
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return false;
                        }
                    }
                    public void onProgressUpdate(Integer... numArr) {
                        super.onProgressUpdate(numArr);
                        PDFOpener.this.seekBar.setProgress(numArr[0].intValue());
                    }
                    @SuppressLint({"StaticFieldLeak", "WrongConstant"})
                    public void onPostExecute(Boolean bool) {
                        super.onPostExecute(bool);
                        Toast.makeText(PDFOpener.this, " pdf downloaded ", 0).show();
                        if (bool.booleanValue()) {
                            PDFOpener.this.getSupportActionBar().setTitle((CharSequence) "Showing PDF 👍");
                            PDFOpener.this.seekBar.setVisibility(8);
                            PDFOpener.this.txtView.setVisibility(8);
                            CardView cardView = (CardView) PDFOpener.this.findViewById(R.id.card);
                            cardView.setVisibility(0);
                            cardView.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View view) {
                                    PDFOpener.this.openPdf(str);
                                    ((CardView) PDFOpener.this.findViewById(R.id.card)).setVisibility(8);
                                }
                            });
                            return;
                        }
                        Toast.makeText(PDFOpener.this, " unable to download pdf", 0).show();
                        PDFOpener pDFOpener = PDFOpener.this;
                        if (!pDFOpener.isConnected(pDFOpener)) {
                            PDFOpener pDFOpener2 = PDFOpener.this;
                            pDFOpener2.buildDialog(pDFOpener2).show();
                        }
                    }
                }.execute(new Void[0]);
            }

            /* access modifiers changed from: private */
            @SuppressLint("WrongConstant")
            public void openPdf(String str) {
                try {
                    getSupportActionBar().setTitle((CharSequence) "Showing PDF 👍");
                    File fileStreamPath = getFileStreamPath(str);
                    Log.e("file", "file: " + fileStreamPath.getAbsolutePath());
                    this.seekBar.setVisibility(8);
                    this.pdfView.setVisibility(0);
                    getSupportActionBar().setTitle((CharSequence) this.getItem);
                    this.pdfView.fromFile(fileStreamPath).enableAntialiasing(true).enableSwipe(true)
                            .swipeHorizontal(false).scrollHandle(new DefaultScrollHandle(this)).spacing(0).load();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public boolean onCreateOptionsMenu(Menu menu) {
                getMenuInflater().inflate(R.menu.main, menu);
                return super.onCreateOptionsMenu(menu);
            }

            @SuppressLint("WrongConstant")
            public boolean onOptionsItemSelected(MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.delete) {
                    this.pdfView = (PDFView) findViewById(R.id.pdfView);
                    if (new File(getFilesDir(), this.MY_PDF).exists()) {
                        deleteFile(this.MY_PDF);
                        Toast.makeText(getApplicationContext(), "PDF Is Deleted", 0).show();
                        super.onBackPressed();
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "PDF not Found", 0).show();
                    }
                }
                else if (itemId == R.id.light_mode) {
                    this.pdfView = (PDFView) findViewById(R.id.pdfView);
                    try {
                        File fileStreamPath = getFileStreamPath(this.MY_PDF);
                        Log.e("file", "file: " + fileStreamPath.getAbsolutePath());
                        ((CardView) findViewById(R.id.card)).setVisibility(8);
                        this.seekBar.setVisibility(8);
                        this.pdfView.setVisibility(0);
                        getSupportActionBar().setTitle((CharSequence) this.getItem);
                        this.pdfView.fromFile(fileStreamPath).enableAntialiasing(true).enableSwipe(true).swipeHorizontal(false)
                                .scrollHandle(new DefaultScrollHandle(this)).spacing(0).load();
                        Toast.makeText(this, "Light mode ON", 0).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (itemId == R.id.menu_refresh) {
                    this.pdfView = (PDFView) findViewById(R.id.pdfView);
                    try {
                        File fileStreamPath2 = getFileStreamPath(this.MY_PDF);
                        Log.e("file", "file: " + fileStreamPath2.getAbsolutePath());
                        ((CardView) findViewById(R.id.card)).setVisibility(8);
                        this.seekBar.setVisibility(8);
                        this.pdfView.setVisibility(0);
                        getSupportActionBar().setTitle((CharSequence) this.getItem);
                        this.pdfView.fromFile(fileStreamPath2).enableAntialiasing(true).enableSwipe(true).swipeHorizontal(false)
                                .scrollHandle(new DefaultScrollHandle(this)).spacing(0).load();
                        // Toast.makeText(this, "Dark mode ON", 0).show();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                return super.onOptionsItemSelected(menuItem);
            }
            public boolean isConnected(Context context) {
                @SuppressLint("WrongConstant") ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                @SuppressLint("MissingPermission") NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                    @SuppressLint("MissingPermission") NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                    @SuppressLint("MissingPermission") NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                    if ((networkInfo2 == null || !networkInfo2.isConnectedOrConnecting()) && (networkInfo == null
                            || !networkInfo.isConnectedOrConnecting())) {
                        return false;
                    }
                    return true;
                }
                return false;
            }

            public AlertDialog.Builder buildDialog(Context context) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("No Internet Connection");
                builder.setMessage("You need to have Mobile Data or Wifi to Download this. Press ok to Exit");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        PDFOpener.this.finish();
                    }
                });
                return builder;
            }

            /* access modifiers changed from: private */
            public void requestStoragePermission() {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    new AlertDialog.Builder(this).setTitle("Storage Permission needed").setMessage("Storage permission is needed for Storing files please grant it").setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            PDFOpener pDFOpener = PDFOpener.this;
                            ActivityCompat.requestPermissions(pDFOpener, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"},
                                    pDFOpener.STORAGE_PERMISSION_CODE);
                        }
                    }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            PDFOpener.this.onBackPressed();
                            dialogInterface.dismiss();
                        }
                    }).create().show();
                } else {
                    ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"},
                            this.STORAGE_PERMISSION_CODE);
                }
            }

            public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                super.onRequestPermissionsResult(i, strArr, iArr);
                if (i != this.STORAGE_PERMISSION_CODE) {
                    return;
                }
                if (iArr.length <= 0 || iArr[0] != 0) {
                    Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
                    onBackPressed();
                    return;
                }
                downloadPdf(this.MY_PDF);
            }
        }
