package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.MessageQueue;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("aaa", "onCreate MainActivity");
//        findViewById(R.id.aaaa).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
//                startActivityForResult(intent, 0);
//
//            }
//        });
        final List<User> string1 = new ArrayList<>();

        string1.add(new User("1111", "张三"));
        string1.add(new User("2222", "张三"));
        string1.add(new User("3333", "张三"));
        string1.add(new User("2222", "张三"));
        string1.add(new User("1111", "张三"));
        string1.add(new User("2222", "张三"));
        string1.add(new User("3333", "张三"));
        string1.add(new User("1111", "张三"));
        final List<User> string2 = new ArrayList<>();

        string2.add(new User("1111", "李四"));
        string2.add(new User("2222", "李四"));
        string2.add(new User("3333", "李四"));
        string2.add(new User("1111", "李四"));
        string2.add(new User("1111", "李四"));
        string2.add(new User("3333", "李四"));
        string2.add(new User("1111", "李四"));
        string2.add(new User("4444", "李四"));
        string2.add(new User("1111", "李四"));
        string2.add(new User("5555", "李四"));
        string2.add(new User("1111", "李四"));
        string2.add(new User("6666", "李四"));
        string2.add(new User("3333", "李四"));
        string2.add(new User("1111", "李四"));
        string2.add(new User("1111", "李四"));
        string2.add(new User("1111", "李四"));
        string2.add(new User("22222", "李四"));

        calculateDiff(string1, string2);
    }

    public void calculateDiff(final List<User> string1, final List<User> string2) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffUtil.Callback() {
            @Override
            public int getOldListSize() {
                return string1.size();
            }

            @Override
            public int getNewListSize() {
                return string2.size();
            }

            @Override
            public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                if (string1.get(oldItemPosition).id.equals(string2.get(newItemPosition).id)) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                if (string1.get(oldItemPosition).id.equals(string2.get(newItemPosition).id)) {
                    if (string1.get(oldItemPosition).name.equals(string2.get(newItemPosition).name)) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }, false);
        diffResult.dispatchUpdatesTo(new ListUpdateCallback() {
            @Override
            public void onInserted(int position, int count) {
                Log.e("position", "onInserted-------position=" + position + "counnt=" + count + "-------");
            }

            @Override
            public void onRemoved(int position, int count) {
                Log.e("position", "onRemoved-------position=" + "counnt=" + count + "-------");

            }

            @Override
            public void onMoved(int fromPosition, int toPosition) {
                Log.e("position", "onMoved-------fromPosition = " + fromPosition + "toPosition" + toPosition + "-------");

            }

            @Override
            public void onChanged(int position, int count, @Nullable Object payload) {
                Log.e("position", "onChanged-------position=" + position + "counnt=" + count + "payload=" + payload);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("aaa", "onActivityResult");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("aaa", "onStart MainActivity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("aaa", "onRestart MainActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("aaa", "onResume MainActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("aaa", "onnPause MainActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("aaa", "onStop MainActivity");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("aaa", "onDestroy MainActivity");
    }

    class User {
        String id;
        String name;

        User(String id, String name) {
            this.id = id;
            this.name = name;
        }
    }


}