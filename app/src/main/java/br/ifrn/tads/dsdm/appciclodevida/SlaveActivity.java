package br.ifrn.tads.dsdm.appciclodevida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SlaveActivity extends AppCompatActivity {
    private final String Tag = "Slave";
    private EditText editText1;
    private TextView textView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slave);
        editText1 = (EditText) findViewById(R.id.editTextSlave);
        textView1 = (TextView) findViewById(R.id.textViewSlave);
        Log.i(Tag, "onCreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(Tag, "onStart");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(Tag, "onRestart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(Tag, "onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(Tag, "onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(Tag, "onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(Tag, "onDestroy");
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putCharSequence("texto", textView1.getText().toString());
        Log.i(Tag, "onSaveInstanceState");
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textView1.setText(savedInstanceState.getCharSequence("texto"));
        Log.i(Tag, "onRestoreInstanceState");
    }


    public void btnAdicionarClick(View v) {
        String s1 = editText1.getText().toString();
        String s2 = textView1.getText().toString();
        textView1.setText(s1 + "\n" + s2);
    }

    public void btnVoltarClick(View v) {
        Intent i = new Intent();
        i.putExtra("ret", textView1.getText().toString());
        setResult(RESULT_OK, i);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_slave, menu);
        Log.i(Tag, "onCreateOptionsMenu");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
