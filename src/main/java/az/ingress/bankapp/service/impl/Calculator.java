package az.ingress.bankapp.service.impl;


import org.springframework.stereotype.Service;

@Service
public class Calculator {


    public int multiple(int x,int y){
        return x/y;
    }
}
