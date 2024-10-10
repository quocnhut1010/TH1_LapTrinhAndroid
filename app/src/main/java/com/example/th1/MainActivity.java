package com.example.th1;

import android.os.Bundle;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;

//public class MainActivity extends Activity {
public class MainActivity extends Activity implements View.OnClickListener {
    //    Button btnLogin, btnLogout;
    Button simpleToast, customToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get the reference of Button's
        simpleToast = (Button) findViewById(R.id.simpleToast);
        customToast = (Button) findViewById(R.id.customToast);
        // set the onClick listener for the buttons
        simpleToast.setOnClickListener(this);
        customToast.setOnClickListener(this);
    }

//        btnLogin = (Button)findViewById(R.id.btnLogin);
//        btnLogout = (Button)findViewById(R.id.btnLogout);
    //Xử lý sự kiện cho 2 button
//        btnLogin.setOnClickListener(this);
//        btnLogout.setOnClickListener(this);

    // Thêm sự kiện tại đây có tham số là View
//        public void clickMe(View v) {
//        // kiem tra bằng dùng phương thức getID() của view so sánh với id của button
//        if (v.getId() == R.id.btnLogin)
//                // Hiện thị thông báo trong vòng vài giây
//                Toast.makeText(getApplication(), "Bạn đang Click vào Button Login", Toast.LENGTH_LONG).show();
//        else if(v.getId() == R.id.btnLogout)
//                Toast.makeText(getApplication(), "Bạn đang Click vào Button Logout", Toast.LENGTH_LONG).show();
//
//        }
//    @Override
//    public void onClick(View v) {
//        // TODO Auto-generated method stub
//        // Lấy id từng button
//        if (v.getId() == R.id.btnLogin)
//            // Hiện thị thông báo trong vòng vài giây
//            Toast.makeText(getApplication(), "Bạn đang Click vào Button Login", Toast.LENGTH_LONG).show();
//        else if (v.getId() == R.id.btnLogout)
//            Toast.makeText(getApplication(), "Bạn đang Click vào Button Logout", Toast.LENGTH_LONG).show();
//    }

    //toast

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.simpleToast) {
            Toast toast = Toast.makeText(getApplicationContext(), "Simple Toast In Android", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
        } else if (v.getId() == R.id.customToast) {
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast_layout,
                    (ViewGroup) findViewById(R.id.toast_layout_root));
            TextView toastTextView = (TextView) layout.findViewById(R.id.toastTextView);
            ImageView toastImageView = (ImageView) layout.findViewById(R.id.toastImageView);
            toastTextView.setGravity(Gravity.CENTER);
            toastTextView.setText("Custom Toast In Android");
            toastImageView.setImageResource(R.drawable.ic_launcher_foreground);
            Toast toast = new Toast(getApplicationContext());
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();
        }
    }
    public void exit(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        // Setting Alert Dialog Title
        alertDialogBuilder.setTitle("Xác nhận để thoát..!!!");
        // Icon Of Alert Dialog
        alertDialogBuilder.setIcon(R.drawable.ic_launcher_foreground);
        // Setting Alert Dialog Message
        alertDialogBuilder.setMessage("Bạn có muốn thoát?");
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                //Đóng Activity hiện tại
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Bạn đã click vào nút không đồng ý",Toast.LENGTH_SHORT).show();
            }
        });
        alertDialogBuilder.setNeutralButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Bạn đã click vào nút hủy",Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
