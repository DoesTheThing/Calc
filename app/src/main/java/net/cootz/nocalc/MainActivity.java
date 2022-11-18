package net.cootz.nocalc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private float getContentValue(String text){
        text = text.toLowerCase(Locale.ROOT);

        if (text.contains("cos"))
            return new Float(Math.cos(new Float(text.replace("cos(","").replace(")", ""))));
        else if (text.contains("sin"))
            return new Float(Math.sin(new Float(text.replace("sin(","").replace(")", ""))));
        else if (text.contains("tg"))
            return new Float(Math.tan(new Float(text.replace("tg(","").replace(")", ""))));
        else if (text.contains("abs"))
            return new Float(Math.abs(new Float(text.replace("abs(","").replace(")", ""))));
        else if (text.contains("sqrt"))
            return new Float(Math.sqrt(new Float(text.replace("sqrt(","").replace(")", ""))));
        else
            return new Float(text);
    }

    public void onAddClick(View view) {
        float a = 0f;
        float b = 0f;
        boolean isBroken = false;

        try {
            a = getContentValue(((EditText)findViewById(R.id.editTextA)).getText().toString());
            b = getContentValue(((EditText)findViewById(R.id.editTextB)).getText().toString());
        }
        catch (Exception e)
        {
            isBroken = true;
            AlertDialog.Builder errorDialog = new AlertDialog.Builder(this);
            errorDialog.setMessage(e.getMessage());
            errorDialog.setTitle("Error");
            errorDialog.create().show();
        }

        if (!isBroken)
            ((EditText)findViewById(R.id.editTextResult)).setText(Float.toString(a+b));
    }

    public void onSubtract(View view)
    {
        float a = getContentValue(((EditText)findViewById(R.id.editTextA)).getText().toString());
        float b = getContentValue(((EditText)findViewById(R.id.editTextB)).getText().toString());

        ((EditText)findViewById(R.id.editTextResult)).setText(Float.toString(a-b));
    }

    public void onMultiply(View view)
    {
        float a = getContentValue(((EditText)findViewById(R.id.editTextA)).getText().toString());
        float b = getContentValue(((EditText)findViewById(R.id.editTextB)).getText().toString());

        ((EditText)findViewById(R.id.editTextResult)).setText(Float.toString(a*b));
    }

    public void onDivide(View view)
    {
        float a = getContentValue(((EditText)findViewById(R.id.editTextA)).getText().toString());
        float b = getContentValue(((EditText)findViewById(R.id.editTextB)).getText().toString());

        ((EditText)findViewById(R.id.editTextResult)).setText(Float.toString(a/b));
    }
}