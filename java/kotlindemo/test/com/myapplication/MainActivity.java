package kotlindemo.test.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import kotlindemo.test.com.myapplication.model.Bank;
import kotlindemo.test.com.myapplication.model.Employee;
import kotlindemo.test.com.myapplication.model.Student;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bank employee = stringFromJNI();
        System.out.println( "=============>>> " + employee.getName() );

    // Example of a call to a native method
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native Bank stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}
