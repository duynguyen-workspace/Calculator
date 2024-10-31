package vn.edu.rmit.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    double result = 0;
    int operatorOption = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Number buttons
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);

        // Calculate buttons
        Button btnPlus = findViewById(R.id.btnPlus);
        Button btnMinus = findViewById(R.id.btnMinus);
        Button btnMultiply = findViewById(R.id.btnMultiply);
        Button btnDivide = findViewById(R.id.btnDivide);
        Button btnAC = findViewById(R.id.btnAC);
        Button btnDEL = findViewById(R.id.btnDelete);
        Button btnEqual = findViewById(R.id.btnEqual);

        // Views
        TextView resultView = findViewById(R.id.resultView);
        TextView resultLabel = findViewById(R.id.resultLabel);

        resultView.setText("");
        resultLabel.setText("");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultView.setText(String.format("%s1", resultView.getText().toString()));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultView.setText(resultView.getText().toString() + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultView.setText(resultView.getText().toString() + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultView.setText(resultView.getText().toString() + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultView.setText(resultView.getText().toString() + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultView.setText(resultView.getText().toString() + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultView.setText(resultView.getText().toString() + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultView.setText(resultView.getText().toString() + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultView.setText(resultView.getText().toString() + "9");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultTxt = resultView.getText().toString();

                if (resultTxt.isEmpty()) {
                    return;
                }

                double value = Double.parseDouble(resultTxt);
                if (result == 0) {
                    result = value;
                } else {
                    result += value;
                }

                operatorOption = 1;

                String newLabel = resultLabel.getText().toString() + resultTxt;
                resultLabel.setText(newLabel + " + ");

                resultView.setText("");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultTxt = resultView.getText().toString();

                if (resultTxt.isEmpty()) {
                    return;
                }

                double value = Double.parseDouble(resultTxt);

                if (result == 0) {
                    result = value;
                } else {
                    result -= value;
                }

                operatorOption = 2;

                String newLabel = resultLabel.getText().toString() + resultTxt;
                resultLabel.setText(newLabel + " - ");

                resultView.setText("");
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultTxt = resultView.getText().toString();

                if (resultTxt.isEmpty()) {
                    return;
                }

                double value = Double.parseDouble(resultTxt);

                if (result == 0) {
                    result = value;
                } else {
                    result *= value;
                }

                operatorOption = 3;

                String newLabel = resultLabel.getText().toString() + resultTxt;
                resultLabel.setText(newLabel + " * ");

                resultView.setText("");
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultTxt = resultView.getText().toString();

                if (resultTxt.isEmpty()) {
                    return;
                }

                double value = Double.parseDouble(resultTxt);

                if (result == 0) {
                    result = value;
                } else {
                    result /= value;
                }

                operatorOption = 4;

                String newLabel = resultLabel.getText().toString() + resultTxt;
                resultLabel.setText(String.format("%s / ", newLabel));

                resultView.setText("");
            }
        });

        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = 0;
                resultView.setText("");
                resultLabel.setText("");
            }
        });

        btnDEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultTxt = resultView.getText().toString();

                if (resultTxt.isEmpty()) {
                    return;
                }

                String newLabel = resultTxt.substring(0, resultTxt.length() - 1);
                resultView.setText(newLabel);
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultTxt = resultView.getText().toString();

                if (resultTxt.isEmpty()) {
                    return;
                }

                double value = Double.parseDouble(resultTxt);

                switch (operatorOption) {
                    case 1:
                        result += value;
                        break;
                    case 2:
                        result -= value;
                        break;
                    case 3:
                        result *= value;
                        break;
                    case 4:
                        result /= value;
                        break;
                    default:
                        return;
                }

                String newLabel = resultLabel.getText().toString() + resultTxt;
                resultLabel.setText(newLabel + " = " + result);
                resultView.setText(String.valueOf(result));
            }
        });

    }
}