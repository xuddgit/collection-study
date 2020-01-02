package com.org.classs.map;

import java.util.HashMap;

public class HashMapDemo {


    public static void main(String[] args) {
        HashMap<User,String > hashMap = new HashMap();
        for(int i=0;i<20;i++){
            User user = new HashMapDemo().new User();
            String str= String.valueOf(i);
            user.setName(str);
            hashMap.put(user,str);
            hashMap.get(user);

        }



       int hashCode= hashMap.hashCode();
       int h=hashCode;
      //  (h = key.hashCode()) ^ (h >>> 16)

        System.out.println(hashCode);

        System.out.println(h>>>16);

        System.out.println(hashCode^(h>>>16));


    }

    class User{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int hashCode() {
            return 1;
        }
    }






}
