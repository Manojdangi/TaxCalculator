package com.example.taxcalculation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText salary;
    Button calculate;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        salary = findViewById(R.id.txt_sal);
        calculate = findViewById(R.id.btn_calculate);
        res = findViewById(R.id.result);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double monthly_salary = Double.parseDouble(salary.getText().toString());

                if (monthly_salary >= 1.0 || monthly_salary < 200000.0) {
                    Double tax = first_tax(monthly_salary);
                    res.setText("Your tax amount is "+tax);
                }

                else if (monthly_salary >= 200000.0 || monthly_salary < 350000.0) {
                    Double tax = second_tax(monthly_salary);
                    res.setText("Your tax amount is "+tax);

                }

                else if (monthly_salary >= 350000.0) {
                    Double tax = third_tax(monthly_salary);
                    res.setText("Your tax amount is "+tax);
                }
            }
        });

    }


    public  Double first_tax(Double salary) {

        Double tax_paid =  (1.0/100.0) * salary;

        return tax_paid;
    }


    public  Double second_tax(Double salary) {
        Double first_tax = (1.0/100)* 200000.0;

        Double remaning_salary = salary - 200000.0;

        Double remaning_tax = (15.0/100.0) * remaning_salary;

        Double total_tax = first_tax + remaning_tax;

        return total_tax;
    }


    public  Double third_tax(Double salary) {
        Double first_tax = (1.0/100.0)*200000.0;

        Double next_tax = (15.0/100.0) * 150000.0;

        Double remaning_salary = salary - (150000.0+200000.0);

        Double remaning_tax = (25.0/100.0) * remaning_salary;

        Double total_tax = first_tax + next_tax + remaning_tax;

        return total_tax;
    }
}
