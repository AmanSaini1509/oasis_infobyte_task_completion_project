package com.example.calculator;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;


public class MainActivity extends AppCompatActivity {
    private CalculatorViewModel viewModel;
    private EditText expressionEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        expressionEditText = findViewById(R.id.editText);
        resultTextView = findViewById(R.id.resultView);

        viewModel = new ViewModelProvider(this).get(CalculatorViewModel.class);

        setupObservers();
        setupClickListeners();

    }

    private void setupObservers() {
        viewModel.getExpression().observe(this, expression -> expressionEditText.setText(expression));
        viewModel.getResult().observe(this, result -> resultTextView.setText(result));
    }

    private void setupClickListeners() {
        findViewById(R.id.number0).setOnClickListener(view -> viewModel.appendToExpression("0"));
        findViewById(R.id.number1).setOnClickListener(view -> viewModel.appendToExpression("1"));
        findViewById(R.id.number2).setOnClickListener(view -> viewModel.appendToExpression("2"));
        findViewById(R.id.number3).setOnClickListener(view -> viewModel.appendToExpression("3"));
        findViewById(R.id.number4).setOnClickListener(view -> viewModel.appendToExpression("4"));
        findViewById(R.id.number5).setOnClickListener(view -> viewModel.appendToExpression("5"));
        findViewById(R.id.number6).setOnClickListener(view -> viewModel.appendToExpression("6"));
        findViewById(R.id.number7).setOnClickListener(view -> viewModel.appendToExpression("7"));
        findViewById(R.id.number8).setOnClickListener(view -> viewModel.appendToExpression("8"));
        findViewById(R.id.number9).setOnClickListener(view -> viewModel.appendToExpression("9"));
        findViewById(R.id.decimal).setOnClickListener(view -> viewModel.appendToExpression("."));
        findViewById(R.id.openBracket).setOnClickListener(view -> viewModel.appendToExpression("("));
        findViewById(R.id.closeBracket).setOnClickListener(view -> viewModel.appendToExpression(")"));
        findViewById(R.id.addition).setOnClickListener(view -> viewModel.appendToExpression("+"));
        findViewById(R.id.subtraction).setOnClickListener(view -> viewModel.appendToExpression("-"));
        findViewById(R.id.multiply).setOnClickListener(view -> viewModel.appendToExpression("*"));
        findViewById(R.id.divide).setOnClickListener(view -> viewModel.appendToExpression("/"));
        findViewById(R.id.allClear).setOnClickListener(view -> viewModel.clearExpression());
        findViewById(R.id.equal).setOnClickListener(view -> viewModel.evaluateExpression());
        findViewById(R.id.delete).setOnClickListener(view -> viewModel.deleteLastDigit());
    }
}