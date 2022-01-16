package com.example.bmi.Classes;


import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Date;

public class User {
    private FirebaseAuth mAuth;
    private String name, email, password, gender, birthDay;
    private Double weigth;

    public Double getWeigth() {
        return weigth;
    }

    public void setWeigth(Double weigth) {
        this.weigth = weigth;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    private Double length;

    public User(){

    }

    public FirebaseAuth getmAuth() {
        return mAuth;
    }

    public void setmAuth(FirebaseAuth mAuth) {
        this.mAuth = mAuth;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
}

//    public User(){}
//    public User(String name, String email, String password, String re_password)throws Exception
//            {
////        if(!name.matches("[A-Za-z\\s]+")){throw Ex new ("the name is error");}
////        if(!email.matches("[A-Za-z][\\w]{0,31}@[\\w]{2,10}\\.com")){throw new UserException("the email is error");}
////        if(!password.equals("re_password")){throw new UserException("the password is conflict");}
////        if(password.length()<3){throw new UserException("the password is short");}
//        this.name = name;
//        this.email = email;
//        this.password = password;
//    }
//    //mAuth
//    public void setMAuth(FirebaseAuth mAuth){
//        this.mAuth=mAuth;
//    }
//    public FirebaseAuth getMAuth(){
//        return mAuth;
//    }
//    //name
//    public void setName(String name){
//        this.name=name;
//    }
//    public String getName(){
//        return name;
//    }
//    //email
//    public void setEmail(String email){
//        this.email=email;
//    }
//    public String getEmail(){
//        return email;
//    }
//    //password
//    public void setPassword(String password){
//        this.password=password;
//    }
//    public String getPassword(){
//        return password;
//    }
//    //food
//    public void setFoods(ArrayList<Food> foods){
//        this.foods=foods;
//    }
//    public ArrayList<Food> getFoods(){
//        return foods;
//    }
//    //record
//    public void setRecords(ArrayList<Record> records){
//        this.records=records;
//    }
//    public ArrayList<Record> getRecords(){
//        return records;
//    }
//    //birthOfDay
//    public void setBirthDay(String birthDay){
//        this.birthDay=birthDay;
//    }
//    public String getBirthDay(){
//        return birthDay;
//    }
//
//    //gender
//    public void setGender(String gender){
//        this.gender=gender;
//    }
//    public String getGender(){
//        return gender;
//    }
//
//    public void updateList(DataSnapshot snapshot, AppCompatActivity context){}
//
//
//
//}