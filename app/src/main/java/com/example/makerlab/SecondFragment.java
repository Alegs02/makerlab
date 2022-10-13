package com.example.makerlab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;


import com.example.makerlab.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private final String SERVER_IP = "117.124.0.22";
    JavClient javaSocketClient;

    class ClientThread implements Runnable {
        @Override
        public void run() {
            javaSocketClient = new JavClient(SERVER_IP,9915);
        }
    }



    class SendStopThread implements Runnable {
        @Override
        public void run() {
            javaSocketClient.sendStop();
        }
    }

    class SendHappyThread implements Runnable {
        @Override
        public void run() {
            javaSocketClient.sendHappy();
        }
    }

    class SendOkThread implements Runnable {
        @Override
        public void run() {
            javaSocketClient.sendOK();
        }
    }

    class SendSadThread implements Runnable {
        @Override
        public void run() {
            javaSocketClient.sendSad();
        }
    }

    class SendAlone implements Runnable {
        @Override
        public void run() {
            javaSocketClient.sendAlone();
        }
    }

    class SendBuddyStudyThread implements Runnable {
        @Override
        public void run() {
            javaSocketClient.sendBuddyStudy();
        }
    }

    class SendBuddyGymThread implements Runnable {
        @Override
        public void run() {
            javaSocketClient.sendBuddyGym();
        }
    }

    class SendDoNotDisturbThread implements Runnable {
        @Override
        public void run() {
            javaSocketClient.sendDoNotDisturb();
        }
    }


    class SendEmergencyThread implements Runnable {
        @Override
        public void run() {
            javaSocketClient.sendEmergency();
        }
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        new Thread(new ClientThread()).start();
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)     {
        super.onViewCreated(view, savedInstanceState);


        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        binding.veryHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new SendHappyThread()).start();
            }
        });

        binding.ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new SendOkThread()).start();
            }
        });

        binding.alone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new SendAlone()).start();
            }
        });

        binding.sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new SendSadThread()).start();
            }
        });

        binding.book2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new SendBuddyStudyThread()).start();
            }
        });

        binding.fitness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new SendBuddyGymThread()).start();
            }
        });

        binding.emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new SendEmergencyThread()).start();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}