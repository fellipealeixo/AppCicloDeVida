package br.ifrn.tads.dsdm.appciclodevida;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private final String Tag = "Main";
    private String[] items;
    private int checkedItem;
    private boolean[] checkedItems;
    private Dialog dialog;
    private DialogInterface.OnClickListener listenerItemClick = new
            DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, items[which], Toast.LENGTH_SHORT).show();
                }
            };
    private DialogInterface.OnMultiChoiceClickListener listenerMultiItem = new
            DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    Toast.makeText(MainActivity.this, items[which], Toast.LENGTH_SHORT).show();
                }
            };
    private View.OnClickListener listenerAdicionar = new View.OnClickListener() {
        public void onClick(View v) {
            EditText editText1 = (EditText) dialog.findViewById(R.id.editTextSlave);
            TextView textView1 = (TextView) dialog.findViewById(R.id.textViewSlave);
            String s1 = editText1.getText().toString();
            String s2 = textView1.getText().toString();
            textView1.setText(s1 + "\n" + s2); }
    };

    private View.OnClickListener listenerVoltar = new View.OnClickListener() {
        public void onClick(View v) {
            TextView textView1 = (TextView) dialog.findViewById(R.id.textViewSlave);
            Toast.makeText(MainActivity.this, textView1.getText().toString(), Toast.LENGTH_SHORT).show();
            dialog.dismiss();
            dialog = null; }
    };
    private DatePickerDialog.OnDateSetListener listenerDate = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            String msg = String.format("%d/%d/%d", dayOfMonth, monthOfYear, year);
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show(); }
    };

    private TimePickerDialog.OnTimeSetListener listenerTime = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            String msg = String.format("%d:%d", hourOfDay, minute);
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show(); }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items = getResources().getStringArray(R.array.listaOpcoes);
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
        Log.i(Tag, "onSaveInstanceState");
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        Log.i(Tag, "onRestoreInstanceState");
    }

    public void btnActivityClick(View v) {
        Intent i = new Intent(this, SlaveActivity.class);
        Log.i(Tag, "btnActivityClick");
        startActivityForResult(i, 0);
    }

    public void btnAlertClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.app_name);
        builder.setPositiveButton("OK", null);
        builder.setMessage(R.string.textoDialogo);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void btnItemsClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.app_name);
        builder.setItems(items, listenerItemClick);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void btnRadioClick(View v) {
        checkedItem = 0;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.app_name);
        builder.setSingleChoiceItems(items, checkedItem, listenerItemClick);
        builder.setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void btnCheckClick(View v) {
        checkedItems = new boolean[items.length];
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.app_name);
        builder.setMultiChoiceItems(items, checkedItems, listenerMultiItem);
        builder.setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void btnDialogClick(View v) {
        Button btnAdd, btnRet;
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_slave);
        dialog.setTitle(R.string.app_name);
        btnAdd = (Button) dialog.findViewById(R.id.btnAdicionar);
        btnRet = (Button) dialog.findViewById(R.id.btnVoltar);
        btnAdd.setOnClickListener(listenerAdicionar);
        btnRet.setOnClickListener(listenerVoltar);
        dialog.show();
    }

    public void btnDatePickerClick(View v) {
        Calendar data = Calendar.getInstance();
        int dia = data.get(Calendar.DAY_OF_MONTH);
        int mes = data.get(Calendar.MONTH);
        int ano = data.get(Calendar.YEAR);
        DatePickerDialog dialog = new DatePickerDialog(this, listenerDate, ano, mes, dia);
        dialog.setTitle(R.string.app_name);
        dialog.show();
    }

    public void btnTimePickerClick(View v) {
        Calendar data = Calendar.getInstance();
        int hor = data.get(Calendar.HOUR_OF_DAY);
        int min = data.get(Calendar.MINUTE);
        TimePickerDialog dialog = new TimePickerDialog(this, listenerTime, hor, min, true);
        dialog.setTitle(R.string.app_name);
        dialog.show();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0)
            if (resultCode == RESULT_OK) {
                Log.i(Tag, "onActivityResult");
                Toast.makeText(this, data.getCharSequenceExtra("ret").toString(), Toast.LENGTH_SHORT).show();
            }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
