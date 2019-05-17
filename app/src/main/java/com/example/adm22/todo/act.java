package com.example.adm22.todo;

import java.util.Date;

/**
 * Created by adm22 on 04.07.2017.
 */

public class act {
        private boolean arg = false;
        public Date datetodo;
        public long datetodid;
        public String title,discript;
        //public act(Date dt, String titl, String discrpt){
        //    datetodo = dt;
        //    title = titl;
        //    discript = discrpt;
        //}
        public void didit(){
            datetodid = System.currentTimeMillis();
            arg=false;
        }
        public void startact(){
            arg=true;
        }
        public boolean dodid(){
            return arg;
        }
    }

