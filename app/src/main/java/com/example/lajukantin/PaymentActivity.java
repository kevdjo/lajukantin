package com.example.lajukantin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lajukantin.Adapter.PaymentAdapter;
import com.example.lajukantin.Interface.PaymentViewInterface;
import com.example.lajukantin.Model.PaymentModel;

import java.util.ArrayList;
import java.util.List;

public class PaymentActivity extends AppCompatActivity implements PaymentViewInterface {

    private RecyclerView rvPayment;
    private ImageView ivCheckStatus;
    private TextView txtPaymentStatus;
    private boolean  paymentStatus;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        List<PaymentModel> paymentModelList = new ArrayList<>();
        paymentModelList.add(new PaymentModel(R.drawable.bca_payment));
        paymentModelList.add(new PaymentModel(R.drawable.bri_payment));
        paymentModelList.add(new PaymentModel(R.drawable.bni_payment));
        paymentModelList.add(new PaymentModel(R.drawable.mandiri_payment));

        rvPayment = findViewById(R.id.rv_payment);
        PaymentAdapter paymentAdapter = new PaymentAdapter(this, paymentModelList, this);
        rvPayment.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1, RecyclerView.VERTICAL, false);
//        rvMyCart.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvPayment.setLayoutManager(layoutManager);
        rvPayment.setItemAnimator(new DefaultItemAnimator());
        rvPayment.setAdapter(paymentAdapter);

        ivCheckStatus = findViewById(R.id.iv_checkStatus);
        txtPaymentStatus = findViewById(R.id.txt_paymentStatus);
        paymentStatus = false;
    }

    @Override
    public void onItemClick(int position) {
        if (paymentStatus == false){
            showPopupWindow();
        }
    }



    private void showPopupWindow() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Are you sure to proceed with the chosen payment method?")
                .setTitle("Confirmation");

        builder.setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                Toast.makeText(PaymentActivity.this, "Payment Successful", Toast.LENGTH_SHORT).show();

                ivCheckStatus.setImageResource(R.drawable.blue_check);
                txtPaymentStatus
                        .setText("Payment Succeed");
                paymentStatus = true;
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(PaymentActivity.this, "Cancel clicked", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}