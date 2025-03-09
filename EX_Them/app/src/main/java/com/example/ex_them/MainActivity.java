package com.example.ex_them;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tvQuestion, tvAnswerBox;
    private Button btnCheck;
    private Button[] answerButtons;
    private int num1, num2, correctAnswer, selectedAnswer;
    private int currentNumber; // Biến tạm để lưu số đang nhập

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo các thành phần giao diện
        tvQuestion = findViewById(R.id.tvQuestion);
        tvAnswerBox = findViewById(R.id.tvAnswerBox);
        btnCheck = findViewById(R.id.btnCheck);

        // Mảng các nút đáp án
        answerButtons = new Button[12];
        answerButtons[0] = findViewById(R.id.btn1);
        answerButtons[1] = findViewById(R.id.btn2);
        answerButtons[2] = findViewById(R.id.btn3);
        answerButtons[3] = findViewById(R.id.btn4);
        answerButtons[4] = findViewById(R.id.btn5);
        answerButtons[5] = findViewById(R.id.btn6);
        answerButtons[6] = findViewById(R.id.btn7);
        answerButtons[7] = findViewById(R.id.btn8);
        answerButtons[8] = findViewById(R.id.btn9);
        answerButtons[9] = findViewById(R.id.btn10);
        answerButtons[10] = findViewById(R.id.btn11);
        answerButtons[11] = findViewById(R.id.btn12);

        // Tạo câu hỏi đầu tiên
        generateNewQuestion();

        // Gán sự kiện cho các nút đáp án
        for (int i = 0; i < answerButtons.length; i++) {
            final int value = i + 1; // Giá trị của nút (1 đến 12)
            answerButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Xây dựng số từ các lần bấm
                    if (currentNumber == 0) {
                        currentNumber = value; // Lần bấm đầu tiên
                    } else {
                        currentNumber = currentNumber * 10 + value; // Thêm chữ số mới
                    }
                    selectedAnswer = currentNumber; // Cập nhật đáp án đã chọn
                    tvAnswerBox.setText(String.valueOf(selectedAnswer)); // Hiển thị số tạm thời
                }
            });
        }

        // Sự kiện cho nút Check
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    // Tạo câu hỏi mới
    private void generateNewQuestion() {
        Random random = new Random();
        num1 = random.nextInt(12) + 1; // Số ngẫu nhiên từ 1 đến 12
        num2 = random.nextInt(12) + 1; // Số ngẫu nhiên từ 1 đến 12
        correctAnswer = num1 * num2;

        // Chỉ hiển thị phép tính, chưa có kết quả
        tvQuestion.setText(num1 + " x " + num2 + " =");
        tvAnswerBox.setText(""); // Xóa kết quả cũ
        selectedAnswer = -1; // Reset đáp án đã chọn
        currentNumber = 0; // Reset số tạm thời
    }

    // Kiểm tra đáp án
    private void checkAnswer() {
        if (selectedAnswer == -1 || currentNumber == 0) {
            Toast.makeText(this, "Please select an answer!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (selectedAnswer == correctAnswer) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wrong! The correct answer is " + correctAnswer, Toast.LENGTH_SHORT).show();
        }

        // Tạo câu hỏi mới sau khi kiểm tra
        generateNewQuestion();
    }
}