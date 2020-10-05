package com.leslie.iotparkinglot;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private final static String MY_UUID = "00001101-0000-1000-8000-00805F9B34FB";   //SPP服务UUID号
    private BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter(); //获取蓝牙实例
    private String smsg = ""; //显示用数据缓存
    private Button[] buttons = new Button[8];

    BluetoothDevice mBluetoothDevice = null; //蓝牙设备
    BluetoothSocket mBluetoothSocket = null; //蓝牙通信Socket

    boolean bRun = true; //运行状态
    boolean bThread = false; //读取线程状态
    private InputStream is;    //输入流，用来接收蓝牙数据

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //如果打不开蓝牙提示信息，结束程序
        if (mBluetoothAdapter == null) {
            Toast.makeText(getApplicationContext(), "无法打开手机蓝牙，请确认手机是否有蓝牙功能！", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        //连接按钮响应
        final Button connectButton = findViewById(R.id.connectButton);
        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mBluetoothAdapter.isEnabled() == false) {
                    Toast.makeText(getApplicationContext(), " 请先打开蓝牙", Toast.LENGTH_LONG).show();
                    return;
                }

                //如果未连接设备则打开DevicesListActivity搜索设备
                if (mBluetoothSocket == null) {
                    Intent serveIntent = new Intent(getApplicationContext(), DevicesListActivity.class); //跳转活动
                    startActivityForResult(serveIntent, 1); //设置返回宏定义
                } else {
                    //关闭连接socket
                    try {
                        bRun = false;
                        Thread.sleep(2000);

                        is.close();
                        mBluetoothSocket.close();
                        mBluetoothSocket = null;

                        connectButton.setText("连接");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        Button sendButton2 = (Button) findViewById(R.id.sendButton2);
        sendButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBluetoothSocket == null) {
                    Toast.makeText(getApplicationContext(), "请先连接设备", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    OutputStream os = mBluetoothSocket.getOutputStream();
                    os.write(2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Button sendButton3 = (Button) findViewById(R.id.sendButton3);
        sendButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBluetoothSocket == null) {
                    Toast.makeText(getApplicationContext(), "请先连接设备", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    OutputStream os = mBluetoothSocket.getOutputStream();
                    os.write(3);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Button sendButton4 = (Button) findViewById(R.id.sendButton4);
        sendButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBluetoothSocket == null) {
                    Toast.makeText(getApplicationContext(), "请先连接设备", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    OutputStream os = mBluetoothSocket.getOutputStream();
                    os.write(4);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Button sendButton5 = (Button) findViewById(R.id.sendButton5);
        sendButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBluetoothSocket == null) {
                    Toast.makeText(getApplicationContext(), "请先连接设备", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    OutputStream os = mBluetoothSocket.getOutputStream();
                    os.write(5);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Button sendButton6 = (Button) findViewById(R.id.sendButton6);
        sendButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBluetoothSocket == null) {
                    Toast.makeText(getApplicationContext(), "请先连接设备", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    OutputStream os = mBluetoothSocket.getOutputStream();
                    os.write(6);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Button sendButton7 = (Button) findViewById(R.id.sendButton7);
        sendButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBluetoothSocket == null) {
                    Toast.makeText(getApplicationContext(), "请先连接设备", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    OutputStream os = mBluetoothSocket.getOutputStream();
                    os.write(7);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Button sendButton8 = (Button) findViewById(R.id.sendButton8);
        sendButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBluetoothSocket == null) {
                    Toast.makeText(getApplicationContext(), "请先连接设备", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    OutputStream os = mBluetoothSocket.getOutputStream();
                    os.write(8);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Button sendButton9 = (Button) findViewById(R.id.sendButton9);
        sendButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBluetoothSocket == null) {
                    Toast.makeText(getApplicationContext(), "请先连接设备", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    OutputStream os = mBluetoothSocket.getOutputStream();
                    os.write(9);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        buttons[0]=sendButton2;
        buttons[1]=sendButton3;
        buttons[2]=sendButton4;
        buttons[3]=sendButton5;
        buttons[4]=sendButton6;
        buttons[5]=sendButton7;
        buttons[6]=sendButton8;
        buttons[7]=sendButton9;

        // 设置设备可以被搜索
        new Thread() {
            public void run() {
                if (mBluetoothAdapter.isEnabled() == false) {
                    mBluetoothAdapter.enable();
                }
            }
        }.start();
    }

    //接收活动结果，响应startActivityForResult()
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:     //连接结果，由DeviceListActivity设置返回
                // 响应返回结果
                if (resultCode == Activity.RESULT_OK) {   //连接成功，由DeviceListActivity设置返回
                    // MAC地址，由DeviceListActivity设置返回
                    String address = data.getExtras().getString(DevicesListActivity.EXTRA_DEVICE_ADDRESS);
                    // 得到蓝牙设备句柄
                    mBluetoothDevice = mBluetoothAdapter.getRemoteDevice(address);

                    // 用服务号得到socket
                    try {
                        mBluetoothSocket = mBluetoothDevice.createRfcommSocketToServiceRecord(UUID.fromString(MY_UUID));
                    } catch (IOException e) {
                        Toast.makeText(this, "连接失败！", Toast.LENGTH_SHORT).show();
                    }
                    //连接socket
                    Button connectButton = findViewById(R.id.connectButton);
                    try {
                        mBluetoothSocket.connect();
                        Toast.makeText(this, "连接" + mBluetoothDevice.getName() + "成功！", Toast.LENGTH_SHORT).show();
                        connectButton.setText("断开连接");
                    } catch (IOException e) {
                        try {
                            Toast.makeText(this, "连接失败！", Toast.LENGTH_SHORT).show();
                            mBluetoothSocket.close();
                            mBluetoothSocket = null;
                        } catch (IOException ee) {
                            Toast.makeText(this, "连接失败！", Toast.LENGTH_SHORT).show();
                        }

                        return;
                    }

                    //打开接收线程
                    try {
                        is = mBluetoothSocket.getInputStream();   //得到蓝牙数据输入流
                    } catch (IOException e) {
                        Toast.makeText(this, "接收数据失败！", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (bThread == false) {
                        readThread.start();
                        bThread = true;
                    } else {
                        bRun = true;
                    }
                }
                break;
            default:
                break;
        }
    }

    //接收数据线程
    Thread readThread=new Thread(){

        public void run(){
            byte[] buffer = new byte[1024];
            bRun = true;
            //接收线程
            while(true){
                try{
                    while(is.available()==0){
                        while(bRun == false){}
                    }
                    while(true){
                        if(!bThread)//跳出循环
                            return;

                        is.read(buffer);         //读入数据
                        smsg=new String(buffer);   //写入接收缓存
                        if(is.available()==0)break;  //短时间没有数据才跳出进行显示
                    }
                    //发送显示消息，进行显示刷新
                    handler.sendMessage(handler.obtainMessage());
                }catch(IOException e){
                }
            }
        }
    };

    //消息处理队列
    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            for (int i=0;i<8;i++) {
                if (smsg.charAt(i) == '1')
                    buttons[i].setBackgroundColor(Color.rgb(0, 255, 0));
                else
                    buttons[i].setBackgroundColor(Color.rgb(255, 0, 0));
            }
            TextView textView=findViewById(R.id.textView3);
            textView.setText(smsg);
        }
    };

    //关闭程序掉用处理部分
    public void onDestroy() {
        super.onDestroy();
        if (mBluetoothSocket != null)  //关闭连接socket
            try {
                mBluetoothSocket.close();
            } catch (IOException e) {
            }
        //	_bluetooth.disable();  //关闭蓝牙服务
    }
}
